package com.pojo;

// Generated Jan 15, 2013 9:10:07 PM by Hibernate Tools 3.4.0.CR1

/**
 * Position generated by hbm2java
 */
public class Position implements java.io.Serializable {

	private Integer id;
	private Integer iduser;
	private Fund fund;
	private Long shares;
	
	private String fundName;
	private String fundSymbol;
	
	private String shareString;
	private String lastPriceString;
	private String shareValueString;
	
	public Position() {
	}

	public Position(Integer iduser, Fund fund, Long shares) {
		this.iduser = iduser;
		this.fund = fund;
		this.shares = shares;
	}
	public String getFundName() {
		return fundName;
	}

	public String getFundSymbol() {
		return fundSymbol;
	}
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIduser() {
		return iduser;
	}

	public void setIduser(Integer iduser) {
		this.iduser = iduser;
	}

	public Fund getFund() {
		return this.fund;
	}

	public void setFund(Fund fund) {
		this.fund = fund;
		if(fund.getName()!=null && fund.getSymbol()!=null){
				this.fundName=fund.getName();
				this.fundSymbol=fund.getSymbol();
		}
	}

	public Long getShares() {
		return this.shares;
	}

	public void setShares(Long shares) {
		this.shares = shares;
	}

	public String getShareString() {
		return shareString;
	}

	public void setShareString(String shareString) {
		this.shareString = shareString;
	}

	public String getLastPriceString() {
		return lastPriceString;
	}

	public void setLastPriceString(String lastPriceString) {
		this.lastPriceString = lastPriceString;
	}

	public String getShareValueString() {
		return shareValueString;
	}

	public void setShareValueString(String shareValueString) {
		this.shareValueString = shareValueString;
	}

}
