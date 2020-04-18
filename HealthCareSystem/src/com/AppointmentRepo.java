package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AppointmentRepo {

Connection con = null;
	
	
	public AppointmentRepo() {
		
		String url = "jdbc:mysql://localhost:3306/pafdb";
//		String username = "root";
//		String password = "";
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url,"root","");
		
		System.out.println("connected!");
		
		}catch(Exception e) {
			System.out.println(e);
			
			System.out.println("failed");
		}
	}
	
	public List<Appointment> getAppointments(){
		
		List<Appointment> appointments = new ArrayList<>();
		String sql = "select * from appointments";
		try
		{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Appointment a = new Appointment();
				
				a.setId(rs.getInt(1));
				a.setDate(rs.getString(2));
				a.setTime(rs.getString(3));
				a.setDescription(rs.getString(4));
				a.setStatus(rs.getString(5));
				
				appointments.add(a);
				
			}
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return appointments;
	}
	
	public Appointment getAppointment(int id) {
		
		String sql = "select * from appointments where id="+id;
		Appointment a = new Appointment();
		try
		{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) {
				
				a.setId(rs.getInt(1));
				a.setDate(rs.getString(2));
				a.setTime(rs.getString(3));
				a.setDescription(rs.getString(4));
				a.setStatus(rs.getString(5));
			}
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return a;
	}

	//create
	public void create(Appointment a1i) {
		String sql = "insert into appointments(date,time,description,status) values(?,?,?,?);";
		try
		{
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, a1i.getDate());
			st.setString(2, a1i.getTime());
			st.setString(3, a1i.getDescription());
			st.setString(4, a1i.getStatus());
			
			st.executeUpdate();
			System.out.println("Data inserted!!");
			
		}catch(Exception e)
		{
			System.out.println(e);
			System.out.println("Error!!");
		}
		
	}
	
	//update
	public void update(Appointment a1i) {
		String sql = "update appointments set date=? , time=? , description=?, status=? where id=?;";
		try
		{
			PreparedStatement st = con.prepareStatement(sql);

			st.setInt(5, a1i.getId());
			st.setString(1, a1i.getDate());
			st.setString(2, a1i.getTime());
			st.setString(3, a1i.getDescription());
     		st.setString(4, a1i.getStatus());
			
			st.executeUpdate();
			
			System.out.println("Updated!");
		}catch(Exception e)
		{
			System.out.println(e);
			System.out.println("Error!!");
		}
	}

	//delete
	public void delete(int id) {
		
		String sql = "delete from appointments where id=?";
		try
		{
			PreparedStatement st = con.prepareStatement(sql);

			st.setInt(1, id);
			st.executeUpdate();
			
			System.out.println("Deleted!!");
		}catch(Exception e)
		{
			System.out.println(e);
			System.out.println("Error!!");
		}
		
	}
	

}
