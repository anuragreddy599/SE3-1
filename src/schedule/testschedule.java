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

public class testschedule {

	private JFrame frame;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testschedule window = new testschedule();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public testschedule()
	{
		initialize();
	}
	private void initialize()
	{
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.controlLtHighlight);
		frame.setBounds(100, 100, 731, 476);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblUniversityEditPage = new JLabel("Test Schedule");
		lblUniversityEditPage.setForeground(SystemColor.activeCaption);
		lblUniversityEditPage.setBackground(SystemColor.activeCaption);
		lblUniversityEditPage.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btnDelete = new JButton("Test");
		btnDelete.setBackground(SystemColor.activeCaption);
		
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
		
		JLabel lblSelectSchedule = new JLabel("Select Schedule");
		
		JComboBox comboBox = new JComboBox();
		
		JLabel lblLogs = new JLabel("Logs");
		lblLogs.setForeground(SystemColor.activeCaption);
		
		JLabel lblClashes = new JLabel("Clashes");
		
		JLabel label = new JLabel("0");
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(303, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblUniversityEditPage)
							.addGap(263))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
							.addGap(65))))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(91)
					.addComponent(lblSelectSchedule)
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblClashes)
							.addGap(40)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblLogs)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addComponent(btnDelete)
					.addContainerGap(282, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblUniversityEditPage)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSelectSchedule)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnDelete))
					.addGap(83)
					.addComponent(lblLogs)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblClashes)
						.addComponent(label))
					.addPreferredGap(ComponentPlacement.RELATED, 163, Short.MAX_VALUE)
					.addComponent(btnCancel)
					.addGap(45))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}