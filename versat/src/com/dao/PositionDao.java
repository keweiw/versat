package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.pojo.Fund;
import com.pojo.Position;

public class PositionDao extends BaseDao<Position>{
	private static PositionDao instance = new PositionDao();

	public static PositionDao getInstance() {
		return instance;
	}
	private PositionDao() {
		super(Position.class);
	}
	public ArrayList<Position> getAllList() throws Exception{
		return (ArrayList<Position>) super.getList();
	}
	
	public ArrayList<Position> getPositionByCostomerId(int id) throws Exception{
		List<Criterion> criterions = new ArrayList<Criterion>();
		Criterion criterion = Restrictions.eq("iduser", id);
		criterions.add(criterion);
		return (ArrayList<Position>) super.getList(criterions);
	}
	public Position getByCustomerIdFundId(int customerId, int fundId) throws Exception{
		List<Criterion> criterions = new ArrayList<Criterion>();
		Criterion criterion = Restrictions.eq("iduser", customerId);
		Criterion criterion2 = Restrictions.eq("fund.id", fundId);
		criterions.add(criterion);
		criterions.add(criterion2);
		return super.get(criterions);
	}
	public ArrayList<Position> getListByCustomerIdFundId(int customerId, int fundId) throws Exception{
		List<Criterion> criterions = new ArrayList<Criterion>();
		Criterion criterion = Restrictions.eq("iduser", customerId);
		Criterion criterion2 = Restrictions.eq("fund.id", fundId);
		criterions.add(criterion);
		criterions.add(criterion2);
		return (ArrayList<Position>) super.getList(criterions);
	}
/*	public ArrayList<Position> getListByCustomerIdFundName(int customerId, String fundName) throws Exception{
		Position p = new Position();
		Fund f = new Fund();
		p.setIduser(customerId);
		p.setId(null);
		f.setName(fundName);
		
		p.setFund(f);
		
		return (ArrayList<Position>) super.getByExample(p);
	}
	*/
}
