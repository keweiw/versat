package com.action;

import java.util.ArrayList;

import com.dao.FundDao;
import com.dao.PositionDao;
import com.opensymphony.xwork2.ActionSupport;
import com.pojo.Fund;
import com.pojo.Position;
import com.pojo.Sysuser;

public class FundAction extends ActionSupport{
	private String name;
	private String symbol;
	private ArrayList<Fund> funds;
	private ArrayList<Position> positions;
	
	public ArrayList<Fund> getFunds(){
		return funds;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName() {
		this.name = name;
	}
	
	public String getSymbol() {
		return symbol;
	}
	
	public void setSymbol() {
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
	
	public String listFundByUserId(int userId){
		try{
			positions=PositionDao.getInstance().getPositionByCostomerId(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
}
