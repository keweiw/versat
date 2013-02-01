package com.action;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.bu.TransitionDay;
import com.dao.FundDao;
import com.dao.FundPriceHistoryDao;
import com.dao.PositionDao;
import com.dao.SysuserDao;
import com.dao.TransactionDao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.pojo.Fund;
import com.pojo.FundPriceHistory;
import com.pojo.Position;
import com.pojo.Sysuser;
import com.pojo.Transaction;

public class FundAction extends ActionSupport {
	private String name;
	private String symbol;
	private String keyword;
	private String optionC;
	private double lastPrice;
	private double shareValue;

	private int fundId;
	private int userId;

	private double shares;
	private int isSuccess = 0;
	private double inputShares;
	private String amount;
	private String inputShareString;
	private String outputShareString;
	private String outputAvaiShareString;
	private String outputBalanceString;
	private String outputAvaiBalanceString;

	private ArrayList<Fund> funds;
	private ArrayList<Position> positions;

	private ArrayList<FundPriceHistory> outputFundPriceHistory;

	private DecimalFormat cashDFormat = new DecimalFormat("###,##0.00");
	private DecimalFormat shareDFormat = new DecimalFormat("###,##0.000");

	// --getters and setters to be here--//
	public String getOutputAvaiShareString() {
		return outputAvaiShareString;
	}

	public void setOutputAvaiShareString(String outputAvaiShareString) {
		this.outputAvaiShareString = outputAvaiShareString;
	}

	public String getOutputAvaiBalanceString() {
		return outputAvaiBalanceString;
	}

	public void setOutputAvaiBalanceString(String outputAvaiBalanceString) {
		this.outputAvaiBalanceString = outputAvaiBalanceString;
	}

	public String getOutputBalanceString() {
		return outputBalanceString;
	}

	public void setOutputBalanceString(String outputBalanceString) {
		this.outputBalanceString = outputBalanceString;
	}

	public String getOutputShareString() {
		return outputShareString;
	}

	public void setOutputShareString(String outputShareString) {
		this.outputShareString = outputShareString;
	}

	public String getInputShareString() {
		return inputShareString;
	}

	public void setInputShareString(String inputShareString) {
		this.inputShareString = inputShareString;
	}

	public double getShareValue() {
		return shareValue;
	}

	public void setShareValue(double shareValue) {
		this.shareValue = shareValue;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getOptionC() {
		return optionC;
	}

	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}

	public double getLastPrice() {
		return lastPrice;
	}

	public void setLastPrice(double lastPrice) {
		this.lastPrice = lastPrice;
	}

	public int getIsSuccess() {
		return isSuccess;
	}

