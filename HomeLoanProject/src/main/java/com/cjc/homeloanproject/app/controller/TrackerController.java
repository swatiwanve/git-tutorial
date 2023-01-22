package com.cjc.homeloanproject.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.homeloanproject.app.model.Tracker;
import com.cjc.homeloanproject.app.service.HomeLoanServiceI;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class TrackerController {
	
	@Autowired
	HomeLoanServiceI hi;
	
	@RequestMapping("/showTrackerPage")
	public String showTrackerPage(Model model) {
		model.addAttribute("tracker", new Tracker());
		model.addAttribute("status", " ");
		return  "trackerPage";
	} 
	
//	@RequestMapping(value ="/getStatus", method=RequestMethod.POST)
//	public String showStatus(@ModelAttribute("tracker") @Validated Tracker tracker,
//			BindingResult bindingResult, Model model) {
//			String viewName="";
//			model.addAttribute("status", HomeLoanServiceI.getStatusById(tracker));
//			System.err.println("STATUS"+HomeLoanServiceI.getStatusById(tracker));
//			viewName="trackerPage";
//			return viewName;
//		
//	}
//	

}
