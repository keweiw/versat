package com.dao;

import com.pojo.FundPriceHistory;

public class FundPriceHistoryDao extends BaseDao<FundPriceHistory>{
	private static FundPriceHistoryDao instance = new FundPriceHistoryDao();
	
	public static FundPriceHistoryDao getInstance() {
		return instance;
	}

	private FundPriceHistoryDao() {
		super(FundPriceHistory.class);
	}
}
