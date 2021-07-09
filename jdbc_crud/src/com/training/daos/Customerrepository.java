package com.training.daos;
import java.util.ArrayList;
import java.util.List;

import com.training.ifaces.Crudrepository;
import com.training.model.Customer;
import java.sql.*;

public  class Customerrepository implements Crudrepository<Customer> {
	private Connection con;
	
	@Override
	public int add(Customer t) throws SQLException{
	 String sqlAdd = "insert into Customer values(?,?,?)";
	 PreparedStatement pstmt = con.prepareStatement(sqlAdd);
	 pstmt.setInt(1, t.getId());
	 pstmt.setString(2, t.getCustomername());
	 pstmt.setString(3, t.getEmail());
	
	int rowAdded = pstmt.executeUpdate();
	 return rowAdded;

}
	public Customerrepository(Connection con) {
		super();
		this.con=con;
		
	}
	@Override
	public List<Customer> findAll() throws SQLException {
		// TODO Auto-generated method stub
	
	 List<Customer> custList = new ArrayList<>();
	 String sql = "select * from Customer";
	 PreparedStatement pstmt = con.prepareStatement(sql);
	 ResultSet rs = pstmt.executeQuery();
	 while(rs.next()) {
		 int id = rs.getInt("id");
		 String customername = rs.getString("customername");
		 String email = rs.getString("email");
		 
		 custList.add(new Customer(id,customername,email));
	 }
	 return custList;	 
}
	 public Connection getcon() {
		 return con;
}
	 public void setcon(Connection con) {
		 this.con = con;	 
	 }
//	 @Override
//	 public Customer findById(int key) throws SQLException{
//		 return null;
//	 }
//	
//	@Override
//	 public boolean remove(int key) throws SQLException {
//		  return false;
//		 
//	 }
	@Override
	public boolean remove(int key) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	 
}
