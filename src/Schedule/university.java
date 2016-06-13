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
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class university {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					university window = new university();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public university() {
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
		
		JLabel lblUniversityEditPage = new JLabel("University Edit Page");
		lblUniversityEditPage.setForeground(SystemColor.activeCaption);
		lblUniversityEditPage.setBackground(SystemColor.activeCaption);
		lblUniversityEditPage.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblUniversityName = new JLabel("University Name");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblAbbrevation = new JLabel("Abbrevation");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(SystemColor.activeCaption);
		comboBox.setBackground(SystemColor.controlLtHighlight);
		comboBox.addItem("GSECS");
		
		
		JLabel lblGradSchool = new JLabel("Grad School");
		
		JLabel lblSemester = new JLabel("Semester");
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setForeground(SystemColor.activeCaption);
		comboBox_1.addItem("1st Semester");
		comboBox_1.addItem("2nd Semester");
		comboBox_1.setBackground(SystemColor.controlLtHighlight);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBackground(SystemColor.activeCaption);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBackground(SystemColor.activeCaption);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBackground(SystemColor.activeCaption);
		
		JButton btnAdd_1 = new JButton("Add");
		btnAdd_1.setBackground(SystemColor.activeCaption);
		
		JButton btnEdit_1 = new JButton("Edit");
		btnEdit_1.setBackground(SystemColor.activeCaption);
		
		JButton btnDelete_1 = new JButton("Delete");
		btnDelete_1.setBackground(SystemColor.activeCaption);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBackground(SystemColor.activeCaption);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBackground(SystemColor.activeCaption);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(39, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(lblUniversityEditPage)
							.addGap(263))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblAbbrevation)
								.addComponent(lblUniversityName)
								.addComponent(lblGradSchool))
							.addGap(41)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(comboBox, Alignment.TRAILING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(textField_1)
								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnAdd)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnEdit)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnDelete)))
							.addGap(42)
							.addComponent(lblSemester)
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnAdd_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnEdit_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnDelete_1)))
							.addGap(38))))
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
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSemester)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblGradSchool))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAdd)
						.addComponent(btnEdit)
						.addComponent(btnDelete)
						.addComponent(btnAdd_1)
						.addComponent(btnEdit_1)
						.addComponent(btnDelete_1))
					.addPreferredGap(ComponentPlacement.RELATED, 219, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSave)
						.addComponent(btnCancel))
					.addContainerGap())
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}