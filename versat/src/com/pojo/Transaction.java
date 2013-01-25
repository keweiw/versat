package com.pojo;

// Generated Jan 15, 2013 9:10:07 PM by Hibernate Tools 3.4.0.CR1

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Transaction generated by hbm2java
 */
public class Transaction implements java.io.Serializable {

	public static final int TRANS_TYPE_BUY = 0;
	public static final int TRANS_TYPE_SELL = 1;
	public static final int TRANS_TYPE_DEPOSIT = 2;
	public static final int TRANS_TYPE_WITHDRAW = 3;
	public static final int TRANS_STATUS_PENDING = 0;
	public static final int TRANS_STATUS_FINISH = 1;
	public static final int TRANS_STATUS_FAIL = 2;
	private Integer id;
	private Sysuser sysuser;
	private FundPriceHistory fundPriceHistory;
	private Date executeDate;
	private String stringDate;
	private Long shares;
	private double doubleshares;
	private Long amount;
	private double doubleamount;
	private Integer transactionType;
	private Integer status;
	private String fundName;
	private double unitPrice;
	private String sharesString;
	private String amountString;
	DecimalFormat dFormat1 = new DecimalFormat("###,##0.000");
	DecimalFormat dFormat2 = new DecimalFormat("###,##0.00");
	SimpleDateFormat df = new SimpleDateFormat("MM-dd-yyyy");

	public Transaction() {
	}

	public Transaction(Sysuser sysuser, FundPriceHistory fundPriceHistory,
			Date executeDate, Long shares, Long amount, Integer transactionType, Integer status) {
		this.sysuser = sysuser;
		this.fundPriceHistory = fundPriceHistory;
		this.executeDate = executeDate;
		this.shares = shares;
		this.amount = amount;
		this.transactionType = transactionType;
		this.status = status;
		this.setDoubleshares(this.shares / 1000.00);
		this.setDoubleamount(this.amount / 100.00);
		if (this.fundPriceHistory != null) {
			this.fundName = fundPriceHistory.getFund().getName();
			this.unitPrice = fundPriceHistory.getPrice() / 100.0;
		}
	}

	public Transaction(Sysuser sysuser,Date executeDate, Long amount, Integer transactionType, Integer status) {
		this.sysuser = sysuser;
		this.executeDate = executeDate;
		this.amount = amount;
		this.transactionType = transactionType;
		this.status = status;
		this.setDoubleamount(this.amount / 100.00);
		
	}
	public String getFundName() {
		return fundName;
	}

	public void setFundName(String fundName) {
		this.fundName = fundName;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Sysuser getSysuser() {
		return this.sysuser;
	}

	public void setSysuser(Sysuser sysuser) {
		this.sysuser = sysuser;
	}

	public FundPriceHistory getFundPriceHistory() {
		return this.fundPriceHistory;
	}

	public void setFundPriceHistory(FundPriceHistory fundPriceHistory) {
		this.fundPriceHistory = fundPriceHistory;
		if (this.fundPriceHistory != null) {
			this.fundName = fundPriceHistory.getFund().getName();
			this.unitPrice = fundPriceHistory.getPrice() / 100.0;
		}
	}

	public Date getExecuteDate() {
		return this.executeDate;
	}

	public void setExecuteDate(Date executeDate) {
		this.executeDate = executeDate;
		this.stringDate = df.format(executeDate);
	}

	public Long getShares() {
		return this.shares;
	}

	public void setShares(Long shares) {
		this.shares = shares;
//		this.doubleshares = this.shares / 1000.00;
//		this.setSharesString(dFormat1.format(doubleshares));
	}

	public Integer getTransactionType() {
		return this.transactionType;
	}

	public void setTransactionType(Integer transactionType) {
		this.transactionType = transactionType;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
		this.doubleamount = this.amount / 100.00;
		this.amountString = dFormat2.format(doubleamount);
	}

	public double getDoubleshares() {
		return doubleshares;
	}

	public void setDoubleshares(double doubleshares) {
		this.doubleshares = doubleshares;
	}

	public double getDoubleamount() {
		return doubleamount;
	}

	public void setDoubleamount(double doubleamount) {
		this.doubleamount = doubleamount;
	}

	public String getSharesString() {
		return sharesString;
	}

	public void setSharesString(String sharesString) {
		this.sharesString = sharesString;
	}

	public String getAmountString() {
		return amountString;
	}

	public void setAmountString(String amountString) {
		this.amountString = amountString;
	}

	public String getStringDate() {
		return stringDate;
	}

	public void setStringDate(String stringDate) {
		this.stringDate = stringDate;
	}
}
