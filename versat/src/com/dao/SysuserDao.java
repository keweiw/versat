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
	
	public Sysuser getByUsername(String username) throws Exception {
		List<Criterion> criterions = new ArrayList<Criterion>();
		Criterion criterion = Restrictions.eq("username", username);
		criterions.add(criterion);
		return super.get(criterions);
	}

}
