package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class HospitalRepository
{


	Connection con = null;
	
	public HospitalRepository()
	{
		String url = "jdbc:mysql://localhost:3306/pafdb";
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url,"root","");
		
		System.out.println("connected!");
		
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public List<Hospital> getHospitals()
	{
		List<Hospital> hospitals = new ArrayList<>();
		String sql = "select * from hospital";
		try
		{
		Statement st = con.createStatement();
		ResultSet rs =  st.executeQuery(sql);
		while(rs.next())
		{
			Hospital a = new Hospital();
			a.setId(rs.getInt(1));
			a.setHospitalName(rs.getString(2));
			a.setEmail(rs.getString(3));
			a.setProvince(rs.getString(4));
			a.setCity(rs.getString(5));
			a.setPostalCode(rs.getInt(6));
			a.setPhoneNo(rs.getInt(7));
			a.setEmergencyRoom(rs.getBoolean(8));
			a.setSurgical(rs.getBoolean(9));
			a.setXray(rs.getBoolean(10));
			a.setLaboratory(rs.getBoolean(11));
			a.setGoverment(rs.getBoolean(12));
			
			hospitals.add(a);
			
		}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		return hospitals;
	}
	
	public Hospital getHospital(int id)
	{	
		String sql = "select * from hospital where id=" + id;
		Hospital a = new Hospital();
		try
		{
		Statement st = con.createStatement();
		ResultSet rs =  st.executeQuery(sql);
		if(rs.next())
		{
			a.setId(rs.getInt(1));
			a.setHospitalName(rs.getString(2));
			a.setEmail(rs.getString(3));
			a.setProvince(rs.getString(4));
			a.setCity(rs.getString(5));
			a.setPostalCode(rs.getInt(6));
			a.setPhoneNo(rs.getInt(7));
			a.setEmergencyRoom(rs.getBoolean(8));
			a.setSurgical(rs.getBoolean(9));
			a.setXray(rs.getBoolean(10));
			a.setLaboratory(rs.getBoolean(11));
			a.setGoverment(rs.getBoolean(12));	
			
		}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return a;
	}

	public void create(Hospital hos) {
		String sql = "insert into hospital values(?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try
		{
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1,hos.getId());
		st.setString(2,hos.getHospitalName());
		st.setString(3,hos.getEmail());
		st.setString(4,hos.getProvince());
		st.setString(5,hos.getCity());
		st.setInt(6,hos.getPostalCode());
		st.setInt(7,hos.getPhoneNo());
		st.setBoolean(8,hos.isEmergencyRoom());
		st.setBoolean(9,hos.isSurgical());
		st.setBoolean(10,hos.isXray());
		st.setBoolean(11,hos.isLaboratory());
		st.setBoolean(12,hos.isGoverment());
		
		st.executeUpdate();
		
		System.out.println("Inserted!");
		
		}
		catch(Exception e) {
			System.out.println(e);
			System.out.println("Not Inserted!");
		}
	}
	
	
	public void update(Hospital hos) {
		String sql = "update hospital set hosname=?,email=?,prov=?,city=?,pc=?,phn=?,er=?,surg=?,xray=?,lab=?,gov=? where id=?;";
		try
		{
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1,hos.getHospitalName());
		st.setString(2,hos.getEmail());
		st.setString(3,hos.getProvince());
		st.setString(4,hos.getCity());
		st.setInt(5,hos.getPostalCode());
		st.setInt(6,hos.getPhoneNo());
		st.setBoolean(7,hos.isEmergencyRoom());
		st.setBoolean(8,hos.isSurgical());
		st.setBoolean(9,hos.isXray());
		st.setBoolean(10,hos.isLaboratory());
		st.setBoolean(11,hos.isGoverment());
		st.setInt(12, hos.getId());
		st.executeUpdate();
		
		System.out.println("Updated!");
		}
		catch(Exception e) {
			System.out.println(e);
			System.out.println("Not Updated!");
		}
	}

	public void delete(int id) {
		String sql = "delete from hospital where id=?";
		try
		{
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, id);
		st.executeUpdate();
		
		System.out.println("Deleted!");
		
		}
		catch(Exception e) {
			System.out.println(e);
			System.out.println("Not Deleted!");
		}
	}


}