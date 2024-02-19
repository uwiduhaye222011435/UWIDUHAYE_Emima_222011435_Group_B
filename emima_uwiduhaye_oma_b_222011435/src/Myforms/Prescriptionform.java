package Myforms;

	import java.awt.Color;
import java.awt.Component;
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



import Mytable.Prescription;
		 
		
	
	public class Prescriptionform implements ActionListener {
		
	JFrame frame; 
	JLabel prescription_id_lb=new JLabel(" PRESCRIPTION_ID");
	JLabel medication_name_lb=new JLabel("MEDICATION_NAME");
	JLabel dosage_lb=new JLabel("DOSAGE");
	JLabel frequency_lb=new JLabel("FREQUENCY");
	JLabel startdate_lb=new JLabel("STARTDATE");
	JLabel enddate_lb=new JLabel("ENDDATE");
	JLabel patient_id_lb=new JLabel("PATIENT_ID");
	JLabel DOCTOR_id_lb=new JLabel("DOCTOR_ID");
	JLabel appointment_id_lb=new JLabel("APPOINTMENT_ID");
	DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);


	JTextField prescription_id_txf=new JTextField();
	JTextField medication_name_txf=new JTextField();
	JTextField dosage_txf=new JTextField();
	JTextField frequency_txf=new JTextField();
	JTextField startdate_txf=new JTextField();
	JTextField enddate_txf=new JTextField();
	JTextField patient_id_txf=new JTextField();
	JTextField doctor_id_txf=new JTextField();
	JTextField appointment_id_txf=new JTextField();
	   


	JButton insert_btn=new JButton("insert");
	JButton Read_btn=new JButton("Read");
	JButton updatebtn=new JButton("update");
	JButton Delete_btn=new JButton("Delete");
	Dimension ScreenSize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int) ScreenSize.getWidth();
	int H=(int) ScreenSize.getHeight();
	

	 public Prescriptionform() {
		 CreateForm1();
		 ActionEvent1();
		 SetLocation1();
		 SetFontforAll();
		 AddCompenentToFrame();
		 
	 }
	 
	 private void AddCompenentToFrame() {
		 frame.add(prescription_id_lb);
		 frame.add(medication_name_lb);
		 frame.add(dosage_lb);
		 frame.add(frequency_lb);
		 frame.add(startdate_lb);
		 frame.add(enddate_lb);
		 frame.add(patient_id_lb);
		 frame.add(DOCTOR_id_lb);
		 frame.add(appointment_id_lb);
		 
		 
		 
		 frame.add(prescription_id_txf);
		 frame.add(medication_name_txf);
		 frame.add(dosage_txf);
		 frame.add(frequency_txf);
		 frame.add(startdate_txf);
		 frame.add(enddate_txf);
		 frame.add(patient_id_txf);
		 frame.add(doctor_id_txf);
		 frame.add(appointment_id_txf);
		 
		 
		 frame.add(insert_btn);
		 frame.add(Read_btn);
		 frame.add(updatebtn);
		 frame.add(Delete_btn);
		 frame.add(table);
	 }
	 private void SetFontforAll() {
		 Font font=new Font("Georgia",Font.BOLD,18);
		 prescription_id_lb.setFont(font);
		medication_name_lb.setFont(font);
		dosage_lb.setFont(font);
		frequency_lb.setFont(font);
		startdate_lb.setFont(font);
		enddate_lb.setFont(font);
		patient_id_lb.setFont(font);
		DOCTOR_id_lb.setFont(font);
		appointment_id_lb.setFont(font);
		 
		prescription_id_txf.setFont(font);
		medication_name_txf.setFont(font);
		dosage_txf.setFont(font);
		frequency_txf.setFont(font);
		startdate_txf.setFont(font);
		enddate_txf.setFont(font);
		patient_id_txf.setFont(font);
		doctor_id_txf.setFont(font);
		appointment_id_txf.setFont(font);
		 
		 
		 Font fonti=new Font("courier new",Font.ITALIC,12);
		 insert_btn.setFont(fonti);
		 Read_btn.setFont(fonti);
		 updatebtn.setFont(fonti);
		 Delete_btn.setFont(fonti);
	 }
	 
	 
	 private void SetLocation1() {
		 prescription_id_lb.setBounds(10,10,180,30);
		 medication_name_lb.setBounds(10,60,230,30);
		 dosage_lb.setBounds(10,110,180,30);
		 frequency_lb.setBounds(10,160,180,30);
		 startdate_lb.setBounds(10,210,180,30);
		 enddate_lb.setBounds(10,260,180,30);
		 patient_id_lb.setBounds(10,310,180,30);
		 DOCTOR_id_lb.setBounds(10,360,180,30);
		 appointment_id_lb.setBounds(10,410,200,30);
			
		 
		 prescription_id_txf.setBounds(230,10,150,30);
		 medication_name_txf.setBounds(230,60,150,30);
		 dosage_txf.setBounds(230,110,150,30);
		 frequency_txf.setBounds(230,160,150,30);
		 startdate_txf.setBounds(230,210,150,30);
		 enddate_txf.setBounds(230,260,150,30);
		 patient_id_txf.setBounds(230,310,150,30);
		 doctor_id_txf.setBounds(230,360,150,30);
		 appointment_id_txf.setBounds(230,410,150,30);
		 
		 
		 insert_btn.setBounds(80,510,80,30);
		 Read_btn.setBounds(180,510,80,30);
		 updatebtn.setBounds(280,510,80,30);
		 Delete_btn.setBounds(380,510,80,30);
		 table.setBounds(500, 10, 600, 240);
		 
	 }
	 private void CreateForm1() {	 
		 
		 frame=new JFrame();
		 frame.setTitle("Prescriptionform");
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
	Prescription pr= new Prescription();
	
if (e.getSource()==insert_btn) {
		pr.setMedication_name(medication_name_txf.getText());
		pr.setDosage(dosage_txf.getText());
		pr.setFrequency(frequency_txf.getText());
		pr.setStartdate(startdate_txf.getText());
		pr.setEnddate(enddate_txf.getText());
	    pr.setPatient_id(patient_id_txf.getText());
		pr.setDoctor_id(doctor_id_txf.getText());
		pr.setAppointment_id(appointment_id_txf.getText());
		pr.insertData();
	}

else if (e.getSource()==Read_btn) {
    model.setColumnCount(0);
    model.setRowCount(0);
    model.addColumn("Prescription_id");
    model.addColumn("dosage");
    model.addColumn("frequency");
    model.addColumn("startdate");
    model.addColumn("enddate");
    model.addColumn("patient_id_");
    model.addColumn("doctor_id");
    model.addColumn("appointment_id");
    

    ResultSet resultSet = Prescription.viewData();
    if (resultSet != null) {
        try {
            while (resultSet.next()) {
                model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                        resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7), resultSet.getString(8) });
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }}
	else if (e.getSource()==updatebtn) {
		int id=Integer.parseInt(prescription_id_txf.getText());
		pr.setMedication_name(medication_name_txf.getText());
		pr.setDosage(dosage_txf.getText());
		pr.setFrequency(frequency_txf.getText());
		pr.setStartdate(startdate_txf.getText());
		pr.setEnddate(enddate_txf.getText());
	    pr.setPatient_id(patient_id_txf.getText());
		pr.setDoctor_id(doctor_id_txf.getText());
		pr.setAppointment_id(appointment_id_txf.getText());
		pr.update(id);
		}
	else {
		int id=Integer.parseInt(prescription_id_txf.getText());
		pr.delete(id);}}

	public static void main (String[] args) {
		Prescriptionform pi= new  Prescriptionform();

		System.out.println( pi);
	}}
 

