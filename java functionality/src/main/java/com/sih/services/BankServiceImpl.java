package com.sih.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sih.dao.BankDAO;
import com.sih.model.Bank;

@Service
public class BankServiceImpl implements BankService {

	@Autowired
	private BankDAO bankDAO;
	
	@Override
	public List<Bank> getBanks() {
		return bankDAO.getBanks();
	}

}
