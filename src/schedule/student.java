package schedule;
import beans.Degree;
import beans.Faculty;
import beans.Semester;
import beans.Student;
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
import java.sql.SQLException;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import model.FacultyTableModel;
import model.StudentTableModel;
import registers.DegreeRegister;
import registers.FacultyRegister;
import registers.SemesterRegister;
import registers.StudentRegister;

public class student extends javax.swing.JDialog{

        boolean addRecord = false;

    private void clearInputBoxes() {
       
        txtId.setText("");
        txtId.setEnabled(true);
        cmbDegPlan.setSelectedIndex(0);
        cmbDegSemester.setSelectedIndex(0);
        /*cmbCourseCode.setSelectedIndex(0);
        txtCourseName.setText("");
        cmbCourseSemester.setSelectedIndex(0);
        txtGrade.setText("");*/
       
    }

    private int addNew() throws SQLException {
        StudentRegister newObj= StudentRegister.getInstance();
        newObj.addStudent(txtId.getText(),cmbDegPlan.getSelectedItem().toString(),cmbDegSemester.getSelectedItem().toString());
        return 1;
    }

    private boolean updateRecord() throws SQLException {
         StudentRegister newObj= StudentRegister.getInstance();
         boolean bool= newObj.editStudent(txtId.getText(),cmbDegPlan.getSelectedItem().toString(),cmbDegSemester.getSelectedItem().toString());
        
        return bool;
    }

    private boolean deleteRecord() throws SQLException {
        StudentRegister newObj= StudentRegister.getInstance();
         boolean bool= newObj.deleteStudent(txtId.getText());
        
        return bool;
    }

    private void loadRecords()  {
        
         List<Student> studentList=StudentRegister.students;
        StudentTableModel tableModel = new StudentTableModel(studentList);
        jTable1.setModel(tableModel);
        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() 
        {
                public void valueChanged(ListSelectionEvent event)
                    {
                         try {
                            if (jTable1.getSelectedRow() >= 0) {
                                txtId.setEnabled(false);
                                //String code,name,cmbDegSemester,cmbCourseCode,txtCourseName,cmbCourseSemester,txtGrade,txtMaxLoadSP;
                                Object idV = jTable1.getValueAt(jTable1.getSelectedRow(), 0);
                                Object degreeV = jTable1.getValueAt(jTable1.getSelectedRow(), 1);
                                Object semesterV = jTable1.getValueAt(jTable1.getSelectedRow(), 2);
                               

                                txtId.setText(idV.toString());
                                cmbDegPlan.setSelectedItem(degreeV.toString());
                                cmbDegSemester.setSelectedItem(semesterV.toString());
                               /* cmbCourseCode.setText(degreeV.toString());
                                txtCourseName.setText(titleV.toString());
                                cmbCourseSemester.setText(daysV.toString());
                                txtGrade.setText(maxLoadFAV.toString());*/
                                
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
                    }
        });
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.LEFT);
        jTable1.getColumnModel().getColumn(0).setCellRenderer(rightRenderer);
    }

