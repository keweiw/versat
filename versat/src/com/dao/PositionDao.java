package com.dao;

import com.pojo.Position;

public class PositionDao extends BaseDao<Position>{
	private static PositionDao instance = new PositionDao();

	public static PositionDao getInstance() {
		return instance;
	}

	private PositionDao() {
		super(Position.class);
	}

}
