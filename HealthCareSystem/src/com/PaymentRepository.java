package com;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class PaymentRepository 
{

	
	Connection con = null;
	
	public PaymentRepository() 
	{
		String url = "jdbc:mysql://localhost:3306/paf";
		String username = "root";
		String password = "";
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,username,password);
	    }
		catch(Exception e){
			System.out.println(e);
		}
		
	}
	public List<Payment> getPayments(){
		
		List<Payment> payments = new ArrayList<>();
		String sql = "Select * from payment";
		try 
		{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next())
			{
				Payment p = new Payment();
				p.setPaymentId(rs.getInt(1));
				p.setPatientName(rs.getString(2));
				p.setAmout(rs.getInt(3));
				p.setType(rs.getString(4));
				p.setDate(rs.getInt(5));
				
				
				payments.add(p);
				
				}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return payments;
	}
	
	public Payment getPayment(int paymentId) 
	{
		String sql = "Select * from payment where PaymentId="+ paymentId;
		Payment p = new Payment();
		try 
		{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next())
			{
				
				p.setPaymentId(rs.getInt(1));
				p.setPatientName(rs.getString(2));
				p.setAmout(rs.getInt(3));
				p.setType(rs.getString(4));
				p.setDate(rs.getInt(5));
				
				
				
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return p;
		
		
	}	
		
		
	public void create(Payment p1) {
		String sql = "insert into payment values(?,?,?,?,?)";
		try 
		{
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, p1.getPaymentId());
			st.setString(2,p1.getPatientName());
			st.setInt(3,p1.getAmout());
			st.setString(4,p1.getType());
			st.setInt(5,p1.getDate());
			
			st.executeLargeUpdate();
				
		}
		
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	
	
	public void update(Payment p1) {
		String sql = "update payment set Amount= ?,Type =? where PaymentId =?";
		try 
		{
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(3, p1.getPaymentId());
			st.setInt(1,p1.getAmout());
			st.setString(2,p1.getType());
			
			st.executeLargeUpdate();
				
		}
		
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	public void delete(int PaymentId) {
		
			String sql = "delete from payment where id=?";
			try
			{
			PreparedStatement st = con.prepareStatement(sql);
		
			st.setInt(1,PaymentId);
			st.executeUpdate();
			

			}
			catch(Exception e) {
				System.out.println(e);
			}
			
	}
	
	
	
	
	
	
	
}
