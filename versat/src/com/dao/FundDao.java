package com.dao;

import com.pojo.Fund;

public class FundDao extends BaseDao<Fund>{
	private static FundDao instance = new FundDao();
	
	public static FundDao getInstance() {
		return instance;
	}
	
	private FundDao() {
		super(Fund.class);
	}
}
