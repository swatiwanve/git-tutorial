package com.cjc.homeloanproject.app.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


import com.cjc.homeloanproject.app.model.Address;
import com.cjc.homeloanproject.app.model.AllPersonDocument;
import com.cjc.homeloanproject.app.model.Customer;
import com.cjc.homeloanproject.app.model.Guarantor;
import com.cjc.homeloanproject.app.model.LoanDisbusment;
import com.cjc.homeloanproject.app.model.PropertyInfo;
import com.cjc.homeloanproject.app.model.Tracker;
import com.cjc.homeloanproject.app.repository.AddressRepository;
import com.cjc.homeloanproject.app.repository.AllPersonDocumentRepository;
import com.cjc.homeloanproject.app.repository.GurantorRepository;
import com.cjc.homeloanproject.app.repository.HomeLoanRepository;
import com.cjc.homeloanproject.app.repository.LoanDisbusmentRepository;
import com.cjc.homeloanproject.app.repository.PropertyInfoRepository;
import com.cjc.homeloanproject.app.repository.TrackerRepository;
import com.cjc.homeloanproject.app.service.HomeLoanServiceI;
@Service
public class HomeLoanServiceImpl implements HomeLoanServiceI
{
	@Autowired
	HomeLoanRepository hlr;
	
	@Autowired
	AllPersonDocumentRepository apd;
	
	@Autowired
	GurantorRepository gr;
	
	@Autowired
	AddressRepository ar;
	
	@Autowired 
	TrackerRepository tr;
	
	@Autowired
	LoanDisbusmentRepository ldr;
	
	@Autowired
	PropertyInfoRepository pir;

	@Override
	public List<Customer> getCustomer()
	{
		List<Customer> list=hlr.findAll();
		
		return list;
	}

	@Override
	public Customer PostCustomer(Customer c)
	{
		Customer cust=hlr.save(c);
		return cust;
	}


	
	

	@Override
	public Customer updateCustomer(int customerId, Customer c) {
		Optional<Customer> op  = hlr.findById(customerId);
		 if(op.isPresent()) 
		 {
			 Customer cust= op.get();
			 cust.setCustomerFname(c.getCustomerFname());
			 cust.setCustomerMname(c.getCustomerMname());
			 cust.setCustomerLname(c.getCustomerLname());
			 
			 return   hlr.save(cust);
		 }
		 else
		 {
			 return null;
		 }
		
		
	}

	@Override
	public void delete(int customerId) {
		hlr.deleteById(customerId);
		
	}

	
		@Override
		public List<AllPersonDocument> saveDocument(AllPersonDocument doc)
		{
			apd.save(doc);
			
			
			return apd.findAll();
		}

		
	
		///////////////////////////////Guarantor////////////////////////
		
		@Override
		public List<Guarantor> getGuranter() 
		{
			List<Guarantor> list=gr.findAll();
			return list;
		}

		@Override
		public Guarantor saveGauranter(Guarantor p) {
			
			Guarantor g=gr.save(p);
			return g;
		}

		@Override
		public void deleteGuranter(Integer guranterId) {
			gr.deleteById(guranterId);
			
		}

		@Override
		public Guarantor updateGuarantor(Integer guranterId, Guarantor c) {
			
			Optional<Guarantor> op  = gr.findById(guranterId);
			 if(op.isPresent()) 
			 {
				 Guarantor gur= op.get();
				 gur.setGurantorId(c.getGurantorId());
				 gur.setGuarantorFname(c.getGuarantorFname()); 
				 
				 return   gr.save(gur);
			 }
			 else
			 {
				 return null;
			 }
		
		}

		

		@Override
		public List<Guarantor> saveAllDocument(Guarantor document) {
			
			gr.save(document);
			return gr.findAll();
		}

		
	
////////Address////////////////////
		@Override
		public Address PostCustomer(Address a)
		{
			Address aa=ar.save(a);
			
			return aa;
		}

		@Override
		public List<Address> getAddress() {
			
			List<Address> list1=ar.findAll();
			return list1;
			
		}

