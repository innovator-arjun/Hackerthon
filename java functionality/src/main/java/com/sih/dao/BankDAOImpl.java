package com.sih.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sih.model.Bank;

@Repository
public class BankDAOImpl implements BankDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Bank> getBanks() {
		Session session = sessionFactory.getCurrentSession();
		Query<Bank> query1 = session.createQuery("from Bank",Bank.class);
		List<Bank> banks = query1.getResultList();
		return banks;
	}

}
