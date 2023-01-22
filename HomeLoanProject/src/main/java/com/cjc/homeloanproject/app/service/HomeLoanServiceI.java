package com.cjc.homeloanproject.app.service;

import java.util.List;


import com.cjc.homeloanproject.app.model.Address;
import com.cjc.homeloanproject.app.model.AllPersonDocument;
import com.cjc.homeloanproject.app.model.Customer;
import com.cjc.homeloanproject.app.model.Guarantor;
import com.cjc.homeloanproject.app.model.LoanDisbusment;
import com.cjc.homeloanproject.app.model.PropertyInfo;
import com.cjc.homeloanproject.app.model.Tracker;

public interface HomeLoanServiceI {

	public List<Customer> getCustomer();
	public Customer PostCustomer(Customer c);
	public Customer updateCustomer(int id, Customer p);
	public void delete(int customerId);
	
	////////////All Person Document///////////////////////
	public List<AllPersonDocument> saveDocument(AllPersonDocument document);
	
	//***************Guarantor********************
	public List<Guarantor> getGuranter();
	public Guarantor saveGauranter(Guarantor p);
	public void deleteGuranter(Integer guranterId);
	public Guarantor updateGuarantor(Integer guranterId, Guarantor p);
	public List<Guarantor> saveAllDocument(Guarantor document);

	//////////Address////

	public Address PostCustomer(Address a);
	public List<Address> getAddress();
	public Address updateCustomerAddress(int customerAddrId, Address a);
	public void deleteAdress(int customerAddrId);

	
	
	////////////Tracker////////////////
	
	//public Integer getStatusById(Tracker tracker);

	///////Loan Disbusment//////////////
	
	public List<LoanDisbusment> getLoanDisbusment();
	public LoanDisbusment saveLoanDisburst(LoanDisbusment agreementId);
	public LoanDisbusment updateLoanDisburstment(Integer agreementId, LoanDisbusment ld);
	public void deleteDisbusment(int agreementId);
	public List<PropertyInfo> getPropertyInfo();
	public PropertyInfo savePropertyinfi(PropertyInfo p);
	public void deleteProperty(Integer propertyId);
	//public PropertyInfo updateProperty(Integer propertyId, PropertyInfo p);
	public PropertyInfo updateProperty(Integer propertyId, PropertyInfo p);
	public List<PropertyInfo> saveDocument(PropertyInfo document);
	
	
	
	
	
	
	



	



}
