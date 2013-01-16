package com.pojo;

// Generated Jan 15, 2013 9:10:07 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * Transaction generated by hbm2java
 */
public class Transaction implements java.io.Serializable {

	public static final int TRANS_TYPE_BUY = 0;
	public static final int TRANS_TYPE_SELL = 1;
	public static final int TRANS_TYPE_DEPOSIT = 2;
	public static final int TRANS_TYPE_WITHDREW = 3;
	public static final int TRANS_STATUS_PENDING = 0;
	public static final int TRANS_STATUS_FINISH = 1;
	private Integer id;
	private Sysuser sysuser;
	private FundPriceHistory fundPriceHistory;
	private Date executeDate;
	private Long shares;
	private Long amount;
	private Integer transactionType;
	private Integer status;
	private String fundName;
	private double unitPrice;

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
		if (this.fundPriceHistory != null) {
			this.fundName = fundPriceHistory.getFund().getName();
			this.unitPrice = fundPriceHistory.getPrice() / 100.0;
		}
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
	}

	public Long getShares() {
		return this.shares;
	}

	public void setShares(Long shares) {
		this.shares = shares;
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
	}
}
