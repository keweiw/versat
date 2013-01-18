package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.pojo.Position;

public class PositionDao extends BaseDao<Position>{
	private static PositionDao instance = new PositionDao();

	public static PositionDao getInstance() {
		return instance;
	}
	private PositionDao() {
		super(Position.class);
	}
	
	public ArrayList<Position> getPositionByCostomerId(int id) throws Exception{
		List<Criterion> criterions = new ArrayList<Criterion>();
		Criterion criterion = Restrictions.eq("customer_id", id);
		criterions.add(criterion);
		return (ArrayList<Position>) super.getList(criterions);
	}
}
