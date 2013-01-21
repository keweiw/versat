package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.pojo.Fund;

public class FundDao extends BaseDao<Fund>{
	private static FundDao instance = new FundDao();
	
	public static FundDao getInstance() {
		return instance;
	}
	
	private FundDao() {
		super(Fund.class);
	}
	
	public void createFund(String name,String symbol) throws Exception{
		Fund f = new Fund(name,symbol);
		super.create(f);
	}
	
	public Fund getById(Integer id) throws Exception {
		List<Criterion> criterions = new ArrayList<Criterion>();
		Criterion criterion = Restrictions.eq("id", id);
		criterions.add(criterion);
		return super.get(criterions);
	}
	
	public ArrayList<Fund> getAllList() throws Exception{
		return (ArrayList<Fund>) super.getList();
	}
	public ArrayList<Fund> getByName(String name) throws Exception{
		List<Criterion> criterions = new ArrayList<Criterion>();
		Criterion criterion = Restrictions.eq("name", name);
		criterions.add(criterion);
		return (ArrayList<Fund>) super.getList(criterions);
	}
	
	public boolean isExist(Fund f) throws Exception{
		if(super.retrieve(f)==null)
			return false;
		else
			return true;
	}
}
