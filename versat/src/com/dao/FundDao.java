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
	public ArrayList<Fund> getByName(String name, boolean isLike) throws Exception{
		List<Criterion> criterions = new ArrayList<Criterion>();
		Criterion criterion;
		if(isLike==true)
			criterion = Restrictions.like("name", "%"+name+"%");
		else
			criterion = Restrictions.eq("name", name);
		criterions.add(criterion);
		return (ArrayList<Fund>) super.getList(criterions);
	}
	public ArrayList<Fund> getBySymbol(String symbol, boolean isLike) throws Exception{
		List<Criterion> criterions = new ArrayList<Criterion>();
		Criterion criterion;
		if(isLike==true)
			criterion = Restrictions.like("symbol", "%"+symbol+"%");
		else
			criterion = Restrictions.eq("symbol", symbol);
		criterions.add(criterion);
		return (ArrayList<Fund>) super.getList(criterions);
	}
	
	
	public boolean isExist(Fund f) throws Exception{
		if(super.getByExample(f)==null)
			return true;
		else
			return false;
	}
	/**/
}
