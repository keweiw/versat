package com.bu;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicInteger;

import com.dao.BaseDao;
import com.dao.FundDao;
import com.dao.FundPriceHistoryDao;
import com.dao.PositionDao;
import com.dao.SysuserDao;
import com.dao.TransactionDao;
import com.dao.TransitionDao;
import com.pojo.Fund;
import com.pojo.FundPriceHistory;
import com.pojo.Position;
import com.pojo.Sysuser;
import com.pojo.Transaction;

public class TransitionDay {
	public static final int SUCCESS = 0;
	public static final int FAILED = -1;
	public static final int RETRY = -2;
	public static final int NEWFUNDS = -3; // funds need vale
	private static TransitionDay instance = new TransitionDay();
	private boolean inTransition;

	private AtomicInteger inProcessingTransition;

	private TransitionDay() {
		inTransition = false;
		inProcessingTransition = new AtomicInteger(0);
	}

	public static TransitionDay getInstance() {
		return instance;
	}

	public synchronized boolean getAndSetinTransition() {
		if (inTransition) {
			return false;
		} else {
			inTransition = true;
			return true;
		}
	}

	private boolean beforeTransition() {
		inProcessingTransition.getAndIncrement();
		if (!inTransition) {
			return true;
		} else {
			inProcessingTransition.getAndDecrement();
			return false;
		}
	}

	public FundPriceHistory getCurHistory(int idFund) throws Exception {
		return FundPriceHistoryDao.getInstance().getLatestFundHistoryById(
				idFund);
	}

