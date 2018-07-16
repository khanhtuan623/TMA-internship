package com.internship.bank.service;

import java.util.List;

import com.internship.bank.model.Account;
import com.internship.bank.model.History;
import com.internship.bank.model.Refund;

public interface BankService {
	void createHistory(History history);

	List<Account> list();

	List<History> listHistory();

	History refund(Refund refund);

	Boolean updateBalance(Long numberAccount, long Balance);

	Boolean updateRef_Pri_His(Long id, long refundPrice);

	History checkCard(long price, String nameCard, Long numberCard, int cvc, String expDate);
}
