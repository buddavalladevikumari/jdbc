package com.example.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Data_Controller {
	
	@RequestMapping(value="/")
	public String init(Model model) {
		
		model.addAttribute("details","car details");
		return "index";
	}
	
	@ModelAttribute("group1")
	public String[] status() {
		return new String[] {"sold","unsold"};
		
	}
	
	
	@ModelAttribute("group2")
	public String[] model() {
		return  new  String[] {"hyundai","toyota","fortuner","suzuki"};
		
	}

}
