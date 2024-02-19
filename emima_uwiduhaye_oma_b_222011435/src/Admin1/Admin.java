package Admin1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Admin {
	 private String fname;
	    private String lname;
	    private String idNumber;
	    private String phone;
	    private String gender;
	    private String martialStatus;
	    private String DoB; // Assuming DoB stands for Date of Birth
	    private String email;
	    private String password;

	    public Admin() {
	        // Default constructor
	    }

	    public Admin(String fname, String lname, String idNumber, String phone, String gender, String martialStatus, String DoB,
	            String email, String password) {
	        this.fname = fname;
	        this.lname = lname;
	        this.idNumber = idNumber;
	        this.phone = phone;
	        this.gender = gender;
	        this.martialStatus = martialStatus;
	        this.DoB = DoB;
	        this.email = email;
	        this.password = password;
	    }

	    // Setters

	    public void setFname(String fname) {
	        this.fname = fname;
	    }

	    public void setLname(String lname) {
	        this.lname = lname;
	    }

	    public void setIdNumber(String idNumber) {
	        this.idNumber = idNumber;
	    }

	    public void setPhone(String phone) {
	        this.phone = phone;
	    }

	    public void setGender(String gender) {
	        this.gender = gender;
	    }

	    public void setMartialStatus(String martialStatus) {
	        this.martialStatus = martialStatus;
	    }

	    public void setDoB(String DoB) {
	        this.DoB = DoB;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public void setPassword(String passwordString) {
	        this.password = passwordString;
	    }

	    // Getters

	    public String getFname() {
	        return fname;
	    }

	    public String getLname() {
	        return lname;
	    }

	    public String getIdNumber() {
	        return idNumber;
	    }

	    public String getPhone() {
	        return phone;
	    }

	    public String getGender() {
	        return gender;
	    }

	    public String getMartialStatus() {
	        return martialStatus;
	    }

	    public String getDoB() {
	        return DoB;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public String getPassword() {
	        return password;
	    }
	    public void makeconnection() {
	    	
	    }
	    public void insertData() {
	        String host = "jdbc:mysql://localhost/online_medical_appointment";
	        String user = "root";
	        String password = "";

	        String sql = "INSERT INTO Admin (fname, lname, id_number,phone,gender,martial_status,DoB,email,password) VALUES (?, ?, ?, ?,?,?,?,?,?)";

	        try (
	        		
	            Connection con = DriverManager.getConnection(host, user, password);

	            // Create a prepared statement
	        		
	            PreparedStatement stm= con.prepareStatement(sql);
	        ) {
	            // Set the values for the prepared statement
	        	
	           stm.setString(1, this.fname);
	            stm.setString(2, this.lname);
	            stm.setString(3, this.idNumber);
	            stm.setString(4, this.phone);
	            stm.setString(5, this.gender);
	            stm.setString(6, this.martialStatus);
	            stm.setString(7, this.DoB);
	            stm.setString(8, this.email);
	            stm.setString(9, this.password);

	            // Execute the query
	            int rowsAffected = stm.executeUpdate();

	            // Check the result
	            if (rowsAffected > 0) {
	            	System.out.println("Data inserted successfully!");
	                JOptionPane.showMessageDialog(null, "Data inserted successfully!","After insert",JOptionPane.INFORMATION_MESSAGE);
	            } else {
	                System.out.println("Failed to insert data.");
	                JOptionPane.showMessageDialog(null, "Failed to insert data.!","After insert",JOptionPane.ERROR_MESSAGE);

	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }	
	    }
	    
	    public void login() {
	    	makeconnection();
	    	String host = "jdbc:mysql://localhost/online_medical_appointment";
	        String user = "root";
	        String password = "";
	        String sql = "SELECT * FROM admin WHERE email = ? AND password = ?";
	        
	    	try(
	    			Connection con = DriverManager.getConnection(host, user, password);
	            		
	                PreparedStatement stm= con.prepareStatement(sql);
	    			
	    			) {
	    		
	    		stm.setString(1, this.email);
	    		stm.setString(2, this.password);
	    		ResultSet rs = stm.executeQuery();
	    		if(rs.next()) {
	    			System.out.println("Data inserted successfully!");
	                JOptionPane.showMessageDialog(null, "Loged in successfully!","After login",JOptionPane.INFORMATION_MESSAGE);
	    		} else {
	    			JOptionPane.showMessageDialog(null, "Incorect Email and password!","After login",JOptionPane.INFORMATION_MESSAGE);
	    		}
	    		con.close();
	    		
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

		
	}

