package com.action;

import java.util.ArrayList;
import java.util.Map;

import com.dao.FundDao;
import com.dao.PositionDao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.pojo.Fund;
import com.pojo.Position;
import com.pojo.Sysuser;

public class FundAction extends ActionSupport{
	private String name;
	private String symbol;
	private int fundId;
	public int getFundId() {
		return fundId;
	}

	public void setFundId(int fundId) {
		this.fundId = fundId;
	}
	private ArrayList<Fund> funds;
	private ArrayList<Position> positions;
	
	

	public ArrayList<Position> getPositions() {
		return positions;
	}

	public ArrayList<Fund> getFunds(){
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
	
	public String create(){
		return SUCCESS;
	}
	
	public String showfund() {
		return SUCCESS;
	}
	


	public String listAllFund(){
		try {
			funds=FundDao.getInstance().getAllList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String listFundByUserId(){
		Sysuser user;
		Map session = ActionContext.getContext().getSession();
		user = (Sysuser) session.get(LoginAction.SYSUSER);
		int userId = user.getId();
		try{
			positions=PositionDao.getInstance().getPositionByCostomerId(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return SUCCESS;
	}
	
	public String createFund() throws Exception{
		name=name.trim();
		symbol=symbol.trim();
		Fund f1 = new Fund();
		f1.setName(name);
		//check if there is a fund already had the same name
		if(FundDao.getInstance().isExist(f1)==true){
			this.addActionError("The fund name already existed");
			return ERROR;
		}
		Fund f2 = new Fund();
		f2.setSymbol(symbol);
		//
		if(FundDao.getInstance().isExist(f2)==true){
			this.addActionError("The fund name already existed");
			return ERROR;
		}
		FundDao.getInstance().createFund(name, symbol);
		return SUCCESS;
	}
	public String showFundDetail() throws Exception{
		Fund f=FundDao.getInstance().getById(fundId);
		name=f.getName();
		symbol=f.getSymbol();
		return SUCCESS;
	}
}
