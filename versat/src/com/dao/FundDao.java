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
	
	public Fund getById(Integer id) throws Exception {
		List<Criterion> criterions = new ArrayList<Criterion>();
		Criterion criterion = Restrictions.eq("id", id);
		criterions.add(criterion);
		return super.get(criterions);
	}
}
