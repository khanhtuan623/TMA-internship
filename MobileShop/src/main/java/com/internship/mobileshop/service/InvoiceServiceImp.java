package com.internship.mobileshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.internship.mobileshop.dao.InvoiceDao;
import com.internship.mobileshop.model.Invoice;

@Service
@Transactional
public class InvoiceServiceImp implements InvoiceService {

	@Autowired
	private InvoiceDao invoiceDao;
//	@Override
//	public Boolean inforCustomer(BankAccount account) {
//		// TODO Auto-generated method stub
//		return invoiceDao.inforCustomer(account);
//	}

	@Override
	public void createInvoice(Invoice invoice) {
		// TODO Auto-generated method stub
		invoiceDao.createInvoice(invoice);
	}

}