    /**
     * Creates new form faculty
     */
    public student(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" cmbDegSemester="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel1.setSize(700, 700);
        jLabel2 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cmbDegPlan = new javax.swing.JComboBox();
        List<Degree> degObjList= DegreeRegister.degrees;
        for(Degree obj:degObjList){
            cmbDegPlan.addItem(obj.getCode());
        }
        jLabel4 = new javax.swing.JLabel();
        cmbDegSemester = new javax.swing.JComboBox();
         List<Semester> semObjList= SemesterRegister.semesters;
        for(Semester obj:semObjList){
            cmbDegSemester.addItem(obj.getName());
        }
       /* jLabel5 = new javax.swing.JLabel();
        cmbCourseCode = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        txtCourseName = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cmbCourseSemester = new javax.swing.JTextField();
         jLabel8 = new javax.swing.JLabel();
        txtGrade = new javax.swing.JTextField();*/
       
        btnAddNew = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnPrintAll = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Student Records Editor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel2.setText("Student Id:");

        txtId.setEnabled(false);

        jLabel3.setText("Degree:");

        jLabel4.setText("Semester:");

       // cmbDegSemester.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Male", "Female" }));

       /* jLabel5.setText("Degree :");
        jLabel6.setText("Title :");
        jLabel7.setText("Days:");

        jLabel8.setText("MaxLoadFA :");*/
        
        
        

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            
                            .addComponent(cmbDegSemester, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbDegPlan, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        
                    ))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbDegPlan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbDegSemester, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                   
                    
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnAddNew.setText("Add New");
        btnAddNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNewActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

       

        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAddNew)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete)
                        
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                        .addComponent(btnClose))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddNew)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete)
                    
                    .addComponent(btnClose))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void formWindowOpened(java.awt.event.WindowEvent evt) {                                  
        
            loadRecords();
        
    }                                 

    private void btnAddNewActionPerformed(java.awt.event.ActionEvent evt) {                                          
        addRecord = true;
        
        clearInputBoxes();

        cmbDegPlan.requestFocus();
    }                                         

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {  
        mainpage x=new mainpage();
        
	getContentPane().getParent().getParent().getParent().setVisible(false);
        //getContentPane().getParent().removeAll();
	x.main(null);
        //System.exit(1);
    }                                        

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {                                          
        int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this record?", "Confirm Delete Record?", JOptionPane.YES_NO_OPTION);

        if (dialogResult == JOptionPane.YES_OPTION) {
            try {
                boolean ret=deleteRecord();
                String message="";
                     if(ret){
                         message =" Record deleted";
                     }else
                         message =" Record failed to delete";
                        JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.INFORMATION_MESSAGE);
                loadRecords();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }                                         

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {                                          
        int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to update this record?", "Confirm Update Record?", JOptionPane.YES_NO_OPTION);

        if (dialogResult == JOptionPane.YES_OPTION) {
            try {
                if (addRecord == true) {
                    int ret=addNew();
                    if(ret==1){
                        String message =" Record added.";
                        JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    boolean ret=updateRecord();
                    String message="";
                     if(ret){
                         message =" Record updated";
                     }else
                         message =" Record failed to update";
                        JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.INFORMATION_MESSAGE);
                   
                }

                addRecord = false;
                loadRecords();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }                                         

    private void btnPrintAllActionPerformed(java.awt.event.ActionEvent evt) {                                            
       // DisplayReports displayReports = new DisplayReports();
        
        //displayReports.showEmployees();
    }                                           

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" cmbDegSemester=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(course.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(course.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(course.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(course.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                student dialog = new student(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnAddNew;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnPrintAll;
    private javax.swing.JButton btnUpdate;
   
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    
     private javax.swing.JComboBox cmbDegSemester;
    private javax.swing.JComboBox cmbCourseCode;
    private javax.swing.JTextField txtId;
    private javax.swing.JComboBox cmbDegPlan;
    private javax.swing.JTextField txtCourseName;
    private javax.swing.JComboBox cmbCourseSemester;
    private javax.swing.JTextField txtGrade;
   
}
    /*{

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					student window = new student();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public student()
	{
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.controlLtHighlight);
		frame.setBounds(100, 100, 731, 476);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblUniversityEditPage = new JLabel("Student Edit Page");
		lblUniversityEditPage.setForeground(SystemColor.activeCaption);
		lblUniversityEditPage.setBackground(SystemColor.activeCaption);
		lblUniversityEditPage.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblUniversityName = new JLabel("Roll Number");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblAbbrevation = new JLabel("First Name");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(SystemColor.activeCaption);
		comboBox.setBackground(SystemColor.controlLtHighlight);
		comboBox.addItem("English");
		comboBox.addItem("History");
		
		JLabel lblGradSchool = new JLabel("Last Name");
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBackground(SystemColor.activeCaption);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBackground(SystemColor.activeCaption);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBackground(SystemColor.activeCaption);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				mainpage x=new mainpage();
				frame.setVisible(false);
				x.main(null);
			}
		});
		btnSave.setBackground(SystemColor.activeCaption);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				mainpage x=new mainpage();
				frame.setVisible(false);
				x.main(null);
			}
		});
		btnCancel.setBackground(SystemColor.activeCaption);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JLabel lblBatch = new JLabel("Batch");
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		JLabel lblSemester = new JLabel("Semester");
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(64, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblUniversityEditPage)
							.addGap(263))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblAbbrevation)
								.addComponent(lblUniversityName)
								.addComponent(lblGradSchool)
								.addComponent(lblBatch)
								.addComponent(lblSemester))
							.addGap(41)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(textField_3)
								.addComponent(textField_2)
								.addComponent(textField_1)
								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnAdd)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnEdit)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnDelete)))
							.addGap(335))))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(234)
					.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
					.addGap(38)
					.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(299, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblUniversityEditPage)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUniversityName))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAbbrevation))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGradSchool)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBatch)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSemester)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAdd)
						.addComponent(btnEdit)
						.addComponent(btnDelete))
					.addPreferredGap(ComponentPlacement.RELATED, 151, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSave)
						.addComponent(btnCancel))
					.addContainerGap())
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}*/