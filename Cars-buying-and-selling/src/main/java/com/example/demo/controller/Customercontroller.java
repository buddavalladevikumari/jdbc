package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.model.CarData;

import com.example.demo.repository.Car_Repository;



@Controller
public class Customercontroller {
	
	
	@Autowired
	private CarData cardata;
	
	@Autowired
	private Car_Repository repo;
	
	@RequestMapping(value="/cardata",method = RequestMethod.GET)
	public String initForm(Model model) {
		
		model.addAttribute("command",cardata);
		
		return "adddata";}
	@RequestMapping(value="/cardata",method = RequestMethod.POST)
	public String submitform(@ModelAttribute("command")CarData cardata, Model model) {
			
		System.out.println("submitform started");
	 int rowadded=	repo.adddata(cardata);
	 
		System.out.println(cardata);
	 model.addAttribute("rowAdded",rowadded);
		
		return "adddata";
}
	
	@RequestMapping(value="/cardata/all",method = RequestMethod.GET)
	public String findallcustomer(Model model) {
		
		List<CarData> list = repo.getallCardata();
		model.addAttribute("list",list);
		
		return "showdetails";}

	@RequestMapping(value="/cardata/sold",method = RequestMethod.GET)
	public String findallcustomer1(Model model) {
		
		List<CarData> list1 = repo.getallCardata1();
		model.addAttribute("list",list1);
		
		return "soldcars";}
	
	
	@RequestMapping(value="/cardata/model",method = RequestMethod.GET)
	public String findallcustomer2(Model model) {
		
		List<CarData> list2 = repo.getallCardata2();
		model.addAttribute("list",list2);
		
		return "model";}

}

	
	
	
	