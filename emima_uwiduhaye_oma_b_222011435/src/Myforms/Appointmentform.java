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

import Mytable.Appointment;
import Mytable.Patient;
		 
		
	
public class Appointmentform implements ActionListener {
		
	JFrame frame; 
	JLabel appointment_id_lb=new JLabel(" APPOINTMENT_ID");
	JLabel appointmentdate_lb=new JLabel("APPOINTMENTDATE");
	JLabel status_lb=new JLabel("STATUS");
	JLabel reason_lb=new JLabel("REASON");
	JLabel patient_id_lb=new JLabel("PATIENT_ID");
	JLabel DOCTOR_id_lb=new JLabel("DOCTOR_ID");
	DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);

	


	JTextField appointment_id_txf=new JTextField();
	JTextField appointmentdate_txf=new JTextField();
	JTextField status_txf=new JTextField();
	JTextField reason_txf=new JTextField();
	JTextField patient_id_txf=new JTextField();
	JTextField doctor_id_txf=new JTextField();
	   

	JButton insert_btn=new JButton("insert");
	JButton Read_btn=new JButton("Read");
	JButton updatebtn=new JButton("update");
	JButton Delete_btn=new JButton("Delete");

	Dimension ScreenSize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int) ScreenSize.getWidth();
	int H=(int) ScreenSize.getHeight();
	

	 public Appointmentform() {
		 CreateForm1();
		 ActionEvent1();
		 SetLocation1();
		 SetFontforAll();
		 AddCompenentToFrame();
		 
	 }
	 
	 private void AddCompenentToFrame() {
		 frame.add(appointment_id_lb);
		 frame.add(appointmentdate_lb);
		 frame.add(status_lb);
		 frame.add(reason_lb);
		 frame.add(patient_id_lb);
		 frame.add(DOCTOR_id_lb);
	     
		 
		 
		 
		 frame.add(appointment_id_txf);
		 frame.add(appointmentdate_txf);
		 frame.add(status_txf);
		 frame.add(reason_txf);
		 frame.add(patient_id_txf);
		 frame.add(doctor_id_txf);
		
		 
		 frame.add(insert_btn);
		 frame.add(Read_btn);
		 frame.add(updatebtn);
		 frame.add(Delete_btn);
		 frame.add(table);
	 }
	 private void SetFontforAll() {
		 Font font=new Font("Georgia",Font.BOLD,18);
		 appointment_id_lb.setFont(font);
		appointmentdate_lb.setFont(font);
		status_lb.setFont(font);
		reason_lb.setFont(font);
		patient_id_lb.setFont(font);
		DOCTOR_id_lb.setFont(font);
		
		 
		appointment_id_txf.setFont(font);
		appointmentdate_txf.setFont(font);
		status_txf.setFont(font);
		reason_txf.setFont(font);
		patient_id_txf.setFont(font);
		doctor_id_txf.setFont(font);
		 
		 
		 Font fonti=new Font("courier new",Font.ITALIC,12);
		 insert_btn.setFont(fonti);
		 Read_btn.setFont(fonti);
		 updatebtn.setFont(fonti);
		 Delete_btn.setFont(fonti);
	 }
	 
	 
	 private void SetLocation1() {
		appointment_id_lb.setBounds(10,10,150,30);
		 appointmentdate_lb.setBounds(10,60,150,30);
		 status_lb.setBounds(10,110,150,30);
		 reason_lb.setBounds(10,160,150,30);
		 patient_id_lb.setBounds(10,210,150,30);
		 DOCTOR_id_lb.setBounds(10,260,150,30);
		 
		 appointment_id_txf.setBounds(230,10,100,30);
		 appointmentdate_txf.setBounds(230,60,100,30);
		 status_txf.setBounds(230,110,100,30);
		 reason_txf.setBounds(230,160,100,30);
		 patient_id_txf.setBounds(230,210,100,30);
		 doctor_id_txf.setBounds(230,260,100,30);
		 
		 
		 insert_btn.setBounds(50,310,90,30);
		 Read_btn.setBounds(150,310,90,30);
		 updatebtn.setBounds(260,310,90,30);
		 Delete_btn.setBounds(360,310,90,30);
		 table.setBounds(500, 10, 600, 240);
		 
	 }
	 private void CreateForm1() {	 
		 
		 frame=new JFrame();
		 frame.setTitle("Appointmentform");
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
		Appointment ap= new Appointment();
		
if (e.getSource()==insert_btn) {
			ap.setAppointmentdate(appointmentdate_txf.getText());
			ap.setStatus(status_txf.getText());
			ap.setReason(reason_txf.getText());
			ap.setPatient_id(patient_id_txf.getText());
			ap.setDoctor_id(doctor_id_txf.getText());
			ap.insertData();
		}

else if (e.getSource()==Read_btn) {
    model.setColumnCount(0);
    model.setRowCount(0);
    model.addColumn("Appointment_id");
    model.addColumn("appointmentdate");
    model.addColumn("status");
    model.addColumn("patient_id_");
    model.addColumn("doctor_id");
    

    ResultSet resultSet = Appointment.viewData();
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
			int id=Integer.parseInt(appointment_id_txf.getText());
			ap.setAppointmentdate(appointmentdate_txf.getText());
			ap.setStatus(status_txf.getText());
			ap.setReason(reason_txf.getText());
			ap.setPatient_id(patient_id_txf.getText());
			ap.setDoctor_id(doctor_id_txf.getText());
			ap.update(id);
			}
		else {
			int id=Integer.parseInt(appointment_id_txf.getText());
			ap.delete(id);}}

		public static void main (String[] args) {
			Appointmentform ap= new  Appointmentform();

			System.out.println( ap);
		}}
	 









