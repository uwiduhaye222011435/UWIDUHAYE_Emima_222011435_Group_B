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
import Mytable.Medical_clinic;
import Mytable.Patient;

public class Medical_clinicform implements ActionListener {

	JFrame frame; 
	JLabel medical_id_lb=new JLabel(" MEDICAL_ID");
	JLabel medical__clinicname_lb=new JLabel("CLINIC_NAME");
	JLabel date_lb=new JLabel("DATE");
	JLabel patient_id_lb=new JLabel("PATIENT_ID");
	DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);

	


	JTextField medical_id_txf=new JTextField();
	JTextField medical_clinicname_txf=new JTextField();
	JTextField date_txf=new JTextField();
	JTextField patient_id_txf=new JTextField();
	   


	JButton insert_btn=new JButton("insert");
	JButton Read_btn=new JButton("Read");
	JButton updatebtn=new JButton("update");
	JButton Delete_btn=new JButton("Delete");

	Dimension ScreenSize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int) ScreenSize.getWidth();
	int H=(int) ScreenSize.getHeight();
	

	 public Medical_clinicform() {
		 CreateForm1();
		 ActionEvent1();
		 SetLocation1();
		 SetFontforAll();
		 AddCompenentToFrame();
		 
	 }
	 
	 private void AddCompenentToFrame() {
		 frame.add(medical_id_lb);
		 frame.add(medical__clinicname_lb);
		 frame.add(date_lb);
		 frame.add(patient_id_lb);
		 
		 
		 
		 frame.add(medical_id_txf);
		 frame.add(medical_clinicname_txf);
		 frame.add(date_txf);
		 frame.add(patient_id_txf);
		
		 
		 
		 frame.add(insert_btn);
		 frame.add(Read_btn);
		 frame.add(updatebtn);
		 frame.add(Delete_btn);
		 frame.add(table);
	 }
	 private void SetFontforAll() {
		 Font font=new Font("Georgia",Font.BOLD,18);
		medical_id_lb.setFont(font);
		medical__clinicname_lb.setFont(font);
		date_lb.setFont(font);
		patient_id_lb.setFont(font);
		
		medical_id_txf.setFont(font);
		medical_clinicname_txf.setFont(font);
		date_txf.setFont(font);
		patient_id_txf.setFont(font);
		
		 
		 
		 Font fonti=new Font("courier new",Font.ITALIC,12);
		 insert_btn.setFont(fonti);
		 Read_btn.setFont(fonti);
		 updatebtn.setFont(fonti);
		 Delete_btn.setFont(fonti);
	 }
	 
	 
	 private void SetLocation1() {
		 medical_id_lb.setBounds(10,10,180,30);
		 medical__clinicname_lb.setBounds(10,60,230,30);
		 date_lb.setBounds(10,110,180,30);
		 patient_id_lb.setBounds(10,160,180,30);
		 
		 
		 medical_id_txf.setBounds(230,10,150,30);
		 medical_clinicname_txf.setBounds(230,60,150,30);
		 date_txf.setBounds(230,110,150,30);
         patient_id_txf.setBounds(230,160,150,30);
		
		 
		 insert_btn.setBounds(80,280,80,30);
		 Read_btn.setBounds(180,280,80,30);
		 updatebtn.setBounds(280,280,80,30);
		 Delete_btn.setBounds(380,280,80,30);
		 table.setBounds(500, 10, 600, 240);
		 
	 }
	 private void CreateForm1() {	 
		 
		 frame=new JFrame();
		 frame.setTitle("Medical_clinicform");
		 frame.setBounds(0,0,w/2,H/2);
		 frame.getContentPane().setLayout(null);
		 frame.getContentPane().setBackground(Color.PINK);
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
		Medical_clinic md= new Medical_clinic();
		  Medical_clinicform mr= new Medical_clinicform();		
	
			 
if (e.getSource()==insert_btn) {
			md.setMedical_clinicname(medical_clinicname_txf.getText());
			md.setDate_(date_txf.getText());
			md.setPatient_id(patient_id_txf.getText());
			md.insertData();
		}

else if (e.getSource()==Read_btn) {
    model.setColumnCount(0);
    model.setRowCount(0);
    model.addColumn("medical_id");
    model.addColumn("medical_clinicname");
    model.addColumn("date");
    model.addColumn("patient_id_txf");
    

    ResultSet resultSet =Medical_clinic.viewData();
    if (resultSet != null) {
        try {
            while (resultSet.next()) {
                model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                        resultSet.getString(4), });
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }}
		else if (e.getSource()==updatebtn) {
			int id=Integer.parseInt(medical_id_txf.getText());
			md.setMedical_clinicname(medical_clinicname_txf.getText());
			md.setDate_(date_txf.getText());
			md.setPatient_id(patient_id_txf.getText());
			md.update(id);
			}
		else {
			int id=Integer.parseInt(medical_id_txf.getText());
			md.delete(id);}}

		public static void main (String[] args) {
			Medical_clinicform mr= new Medical_clinicform();
			System.out.println( mr );
		}}













		
	 
