package schedule;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.filechooser.FileNameExtensionFilter;

import registers.CourseRegister;
import registers.DegreeRegister;
import registers.FacultyRegister;
import registers.GradSchoolRegister;
import registers.SemesterRegister;
import registers.StudentCourseRegister;
import registers.StudentRegister;
import registers.UniversityRegister;

import java.awt.SystemColor;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.EventQueue;
import java.io.File;
import java.io.IOException;
import java.util.prefs.Preferences;

import utils.FileParser;
import utils.FilesEnum;

public class importFile {

        public static boolean isImported=false;
	private int fileType;
	private JFrame frame;
	private JTextField textField;
	static importFile window;
	public static void main(final String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					window = new importFile(args[0]);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public importFile(String fileType)
	{
		this.fileType=Integer.parseInt(fileType);
		initialize();
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.controlLtHighlight);
		frame.setBounds(100, 100, 731, 476);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblUniversityEditPage = new JLabel("Data Import");
		lblUniversityEditPage.setForeground(SystemColor.activeCaption);
		lblUniversityEditPage.setBackground(SystemColor.activeCaption);
		lblUniversityEditPage.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel path = new JLabel("Path");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnImport = new JButton("Import");
		btnImport.setBackground(SystemColor.activeCaption);
		final JFileChooser fileChooser = new JFileChooser();
		btnImport.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				if(textField.getText().equals("")){
					if(getFilePath()!=null){
						fileChooser.setCurrentDirectory(new File(getFilePath().getAbsolutePath()));
					}
					else{
						fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
					}				
					fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("CSV Files", "csv","CSV"));
					fileChooser.setAcceptAllFileFilterUsed(false);
					int result = fileChooser.showOpenDialog(frame);
					if (result == JFileChooser.APPROVE_OPTION) {
					    File selectedFile = fileChooser.getSelectedFile();
					    setFilePath(selectedFile);
					    
					    if(fileType==FilesEnum.UNIVERSITY_FILE){
					    	try{
					    		FileParser parser =new FileParser();					    		
					    		int count=parser.saveUniversityInfo(parser.parse(selectedFile.getAbsolutePath()));
					    		
					    		String message =count+" Record(s) imported.";
								JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.INFORMATION_MESSAGE);
					    	
					    	}catch(IOException  e){
					    		String message = "Please Give path to a correct File University Data File.";
								JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.ERROR_MESSAGE);
								e.printStackTrace();
					    	}
                                                catch( ArrayIndexOutOfBoundsException e){
					    		String message = "Please Give path to a correct File University Data File.";
								JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.ERROR_MESSAGE);
								e.printStackTrace();
					    	}
					    	
					    }
					    
					    else if(fileType==FilesEnum.GRADSCHOOL_FILE){
					    	try{
					    		FileParser parser =new FileParser();					    		
					    		int count=parser.saveGradSchoolInfo(parser.parse(selectedFile.getAbsolutePath()));
					    		
					    		String message =count+" Record(s) imported.";
								JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.INFORMATION_MESSAGE);
					    	
					    	}catch(IOException e){
					    		String message = "Please Give path to a correct University Data File.";
								JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.ERROR_MESSAGE);
								e.printStackTrace();
					    	}catch( ArrayIndexOutOfBoundsException e){
					    		String message = "Please Give path to a correct University Data File.";
								JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.ERROR_MESSAGE);
								e.printStackTrace();
					    	}				    	
					    }
					    
					    else if(fileType==FilesEnum.SEMESTER_FILE){
					    	try{
					    		FileParser parser =new FileParser();					    		
					    		int count=parser.saveSemestersInfo(parser.parse(selectedFile.getAbsolutePath()));
					    		
					    		String message =count+" Record(s) imported.";
								JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.INFORMATION_MESSAGE);
					    	
					    	}catch(IOException  e){
					    		String message = "Please Give path to a correct Grad School Data File.";
								JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.ERROR_MESSAGE);
								e.printStackTrace();
					    	}catch( ArrayIndexOutOfBoundsException e){
					    		String message = "Please Give path to a correct Grad School Data File.";
								JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.ERROR_MESSAGE);
								e.printStackTrace();
					    	}
					    	
					    }
					    
					    else if(fileType==FilesEnum.DEGREE_FILE){
					    	try{
					    		FileParser parser =new FileParser();					    		
					    		int count=parser.saveDegrees(parser.parse(selectedFile.getAbsolutePath()));
					    		
					    		String message =count+" Record(s) imported.";
								JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.INFORMATION_MESSAGE);
					    	
					    	}catch(IOException e){
					    		String message = "Please Give path to a correct Degree Data File.";
								JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.ERROR_MESSAGE);
								e.printStackTrace();
					    	}catch( ArrayIndexOutOfBoundsException e){
					    		String message = "Please Give path to a correct Degree Data File.";
								JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.ERROR_MESSAGE);
								e.printStackTrace();
					    	}
					    	
					    }
                                            else if(fileType==FilesEnum.DEGREE_REQ_FILE){
					    	try{
					    		FileParser parser =new FileParser();					    		
					    		parser.saveDegreeReqs(parser.parse(selectedFile.getAbsolutePath()));
					    		
					    		String message =" Record(s) imported.";
								JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.INFORMATION_MESSAGE);
					    	
					    	}catch(IOException e){
					    		String message = "Please Give path to a correct Degree Data File.";
								JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.ERROR_MESSAGE);
								e.printStackTrace();
					    	}catch( ArrayIndexOutOfBoundsException e){
					    		String message = "Please Give path to a correct Degree Data File.";
								JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.ERROR_MESSAGE);
								e.printStackTrace();
					    	}
					    	
					    }
                                            
					    
					    else if(fileType==FilesEnum.COURSE_FILE){
					    	try{
					    		FileParser parser =new FileParser();					    		
					    		int count=parser.saveCourseInfo((parser.parse(selectedFile.getAbsolutePath())));
					    		
					    		String message =count+" Record(s) imported.";
								JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.INFORMATION_MESSAGE);
					    	
					    	}catch(IOException  e){
					    		String message = "Please Give path to a correct Course Data File.";
								JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.ERROR_MESSAGE);
								e.printStackTrace();
					    	}catch( ArrayIndexOutOfBoundsException e){
					    		String message = "Please Give path to a correct Course Data File.";
								JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.ERROR_MESSAGE);
								e.printStackTrace();
					    	}
					    	
					    }
					    
					    else if(fileType==FilesEnum.FACULTY_FILE){
					    	try{
					    		FileParser parser =new FileParser();					    		
					    		int count=parser.saveFacultyInfo(parser.parse(selectedFile.getAbsolutePath()));
					    		
					    		String message =count+" Record(s) imported.";
								JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.INFORMATION_MESSAGE);
					    	
					    	}catch(IOException  e){
					    		String message = "Please Give path to a correct Faculty Data File.";
								JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.ERROR_MESSAGE);
								e.printStackTrace();
					    	}catch( ArrayIndexOutOfBoundsException e){
					    		String message = "Please Give path to a correct Faculty Data File.";
								JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.ERROR_MESSAGE);
								e.printStackTrace();
					    	}
					    	
					    }
					    
					    else if(fileType==FilesEnum.STUDENT_FILE){
					    	try{
					    		FileParser parser =new FileParser();					    		
					    		int count=parser.saveStudentsInfo(parser.parse(selectedFile.getAbsolutePath()));
					    		
					    		String message =count+" Record(s) imported.";
								JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.INFORMATION_MESSAGE);
					    	
					    	}catch(IOException e){
					    		String message = "Please Give path to a correct Students Data File.";
								JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.ERROR_MESSAGE);
								e.printStackTrace();
					    	}
                                                catch( ArrayIndexOutOfBoundsException e){
					    		String message = "Please Give path to a correct Students Data File.";
								JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.ERROR_MESSAGE);
								e.printStackTrace();
					    	}
					    }
					    
					    else if(fileType==FilesEnum.STUDENTCOURSES_FILE){
					    	try{
					    		FileParser parser =new FileParser();					    		
					    		int count=parser.saveStudentCourseInfo(parser.parse(selectedFile.getAbsolutePath()));
					    		
					    		String message =count+" Record(s) imported.";
								JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.INFORMATION_MESSAGE);
					    	
					    	}catch(IOException  e){
					    		String message = "Please Give path to a correct Students Courses Data File.";
								JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.ERROR_MESSAGE);
								e.printStackTrace();
					    	}catch( ArrayIndexOutOfBoundsException e){
					    		String message = "Please Give path to a correct Students Courses Data File.";
								JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.ERROR_MESSAGE);
								e.printStackTrace();
					    	}
					    }
					    
					    frame.setVisible(false);
						mainpage.main(null);
					}
					else{
						String message = "Please Choose a file to load.";
						JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.ERROR_MESSAGE);
					}
				}
				else{
					if(textField.getText().endsWith(".csv") || textField.getText().endsWith(".CSV")){
						frame.setVisible(false);
						mainpage.main(null);
					}
					else{
						String message = "Please add path to a .csv file to load.";
						JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				frame.setVisible(false);
				mainpage.main(null);
			}
		});
		btnCancel.setBackground(SystemColor.activeCaption);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				mainpage.main(null);
			}
		});
		btnBack.setBackground(SystemColor.activeCaption);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(106, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblUniversityEditPage)
							.addGap(263))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(path)
									.addGap(41)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, 382, GroupLayout.PREFERRED_SIZE)
									.addGap(26))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnImport))
							.addGap(65))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblUniversityEditPage)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(path)
						.addComponent(btnImport))
					.addPreferredGap(ComponentPlacement.RELATED, 293, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancel)
						.addComponent(btnBack))
					.addGap(45))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
	
	public File getFilePath() {
		Preferences prefs = Preferences.userNodeForPackage(importFile.class);
		String filePath = prefs.get("filePath", null);
		if (filePath != null) {
			return new File(filePath);
		} else {
			return null;
		}
	}

	/**
	 * Sets the file path of the currently loaded file. The path is persisted in
	 * the OS specific registry.
	 * 
	 * @param file the file or null to remove the path
	 */
	public void setFilePath(File file) {
		Preferences prefs = Preferences.userNodeForPackage(importFile.class);
		if (file != null) {
			prefs.put("filePath", file.getPath());
		} else {
			prefs.remove("filePath");
		}
	}
       static void importAllFiles(){
           try{
            //University
            FileParser parser =new FileParser();
            File selectedUnivFile= new File("E:\\test data\\TestDataUniversityName.csv");
            int count=parser.saveUniversityInfo(parser.parse(selectedUnivFile.getAbsolutePath()));
            
            //Grad School
            File selectedGradScoolFile= new File("E:\\test data\\TestDataUniversityName.csv");
            parser.saveGradSchoolInfo(parser.parse(selectedGradScoolFile.getAbsolutePath()));
            
            //Faculty
            File selectedFacultyFile= new File("E:\\test data\\TestDataFaculty.csv");
            parser.saveFacultyInfo(parser.parse(selectedFacultyFile.getAbsolutePath()));
            
            //Degree
            File selectedDegreeFile= new File("E:\\test data\\TestDataDegrees.csv");
            parser.saveDegrees(parser.parse(selectedDegreeFile.getAbsolutePath()));
            
            //Degree plan
            File selectedDegreePlanFile= new File("E:\\test data\\TestDataDegreePlanReq.csv");
            parser.saveDegreePlanReq(parser.parse(selectedDegreePlanFile.getAbsolutePath()));
            
            //Course
             File selectedCourseFile= new File("E:\\test data\\TestDataCourses.csv");
             parser.saveCourseInfo((parser.parse(selectedCourseFile.getAbsolutePath())));
             
             //Semester
             //importSemesterArray("TestDataSemesters.csv");
             File selectedSemesterFile= new File("E:\\test data\\TestDataSemesters.csv");
             parser.saveSemestersInfo(parser.parse(selectedSemesterFile.getAbsolutePath()));
             
             isImported=true;
             
           }catch(Exception e){
               e.printStackTrace();
           }
            
        }
}