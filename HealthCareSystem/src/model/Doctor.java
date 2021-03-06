package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Doctor 
{ 	// A common method to connect to the DB
	private Connection connect()
	{
		Connection con = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			//Provide the correct details: DBServer/DBName, username, password
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/paf", "root", "");
		}
		catch (Exception e)
		{e.printStackTrace();}
		return con;
	}

	// insert function
	public String insertDoctor(int ID, String age, String name, String mail, String speciality)
	{
		String output = "";
		try
		{
			Connection con = connect();
				if (con == null)
				{return "Error while connecting to the database for inserting."; }
				// create a prepared statement
				String query = " insert into doctor(`doctorID`,`doctorAge`,`doctorName`,`doctorMail`,`doctorSpeciality`)"
						+ " values (?, ?, ?, ?, ?)";
				
				PreparedStatement preparedStmt = con.prepareStatement(query);
				
				// binding values
				preparedStmt.setInt(1, ID);
				preparedStmt.setString(2, age);
				preparedStmt.setString(3, name);
				preparedStmt.setString(4, mail);
				preparedStmt.setString(5, speciality);

				// execute the statement
				preparedStmt.execute();
				con.close();
				
				output = "Inserted successfully";
			}
			catch (Exception e)
			{
				output = "Error while inserting the doctor details.";
				System.err.println(e.getMessage());
			}
			
			return output;
		}
		// read function
		public String readDoctor()
		{
			String output = "";
				
			try
			{
				Connection con = connect();
				if (con == null)
				{return "Error while connecting to the database for reading."; }
				
				// Prepare the html table to be displayed
				output = "<table border=\"1\"><tr><th>Age</th><th>Doctor Name</th><th>Doctor Mail</th><th>Doctor Speciality</th><th>Update</th><th>Remove</th></tr>";
				
				String query = "select * from doctor";
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				
				// iterate through the rows in the result set
				while (rs.next())
				{
					String doctorID = Integer.toString(rs.getInt("doctorID"));
					String doctorAge = rs.getString("doctorAge");
					String doctorName = rs.getString("doctorName");
					String doctorMail =rs.getString("doctorMail");
					String doctorSpeciality = rs.getString("doctorSpeciality");
				
					// Add into the html table
					output += "<tr><td>" + doctorAge + "</td>";
					output += "<td>" + doctorName + "</td>";
					output += "<td>" + doctorMail + "</td>";
					output += "<td>" + doctorSpeciality + "</td>";
				
					// buttons
					output += "<td><input name=\"btnUpdate\" type=\"button\"value=\"Update\" class=\"btn btn-secondary\"></td>"
									+ "<td><form method=\"post\" action=\"doctor.jsp\">"+ "<input name=\"btnRemove\" type=\"submit\" value=\"Remove\"class=\"btn btn-danger\">"
											+ "<input name=\"doctorID\" type=\"hidden\" value=\"" + doctorID
											+ "\">" + "</form></td></tr>";
				}
				
				con.close();
				
				// Complete the html table
				output += "</table>";
			}
			catch (Exception e)
			{
				output = "Error while reading the doctor details.";
				System.err.println(e.getMessage());
			}
			return output;
		}
 		
		// Update function
		public String updateDoctor(String ID, String age, String name, String mail, String speciality )
		{
		String output = "";
		
		try
		{
				Connection con = connect();
				
				if (con == null)
				{return "Error while connecting to the database for updating."; }
		
				// create a prepared statement
				String query = "UPDATE doctor SET doctorAge=?,doctorName=?,doctorMail=?,doctorSpeciality=? WHERE doctorID=?";
								
				PreparedStatement preparedStmt = con.prepareStatement(query);
		
				// binding values
				preparedStmt.setString(1, age);
				preparedStmt.setString(2, name);
				preparedStmt.setString(3, mail);
				preparedStmt.setString(4, speciality);
				preparedStmt.setInt(5, Integer.parseInt(ID));
		
				// execute the statement
				preparedStmt.execute();
				con.close();
		
				output = "Updated successfully";
		}
		catch (Exception e)
		{
			output = "Error while updating the doctor details.";
			System.err.println(e.getMessage());
		}
			return output;
	}
	//Delete function
	public String deleteDoctor(String doctorID)
	{
		String output = "";
		
		try
		{
			Connection con = connect();
			
			if (con == null)
			{return "Error while connecting to the database for deleting."; }
		
			// create a prepared statement
			String query = "delete from doctor where doctorID=?";
		
			PreparedStatement preparedStmt = con.prepareStatement(query);
		
			// binding values
			preparedStmt.setInt(1, Integer.parseInt(doctorID));
		
			// execute the statement
			preparedStmt.execute();
			con.close();
		
			output = "Deleted successfully";
		}
		catch (Exception e)
		{
			output = "Error while deleting the doctor details.";
			System.err.println(e.getMessage());
		}
		
		return output;
		}
}

