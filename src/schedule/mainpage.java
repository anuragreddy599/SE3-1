package schedule;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JOptionPane;

import java.awt.SystemColor;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.JPanel;

import controller.MainController;
import registers.CourseRegister;
import registers.DegreeRegister;
import registers.DegreeReqsRegister;
import registers.FacultyRegister;
import registers.GradSchoolRegister;
import registers.SemesterRegister;
import registers.StudentCourseRegister;
import registers.StudentRegister;
import registers.UniversityRegister;
import utils.FileParser;
import utils.FilesEnum;
public class mainpage
{
	JLabel lblWelcome;
	private JFrame frame;
	static String univname;
	
	public static void main(String[] args)
	{
		//FileParser parser=new FileParser();
//		String studentUrl="C:\\Users\\LeMarc\\Downloads\\Files\\TestData\\STU.DUMP.CSV";
//		String studentUrl="C:\\Users\\LeMarc\\Downloads\\Files\\TestData\\STU.DUMP.CSV";
//		try {
			//parser.saveStudentsInfo(parser.parse(studentUrl));
			//System.out.println(StudentRegister.getInstance().getStudent("1000026").toString());
//			DegreeRegister.getInstance().editDegree("MSE.EE", "GSECS", "Masters of Science in Engineering - Electrical Engineering", "15");
//			System.out.println(DegreeRegister.getInstance().getDegree("MSE.EE").toString());
//			DegreeRegister.getInstance().deleteDegree("MSE.EE");
//			System.out.println(DegreeRegister.getInstance().getDegree("MSE.EE").toString());
//		} catch (IOException e1) {
//			String message = "An Error Occured While parsing.";
//			JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.ERROR_MESSAGE);
//			e1.printStackTrace();
//		}
		//System.out.println(MainController.getInstance().getCourses().get(0).toString());
		
		
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					mainpage window = new mainpage();
					window.frame.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}
	public mainpage()
	{
		initialize();
	}
	private void initialize()
	{
		frame = new JFrame();
		//	univname = null;
		university x=new university();
		univname=x.uniname();
		frame.getContentPane().setBackground(SystemColor.controlLtHighlight);
		frame.setBounds(100, 100, 731, 476);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		lblWelcome = new JLabel("OKLAHOMA UNIVERSITY");
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		if(univname!=null)
		{
			lblWelcome.setText(univname);
		}
		lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblWelcome.setForeground(SystemColor.activeCaption);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
						.addGap(30)
						.addComponent(lblWelcome, GroupLayout.PREFERRED_SIZE, 658, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(27, Short.MAX_VALUE))
				);
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGap(39)
						.addComponent(lblWelcome, GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(101, Short.MAX_VALUE))
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
		mntmCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				frame.setVisible(false);
				course x=new course();
				x.main(null);
			}
		});
		mnSecurity.add(mntmCourse);

		JMenuItem mntmDegreePlan = new JMenuItem("Degree Plan");
		mntmDegreePlan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				frame.setVisible(false);
				degreeplan x=new degreeplan();
				x.main(null);
			}
		});
		mnSecurity.add(mntmDegreePlan);

		JMenuItem mntmFaculity = new JMenuItem("Faculty");
		mntmFaculity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				frame.setVisible(false);
				faculty x=new faculty();
				x.main(null);
			}
		});
		mnSecurity.add(mntmFaculity);

		JMenuItem mntmStudent = new JMenuItem("Student");
		mntmStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				frame.setVisible(false);
				student x=new student();
				x.main(null);
			}
		});
		mnSecurity.add(mntmStudent);

		JMenu mnNewMenu = new JMenu("Import");
		menuBar.add(mnNewMenu);

		JMenuItem mntmImportUniversity = new JMenuItem("Import University");
		mntmImportUniversity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				frame.setVisible(false);
				String[] args={Integer.toString(FilesEnum.UNIVERSITY_FILE)};
				importFile.main(args);
			}
		});
		mnNewMenu.add(mntmImportUniversity);

		JMenuItem mntmImportGradschool = new JMenuItem("Import GradSchool");
		mntmImportGradschool.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				frame.setVisible(false);
				String[] args={Integer.toString(FilesEnum.GRADSCHOOL_FILE)};
				importFile.main(args);
			}
		});
		mnNewMenu.add(mntmImportGradschool);

		JMenuItem mntmImportSemester = new JMenuItem("Import Semester");
		mntmImportSemester.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				frame.setVisible(false);
				String[] args={Integer.toString(FilesEnum.SEMESTER_FILE)};
				importFile.main(args);
			}
		});
		mnNewMenu.add(mntmImportSemester);

		JMenuItem mntmImportDegreePlan = new JMenuItem("Import Degree Plan");
		mntmImportDegreePlan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				frame.setVisible(false);
				String[] args={Integer.toString(FilesEnum.DEGREE_FILE)};
				importFile.main(args);
			}
		});
		mnNewMenu.add(mntmImportDegreePlan);

		JMenuItem mntmImportCourse = new JMenuItem("Import Course");
		mntmImportCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				frame.setVisible(false);
				String[] args={Integer.toString(FilesEnum.COURSE_FILE)};
				importFile.main(args);
			}
		});
		mnNewMenu.add(mntmImportCourse);

		JMenuItem mntmImportFaculity = new JMenuItem("Import Faculity");
		mntmImportFaculity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				frame.setVisible(false);
				String[] args={Integer.toString(FilesEnum.FACULTY_FILE)};
				importFile.main(args);
			}
		});
		mnNewMenu.add(mntmImportFaculity);

		JMenuItem mntmImportStudent = new JMenuItem("Import Student");
		mntmImportStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				frame.setVisible(false);
				String[] args={Integer.toString(FilesEnum.STUDENT_FILE)};
				importFile.main(args);
			}
		});
		mnNewMenu.add(mntmImportStudent);

		JMenuItem mntmImportStudentCourses = new JMenuItem("Import Student Courses");
		mntmImportStudentCourses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				frame.setVisible(false);
				String[] args={Integer.toString(FilesEnum.STUDENTCOURSES_FILE)};
				importFile.main(args);
			}
		});
		mnNewMenu.add(mntmImportStudentCourses);

		JMenu mnSchedule = new JMenu("Schedule");
		menuBar.add(mnSchedule);

		JMenuItem mntmGenerateSchedule = new JMenuItem("Generate Schedule");
		mntmGenerateSchedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				frame.setVisible(false);
				generateschedule x=new generateschedule();
				x.main(null);
			}
		});
		mnSchedule.add(mntmGenerateSchedule);

		JMenuItem mntmTestSchedule = new JMenuItem("Test Schedule");
		mntmTestSchedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				frame.setVisible(false);
				testschedule x=new testschedule();
				x.main(null);
			}
		});
		mnSchedule.add(mntmTestSchedule);

		JMenu mnSystem = new JMenu("System");
		menuBar.add(mnSystem);

		JMenuItem mntmUser = new JMenuItem("User");
		mntmUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				frame.setVisible(false);
				user x=new user();
				x.main(null);
			}
		});
		mnSystem.add(mntmUser);

		JMenuItem mntmUserGroup = new JMenuItem("User Group");
		mntmUserGroup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				frame.setVisible(false);
				groupuser x=new groupuser();
				x.main(null);
			}
		});
		mnSystem.add(mntmUserGroup);

		JMenuItem mntmSystemFunction = new JMenuItem("System Function");
		mntmSystemFunction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				frame.setVisible(false);
				systemfunction x=new systemfunction();
				x.main(null);
			}
		});
		mnSystem.add(mntmSystemFunction);

		JMenu mnReport = new JMenu("Report");
		menuBar.add(mnReport);

		JMenuItem mntmGenerateReport = new JMenuItem("Generate Report");
		mntmGenerateReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				frame.setVisible(false);
				reports x=new reports();
				x.main(null);
			}
		});
		mnReport.add(mntmGenerateReport);
	}
}