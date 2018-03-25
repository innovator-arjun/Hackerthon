package com.sih.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sih.dao.LoanSchemeDAO;
import com.sih.model.LoanScheme;

@Service
public class LoanSchemeServiceImpl implements LoanSchemeService{

	@Autowired
	private LoanSchemeDAO loanSchemDAO;
	
	@Override
	@Transactional
	public List<LoanScheme> getLoanSchemes() {
		return loanSchemDAO.getLoanSchemes();
	}

}
