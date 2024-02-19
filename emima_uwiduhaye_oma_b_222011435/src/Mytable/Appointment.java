package Mytable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Appointment {
	private int appointment_id ;
	private String appointmentdate;
	private String status;
	private String reason;
	private String patient_id;
	private String doctor_id;
	
	public Appointment(int appointment_id, String appointmentdate, String status, String reason, String patient_id,
			String doctor_id) {
		super();
		this.appointment_id = appointment_id;
		this.appointmentdate = appointmentdate;
		this.status = status;
		this.reason = reason;
		this.patient_id = patient_id;
		this.doctor_id = doctor_id;
	}
	
	public Appointment() {
		// Default constructor;
}

	public int getAppointment_id() {
		return appointment_id;
	}

	public void setAppointment_id(int appointment_id) {
		this.appointment_id = appointment_id;
	}

	public String getAppointmentdate() {
		return appointmentdate;
	}

	public void setAppointmentdate(String appointmentdate) {
		this.appointmentdate = appointmentdate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
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

	public void makeconnection() {
	}
	public void insertData() {
		String host = "jdbc:mysql://localhost/emima_uwiduhaye_oms_b";
	    String user ="222011435 ";
	    String password = "222011435";
	    String sql = "INSERT INTO Appointment (appointmentdate, status_,reason,patient_id,doctor_id) VALUES (?, ?, ?, ?,?)";
		try {
			Connection con = DriverManager.getConnection(host, user, password);
	    	 PreparedStatement stm= con.prepareStatement(sql);
	        stm.setString(1,appointmentdate);
	    	stm.setString(2,status);
	    	stm.setString(3,reason);
	    	stm.setString(4,patient_id);
	    	stm.setString(5,doctor_id);
	    	
	  
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

	    String sql = "SELECT * FROM Appointment";

	    try {
	        Connection con = DriverManager.getConnection(host, user, password);
	        PreparedStatement preparedStatement = con.prepareStatement(sql);
	        return preparedStatement.executeQuery();
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return null;
	    }
	}
		public void update(int inputappointment_id) {
			// JDBC URL, username, and password of MySQL server
		    String url = "jdbc:mysql://localhost/emima_uwiduhaye_oms_b";
		    String user = "222011435";
		    String password = "222011435";

		    // SQL query to update data
		    String sql = "UPDATE Appointment SET appointmentdate= ?, status_ = ?, reason = ?,patient_id=?,doctor_id=?  WHERE appointment_id = ?";

		    try (
		        // Establish the con
		        Connection con = DriverManager.getConnection(url, user, password);

		        // Create a prepared statement
		        PreparedStatement adm = con.prepareStatement(sql);
		    ) {
		        // Set the new values for the update
		    	  adm.setString(1, this.getAppointmentdate());
		        adm.setString(2, this.getStatus());
		       adm.setString(3, this.getReason()); // Assuming there is a column named 'id' for the WHERE clause
		       adm.setString(4, this.getPatient_id());
		       adm.setString(5, this.getDoctor_id());
		       adm.setInt(6, inputappointment_id);
		       
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
		public void delete(int inputappointment_id) {
			// JDBC URL, username, and password of MySQL server
		    String url = "jdbc:mysql://localhost//emima_uwiduhaye_oms_b";
		    String user = "222011435";
		    String password = "222011435";

		    // SQL query to delete data
		    String sql = "DELETE FROM Appointment WHERE appointment_id = ?";

		    try (
		        // Establish the 
		        Connection co = DriverManager.getConnection(url, user, password);

		        // Create a prepared statement
		        PreparedStatement pl = co.prepareStatement(sql);
		    ) {
		        // Set the value for the WHERE clause
		        pl.setInt(1, inputappointment_id); // Assuming there is a column named 'id' for the WHERE clause

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



	







