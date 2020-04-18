package com;


import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class PatientRepository 
{
	
	
	Connection con = null;
	
	public PatientRepository()
	{
		String url = "jdbc:mysql://localhost:3306/patdb";
		String username = "root";
		String password = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
		    con = DriverManager.getConnection(url,username,password);
		
		
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}  
	
	public List<Patient> getPatients()
	{
		List<Patient> patients = new ArrayList<>();
		String sql = "select * from patient";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				Patient p = new Patient();
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setAge(rs.getInt(3));
				p.setAddress(rs.getString(4));
				
				patients.add(p);
				
			}
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return patients;
	}
	
	public Patient getPatient(int id)
	{
		String sql = "select * from patient where id="+id;
		Patient p = new Patient();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) {
				
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setAge(rs.getInt(3));
				p.setAddress(rs.getString(4));	
				
			}
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return p;
	}

	public void create(Patient p1) {
		String sql = "insert into patient values (?,?,?,?)";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, p1.getId());
			st.setString(2, p1.getName());
			st.setInt(3, p1.getAge());
			st.setString(4, p1.getAddress());
			st.executeUpdate();
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void update(Patient p1) {
		String sql = "update patient set name=?, address=?, age=? where id=?";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, p1.getName());
			st.setString(2, p1.getAddress());
			st.setInt(3, p1.getAge());
			st.setInt(4, p1.getId());
			
			st.executeUpdate();
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	public void delete(int id) {
		
		String sql = "delete from patient where id=?";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			
			st.executeUpdate();
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}

