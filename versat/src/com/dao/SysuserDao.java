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
	
	public ArrayList<Sysuser> getUsersByUsername(String username, int type) throws Exception {
		List<Criterion> criterions = new ArrayList<Criterion>();
		Criterion criterion = Restrictions.eq("type", type);
		Criterion criterion1 = Restrictions.like("username", username);
		criterions.add(criterion);
		criterions.add(criterion1);
		return (ArrayList<Sysuser>) super.getList(criterions);
	}
	
	public ArrayList<Sysuser> getUsersByFirstname(String firstname, int type) throws Exception {
		List<Criterion> criterions = new ArrayList<Criterion>();
		Criterion criterion = Restrictions.eq("type", type);
		Criterion criterion1 = Restrictions.like("firstname", firstname);
		criterions.add(criterion);
		criterions.add(criterion1);
		return (ArrayList<Sysuser>) super.getList(criterions);
	}
	
	public ArrayList<Sysuser> getUsersByLastname(String lastname, int type) throws Exception {
		List<Criterion> criterions = new ArrayList<Criterion>();
		Criterion criterion = Restrictions.eq("type", type);
		Criterion criterion1 = Restrictions.like("lastname", lastname);
		criterions.add(criterion);
		criterions.add(criterion1);
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
	
	public Sysuser getByUserFirstname(String firstname) throws Exception {
		List<Criterion> criterions = new ArrayList<Criterion>();
		Criterion criterion = Restrictions.eq("firstname", firstname);
		criterions.add(criterion);
		return super.get(criterions);
	}
	
	public Sysuser getByUserLastname(String lastname) throws Exception {
		List<Criterion> criterions = new ArrayList<Criterion>();
		Criterion criterion = Restrictions.eq("lastname", lastname);
		criterions.add(criterion);
		return super.get(criterions);
	}
	
	public void update(Sysuser user) throws Exception {
		super.update(user);
	}
	
	public void create(Sysuser user) throws Exception {
		super.create(user);
	}

}
