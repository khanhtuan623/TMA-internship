package com.internship.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.internship.bank.dao.BankDao;
import com.internship.bank.model.Account;
import com.internship.bank.model.History;
import com.internship.bank.model.Refund;

@Service
@Transactional
public class BankServiceImp implements BankService {

	@Autowired
	private BankDao bankDao;
	
	@Override
	public List<Account> list() {
		// TODO Auto-generated method stub
		return bankDao.list();
	}

	@Override
	public History checkCard(long price,String nameCard, Long numberCard, int cvc,String expDate) {
		// TODO Auto-generated method stub
		return bankDao.checkCard(price,nameCard, numberCard, cvc,expDate);
	}

	@Override
	public void createHistory(History history) {
		bankDao.createHistory(history);
		
	}

	@Override
	public List<History> listHistory() {
		// TODO Auto-generated method stub
		return bankDao.listHistory();
	}

	@Override
	public History refund(Refund refund) {
		return bankDao.refund(refund);
		
	}

	@Override
	public Boolean updateBalance(Long numberAccount, long Balance) {
		// TODO Auto-generated method stub
		return bankDao.updateBalance(numberAccount, Balance);
	}

	@Override
	public Boolean updateRef_Pri_His(Long id, long refundPrice) {
		// TODO Auto-generated method stub
		return bankDao.updateRef_Pri_His(id, refundPrice);
	}

}