	public ArrayList<Fund> getFundList() {
		FundPriceHistory fph = null;
		try {
			fph = FundPriceHistoryDao.getInstance().getLastDay();
			if (fph != null) {
				Date d = fph.getPriceDate();
				ArrayList<FundPriceHistory> fundList = FundPriceHistoryDao
						.getInstance().getListByDate(d);
				ArrayList<Fund> funds = new ArrayList<Fund>();
				for (FundPriceHistory f : fundList) {
					f.getFund().setLastDay(f.getPrice() / 100.0);
					funds.add(f.getFund());
				}
				return funds;
			} else {
				ArrayList<Fund> funds = FundDao.getInstance().getAllList();
				return funds;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<Fund>();
	}

	public int commitTransitionDay(ArrayList<Fund> commitFunds, Date date) {
		int ret = SUCCESS;
		ArrayList<Fund> funds = null;
		try {
			funds = FundDao.getInstance().getAllList();
		} catch (Exception e) {
			e.printStackTrace();
			return FAILED;
		}
		HashSet<Integer> fundsMask = new HashSet<Integer>();
		for (Fund commitFund : commitFunds) {
			fundsMask.add(commitFund.getId());
		}
		if (funds != null) {
			for (Fund fund : funds) {
				if (!fundsMask.contains(fund.getId())) {
					commitFunds.add(fund);
					ret = NEWFUNDS;
				}
			}
		}
		if (ret == NEWFUNDS) {
			return ret;
		} else {
			if (getAndSetinTransition()) {
				while (inProcessingTransition.get() != 0) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				Fund fundToLink = new Fund();
				for (Fund commitFund : commitFunds) {
					try {
						FundPriceHistory fundPriceHistoryCur = getCurHistory(commitFund
								.getId());
						fundPriceHistoryCur.setPriceDate(date);
						fundPriceHistoryCur.setPrice((long) (commitFund
								.getCur() * 100));
						FundPriceHistoryDao.getInstance().update(
								fundPriceHistoryCur);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					FundPriceHistory fundPriceHistorynew = new FundPriceHistory();
					fundToLink.setId(commitFund.getId());
					fundPriceHistorynew.setFund(fundToLink);
					try {
						FundPriceHistoryDao.getInstance().create(
								fundPriceHistorynew);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				inTransition = false;
				// NEED to add thread to handle the all transactions;
				return SUCCESS;
			} else {
				return RETRY;
			}
		}
	}

	public Date getLastTransitionDay() {
		FundPriceHistory fph = null;
		try {
			fph = FundPriceHistoryDao.getInstance().getLastDay();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Date ret = new Date();
		if (fph != null) {
			ret = fph.getPriceDate();
		}
		return ret;
	}

	public int newTransaction(int idUser, int idFund, Transaction transaction) {
		int ret = SUCCESS;
		int retryTime = 3;
		while (retryTime > 0) {
			if (beforeTransition()) {
				try {

					Sysuser user = SysuserDao.getInstance().getByUserId(idUser);
					FundPriceHistory fph = getCurHistory(idFund);
					if (user == null || fph == null) {
						ret = FAILED;
					} else {
						transaction.setSysuser(user);
						transaction.setFundPriceHistory(fph);
//						transaction.setExecuteDate(fph.getPriceDate());
						TransactionDao.getInstance().createTransaction(
								transaction);
					}
				} catch (Exception e) {
					ret = FAILED;
					e.printStackTrace();
				} finally {
					retryTime = -1;
					inProcessingTransition.getAndDecrement();
				}
			}
			retryTime--;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if (retryTime == 0) {
			return RETRY;
		}
		return ret;
	}

	public int newTransaction(int idUser, Transaction transaction) {
		int ret = SUCCESS;
		int retryTime = 3;
		while (retryTime > 0) {
			if (beforeTransition()) {
				try {

					Sysuser user = SysuserDao.getInstance().getByUserId(idUser);
					if (user == null) {
						ret = FAILED;
					} else {
						transaction.setSysuser(user);
//						transaction.setExecuteDate(getLastTransitionDay());
						TransactionDao.getInstance().createTransaction(
								transaction);
					}
				} catch (Exception e) {
					ret = FAILED;
					e.printStackTrace();
				} finally {
					retryTime = -1;
					inProcessingTransition.getAndDecrement();
				}
			}
			retryTime--;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if (retryTime == 0) {
			return RETRY;
		}
		return ret;
	}

	public static class TransitionProcessing extends Thread {
		private Date date;

		public TransitionProcessing(Date date) {
			this.date = date;
		}

		@Override
		public void run() {
			try {
				ArrayList<Transaction> trans = TransactionDao.getInstance()
						.getTransByDate(this.date);
				if (trans != null) {
					for (Transaction tran : trans) {
						operation(tran, this.date);
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// TODO Auto-generated method stub

		}

		private static synchronized void operation(Transaction tran, Date date) throws Exception {
			// TODO Auto-generated method stub
			Sysuser user = SysuserDao.getInstance().getByUserId(tran.getSysuser().getId());
			int operation = TransitionDao.OPERATION_UPDATE;
			switch (tran.getTransactionType()) {
			case Transaction.TRANS_TYPE_BUY:
				if (user.getCash() >= tran.getAmount()) {
					user.setCash(user.getCash() - tran.getAmount());
					long shares = 1000 * tran.getAmount() / tran.getFundPriceHistory().getPrice() ;
					tran.setShares(shares);
					Position p = PositionDao.getInstance().getByCustomerIdFundId(user.getId(), tran.getFundPriceHistory().getFund().getId());
					if (p == null) {
						p = new Position();
						p.setFund(tran.getFundPriceHistory().getFund());
						p.setIduser(user.getId());
						p.setShares(shares);
						operation = TransitionDao.OPERATION_NEW;
					} else {
						p.setShares(shares + p.getShares());
					}
					tran.setStatus(Transaction.TRANS_STATUS_FINISH);
					if (!TransitionDao.getInstance().buyAndSell(p, user, tran, operation)) {
						tran.setStatus(Transaction.TRANS_STATUS_FAIL);
						TransactionDao.getInstance().update(tran);
					}
				} else {
					tran.setStatus(Transaction.TRANS_STATUS_FAIL);
					TransactionDao.getInstance().update(tran);
				}
				break;
			case Transaction.TRANS_TYPE_SELL:
				Position p = PositionDao.getInstance().getByCustomerIdFundId(user.getId(), tran.getFundPriceHistory().getFund().getId());
				if (p.getShares() >= tran.getShares()) {
					long money = tran.getShares() / 10 * tran.getFundPriceHistory().getPrice();
					user.setCash(user.getCash() + money);
					tran.setAmount(money);
					if (p.getShares() == tran.getShares()) {
						operation = TransitionDao.OPERATION_DELETE;
					} else {
						p.setShares(p.getShares() - tran.getShares());
					}
					tran.setStatus(Transaction.TRANS_STATUS_FINISH);
					if (!TransitionDao.getInstance().buyAndSell(p, user, tran, operation)) {
						tran.setStatus(Transaction.TRANS_STATUS_FAIL);
						TransactionDao.getInstance().update(tran);
					}
				} else {
					tran.setStatus(Transaction.TRANS_STATUS_FAIL);
					TransactionDao.getInstance().update(tran);
				}
				break;
			case Transaction.TRANS_TYPE_DEPOSIT:
				user.setCash(user.getCash() + tran.getAmount());
				tran.setStatus(Transaction.TRANS_STATUS_FINISH);
				if (!TransitionDao.getInstance().withDrawAndDepsit(user, tran)) {
					tran.setStatus(Transaction.TRANS_STATUS_FAIL);
					TransactionDao.getInstance().update(tran);
				}
				break;
			case Transaction.TRANS_TYPE_WITHDRAW:
				if (user.getCash() >= tran.getAmount()) {
					user.setCash(user.getCash() - tran.getAmount());
					tran.setStatus(Transaction.TRANS_STATUS_FINISH);
					if (!TransitionDao.getInstance().withDrawAndDepsit(user, tran)) {
						tran.setStatus(Transaction.TRANS_STATUS_FAIL);
						TransactionDao.getInstance().update(tran);
					}
				} else {
					tran.setStatus(Transaction.TRANS_STATUS_FAIL);
					TransactionDao.getInstance().update(tran);
				}
				break;
			}
			
		}
	}
}
