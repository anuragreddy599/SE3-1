package Schedule;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

public class mainpage {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainpage window = new mainpage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public mainpage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.controlLtHighlight);
		frame.setBounds(100, 100, 731, 476);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblWelcome = new JLabel("Welcome");
		lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblWelcome.setVerticalAlignment(SwingConstants.TOP);
		lblWelcome.setForeground(SystemColor.activeCaption);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(300, Short.MAX_VALUE)
					.addComponent(lblWelcome)
					.addGap(294))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(159)
					.addComponent(lblWelcome, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(203, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(SystemColor.activeCaption);
		frame.setJMenuBar(menuBar);
		
		JMenu mnSecurity = new JMenu("Maintanance");
		menuBar.add(mnSecurity);
		
		JMenuItem mntmXyz = new JMenuItem("University");
		mntmXyz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				frame.setVisible(false);
				university x=new university();
				x.main(null);
			}
		});
		mnSecurity.add(mntmXyz);
		
		JMenuItem mntmCourse = new JMenuItem("Course");
		mnSecurity.add(mntmCourse);
		
		JMenuItem mntmDegreePlan = new JMenuItem("Degree Plan");
		mnSecurity.add(mntmDegreePlan);
		
		JMenuItem mntmFaculity = new JMenuItem("Faculty");
		mnSecurity.add(mntmFaculity);
		
		JMenuItem mntmStudent = new JMenuItem("Student");
		mnSecurity.add(mntmStudent);
		
		JMenu mnNewMenu = new JMenu("Import");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmImportUniversity = new JMenuItem("Import University");
		mnNewMenu.add(mntmImportUniversity);
		
		JMenuItem mntmImportGradschool = new JMenuItem("Import GradSchool");
		mnNewMenu.add(mntmImportGradschool);
		
		JMenuItem mntmImportSemester = new JMenuItem("Import Semester");
		mnNewMenu.add(mntmImportSemester);
		
		JMenuItem mntmImportDegreePlan = new JMenuItem("Import Degree Plan");
		mnNewMenu.add(mntmImportDegreePlan);
		
		JMenuItem mntmImportCourse = new JMenuItem("Import Course");
		mnNewMenu.add(mntmImportCourse);
		
		JMenuItem mntmImportFaculity = new JMenuItem("Import Faculty");
		mnNewMenu.add(mntmImportFaculity);
		
		JMenuItem mntmImportStudent = new JMenuItem("Import Student");
		mnNewMenu.add(mntmImportStudent);
		
		JMenuItem mntmImportStudentCourses = new JMenuItem("Import Student Courses");
		mnNewMenu.add(mntmImportStudentCourses);
		
		JMenu mnSchedule = new JMenu("Schedule");
		menuBar.add(mnSchedule);
		
		JMenuItem mntmGenerateSchedule = new JMenuItem("Generate Schedule");
		mnSchedule.add(mntmGenerateSchedule);
		
		JMenuItem mntmTestSchedule = new JMenuItem("Test Schedule");
		mnSchedule.add(mntmTestSchedule);
		
		JMenu mnSystem = new JMenu("System");
		menuBar.add(mnSystem);
		
		JMenuItem mntmUser = new JMenuItem("User");
		mnSystem.add(mntmUser);
		
		JMenuItem mntmUserGroup = new JMenuItem("User Group");
		mnSystem.add(mntmUserGroup);
		
		JMenuItem mntmSystemFunction = new JMenuItem("System Function");
		mnSystem.add(mntmSystemFunction);
		
		JMenu mnReport = new JMenu("Report");
		menuBar.add(mnReport);
		
		JMenuItem mntmGenerateReport = new JMenuItem("Generate Report");
		mnReport.add(mntmGenerateReport);
	}
}