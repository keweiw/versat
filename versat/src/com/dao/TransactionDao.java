package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.pojo.Fund;
import com.pojo.Transaction;

public class TransactionDao extends BaseDao<Transaction> {
	private static TransactionDao instance = new TransactionDao();

	public static TransactionDao getInstance() {
		return instance;
	}

	private TransactionDao() {
		super(Transaction.class);
	}

	public ArrayList<Transaction> getListByUserId(int userId) throws Exception {
		List<Criterion> criterions = new ArrayList<Criterion>();
		Criterion criterion = Restrictions.eq("sysuser.id", userId);
		criterions.add(criterion);
		return (ArrayList<Transaction>) super.getList(criterions);
	}
	
	public Transaction getById(Integer id) throws Exception {
		List<Criterion> criterions = new ArrayList<Criterion>();
		Criterion criterion = Restrictions.eq("id", id);
		criterions.add(criterion);
		return super.get(criterions);
	}
	
	
	public ArrayList<Transaction> displayByOperation(int userId, int operation) throws Exception {
		List<Criterion> criterions = new ArrayList<Criterion>();
		Criterion criterion1 = Restrictions.eq("sysuser.id", userId);
		criterions.add(criterion1);
		Criterion criterion2 = Restrictions.eq("transactionType", operation);
		criterions.add(criterion2);
		return (ArrayList<Transaction>) super.getList(criterions);	
	}
	
	public void createTransaction(Transaction transaction) throws Exception{
		super.create(transaction);

	}
	
}
