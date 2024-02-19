package Mytable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Prescription {
	private int prescription_id;
	private String medication_name;
    private String dosage;
	private String frequency;
	private String startdate;
	private String enddate;
	private String patient_id;
	private String doctor_id;
	private String appointment_id;
	public Prescription() {
		// default constructor
	}
	
	
	public Prescription(int prescription_id, String medication_name, String dosage, String frequency, String startdate,
			String enddate, String patient_id, String doctor_id, String appointment_id) {
		super();
		this.prescription_id = prescription_id;
		this.medication_name = medication_name;
		this.dosage = dosage;
		this.frequency = frequency;
		this.startdate = startdate;
		this.enddate = enddate;
		this.patient_id = patient_id;
		this.doctor_id = doctor_id;
		this.appointment_id = appointment_id;
	}
	


	public int getPrescription_id() {
		return prescription_id;
	}


	public void setPrescription_id(int prescription_id) {
		this.prescription_id = prescription_id;
	}


	public String getMedication_name() {
		return medication_name;
	}


	public void setMedication_name(String medication_name) {
		this.medication_name = medication_name;
	}


	public String getDosage() {
		return dosage;
	}


	public void setDosage(String string) {
		this.dosage = string;
	}


	public String getFrequency() {
		return frequency;
	}


	public void setFrequency(String string) {
		this.frequency = string;
	}


	public String getStartdate() {
		return startdate;
	}


	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}


	public String getEnddate() {
		return enddate;
	}


	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}


	public String getPatient_id() {
		return patient_id;
	}


	public void setPatient_id(String patient_id) {
		this.patient_id = patient_id;
	}


	public String getDoctor_id() {
		return doctor_id;
	}


	public void setDoctor_id(String doctor_id) {
		this.doctor_id = doctor_id;
	}


	public String getAppointment_id() {
		return appointment_id;
	}


	public void setAppointment_id(String appointment_id) {
		this.appointment_id = appointment_id;
	}


	public void makeconnection() {
	}
	public void insertData() {
		String host = "jdbc:mysql://localhost/emima_uwiduhaye_oms_b";
	    String user = "222011435";
	    String password = "222011435";
	    String sql = "INSERT INTO Prescription (medication_name, dosage,frequency,startdate,enddate,patient_id,doctor_id,appointment_id) VALUES (?, ?, ?, ?,?,?,?,?)";
		try {
			Connection con = DriverManager.getConnection(host, user, password);
	    	 PreparedStatement stm= con.prepareStatement(sql);
	        stm.setString(1,medication_name);
	    	stm.setString(2,dosage);
	    	stm.setString(3,frequency);
	    	stm.setString(4,startdate);
	    	stm.setString(5,enddate);
	    	stm.setString(6,patient_id);
	    	stm.setString(7,doctor_id);
	    	stm.setString(8,appointment_id);
	    	
	  
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

	    String sql = "SELECT * FROM Prescription ";

	    try {
	        Connection con = DriverManager.getConnection(host, user, password);
	        PreparedStatement preparedStatement = con.prepareStatement(sql);
	        return preparedStatement.executeQuery();
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return null;
	    }
	}
		public void update(int inputprescription_id) {
			// JDBC URL, username, and password of MySQL server
		    String url = "jdbc:mysql://localhost/emima_uwiduhaye_oms_b";
		    String user = "222011435";
		    String password = "222011435";

		    // SQL query to update data
		    String sql = "UPDATE  SET medication_name= ?, dosage = ?, frequency = ?, startdate=?,enddate=?,patient_id=?,doctor_id=?,appointment_id=?,  WHERE prescription_id = ?";

		    try (
		        // Establish the con
		        Connection con = DriverManager.getConnection(url, user, password);

		        // Create a prepared statement
		        PreparedStatement adm = con.prepareStatement(sql);
		    ) {
		        // Set the new values for the update
		    	  adm.setString(1, this.getMedication_name());
		        adm.setString(2, this.getDosage());
		       adm.setString(3, this.getFrequency()); // Assuming there is a column named 'id' for the WHERE clause
		       adm.setString(4, this.getStartdate());
		       adm.setString(5, this.getEnddate());
		       adm.setString(6, this.getPatient_id());
		       adm.setString(7, this.getDoctor_id());
		       adm.setString(7, this.getAppointment_id());
		       adm.setInt(6, inputprescription_id);
		       
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
		public void delete(int inputprescription_id) {
			// JDBC URL, username, and password of MySQL server
		    String url = "jdbc:mysql://localhost/emima_uwiduhaye_oms_b";
		    String user = "222011435";
		    String password = "222011435";

		    // SQL query to delete data
		    String sql = "DELETE FROM Prescription WHERE prescription_id = ?";

		    try (
		        // Establish the 
		        Connection co = DriverManager.getConnection(url, user, password);

		        // Create a prepared statement
		        PreparedStatement pl = co.prepareStatement(sql);
		    ) {
		        // Set the value for the WHERE clause
		        pl.setInt(1, inputprescription_id); // Assuming there is a column named 'id' for the WHERE clause

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



	




