package Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Myforms.Appointmentform;
import Myforms.Insuranceform;
import Myforms.Medical_clinicform;
import Myforms.Patientform;
import Myforms.Prescriptionform;
import Myforms.doctorform;

public class MenuForm implements ActionListener {
	JFrame frame;
	JMenu home,  appointment, doctor,patient,medical_clinic,insurance,prescription, more;
	JMenuItem i1, i2, i3, i4, i5, i6, item1, item2,PatientDelete,PatientUpdate,PatientRead;
	JMenuItem appointmentDelete,appointmentUpdate,appointmentRead;
	JMenuItem doctorDelete,doctorUpdate,doctorRead;
	JMenuItem patientDelete,patientUpdate,patientRead;
	JMenuItem medical_clinicDelete,medical_clinicUpdate,medical_clinicRead;
	JMenuItem insuranceDelete,insuranceUpdate,insuranceRead;
	JMenuItem prescriptionDelete,prescriptionUpdate,prescriptionRead;
	
	public MenuForm (){
		createWindow();
	}
	private void createWindow() {
		frame = new JFrame("Menu form with main Menu");
		frame.setSize(400, 400);

		JMenuBar mb = new JMenuBar(); // Create a new menu bar
		home = new JMenu("Home");
		appointment = new JMenu("appointment");
		doctor= new JMenu("doctor");
		patient = new JMenu("patient");
		medical_clinic=new JMenu("medical_clinic");
		insurance=new JMenu("insurance");
		prescription=new JMenu("prescription");
		
		more = new JMenu("More");
		i1 = new JMenuItem("Insert");
		i2 = new JMenuItem("Read");
		i3 = new JMenuItem("Update");
		i4 = new JMenuItem("Delete");
		i5 = new JMenuItem("Item 5");
		i6 = new JMenuItem("Item 6");
		more.add(i5);
		more.add(i6);

		home.add(i1);
		home.add(more); // Add the 'more' submenu to the 'home' menu
		
		appointmentRead = new JMenuItem("Read");
		appointmentUpdate = new JMenuItem("Update");
		appointmentDelete = new JMenuItem("Delete");
		appointment.add(appointmentRead);
		appointment.add(appointmentUpdate);
		appointment.add(appointmentDelete);

		doctorRead =new JMenuItem("Read");
		doctorUpdate =new JMenuItem("Update");
		doctorDelete =new JMenuItem("Delete");
		
		doctor.add(doctorRead);
		doctor.add(doctorUpdate);
		doctor.add(doctorDelete);
		
		patientRead =new JMenuItem("Read");
		patientUpdate =new JMenuItem("Update");
		patientDelete =new JMenuItem("Delete");
		patient.add(patientRead);
		patient.add(patientUpdate);
		patient.add(patientDelete);
		
		medical_clinicRead =new JMenuItem("Read");
		medical_clinicUpdate =new JMenuItem("Update");
		medical_clinicDelete =new JMenuItem("Update");
		medical_clinic.add(medical_clinicRead);
		medical_clinic.add(medical_clinicUpdate);
		medical_clinic.add(medical_clinicDelete);
		
		insuranceRead =new JMenuItem("Read");
		insuranceUpdate =new JMenuItem("Update");
		insuranceDelete =new JMenuItem("Delete");
		insurance.add(insuranceRead);
		insurance.add(insuranceUpdate);
		insurance.add(insuranceDelete);
		
		prescriptionRead =new JMenuItem("Read");
		prescriptionUpdate =new JMenuItem("Update");
		prescriptionDelete =new JMenuItem("Delete");
		prescription.add(prescriptionRead);
		prescription.add(prescriptionUpdate);
		prescription.add(prescriptionDelete);
		
		
		mb.add(home);
		mb.add(appointment);
		mb.add(doctor);
		mb.add(patient);
		mb.add(medical_clinic);
		mb.add(insurance);
		mb.add(prescription);
		
		frame.setJMenuBar(mb);// Set the menu bar to the frame

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		componentsOnFrame();

	}
	private void componentsOnFrame() {
		home = new JMenu("Home");
		appointment = new JMenu("appointment");
		doctor = new JMenu("doctor");
		patient =new JMenu("patient");
		medical_clinic=new JMenu("medical_clinic");
		insurance=new JMenu("insurance");
	    prescription =new JMenu("prescription");
		
		
		
		more = new JMenu("More");
		i1 = new JMenuItem("Create");
		i2 = new JMenuItem("Read");
		i3 = new JMenuItem("Update");
		i4 = new JMenuItem("Delete");
		i5 = new JMenuItem("Item 5");
		i6 = new JMenuItem("Item 6");
		more.add(i5);
		more.add(i6);

		home.add(i1);
		home.add(more);
		appointment.add(i2);
		appointment.add(i3);
		appointment.add(i4);
		doctor.add(i2);
		doctor.add(i3);
		doctor.add(i4);
		patient.add(i2);
		patient.add(i3);
		patient.add(i4);
	    medical_clinic.add(i2);
		medical_clinic.add(i3);
		medical_clinic.add(i4);
		insurance.add(i2);
		insurance.add(i3);
		insurance.add(i4);
		prescription.add(i2);
		prescription.add(i3);
		prescription.add(i4);
		
		addactionEvent();

		
		
	}
	private void addactionEvent() {
		appointmentRead.addActionListener(this);
		doctorRead.addActionListener(this);
		patientRead.addActionListener(this);
		medical_clinicRead.addActionListener(this);
		insuranceRead.addActionListener(this);
		prescriptionRead.addActionListener(this);
		
		
	}
	public static void main(String[] args) {
		new MenuForm();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==appointmentRead) {
			Appointmentform ap= new  Appointmentform();
			frame.dispose();
		}else if (e.getSource()==doctorRead) {
			doctorform dt= new  doctorform();
			frame.dispose();
		}else if (e.getSource()==patientRead) {
			Patientform pt= new  Patientform();
			frame.dispose();
		}else if (e.getSource()==medical_clinicRead) {
			Medical_clinicform mr= new Medical_clinicform();
			frame.dispose();
			}else if (e.getSource()==insuranceRead) {
				Insuranceform  dy= new Insuranceform();
				frame.dispose();
				}else if (e.getSource()==prescriptionRead) {
					Prescriptionform pi= new  Prescriptionform();
					frame.dispose();
				}
					
	}

}
