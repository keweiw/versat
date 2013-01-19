package com.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.pojo.FundPriceHistory;

public class FundPriceHistoryDao extends BaseDao<FundPriceHistory>{
	private static FundPriceHistoryDao instance = new FundPriceHistoryDao();
	
	public static FundPriceHistoryDao getInstance() {
		return instance;
	}

	private FundPriceHistoryDao() {
		super(FundPriceHistory.class);
	}
	
	public FundPriceHistory getLatestFundHistoryById(int fundId) throws Exception {
		List<Criterion> criterions = new ArrayList<Criterion>();
		Criterion criterion = Restrictions.eq("fund.id", fundId);
		criterions.add(criterion);
		return (FundPriceHistory)super.getMaxId(criterions);
	}
	
	public ArrayList<FundPriceHistory> getListByDate(Date date) throws Exception {
		List<Criterion> criterions = new ArrayList<Criterion>();
		Criterion criterion = Restrictions.eq("priceDate", date);
		criterions.add(criterion);
		return (ArrayList<FundPriceHistory>)super.getList(criterions);
	}
	
	public FundPriceHistory getLastDay() throws Exception {
		FundPriceHistory t = null;
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			session.setFlushMode(FlushMode.AUTO);
			session.getTransaction().begin();

			Criteria criteria = session.createCriteria(FundPriceHistory.class);
			t = (FundPriceHistory) criteria.setProjection(Projections.max("priceDate")).uniqueResult();
			session.flush();
			session.getTransaction().commit();

		} catch (HibernateException e) {
			throw e;
		} finally {
			session.close();
		}
		return t;
	}
	
	public void create(FundPriceHistory fph) throws Exception {
		super.create(fph);
	}
	
	public void update(FundPriceHistory fph) throws Exception {
		super.update(fph);
	}
}
