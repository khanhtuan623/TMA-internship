package com.internship.bank.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.internship.bank.model.Account;
import com.internship.bank.model.History;
import com.internship.bank.model.Refund;

@Repository
@Transactional
public class BankDaoImp implements BankDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public History checkCard(long price, String nameCard, Long numberCard, int cvc, String expDate) {
		History history = null;
		for (Account ac : this.list()) {
			if (ac.getName().equals(nameCard) && (long) ac.getNumberCard() == numberCard && ac.getCvc() == cvc
					&& ac.getExpDate().equals(expDate)) {
				if (ac.getBalance() >= price) {
					history = new History();
					history.setName(ac.getName());
					history.setNumberAccount((long) ac.getNumberAccount());
					history.setPrice(price);
					history.setRefundPriceAvai(price);
					history.setDatePayment(this.getNow());
					history.setCvc(ac.getCvc());
					history.setNumberCard(ac.getNumberCard());
					history.setStatus("success");
					history.setExchange("-");
					history.setBalance(ac.getBalance());
					history.setExpDate(ac.getExpDate());
					return history;
				} else {
					history = new History();
					history.setName(ac.getName());
					history.setNumberAccount((long) ac.getNumberAccount());
					history.setPrice(price);
					history.setRefundPriceAvai(0);
					history.setDatePayment(this.getNow());
					history.setCvc(ac.getCvc());
					history.setNumberCard(ac.getNumberCard());
					history.setStatus("fail [ balance < price ]");
					history.setExchange("null");
					history.setBalance(ac.getBalance());
					history.setExpDate(ac.getExpDate());
					history.setDatePayment(this.getNow());
					return history;
				}
			} else {
				history = new History();
				history.setName(nameCard);
				history.setNumberCard(numberCard);
				history.setCvc(cvc);
				history.setBalance(0);
				history.setExpDate(expDate);
				history.setPrice(price);
				history.setRefundPriceAvai(0);
				history.setStatus("fail [check info account]");
				history.setExchange("null");
				history.setDatePayment(this.getNow());
				history.setNumberAccount((long) 0);
				return history;
			}
		}
		return history;
	}

	@Override
	public List<Account> list() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Account> cq = cb.createQuery(Account.class);
		Root<Account> root = cq.from(Account.class);
		cq.select(root);
		Query<Account> query = session.createQuery(cq);
		return query.getResultList();
	}

	@Override
	public Boolean updateBalance(Long numberAccount, long balance) {
		Session session = sessionFactory.getCurrentSession();
		Account account = session.byId(Account.class).load(numberAccount);
		account.setBalance(balance);
		session.flush();
		return true;
	}

	@Override
	public void createHistory(History history) {
		try {
			sessionFactory.getCurrentSession().save(history);
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}

	}

	@Override
	public List<History> listHistory() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<History> cq = cb.createQuery(History.class);
		Root<History> root = cq.from(History.class);
		cq.select(root);
		Query<History> query = session.createQuery(cq);
		return query.getResultList();
	}

	@Override
	public History refund(Refund refund) {
		History history = new History();
		for (History his : this.listHistory()) {
			if (his.getId() == refund.getId() && his.getNumberAccount() != 0) {
				history.setId(his.getId());
				history.setName(his.getName());
				history.setNumberCard(his.getNumberCard());
				history.setCvc(his.getCvc());
				history.setNumberAccount(his.getNumberAccount());
				history.setExpDate(his.getExpDate());
				history.setRefundPriceAvai(his.getPrice());
				return history;
			}
		}
		return history;
	}

	private String getNow() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		return formatter.format(date).toString();
	}

	@Override
	public Boolean updateRef_Pri_His(Long id, long refundPrice) {
		Session session = sessionFactory.getCurrentSession();
		History his = session.byId(History.class).load(id);
		his.setRefundPriceAvai(refundPrice);
		session.flush();
		return true;
	}

}