		@Override
		public Address updateCustomerAddress(int customerAddrId, Address a)
		{
			Optional<Address> op  = ar.findById(customerAddrId);
			 if(op.isPresent()) 
			 {
				 Address addr= op.get();
				 addr.setCustomerAddrId(a.getCustomerAddrId());
				 addr.setFullAddress(a.getFullAddress());
				 addr.setTaluka(a.getTaluka());
				 addr.setDistrict(a.getDistrict());
				 addr.setState(a.getState());
				 addr.setPincode(a.getPincode());
				  
				 return   ar.save(addr);
			 }
			 else
			 {
				 return null;
			 }
			
		}

		@Override
		public void deleteAdress(int customerAddrId) {
			System.out.println("Id deleted Sucessfully");
			ar.deleteById(customerAddrId);
			
		}

		
		
//		@Override
//		public Integer getStatusById(Tracker tracker) {
//			return trackerDao.getStatusById(tracker);
//			
//			return null;
//		}

		
		/////////////////////Loan Disbusment/////////////////
		@Override
		public List<LoanDisbusment> getLoanDisbusment() {
			
			List<LoanDisbusment> list=ldr.findAll();
			return list;
			
		}

		@Override
		public LoanDisbusment saveLoanDisburst(LoanDisbusment agreementId) {
			
			LoanDisbusment loan=ldr.save(agreementId);
			return loan;
			
			
			
		}

		@Override
		public LoanDisbusment updateLoanDisburstment(Integer agreementId, LoanDisbusment ld) {
			
			Optional<LoanDisbusment> op  = ldr.findById(agreementId);
			 if(op.isPresent()) 
			 {
				 LoanDisbusment loan=op.get();
				 loan.setAgreementId(ld.getAgreementId());
				 loan.setLoanNo(ld.getLoanNo());
				// loan.setAccountType(ld.getAccountType());
				//loan.setAgreementDate(ld.getAgreementDate());
				//loan.setAmountPaidDate(ld.getAmountPaidDate());
				//loan.setAmountPayType(ld.getAmountPayType());
				//loan.setBankName(ld.getBankName());
				//loan.setIFSCCode(ld.getIFSCCode());
				//loan.setAccountNumber(ld.getAccountNumber());
				//loan.setTransferAmount(ld.getTransferAmount());
				//loan.setPaymentStatus(ld.getPaymentStatus());
				//loan.setTotalAmount(ld.getTotalAmount());
				
				 return   ldr.save(loan);
			 }
			 else
			 {
				 return null;
			 }
		}

		@Override
		public void deleteDisbusment(int agreementId) {
		
				ldr.deleteById(agreementId);
				
			
		}
/////////////////////////////////////Prperty Info//////////////////////
		@Override
		public List<PropertyInfo> getPropertyInfo() {
			List<PropertyInfo> list=pir.findAll();
			return list;
			
		}

		@Override
		public PropertyInfo savePropertyinfi(PropertyInfo p) {
			PropertyInfo info=pir.save(p);
			return info;
			
			
		}

		@Override
		public void deleteProperty(Integer propertyId) {
			pir.deleteById(propertyId);
			
		}

		@Override
		public PropertyInfo updateProperty(Integer propertyId, PropertyInfo p) {
			
			Optional<PropertyInfo> op  = pir.findById(propertyId);
			 if(op.isPresent()) 
			 {
				 PropertyInfo info= op.get();
				 info.setPropertyId(p.getPropertyId());
				 info.setPropertyPrice(p.getPropertyPrice());
				 info.setPropertyType(p.getPropertyType());
				// info.setPropertyDocuments(p.getPriceProof());
				 // info.setPriceProof(p.getPriceProof());
				 return   pir.save(info);
			 }
			 else
			 {
				 return null;
			 }
			
		}

		@Override
		public List<PropertyInfo> saveDocument(PropertyInfo document) {
			
			pir.save(document);
			return pir.findAll();
		}
		
		
		
		
		
		
	

}
