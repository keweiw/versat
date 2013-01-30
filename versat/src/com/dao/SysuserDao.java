package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.pojo.Sysuser;

public class SysuserDao extends BaseDao<Sysuser>{
	public static final String USERNAME = "username";
	public static final String FIRSTNAME = "firstname";
	public static final String LASTNAME = "lastname";
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
	
	public ArrayList<Sysuser> getUser(String searchBy, String orderBy, boolean isAsc, String searchkey, int type) throws Exception {
		List<Criterion> criterions = new ArrayList<Criterion>();
		Criterion criterion = Restrictions.eq("type", type);
		criterions.add(criterion);
		if(searchBy != null){
			Criterion criterion1 = Restrictions.like(searchBy, "%"+searchkey+"%");
			criterions.add(criterion1);
		}
		return (ArrayList<Sysuser>) super.getList(0, 0, orderBy, isAsc, criterions);
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
