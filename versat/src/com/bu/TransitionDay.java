package com.bu;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicInteger;

import com.dao.FundDao;
import com.dao.FundPriceHistoryDao;
import com.dao.SysuserDao;
import com.dao.TransactionDao;
import com.pojo.Fund;
import com.pojo.FundPriceHistory;
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
		if (!inTransition) {
			inProcessingTransition.getAndIncrement();
			return true;
		} else {
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
						FundPriceHistory fundPriceHistoryCur = getCurHistory(commitFund.getId());
						fundPriceHistoryCur.setPriceDate(date);
						fundPriceHistoryCur.setPrice((long) (commitFund.getCur() * 100));
						FundPriceHistoryDao.getInstance().update(fundPriceHistoryCur);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					FundPriceHistory fundPriceHistorynew = new FundPriceHistory();
					fundToLink.setId(commitFund.getId());
					fundPriceHistorynew.setFund(fundToLink);
					try {
						FundPriceHistoryDao.getInstance().create(fundPriceHistorynew);
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
		return ret;
	}
	
	public static void main(String argv[]) {
		Fund fund = new Fund();
		fund.setId(1);
		FundPriceHistory fph = new FundPriceHistory();
		fph.setFund(fund);
		try {
			FundPriceHistoryDao.getInstance().create(fph);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
