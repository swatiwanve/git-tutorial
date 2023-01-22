package com.cjc.homeloanproject.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.homeloanproject.app.model.Address;
import com.cjc.homeloanproject.app.model.Customer;
import com.cjc.homeloanproject.app.service.HomeLoanServiceI;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class AddressController {
	
	@Autowired
	HomeLoanServiceI hs;
	
	@PostMapping("/postAddress")
	public ResponseEntity<Address> postCustomerAddress(@RequestBody Address a)
	{
		if(a.getCustomerAddrId()==0)
		{
			return new ResponseEntity<Address>(HttpStatus.BAD_REQUEST);
		}
		
		Address cust=hs.PostCustomer(a);
		return new ResponseEntity<Address>(HttpStatus.CREATED);
	}
	
	@GetMapping("/getAddress")
	public ResponseEntity<List<Address>> getCustomerAddress()
	{
		List<Address> list=hs.getAddress();
		if(list.isEmpty())
		{
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Address>>(HttpStatus.OK);
	}
	@PutMapping("/updateAddress/{customerAddrId}")
	public ResponseEntity<Address> updateData(@RequestBody Address a, @PathVariable int customerAddrId) {
		
		Address addr = hs.updateCustomerAddress(customerAddrId,a);
		return new ResponseEntity<Address>(a,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteAddress/{customerAddrId}")
	public ResponseEntity<Address> deleteAddr(@PathVariable int customerAddrId )
	{
			
		
		hs.deleteAdress(customerAddrId);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	

}