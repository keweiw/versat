package com.action;


import java.util.ArrayList;
import java.util.Date;

import com.dao.FundDao;
import com.opensymphony.xwork2.ActionSupport;
import com.pojo.Fund;
import com.pojo.FundPriceHistory;

public class TransitionAction extends ActionSupport  {
	
	private ArrayList<Fund> funds;
	private FundPriceHistory fundPriceHistory;
	private Date lastTradingDate;
	private Date closingDate;
	private ArrayList<Double> closingPrice;
	
	
	
	public String showFundList() {
			try {
				setFunds(FundDao.getInstance().getAllList());
			} catch (Exception e) {
				e.printStackTrace();
			}
			return SUCCESS;
		
	}



	public ArrayList<Fund> getFunds() {
		return funds;
	}



	public void setFunds(ArrayList<Fund> funds) {
		this.funds = funds;
	}



	public FundPriceHistory getFundPriceHistory() {
		return fundPriceHistory;
	}



	public void setFundPriceHistory(FundPriceHistory fundPriceHistory) {
		this.fundPriceHistory = fundPriceHistory;
	}



	public Date getLastTradingDate() {
		return lastTradingDate;
	}



	public void setLastTradingDate(Date lastTradingDate) {
		this.lastTradingDate = lastTradingDate;
	}



	public Date getClosingDate() {
		return closingDate;
	}



	public void setClosingDate(Date closingDate) {
		this.closingDate = closingDate;
	}



	public ArrayList<Double> getClosingPrice() {
		return closingPrice;
	}



	public void setClosingPrice(ArrayList<Double> closingPrice) {
		this.closingPrice = closingPrice;
	}
	
	
}

