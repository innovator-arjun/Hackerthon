package com.sih.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sih.model.LoanScheme;

@Repository
public class LoanSchemeDAOImpl implements LoanSchemeDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<LoanScheme> getLoanSchemes() {
		// get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		//create a query
		Query<LoanScheme> query = session.createQuery("from LoanScheme", LoanScheme.class);
		
		List<LoanScheme> loanSchemes = query.getResultList();
		
		//To fetch Banks
		for(LoanScheme loanScheme : loanSchemes){
			Hibernate.initialize(loanScheme.getBanks());
		}
		
		return loanSchemes;
	}
	
}
