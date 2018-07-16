package com.internship.mobileshop.dao;

import com.internship.mobileshop.model.Invoice;

public interface InvoiceDao {
//	Boolean inforCustomer(BankAccount account);
	void createInvoice(Invoice invoice);
}
