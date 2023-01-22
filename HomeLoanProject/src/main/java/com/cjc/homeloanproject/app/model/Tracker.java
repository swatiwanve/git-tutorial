package com.cjc.homeloanproject.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Tracker {
	
	@Id
	private Integer customerId;
	private String status;
	

}