	public void setIsSuccess(int isSuccess) {
		this.isSuccess = isSuccess;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public int getFundId() {
		return fundId;
	}

	public void setFundId(int fundId) {
		this.fundId = fundId;
	}

	public ArrayList<Position> getPositions() {
		return positions;
	}

	public ArrayList<Fund> getFunds() {
		return funds;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String showCreate() {
		return SUCCESS;
	}

	public double getShares() {
		return shares;
	}

	public void setShares(double shares) {
		this.shares = shares;
	}

	public double getInputShares() {
		return inputShares;
	}

	public void setInputShares(double inputShares) {
		this.inputShares = inputShares;
	}

	public String create() {
		return SUCCESS;
	}

	public String showfund() {
		return SUCCESS;
	}

	public ArrayList<FundPriceHistory> getOutputFundPriceHistory() {
		return outputFundPriceHistory;
	}

	public void setOutputFundPriceHistory(
			ArrayList<FundPriceHistory> outputFundPriceHistory) {
		this.outputFundPriceHistory = outputFundPriceHistory;
	}

	// --end of getter and setter--//

	public String listAllFund() {
		try {
			funds = FundDao.getInstance().getAllList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	// -- get all(a list) funds using user id to query -- //
	// -- when user click sell fund go to this function -- //
	// -- success go to customer_sell.jsp --//
	public String listFundByUserId() {
		Sysuser user;
		Map session = ActionContext.getContext().getSession();
		user = (Sysuser) session.get(LoginAction.SYSUSER);
		try {
			ArrayList<Fund> fs = TransitionDay.getInstance().getFundList();
			HashMap priceMap = new HashMap<Integer, Double>();
			for (Fund f : fs) {
				priceMap.put(f.getId(), f.getLastDay());
			}

			positions = PositionDao.getInstance().getPositionByCostomerId(
					user.getId());
			if (positions.size() == 0) {
				return SUCCESS;
			}
			for (Position p : positions) {
				Integer fId = p.getFund().getId();
				double priceInDouble = (Double) priceMap.get(fId);
				double shareInDouble = p.getShares() / 1000.0;
				double shareValue = priceInDouble * shareInDouble;

				// -- calculate shares here --//
				long avaiShares = p.getShares();
				ArrayList<Transaction> transactions = TransactionDao
						.getInstance().getPendTransByUserIdOp(user.getId(),
								Transaction.TRANS_TYPE_SELL);
				if (transactions.size() != 0) {
					for (Transaction t : transactions) {

						if (t.getFundPriceHistory().getFund().getId() == fId) {
							avaiShares -= t.getShares();
						}
					}
				}
				double newAvaiShares = avaiShares / 1000.0;

				p.setLastPriceString(cashDFormat.format(priceInDouble));
				p.setShareString(shareDFormat.format(shareInDouble));
				p.setAvaiShareString(shareDFormat.format(newAvaiShares));
				p.setShareValueString(cashDFormat.format(shareValue));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String employeeListFundByUserId() {
		try {
			Sysuser user = SysuserDao.getInstance().getByUserId(userId);
			name = user.getFirstname();
			positions = PositionDao.getInstance().getPositionByCostomerId(
					userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	// --search fund by fund name--//
	/*
	 * public String searchFundByName() throws Exception { keyword =
	 * keyword.trim(); funds = FundDao.getInstance().getByName(keyword, true);
	 * return SUCCESS; }
	 */
	public String searchAllFundByOption() throws Exception {
		Sysuser user;
		Map session = ActionContext.getContext().getSession();
		user = (Sysuser) session.get(LoginAction.SYSUSER);

		if (keyword.equals("") || keyword == null) {
			funds = FundDao.getInstance().getAllList();
			this.addActionError("you must enter the search key!");
			isSuccess = -1;
			return ERROR;
		}
		keyword = keyword.trim();
		if (keyword.equals("")) {
			funds = FundDao.getInstance().getAllList();
			this.addActionError("you must enter the search key!");
			isSuccess = -1;
			return ERROR;
		}
		// --if the user choose default--//
		if (optionC.equals("default")) {
			funds = FundDao.getInstance().getAllList();
			return SUCCESS;
		} else if (optionC.equals("fundName")) {
			funds = FundDao.getInstance().getByName(keyword, true);
			if (funds.size() == 0) {
				this.addActionError("Can not find this fund!");
				isSuccess = -1;
				return ERROR;
			}
			isSuccess = 1;
			return SUCCESS;
		} else if (optionC.equals("fundSymbol")) {
			funds = FundDao.getInstance().getBySymbol(keyword, true);
			if (funds.size() == 0) {
				this.addActionError("Can not find this fund!");
				isSuccess = -1;
				return ERROR;
			}
			isSuccess = 1;
			return SUCCESS;
		}
		return SUCCESS;
	}

	// - search owned fund--//
	public String searchFundByOption() throws Exception {
		Sysuser user;
		Map session = ActionContext.getContext().getSession();
		user = (Sysuser) session.get(LoginAction.SYSUSER);

		if (keyword.equals("") || keyword == null) {
			this.addActionError("you must enter the search key!");
			positions = PositionDao.getInstance().getPositionByCostomerId(
					user.getId());
			isSuccess = -1;
			return ERROR;
		}
		keyword = keyword.trim();
		if (keyword.equals("")) {
			funds = FundDao.getInstance().getAllList();
			this.addActionError("you must enter the search key!");
			isSuccess = -1;
			return ERROR;
		}
		// --if the user choose default--//
		if (optionC.equals("default")) {
			positions = PositionDao.getInstance().getAllList();
			return SUCCESS;
		} else if (optionC.equals("fundName")) {
			funds = FundDao.getInstance().getByName(keyword, true);
			if (funds.size() == 0) {
				this.addActionError("Can not find this fund!");
				isSuccess = -1;
				return ERROR;
			}
			positions = PositionDao.getInstance().getListByCustomerIdFundId(
					user.getId(), funds.get(0).getId());
			if (positions.size() == 0) {
				this.addActionError("Can not find this fund!");
				isSuccess = -1;
				return ERROR;
			}
			isSuccess = 1;
			return SUCCESS;
		} else if (optionC.equals("fundSymbol")) {
			funds = FundDao.getInstance().getBySymbol(keyword, true);
			if (funds.size() == 0) {
				this.addActionError("Can not find this fund!");
				isSuccess = -1;
				return ERROR;
			}
			positions = PositionDao.getInstance().getListByCustomerIdFundId(
					user.getId(), funds.get(0).getId());
			if (positions.size() == 0) {
				this.addActionError("Can not find this fund!");
				isSuccess = -1;
				return ERROR;
			}
			isSuccess = 1;
			return SUCCESS;
		}
		return SUCCESS;
	}

	public String createFund() throws Exception {
		if (name == null || name.equals("")) {
			this.addActionError("The fund can not be empty!");
			isSuccess = -1;
			return ERROR;
		}
		if (symbol == null || symbol.equals("")) {
			this.addActionError("The symbol can not be empty!");
			isSuccess = -1;
			return ERROR;
		}
		if (symbol.length() > 5) {
			this.addActionError("The symbol can not be over five letters!");
			isSuccess = -1;
			return ERROR;
		}
		name = name.trim();
		if (name.matches("[a-zA-Z]*") == false) {
			this.addActionError("The name should be all letters!");
			isSuccess = -1;
			return ERROR;
		}
		symbol = symbol.trim();
		if (symbol.matches("[a-zA-Z]*") == false) {
			this.addActionError("The symbol should be all letters!");
			isSuccess = -1;
			return ERROR;
		}
		// --check if the fund name or symbol is duplicate --//
		ArrayList<Fund> fs = FundDao.getInstance().getByName(name, false);
		if (fs.size() != 0) {
			this.addActionError("The fund name is already exist!");
			isSuccess = -1;
			return ERROR;
		}
		fs = FundDao.getInstance().getBySymbol(symbol, false);
		if (fs.size() != 0) {
			this.addActionError("The fund symbol is already exist!");
			isSuccess = -1;
			return ERROR;
		}

		FundDao.getInstance().createFund(name, symbol);
		ArrayList<Fund> f = FundDao.getInstance().getByName(name, false);
		FundPriceHistory fph = new FundPriceHistory();
		fph.setFund(f.get(0));
		FundPriceHistoryDao.getInstance().create(fph);
		isSuccess = 1;
		return SUCCESS;
	}

	public String showFundDetail() throws Exception {
		Fund f = FundDao.getInstance().getById(fundId);
		outputFundPriceHistory = FundPriceHistoryDao.getInstance()
				.getListByFundId(fundId);
		name = f.getName();
		symbol = f.getSymbol();
		return SUCCESS;
	}

	// --get info from customer_sell2.jsp and set info want to bo post on
	// sellfund.jsp
	public String showSellFund() throws Exception {
		// --get user id from session--//
		Map session = ActionContext.getContext().getSession();
		Sysuser user = (Sysuser) session.get(LoginAction.SYSUSER);
		// --query by userId and fundId--//
		Position p = PositionDao.getInstance().getByCustomerIdFundId(
				user.getId(), fundId);
		if (p == null) {
			this.addActionError("Can not find this fund");
			isSuccess = -1;
			return ERROR;
		}
		name = p.getFundName();
		symbol = p.getFundSymbol();
		shares = p.getShares() / 1000.00;
		// -- calculate available shares here--//
		long avaiShares = p.getShares();
		ArrayList<Transaction> transactions = TransactionDao.getInstance()
				.getPendTransByUserIdOp(user.getId(),
						Transaction.TRANS_TYPE_SELL);
		if (transactions.size() != 0) {
			for (Transaction t : transactions) {

				if (t.getFundPriceHistory().getFund().getId() == p.getFund()
						.getId()) {
					avaiShares -= t.getShares();
				}
			}
		}
		double newAvaiShares = avaiShares / 1000.0;
		outputShareString = shareDFormat.format(shares);
		outputAvaiShareString = shareDFormat.format(newAvaiShares);
		return SUCCESS;
	}

	public String sell() throws Exception {
		Map session = ActionContext.getContext().getSession();
		Sysuser user = (Sysuser) session.get(LoginAction.SYSUSER);
		Position p = PositionDao.getInstance().getByCustomerIdFundId(
				user.getId(), fundId);
		if (p == null) {
			this.addActionError("Can not find this fund");
			isSuccess = -1;
			return ERROR;
		}
		name = p.getFundName();
		symbol = p.getFundSymbol();
		shares = p.getShares() / 1000.0;
		outputShareString = shareDFormat.format(shares);
		// -- calculate available shares here--//
		long avaiShares = p.getShares();
		ArrayList<Transaction> transactions = TransactionDao.getInstance()
				.getPendTransByUserIdOp(user.getId(),
						Transaction.TRANS_TYPE_SELL);
		if (transactions.size() != 0) {
			for (Transaction t : transactions) {
				if (t.getFundPriceHistory().getFund().getId() == p.getFund()
						.getId()) {
					avaiShares -= t.getShares();
				}
			}
		}
		double newAvaiShares = avaiShares / 1000.0;
		outputAvaiShareString = shareDFormat.format(newAvaiShares);
		// -- input check here --//
		if (inputShareString.equals("") || inputShareString == null) {
			this.addActionError("You must enter shares!");
			isSuccess = -1;
			return ERROR;
		}
		inputShareString = inputShareString.trim();
		if (inputShareString.equals("") || inputShareString == null) {
			this.addActionError("You must enter shares!");
			isSuccess = -1;
			return ERROR;
		}
		if (inputShareString.matches("^[0-9]+([.][0-9][0-9][0-9])?$") == false) {
			this.addActionError("You can only enter numbers.!You can not enter more than the third digit after the decimal point");
			isSuccess = -1;
			return ERROR;
		}
		inputShareString = inputShareString.replaceFirst("^0*", "");
		double ds = Double.valueOf(inputShareString);
		long ls = Math.round (ds * 1000);
		if (checkAndSell(fundId, user.getId(), ls) == false) {
			this.addActionError("You can not over sell!");
			isSuccess = -1;
			return ERROR;
		}
		isSuccess = 1;
		return SUCCESS;

	}

	public static synchronized boolean checkAndSell(int fId, int uId,
			long shares) throws Exception {

		Position p = PositionDao.getInstance().getByCustomerIdFundId(uId, fId);
		long avaiShares = p.getShares();
		if (avaiShares <= 0) {
			return false;
		}
		ArrayList<Transaction> transactions = TransactionDao.getInstance()
				.getPendTransByUserIdOp(uId, Transaction.TRANS_TYPE_SELL);
		if (transactions.size() != 0) {
			for (Transaction t : transactions) {
				if (t.getFundPriceHistory().getFund().getId() == p.getFund()
						.getId()) {
					avaiShares -= t.getShares();
				}
			}
		}
		if (avaiShares < shares) {
			return false;
		}
		Transaction t = new Transaction();
		t.setShares(shares);
		t.setStatus(Transaction.TRANS_STATUS_PENDING);
		t.setTransactionType(Transaction.TRANS_TYPE_SELL);
		while (true) {
			int i = TransitionDay.getInstance().newTransaction(uId, fId, t);
			if (i == TransitionDay.SUCCESS)
				break;
		}
		return true;
	}

	public static synchronized boolean checkAndBuy(int fId, int uId,
			long inputAmount) throws Exception {
		// -- the transaction dao needs to be fixed here
		ArrayList<Transaction> transactions = TransactionDao.getInstance()
				.getPendTransByUserIdOp(uId, Transaction.TRANS_TYPE_BUY);
		ArrayList<Transaction> transactions2 = TransactionDao.getInstance()
				.getPendTransByUserIdOp(uId, Transaction.TRANS_TYPE_WITHDRAW);
		Map session = ActionContext.getContext().getSession();
		Sysuser user = (Sysuser) session.get(LoginAction.SYSUSER);
		long avaiBalance = user.getCash();
		if (avaiBalance <= 0) {
			return false;
		}
		if (transactions.size() != 0) {
			for (Transaction t : transactions) {
				avaiBalance -= t.getAmount();
			}
		}
		if (transactions2.size() != 0) {
			for (Transaction t : transactions2) {
				avaiBalance -= t.getAmount();
			}
		}
		if (avaiBalance < inputAmount) {
			return false;
		}
		Transaction t = new Transaction();
		t.setAmount(inputAmount);
		t.setStatus(Transaction.TRANS_STATUS_PENDING);
		t.setTransactionType(Transaction.TRANS_TYPE_BUY);
		while (true) {
			int i = TransitionDay.getInstance().newTransaction(uId, fId, t);
			if (i == TransitionDay.SUCCESS)
				break;
		}
		return true;
	}

	public String showBuyFund() throws Exception {
		// --get user id from session--//
		Map session = ActionContext.getContext().getSession();
		Sysuser user = (Sysuser) session.get(LoginAction.SYSUSER);
		Position p = PositionDao.getInstance().getByCustomerIdFundId(
				user.getId(), fundId);
		Fund f = FundDao.getInstance().getById(fundId);
		if (f == null) {
			this.addActionError("Can not find this fund");
			isSuccess = -1;
			return ERROR;
		}
		long avaiShares;
		if (p == null) {
			shares = 0 / 1000.0;
			outputShareString = "-";
			outputAvaiShareString = "-";
			avaiShares = 0;
		} else {
			shares = p.getShares() / 1000.0;
			outputShareString = shareDFormat.format(shares);
			avaiShares = p.getShares();
			// available share check here
			ArrayList<Transaction> transactions3 = TransactionDao.getInstance()
					.getPendTransByUserIdOp(user.getId(),
							Transaction.TRANS_TYPE_SELL);
			if (transactions3.size() != 0) {
				for (Transaction t : transactions3) {
					if (t.getFundPriceHistory().getFund().getId() == p
							.getFund().getId()) {
						avaiShares -= t.getShares();
					}
				}
			}
		}
		// available balance check here
		ArrayList<Transaction> transactions = TransactionDao.getInstance()
				.getPendTransByUserIdOp(user.getId(),
						Transaction.TRANS_TYPE_BUY);
		ArrayList<Transaction> transactions2 = TransactionDao.getInstance()
				.getPendTransByUserIdOp(user.getId(),
						Transaction.TRANS_TYPE_WITHDRAW);
		long avaiBalance = user.getCash();
		if (transactions.size() != 0) {
			for (Transaction t : transactions) {
				avaiBalance -= t.getAmount();
			}
		}
		if (transactions2.size() != 0) {
			for (Transaction t : transactions2) {
				avaiBalance -= t.getAmount();
			}
		}

		double as = avaiShares / 1000.0;
		if (p != null)
			outputAvaiShareString = shareDFormat.format(as);
		outputAvaiBalanceString = cashDFormat.format(avaiBalance / 100.0);
		name = f.getName();
		symbol = f.getSymbol();
		return SUCCESS;
	}

	public String buy() throws Exception {
		Map session = ActionContext.getContext().getSession();
		Sysuser user = (Sysuser) session.get(LoginAction.SYSUSER);
		Fund f = FundDao.getInstance().getById(fundId);
		if (f == null) {
			this.addActionError("Can not find this fund");
			isSuccess = -1;
			return ERROR;
		}
		Position p = PositionDao.getInstance().getByCustomerIdFundId(
				user.getId(), fundId);
		name = f.getName();
		symbol = f.getSymbol();
		long avaiShares;
		if (p == null) {
			shares = 0 / 1000.0;
			outputShareString = "-";
			outputAvaiShareString = "-";
			avaiShares = 0;
		} else {
			shares = p.getShares() / 1000.0;
			outputShareString = shareDFormat.format(shares);
			avaiShares = p.getShares();
			// calculation share here
			ArrayList<Transaction> transactions = TransactionDao.getInstance()
					.getPendTransByUserIdOp(user.getId(),
							Transaction.TRANS_TYPE_SELL);
			if (transactions.size() != 0) {
				for (Transaction t : transactions) {
					if (t.getFundPriceHistory().getFund().getId() == p
							.getFund().getId()) {
						avaiShares -= t.getShares();
					}
				}
			}
			double as = avaiShares / 1000.0;
			outputAvaiShareString = shareDFormat.format(as);
		}
		// available balance check here
		ArrayList<Transaction> transactions = TransactionDao.getInstance()
				.getPendTransByUserIdOp(user.getId(),
						Transaction.TRANS_TYPE_BUY);
		ArrayList<Transaction> transactions2 = TransactionDao.getInstance()
				.getPendTransByUserIdOp(user.getId(),
						Transaction.TRANS_TYPE_WITHDRAW);
		long avaiBalance = user.getCash();
		if (transactions.size() != 0) {

			for (Transaction t : transactions) {
				avaiBalance -= t.getAmount();
			}
		}
		if (transactions2.size() != 0) {
			for (Transaction t : transactions2) {
				avaiBalance -= t.getAmount();
			}
		}
		double doubleAvaiBalance = avaiBalance / 100.0;
		outputAvaiBalanceString = cashDFormat.format(doubleAvaiBalance);
		// -- input error check here-- //
		if (amount.equals("") || amount == null) {
			this.addActionError("You must enter amount!");
			isSuccess = -1;
			return ERROR;
		}
		amount = amount.trim();
		if (amount.equals("")) {
			this.addActionError("You must enter amount!");
			isSuccess = -1;
			return ERROR;
		}
		if (amount.matches("^[0-9]+([.][0-9][0-9])?$") == false) {
			this.addActionError("You must enter numbers and it can not be negtive. You can not enter more than the second digit after the decimal point");
			isSuccess = -1;
			return ERROR;
		}
		// -- input amount should not more than 1,000,000,000--//
		amount = amount.replaceFirst("^0*", "");
		if (amount.length() > 13) {
			this.addActionError("You can not buy more than 1,000,000,000.");
			isSuccess = -1;
			return ERROR;
		}
		if (Double.valueOf(amount) > 1000000000) {
			this.addActionError("You can not buy more than 1,000,000,000.");
			isSuccess = -1;
			return ERROR;
		}
		// --can not buy too much or too less check here --//
		Double newAmount = Double.valueOf(amount);

		if (newAmount == 0 || newAmount < 0.01) {
			this.addActionError("You must enter non-zero numbers and it should be smaller than 0.01.");
			isSuccess = -1;
			return ERROR;
		}
		if (newAmount > doubleAvaiBalance) {
			this.addActionError("You can not buy more than your balance.");
			isSuccess = -1;
			return ERROR;
		}
		long la = Math.round (newAmount * 100);

		if (checkAndBuy(fundId, user.getId(), la) == false) {
			this.addActionError("You do not have enough balance.");
			isSuccess = -1;
			return ERROR;
		}

		isSuccess = 1;
		return SUCCESS;
	}

}
