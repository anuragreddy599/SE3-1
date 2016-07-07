package schedule;
import beans.Course;
import beans.Degree;
import beans.DegreePlanReqs;
import beans.Faculty;
import beans.Section;
import beans.Student;
import beans.University;
import java.awt.EventQueue;
import scheduler.schedule;

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
import java.util.ArrayList;
import java.util.List;
import registers.CourseRegister;
import registers.DegreePlanReqsRegister;
import registers.DegreeRegister;
import registers.DegreeReqsRegister;
import registers.FacultyRegister;
import registers.GradSchoolRegister;
import registers.SemesterRegister;
import registers.StudentCourseRegister;
import registers.StudentRegister;
import registers.UniversityRegister;
import scheduler.Degree_Report;
import scheduler.Faculty_Report;
import scheduler.Section_Report;
import scheduler.Student_Report;
import utils.FileParser;
import utils.FilesEnum;
public class mainpage
{
	JLabel lblWelcome;
	private JFrame frame;
	static String univname;
	
	public static void main(String[] args)
	{
	
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
		university x=new university(new javax.swing.JFrame(), true);
		
                University obj=UniversityRegister.uni;
                if(null!=obj)
                univname=obj.getName();
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
                
                String loggedInRole= MainClassExecute.loggedInRole;
                
		JMenu mnSecurity = new JMenu("Maintenance");
		menuBar.add(mnSecurity);

		JMenuItem mntmXyz = new JMenuItem("University");
		mntmXyz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				frame.setVisible(false);
				university x=new university(new javax.swing.JFrame(), true);
				x.main(null);
			}
		});
		mnSecurity.add(mntmXyz);

		JMenuItem mntmCourse = new JMenuItem("Course");
		mntmCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
                                //List<Course> courseList=CourseRegister.courses;
                                //System.out.println(courseList);
				frame.setVisible(false);
				course x=new course(new javax.swing.JFrame(), true);
				x.main(null);
			}
		});
		mnSecurity.add(mntmCourse);

		JMenuItem mntmDegreePlan = new JMenuItem("Degree Plan");
		mntmDegreePlan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				frame.setVisible(false);
				degreeplan x=new degreeplan(new javax.swing.JFrame(), true);
				x.main(null);
			}
		});
		mnSecurity.add(mntmDegreePlan);
                
                JMenuItem mntmForecast = new JMenuItem("Forecast");
		mntmForecast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				frame.setVisible(false);
				degreeplan x=new degreeplan(new javax.swing.JFrame(), true);
				x.main(null);
			}
		});
		mnSecurity.add(mntmForecast);
                
                
                JMenuItem mntmDegreePlanReq = new JMenuItem("Degree Plan Req");
		mntmDegreePlanReq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				frame.setVisible(false);
				degreeplanReq x=new degreeplanReq(new javax.swing.JFrame(), true);
				x.main(null);
			}
		});
		mnSecurity.add(mntmDegreePlanReq);

		JMenuItem mntmFaculity = new JMenuItem("Faculty");
		mntmFaculity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				 List<Faculty> courseList=FacultyRegister.faculties;                              
				frame.setVisible(false);
				faculity y=new faculity(new javax.swing.JFrame(), true);
				y.main(null);
			}
		});
		mnSecurity.add(mntmFaculity);

		JMenuItem mntmStudent = new JMenuItem("Student");
		mntmStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				frame.setVisible(false);
				student x=new student(new javax.swing.JFrame(), true);
				x.main(null);
			}
		});
		mnSecurity.add(mntmStudent);
                
                JMenuItem mntmGradSchool = new JMenuItem("Grad School");
		mntmGradSchool.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				frame.setVisible(false);
				gradSchool x=new gradSchool(new javax.swing.JFrame(), true);
				x.main(null);
			}
		});
		mnSecurity.add(mntmGradSchool);
               
                JMenuItem mntmSemester = new JMenuItem("Semester");
		mntmSemester.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				frame.setVisible(false);
				semester x=new semester(new javax.swing.JFrame(), true);
				x.main(null);
			}
		});
		mnSecurity.add(mntmSemester);
                

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
                
                JMenuItem mntmImportDegreePlanReq = new JMenuItem("Import Degree Plan Req");
		mntmImportDegreePlanReq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				frame.setVisible(false);
				String[] args={Integer.toString(FilesEnum.DEGREE_REQ_FILE)};
				importFile.main(args);
			}
		});
		mnNewMenu.add(mntmImportDegreePlanReq);

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

		JMenuItem mntmImportFaculity = new JMenuItem("Import Faculty");
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
                if(loggedInRole.equals("D"))
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
		//mnSchedule.add(mntmTestSchedule);

		JMenu mnSystem = new JMenu("System");
                if(loggedInRole.equals("D"))
                    menuBar.add(mnSystem);
                
		JMenuItem mntmUser = new JMenuItem(" Add User");
		mntmUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				frame.setVisible(false);
				user x=new user();
				x.main(null);
			}
		});
                
                 mnSystem.add(mntmUser);
                 
                

		

		JMenu mnReport = new JMenu("Report");
                if(loggedInRole.equals("D"))
                    menuBar.add(mnReport);

                JMenu mnSchedule_Report = new JMenu("Schedule Report");
		mnReport.add(mnSchedule_Report);
                JMenu mntmStudent_Report = new JMenu("Student Report ");
                mnReport.add(mntmStudent_Report);
                
                JMenuItem mntmSection_Report = new JMenuItem("Section Report");
		mnSchedule_Report.add(mntmSection_Report);
               
		
		
               
               
                
                mntmSection_Report.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                                        Section[] sectionArray=schedule.sectionArray;
                                        if(sectionArray == null){
					JFrame parent = new JFrame();
			        JOptionPane.showMessageDialog(parent,"Please Generate the Schedule first.");
				}else{
                                        frame.setVisible(false);
					new Section_Report(null, sectionArray).setVisible(true);
                                        }
			}
		});
                 JMenuItem mnFaculty_Report = new JMenuItem("Faculty Report");
		mnSchedule_Report.add(mnFaculty_Report);
		mnFaculty_Report.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                            Section[] sectionArray=schedule.sectionArray;
                            ArrayList<Faculty> facultyList=FacultyRegister.faculties;
				if(sectionArray == null){
					JFrame parent = new JFrame();
			        JOptionPane.showMessageDialog(parent,"Please Generate the Schedule first.");
				} else{
					new Faculty_Report(null, sectionArray, facultyList.toArray(new Faculty[facultyList.size()])).setVisible(true);
					frame.setVisible(false);
				}
				
			}
		});
                 JMenuItem mntmDegree_Report = new JMenuItem("Degree Report");
                mntmStudent_Report.add(mntmDegree_Report);
                mntmDegree_Report.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Section[] sectionArray=schedule.sectionArray;
                            ArrayList<Degree> degreeList=DegreeRegister.degrees;
                            ArrayList<Student> studentList=StudentRegister.students;
				if(studentList == null){
					JFrame parent = new JFrame();
			        JOptionPane.showMessageDialog(parent,"import Student first");
				} else{
					new Degree_Report(null,studentList.toArray(new Student[studentList.size()]), 
                                                degreeList.toArray(new Degree[degreeList.size()])).setVisible(true);
					frame.setVisible(false);
				}

			}
		});
                 JMenuItem mntmStudent1_Report = new JMenuItem("Student Report");
                mntmStudent_Report.add(mntmStudent1_Report);
                mntmStudent1_Report.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                            
                            Section[] sectionArray=schedule.sectionArray;
                            ArrayList<Degree> degreeList=DegreeRegister.degrees;
                            ArrayList<Student> studentList=StudentRegister.students;
                             ArrayList<DegreePlanReqs> degreePlanList=DegreePlanReqsRegister.degreePlanReqs;
				if(studentList == null || studentList.size()==0){
					JFrame parent = new JFrame();
			        JOptionPane.showMessageDialog(parent,"Please Generate the Schedule.");
				} else{
					new Student_Report(null, studentList.toArray(new Student[studentList.size()]), 
                                                sectionArray, degreePlanList.toArray(new DegreePlanReqs[degreePlanList.size()])).setVisible(true);
					frame.setVisible(false);
				}


				
			}
		});
		JMenuItem mntmGenerateReport = new JMenuItem("Generate Report");
		mntmGenerateReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				frame.setVisible(false);
				reports x=new reports();
				x.main(null);
			}
		});
		//mnReport.add(mntmGenerateReport);
                
                JMenuItem logoutItem = new JMenuItem("Log out");
		logoutItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				frame.setVisible(false);
				MainClassExecute x=new MainClassExecute();
				x.main(null);
			}
		});
                menuBar.add(logoutItem);
                
                //Initialize all data
                if(!importFile.isImported)
                    importFile.importAllFiles();
	}
}