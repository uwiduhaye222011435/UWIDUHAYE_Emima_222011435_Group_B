package Myforms;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import Mytable.Patient;


	public class Patientform implements ActionListener {
		
		JFrame frame; 
		JLabel patient_id_lb=new JLabel("PATIENT_ID");
		JLabel name_lb=new JLabel("NAME");
		JLabel address_lb=new JLabel("ADDRESS");
		JLabel phonenumber_lb=new JLabel("PHONENUMBER");
		JLabel email_lb=new JLabel("EMAIL");
		 DefaultTableModel model = new DefaultTableModel();
		    JTable table = new JTable(model);
		


		JTextField patient_id_txf=new JTextField();
		JTextField name_txf=new JTextField();
		JTextField address_txf=new JTextField();
		JTextField phonenumber_txf=new JTextField();
		JTextField email_txf=new JTextField();
	    

		JButton insert_btn=new JButton("insert");
		JButton Read_btn=new JButton("Read");
		JButton updatebtn=new JButton("update");
		JButton Delete_btn=new JButton("Delete");

		Dimension ScreenSize=Toolkit.getDefaultToolkit().getScreenSize();
		int w=(int) ScreenSize.getWidth();
		int H=(int) ScreenSize.getHeight();

		 public Patientform() {
			 CreateForm1();
			 ActionEvent1();
			 SetLocation1();
			 SetFontforAll();
			 AddCompenentToFrame();
			 
		 }
		 
		 private void AddCompenentToFrame() {
			 frame.add(patient_id_lb);
			 frame.add(name_lb);
			 frame.add(address_lb);
			 frame.add(email_lb);
			 frame.add(phonenumber_lb);
		     
			 
			 
			 
			 frame.add(patient_id_txf);
			 frame.add(name_txf);
			 frame.add(address_txf);
			 frame.add(phonenumber_txf);
			 frame.add(email_txf);
			 
			
			 
			 frame.add(insert_btn);
			 frame.add(Read_btn);
			 frame.add(updatebtn);
			 frame.add(Delete_btn);
			 frame.add(table);
		 }
		 private void SetFontforAll() {
			 Font font=new Font("Georgia",Font.BOLD,18);
			 patient_id_lb.setFont(font);
			 name_lb.setFont(font);
			 address_lb.setFont(font);
			 phonenumber_lb.setFont(font);
			 email_lb.setFont(font);
			 
			
			 
			 patient_id_txf.setFont(font);
			 name_txf.setFont(font);
			 address_lb.setFont(font);
			 phonenumber_txf.setFont(font);
			 email_txf.setFont(font);
			 
			 
			 Font fonti=new Font("courier new",Font.ITALIC,12);
			 insert_btn.setFont(fonti);
			 Read_btn.setFont(fonti);
			 updatebtn.setFont(fonti);
			 Delete_btn.setFont(fonti);
		 }
		 
		 
		 private void SetLocation1() {
			 patient_id_lb.setBounds(10,10,150,30);
			 name_lb.setBounds(10,60,150,30);
			 address_lb.setBounds(10,110,150,30);
			 phonenumber_lb.setBounds(10,210,250,30);
			 email_lb.setBounds(10,160,150,30);

			 patient_id_txf.setBounds(220,10,150,30);
			 name_txf.setBounds(220,60,150,30);
			 address_txf.setBounds(220,110,150,30);
			 phonenumber_txf.setBounds(220,210,150,30);
			 email_txf.setBounds(220,160,150,30);
			 
			 
			 
			 
			 insert_btn.setBounds(50,290,90,30);
			 Read_btn.setBounds(150,290,90,30);
			 updatebtn.setBounds(260,290,90,30);
			 Delete_btn.setBounds(360,290,90,30);
			 table.setBounds(500, 10, 600, 240);
			 
		 }
		 
		 private void CreateForm1() {
			 frame=new JFrame();
			 frame.setTitle("PatientForm");
			 frame.setBounds(0,0,w/2,H/2);
			 frame.getContentPane().setLayout(null);
			 frame.getContentPane().setBackground(Color.blue);
			 frame.setVisible(true);
			 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			 frame.setResizable(true);
			 
		 }
		 
		 private void ActionEvent1() {
			 insert_btn.addActionListener(this);
			 Read_btn.addActionListener(this);
			 updatebtn.addActionListener(this);
			 Delete_btn.addActionListener(this);
		 }
			
		 @Override
			public void actionPerformed(ActionEvent e) {
			Patient pt= new Patient();
			
	if (e.getSource()==insert_btn) {
				pt.setName(name_txf.getText());
				pt.setAddress(address_txf.getText());
				pt.setEmail(email_txf.getText());
				pt.setPhonenumber(phonenumber_txf.getText());
				pt.insertData();
			}


else if (e.getSource()==Read_btn) {
    model.setColumnCount(0);
    model.setRowCount(0);
    model.addColumn("Patient_id");
    model.addColumn("name");
    model.addColumn("address");
    model.addColumn("email");
    model.addColumn("phonenumber");
    

    ResultSet resultSet = Patient.viewData();
    if (resultSet != null) {
        try {
            while (resultSet.next()) {
                model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                        resultSet.getString(4), resultSet.getString(5)});
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }}
			else if (e.getSource()==updatebtn) {
				int id=Integer.parseInt(patient_id_txf.getText());
				pt.setName(name_txf.getText());
				pt.setAddress(address_txf.getText());
				pt.setPhonenumber(phonenumber_txf.getText());
				pt.setEmail(email_txf.getText());
				pt.update(id);
				}
			else {
				int id=Integer.parseInt(patient_id_txf.getText());
				pt.delete(id);}}

			public static void main (String[] args) {
				Patientform pt= new  Patientform();
				System.out.println( pt );
			}}











