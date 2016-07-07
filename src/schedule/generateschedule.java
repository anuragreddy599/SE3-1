package schedule;
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
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTree;
import java.awt.Color;
import java.awt.List;
import javax.swing.JFormattedTextField;
import javax.swing.JEditorPane;
import scheduler.schedule;
public class generateschedule {
        public static String semesterSelected;
        public static String sectionFillperc;
        public static String sectionOveragePerc;
        public static String iterations;
	private JFrame frame;
	private JTextField textFieldSemesterName;
        private JTextField textFieldSectionFill ;
        private JTextField textFieldSectionOverage ;
        private JTextField textFieldIteration ;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					generateschedule window = new generateschedule();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public generateschedule()
	{
		initialize();
	}
	private void initialize()
	{
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.controlLtHighlight);
		frame.setBounds(100, 100, 731, 476);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblUniversityEditPage = new JLabel("Generate Schedule");
		lblUniversityEditPage.setForeground(SystemColor.activeCaption);
		lblUniversityEditPage.setBackground(SystemColor.activeCaption);
		lblUniversityEditPage.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btnDelete = new JButton("Generate");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                            semesterSelected=textFieldSemesterName.getText();
                            sectionFillperc="3";//textFieldSectionFill.getText();
                            sectionOveragePerc="8";//textFieldSectionOverage.getText();
                            iterations="9";//textFieldIteration.getText();
				schedule x=new schedule();
				x.main(null);
			}
		});
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
		
		JLabel lblSemesterName = new JLabel("Semester Name");
                JLabel lblSectionFill = new JLabel("Section fill ");
                JLabel lblSectionOverage = new JLabel("Section overage ");
                JLabel lblIteration = new JLabel("Iterations");
		
		textFieldSemesterName = new JTextField();
                textFieldSectionFill = new JTextField();
                textFieldSectionOverage = new JTextField();
                textFieldIteration = new JTextField();
                
                
                
		textFieldSemesterName.setColumns(10);
                textFieldSectionFill .setColumns(10);
                textFieldSectionOverage.setColumns(10);
                textFieldIteration .setColumns(10);
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
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblSemesterName)
									.addGap(18)
									.addComponent(textFieldSemesterName, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
//                                                                .addGroup(groupLayout.createSequentialGroup()
//                                                                      .addComponent(lblSectionFill)
//									.addGap(47)
//									.addComponent(textFieldSectionFill, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
//                                                              .addGroup(groupLayout.createSequentialGroup()         
//                                                                        .addComponent(lblSectionOverage)
//									.addGap(15)
//									.addComponent(textFieldSectionOverage, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
//                                                              .addGroup(groupLayout.createSequentialGroup()           
//                                                                        .addComponent(lblIteration)
//									.addGap(57)
//									.addComponent(textFieldIteration, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
                                                                
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnDelete)
									.addGap(406)
									.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)))
							.addGap(65))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblUniversityEditPage)
					.addGap(26)
                                        .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblSemesterName)
                                        .addComponent(textFieldSemesterName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
//                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                            .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
//                                .addComponent(lblSectionFill)
//                                                    .addGap(30)
//                                                    .addComponent(textFieldSectionFill, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
//                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                                                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
//                                                .addComponent(lblSectionOverage)
//                                                .addGap(18)
//                                                .addComponent(textFieldSectionOverage,GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
//                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
//                                                .addComponent(lblIteration)
//                                                .addGap(18)
//                                                .addComponent(textFieldIteration,GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
//					.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancel)
						.addComponent(btnDelete))
					.addGap(45))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}