package com.action;

import java.util.ArrayList;
import java.util.Map;

import com.bu.TransitionDay;
import com.dao.FundDao;
import com.dao.PositionDao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.pojo.Fund;
import com.pojo.Position;
import com.pojo.Sysuser;
import com.pojo.Transaction;

public class FundAction extends ActionSupport{
	private String name;
	private String symbol;
	private String keyword;
	
	private int fundId;
	private double shares;
	private ArrayList<Fund> funds;
	private ArrayList<Position> positions;

	
	//--getters and setters to be here--//
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
	public double getShares() {
		return shares;
	}
	//--end of getter and setter--//
	
	
	public void setShares(double shares) {
		this.shares = shares;
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
	//-- get all(a list) funds using user id to query --//
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
	//--search fund by fund name--//
	public String searchFundByName() throws Exception{
		keyword = keyword.trim();
		funds=FundDao.getInstance().getByName(keyword);
		return SUCCESS;
	}
	//--search fund by fund name and user id--//
	public String searchFundByFundNameUserId() throws Exception{
		Sysuser user;
		Map session = ActionContext.getContext().getSession();
		user = (Sysuser) session.get(LoginAction.SYSUSER);
		
		if(keyword.equals("") || keyword==null){
			this.addActionError("you must enter the search key!");
			return ERROR;
		}
		keyword = keyword.trim();
		Fund f = new Fund();
		f.setName(keyword);
		if(FundDao.getInstance().isExist(f)==false){
			this.addActionError("fund does not exist!");
			return ERROR;
		}
		else{
			funds = FundDao.getInstance().getByName(keyword);
			positions = PositionDao.getInstance().getListByCustomerIdFundId(user.getId(), funds.get(0).getId());
			return SUCCESS;
		}
	}
	
	public String createFund() throws Exception{
		name=name.trim();
		symbol=symbol.trim();
		Fund f1 = new Fund();
		f1.setName(name);
		//--check if there is a fund already had the same name--//
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
	
	//--get info from customer_sell2.jsp and set info want to bo post on sellfund.jsp
	public String showSellFund() throws Exception{
		//--get user id from session--//
		Map session = ActionContext.getContext().getSession();
		Sysuser user = (Sysuser) session.get(LoginAction.SYSUSER);
		//--query by userId and fundId--//
		Position p= PositionDao.getInstance().getByCustomerIdFundId(user.getId(), fundId);
		if(p==null){
			this.addActionError("Can not find this fund");
			return ERROR;
		}
		name=p.getFundName();
		symbol=p.getFundSymbol();
		shares=p.getShares()/100.0;
		return SUCCESS;
	}
	public String sell(){
		Map session = ActionContext.getContext().getSession();
		Sysuser user = (Sysuser) session.get(LoginAction.SYSUSER);
		
	//	this.addActionError("test here");
	//	return ERROR;
		
		//--transaction needs to be filled in--//
		
		Transaction t = new Transaction();
		long s = (long) (shares*1000);
		t.setShares(s);
		t.setStatus(Transaction.TRANS_STATUS_PENDING);
		t.setTransactionType(Transaction.TRANS_TYPE_SELL);	
		TransitionDay.getInstance().newTransaction(user.getId(), fundId, t);
		
		return SUCCESS;
		
	}
	public String showBuyFund() throws Exception{
		//--get user id from session--//
		Map session = ActionContext.getContext().getSession();
		Sysuser user = (Sysuser) session.get(LoginAction.SYSUSER);
		Position p= PositionDao.getInstance().getByCustomerIdFundId(user.getId(), fundId);
		Fund f = FundDao.getInstance().getById(fundId);
		if(p==null){
			shares=0/100.0;	
		}
		else{
			shares=p.getShares()/100.0;
		}
		name=f.getName();
		symbol=f.getSymbol();
		
		
		return SUCCESS;
	}


}
