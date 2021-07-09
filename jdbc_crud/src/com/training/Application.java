package com.training;
import java.util.*;
import com.training.daos.Customerrepository;
import com.training.model.Customer;
import com.training.utility.Dbconnection;
import java.sql.*;


public class Application {

	public static void main(String[] args) {
		Connection con = Dbconnection.getOracleConnection();
		
		Customerrepository dao = new Customerrepository(con);
		int ch=2;
		try {
			
			if(ch==1) {
				dao.add(new Customer(3,"devi","devi@b.com"));
				dao.add(new Customer(4,"devi","devi@b.com"));
				
			}
			if(ch==2) {
				List<Customer> list = dao.findAll();
				for(Customer eachCustomer:list){
					System.out.println(eachCustomer);
				}	
				
			}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		// TODO Auto-generated method stub

	}


