package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.pojo.Sysuser;

public class SysuserDao extends BaseDao<Sysuser>{
	private static SysuserDao instance = new SysuserDao();
	
	private SysuserDao() {
		super(Sysuser.class);
	}
	
	public static SysuserDao getInstance() {
		return instance;
	}
	
	public ArrayList<Sysuser> getUsersByType(int type) throws Exception {
		List<Criterion> criterions = new ArrayList<Criterion>();
		Criterion criterion = Restrictions.eq("type", type);
		criterions.add(criterion);
		return (ArrayList<Sysuser>) super.getList(criterions);
	}
	
	public Sysuser getByUsername(String username) throws Exception {
		List<Criterion> criterions = new ArrayList<Criterion>();
		Criterion criterion = Restrictions.eq("username", username);
		criterions.add(criterion);
		return super.get(criterions);
	}
	
	public Sysuser getByUserId(int id) throws Exception {
		List<Criterion> criterions = new ArrayList<Criterion>();
		Criterion criterion = Restrictions.eq("id", id);
		criterions.add(criterion);
		return super.get(criterions);
	}
	
	public void update(Sysuser user) throws Exception {
		super.update(user);
	}

}
