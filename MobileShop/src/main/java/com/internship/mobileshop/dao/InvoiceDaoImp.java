package com.internship.mobileshop.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.internship.mobileshop.model.Invoice;

@Repository
@Transactional
public class InvoiceDaoImp implements InvoiceDao {
	
	@Autowired
	private SessionFactory sessionFactory;
//	@Autowired
//	private BankAccountDao accountDao;

//	@Override
//	public Boolean inforCustomer(BankAccount a) {
//		List<BankAccount> list = this.accountDao.list();
//		String userName = a.getUserName().trim().toUpperCase();
//		Long numberCard = a.getNumberCard();
//		int securityCode = a.getSecurityCode();
//		int balance = a.getBalance();
//		for (BankAccount account : list) {
//			// if(userName.equals(account.getUserName().trim().toUpperCase())&&numberCard==account.getNumberCard()&&securityCode==account.getSecurityCode()&&balance)
//			// {
//			// return true;
//			// }
//		}
//		return false;
//	}

	@Override
	public void createInvoice(Invoice invoice) {
		try {
			sessionFactory.getCurrentSession().save(invoice);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
}
