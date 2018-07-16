package com.internship.bank.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.internship.bank.model.Account;
import com.internship.bank.model.History;
import com.internship.bank.model.InfoPayment;
import com.internship.bank.model.Refund;
import com.internship.bank.model.infoShow;
import com.internship.bank.service.BankService;

@RestController
public class BankController {

	@Autowired
	private BankService bankService;

	@GetMapping("/account")
	public ResponseEntity<List<Account>> list() {
		List<Account> accounts = bankService.list();
		return ResponseEntity.ok().body(accounts);
	}

	@GetMapping("/history")
	public ResponseEntity<List<History>> listHistory() {
		List<History> histories = bankService.listHistory();
		return ResponseEntity.ok().body(histories);
	}

	@PostMapping(value = "/payment", produces = MediaType.APPLICATION_JSON_VALUE)
	public infoShow payment(@RequestBody InfoPayment info) {
		infoShow infoShow = null;
		History history = bankService.checkCard(info.getPrice(), info.getName(), info.getNumberCard(), info.getCvc(),
				info.getExpDate());
		long updatebalance;
		updatebalance = history.getBalance() - history.getPrice();
		if (history.getBalance() >= history.getPrice()) {
			bankService.updateBalance(history.getNumberAccount(), updatebalance);
		}
		bankService.createHistory(history);
		infoShow = new infoShow(history.getId(), history.getName(), history.getNumberCard(), history.getNumberAccount(),
				history.getStatus(), history.getExchange(), history.getPrice(), history.getDatePayment());
		return infoShow;
	}

	@PostMapping(value = "refund", produces = MediaType.APPLICATION_JSON_VALUE)
	public infoShow refund(@RequestBody Refund refund) {
		infoShow infoShow = null;
		History history;
		long updatebalance;
		long refundPriceAvai;
		for (Account ac : bankService.list()) {
			if (ac.getNumberAccount().equals(bankService.refund(refund).getNumberAccount())) {
				
				history = new History();
				history.setName(bankService.refund(refund).getName());
				history.setCvc(bankService.refund(refund).getCvc());
				history.setNumberCard(bankService.refund(refund).getNumberCard());
				history.setNumberAccount(bankService.refund(refund).getNumberAccount());
				history.setBalance(ac.getBalance());
				history.setStatus("success");
				history.setExchange("+");
				history.setPrice(refund.getPrice());
				history.setExpDate(bankService.refund(refund).getExpDate());
				history.setDatePayment(this.getNow());
				bankService.createHistory(history);
				if(refund.getPrice()<=bankService.refund(refund).getRefundPriceAvai()) {
					updatebalance = ac.getBalance() + refund.getPrice();
					bankService.updateBalance(ac.getNumberAccount(), updatebalance);
					refundPriceAvai = bankService.refund(refund).getRefundPriceAvai()-refund.getPrice();
					bankService.updateRef_Pri_His(bankService.refund(refund).getId(), refundPriceAvai);
				}
				else {
					infoShow=new infoShow(refund.getId(), "Refund-Price > Refund-Price-Available", refund.getPrice(), bankService.refund(refund).getRefundPriceAvai(),this.getNow());
					return infoShow;
				}
				infoShow = new infoShow(history.getId(), history.getName(), history.getNumberCard(),
						history.getNumberAccount(), history.getStatus(), history.getExchange(), history.getPrice(),
						history.getDatePayment());
				System.out.println("done");
				return infoShow;
			}
		}
		return infoShow;
	}

	private String getNow() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		return formatter.format(date).toString();
	}
}
