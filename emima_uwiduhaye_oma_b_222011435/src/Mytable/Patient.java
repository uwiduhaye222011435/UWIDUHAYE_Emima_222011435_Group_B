package Mytable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Patient {
	private int Patient_id ;
	private String name;
	private String address;
	private String phonenumber;
	private String email;
	public Patient() {
		// default constructor
	}
	public Patient(int patient_id, String name, String address, String phonenumber, String email) {
		super();
		Patient_id = patient_id;
		this.name = name;
		this.address = address;
		this.phonenumber = phonenumber;
		this.email = email;
	}
	
	
	public int getPatient_id() {
		return Patient_id;
	}


	public void setPatient_id(int patient_id) {
		Patient_id = patient_id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPhonenumber() {
		return phonenumber;
	}


	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public void makeconnection() {
	}
	public void insertData() {
		String host = "jdbc:mysql://localhost/emima_uwiduhaye_oms_b";
	    String user = "222011435";
	    String password = "222011435";
	    String sql = "INSERT INTO patient (patientname, patientaddress,phonenumber,email) VALUES (?, ?, ?, ?)";
		try {
			Connection con = DriverManager.getConnection(host, user, password);
	    	 PreparedStatement stm= con.prepareStatement(sql);
	    	stm.setString(1, name);
	    	stm.setString(2,address);
	    	stm.setString(3, phonenumber);
	    	stm.setString(4, email);
	  
	    	int rowsAffected = stm.executeUpdate();
	         if (rowsAffected > 0) {
	        	 System.out.println("data inserted succeccful");
	        	 JOptionPane.showMessageDialog(null, "data inserted successful","After insert",JOptionPane.INFORMATION_MESSAGE);
	         }
	        	 else {
	        		 System.out.println("Failed to insert data!!!");
	                 JOptionPane.showMessageDialog(null, "Failed to insert data!!!","After insert",JOptionPane.ERROR_MESSAGE);
	                 }
					
				
		} catch (Exception e) {
			e.printStackTrace();
		}}
	public static ResultSet viewData() {
	    String host = "jdbc:mysql://localhost/emima_uwiduhaye_oms_b";
	    String user = "222011435";
	    String password = "222011435";

	    String sql = "SELECT * FROM Patient";

	    try {
	        Connection con = DriverManager.getConnection(host, user, password);
	        PreparedStatement preparedStatement = con.prepareStatement(sql);
	        return preparedStatement.executeQuery();
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return null;
	    }
	}
		public void update(int inputPatient_id) {
			// JDBC URL, username, and password of MySQL server
		    String url = "jdbc:mysql://localhost/emima_uwiduhaye_oms_b";
		    String user = "root";
		    String password = "";

		    // SQL query to update data
		    String sql = "UPDATE patient SET  patientname= ?,patientaddress = ?,phonenumber = ?,email=?  WHERE patient_id = ?";

		    try (
		        // Establish the con
		        Connection con = DriverManager.getConnection(url, user, password);

		        // Create a prepared statement
		        PreparedStatement adm = con.prepareStatement(sql);
		    ) {
		        // Set the new values for the update
		    	  adm.setString(1, this.getName());
		        adm.setString(2, this.getAddress());
		       adm.setString(3, this.getPhonenumber()); // Assuming there is a column named 'id' for the WHERE clause
		       adm.setString(4, this.getEmail());
		        adm.setInt(5,inputPatient_id);
		       
		        // Execute the update
		        int rowsAffected = adm.executeUpdate();

		        // Check the result
		        if (rowsAffected > 0) {
		            System.out.println("Data updated successfully!");
		            JOptionPane.showMessageDialog(null, "data updated successful","After update",JOptionPane.INFORMATION_MESSAGE);
		        } else {
		            System.out.println("Failed to update data. No matching record found.");
		            JOptionPane.showMessageDialog(null, "Failed to update data!!!","After update",JOptionPane.ERROR_MESSAGE);
		        }

		    } catch (SQLException e) {
		        e.printStackTrace();
		    }   
		}
		public void delete(int inputpatient_id ) {
			// JDBC URL, username, and password of MySQL server
		    String url = "jdbc:mysql://localhost/emima_uwiduhaye_oms_b";
		    String user = "222011435";
		    String password = "222011435";

		    // SQL query to delete data
		    String sql = "DELETE FROM Patient WHERE patient_id = ?";

		    try (
		        // Establish the 
		        Connection co = DriverManager.getConnection(url, user, password);

		        // Create a prepared statement
		        PreparedStatement pl = co.prepareStatement(sql);
		    ) {
		        // Set the value for the WHERE clause
		        pl.setInt(1, inputpatient_id ); // Assuming there is a column named 'id' for the WHERE clause

		        // Execute the delete
		        int rowsAffected = pl.executeUpdate();

		        // Check the result
		        if (rowsAffected > 0) {
		            System.out.println("Data deleted successfully!");
		            JOptionPane.showMessageDialog(null, "data deleted successful","After delete",JOptionPane.INFORMATION_MESSAGE);
		        } else {
		            System.out.println("Failed to delete data. No matching record found.");
		            JOptionPane.showMessageDialog(null, "Failed to insert data!!!","After delete",JOptionPane.ERROR_MESSAGE);
		        }

		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		}
		}



	



