package Mytable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Insurance {
 private int insurance_id;
 private String insurance_name;
 public Insurance() {
		// default constructor
	}
public Insurance(int insurance_id, String insurance_name) {
	super();
	this.insurance_id = insurance_id;
	this.insurance_name = insurance_name;
}
public int getInsurance_id() {
	return insurance_id;
}
public void setInsurance_id(int insurance_id) {
	this.insurance_id = insurance_id;
}
public String getInsurance_name() {
	return insurance_name;
}
public void setInsurance_name(String insurance_name) {
	this.insurance_name = insurance_name;
}

public void makeconnection() {
}
public void insertData() {
String host = "jdbc:mysql://localhost/emima_uwiduhaye_oms_b";
String user = "222011435";
String password = "222011435";
String sql = "INSERT INTO insurance(insurance_name) VALUES (?)";
try {
Connection con = DriverManager.getConnection(host, user, password);
PreparedStatement stm= con.prepareStatement(sql);
stm.setString(1,insurance_name);
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

    String sql = "SELECT * FROM Insurance";

    try {
        Connection con = DriverManager.getConnection(host, user, password);
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        return preparedStatement.executeQuery();
    } catch (SQLException e) {
        e.printStackTrace();
        return null;
    }
}
public void update(int inputinsurance_id) {
// JDBC URL, username, and password of MySQL server
String url = "jdbc:mysql://localhost/emima_uwiduhaye_oms_b";
String user = "222011435";
String password = "222011435";

// SQL query to update data
String sql = "UPDATE insurance SET  insurance_name= ? WHERE insurance_id = ?";

try (
// Establish the con
Connection con = DriverManager.getConnection(url, user, password);

// Create a prepared statement
PreparedStatement adm = con.prepareStatement(sql);
) {
// Set the new values for the update
  adm.setString(1, this.getInsurance_name());
  adm.setInt(2, inputinsurance_id);

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
public void delete(int inputinsurance_id) {
// JDBC URL, username, and password of MySQL server
String url = "jdbc:mysql://localhost/emima_uwiduhaye_oms_b";
String user = "222011435";
String password = "222011435";

// SQL query to delete data
String sql = "DELETE FROM insurance WHERE insurance_id = ?";

try (
// Establish the 
Connection co = DriverManager.getConnection(url, user, password);

// Create a prepared statement
PreparedStatement pl = co.prepareStatement(sql);
) {
// Set the value for the WHERE clause
pl.setInt(1, inputinsurance_id); // Assuming there is a column named 'id' for the WHERE clause

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



