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
import Mytable.Doctor;
import Mytable.Insurance;
import Mytable.Patient;

public class Insuranceform implements ActionListener {
JFrame frame; 
JLabel insurance_id_lb=new JLabel(" INSURANCE_ID");
JLabel insurance_name_lb=new JLabel("INSURANCE-NAME");
DefaultTableModel model = new DefaultTableModel();
JTable table = new JTable(model);


JTextField insurance_id_txf=new JTextField();
JTextField insurance_name_txf=new JTextField();

JButton insert_btn=new JButton("insert");
JButton Read_btn=new JButton("Read");
JButton updatebtn=new JButton("update");
JButton Delete_btn=new JButton("Delete");

Dimension ScreenSize=Toolkit.getDefaultToolkit().getScreenSize();
int w=(int) ScreenSize.getWidth();
int H=(int) ScreenSize.getHeight();

 public Insuranceform() {
	 CreateForm1();
	 ActionEvent1();
	 SetLocation1();
	 SetFontforAll();
	 AddCompenentToFrame();
	 
 }
 
 private void AddCompenentToFrame() {
	 frame.add(insurance_id_lb);
	 frame.add(insurance_name_lb);
	 
	 frame.add(insurance_id_txf); 
	 frame.add(insurance_name_txf);
	 
	 frame.add(insert_btn);
	 frame.add(Read_btn);
	 frame.add(updatebtn);
	 frame.add(Delete_btn);
	 frame.add(table);
 }
 private void SetFontforAll() {
	 Font font=new Font("Georgia",Font.BOLD,18);
	 insurance_id_lb.setFont(font);
	 insurance_name_lb.setFont(font);
	 
	 insurance_id_txf.setFont(font);
	 insurance_name_txf.setFont(font);
	 
	
	 Font fonti=new Font("courier new",Font.ITALIC,12);
	 insert_btn.setFont(fonti);
	 Read_btn.setFont(fonti);
	 updatebtn.setFont(fonti);
	 Delete_btn.setFont(fonti);
 }
 
 
 private void SetLocation1() {
	 insurance_id_lb.setBounds(10,10,80,30);
	 insurance_name_lb.setBounds(10,60,80,30);
	 
	 insurance_id_txf.setBounds(160,10,90,30);
	 insurance_name_txf.setBounds(160,60,90,30);
	 
	 
	 insert_btn.setBounds(50,290,85,30);
	 Read_btn.setBounds(150,290,95,30);
	 updatebtn.setBounds(260,290,85,30);
	 Delete_btn.setBounds(360,290,85,30);
	 table.setBounds(500, 10, 600, 240);
	 
 }
 
 private void CreateForm1() {
	 frame=new JFrame();
	 frame.setTitle("InsuranceForm");
	 frame.setBounds(0,0,w/2,H/2);
	 frame.getContentPane().setLayout(null);
	 frame.getContentPane().setBackground(Color.red);
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
	Insurance di= new Insurance();
				Insuranceform dy= new Insuranceform ();
		
 
if (e.getSource()==insert_btn) {
		di.setInsurance_name(insurance_name_txf.getText());
		di.insertData();
	}

else if (e.getSource()==Read_btn) {
    model.setColumnCount(0);
    model.setRowCount(0);
    model.addColumn("insurance_id");
    model.addColumn("insurance_name");
    

    ResultSet resultSet = Patient.viewData();
    if (resultSet != null) {
        try {
            while (resultSet.next()) {
                model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2) });
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
	else if (e.getSource()==updatebtn) {
		int id=Integer.parseInt(insurance_id_txf.getText());
		di.setInsurance_name(insurance_name_txf.getText());
		di.update(id);
		}
	else {
		int id=Integer.parseInt(insurance_id_txf.getText());
		di.delete(id);}}}

	public static void main (String[] args) {
		Insuranceform  dy= new Insuranceform();
		System.out.println( dy );
	}}










	

	
























