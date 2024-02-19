package Mytable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Medical_clinic {
	private int medical_id;
	private String medical_clinicname;
	private String date_;
	private String patient_id;
	public Medical_clinic() {
		// default constructor
	}
	
	public Medical_clinic(int medical_id, String medical_clinicname, String date_, String patient_id) {
		super();
		this.medical_id = medical_id;
		this.medical_clinicname = medical_clinicname;
		this.date_ = date_;
		this.patient_id = patient_id;
	}


	public int getMedical_id() {
		return medical_id;
	}


	public void setMedical_id(int medical_id) {
		this.medical_id = medical_id;
	}


	public String getMedical_clinicname() {
		return medical_clinicname;
	}


	public void setMedical_clinicname(String medical_clinicname) {
		this.medical_clinicname = medical_clinicname;
	}


	public String getDate_() {
		return date_;
	}


	public void setDate_(String date_) {
		this.date_ = date_;
	}


	public String getPatient_id() {
		return patient_id;
	}


	public void setPatient_id(String patient_id) {
		this.patient_id = patient_id;
	}


	public void makeconnection() {
	}
	public void insertData() {
		String host = "jdbc:mysql://localhost/emima_uwiduhaye_oms_b";
	    String user = "222011435";
	    String password = "222011435";
	    String sql = "INSERT INTO medical_clinic (medical_clinicname, date_,patient_id) VALUES ( ?,?,?)";
		try {
			Connection con = DriverManager.getConnection(host, user, password);
	    	 PreparedStatement stm= con.prepareStatement(sql);
	        stm.setString(1,medical_clinicname);
	        stm.setString(2,date_);
	        stm.setString(3,patient_id);
	    	
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

	    String sql = "SELECT * FROM Medical_clinic";

	    try {
	        Connection con = DriverManager.getConnection(host, user, password);
	        PreparedStatement preparedStatement = con.prepareStatement(sql);
	        return preparedStatement.executeQuery();
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return null;
	    }
	}
		public void update(int inputmedical_id) {
			// JDBC URL, username, and password of MySQL server
		    String url = "jdbc:mysql://localhost/online_medical_appointment";
		    String user = "root";
		    String password = "";

		    // SQL query to update data
		    String sql = "UPDATE medical_clinic SET  medical_clinicname = ?, date_= ?,patient_id=? WHERE medical_id = ?";

		    try (
		        // Establish the con
		        Connection con = DriverManager.getConnection(url, user, password);

		        // Create a prepared statement
		        PreparedStatement adm = con.prepareStatement(sql);
		    ) {
		        // Set the new values for the update
		    	  adm.setString(1, this.getMedical_clinicname());
		        adm.setString(2, this.getDate_());
		        adm.setString(3, this.getPatient_id());
		        adm.setInt(4,inputmedical_id);
			       
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
		public void delete(int inputmedical_id) {
			// JDBC URL, username, and password of MySQL server
		    String url = "jdbc:mysql://localhost/emima_uwiduhaye_oms_b";
		    String user = "222011435";
		    String password = "222011435";

		    // SQL query to delete data
		    String sql = "DELETE FROM medical_clinic WHERE medical_id = ?";

		    try (
		        // Establish the 
		        Connection co = DriverManager.getConnection(url, user, password);

		        // Create a prepared statement
		        PreparedStatement pl = co.prepareStatement(sql);
		    ) {
		        // Set the value for the WHERE clause
		        pl.setInt(1, inputmedical_id); // Assuming there is a column named 'id' for the WHERE clause

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



	








	 

	


  
	 