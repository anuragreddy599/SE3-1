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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.JEditorPane;
import javax.swing.JOptionPane;

public class user {

    
        JTextField txtUserId;
        JTextField txtPassword;
	JComboBox cmbRole;
	private JFrame frame;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					user window = new user();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public user()
	{
		initialize();
	}
	private void initialize()
	{
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.controlLtHighlight);
		frame.setBounds(100, 100, 731, 476);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblUniversityEditPage = new JLabel("User Panel");
		lblUniversityEditPage.setForeground(SystemColor.activeCaption);
		lblUniversityEditPage.setBackground(SystemColor.activeCaption);
		lblUniversityEditPage.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
                JButton btnAdd = new JButton("Add ");
                btnAdd.setBackground(SystemColor.activeCaption);
		btnAdd.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
                                int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to Add this user ?", "Confirm Update Record?", JOptionPane.YES_NO_OPTION);

                            if (dialogResult == JOptionPane.YES_OPTION) {
                               int ret=addUser();
                            if(ret==1){
                                String message =" Record added.";
                                JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.INFORMATION_MESSAGE);
                            } 
				mainpage x=new mainpage();
				frame.setVisible(false);
				x.main(null);
			}
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
		
		JLabel lblName = new JLabel("User Name");
		 txtUserId= new JTextField();
		JLabel lblPassword = new JLabel("Password");
		 txtPassword= new JTextField();
		JLabel lblRole = new JLabel("Role");
		 cmbRole= new JComboBox();
                cmbRole.addItem("Admin");
                cmbRole.addItem("Director");
		JLabel label = new JLabel("1");
		
		JLabel lblDescription = new JLabel("Description");
		
		JLabel lblStandardUser = new JLabel("Standard User");
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(94, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(lblUniversityEditPage)
							.addGap(302))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
                                                                        .addComponent(btnAdd,GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
									.addGap(483)
									.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblName)
										.addComponent(lblPassword)
										.addComponent(lblRole))
									.addGap(31)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(cmbRole,javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(txtUserId,javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(txtPassword,javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))))
							.addGap(65))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblUniversityEditPage)
					.addGap(23)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName)
						.addComponent(txtUserId,GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword)
						.addComponent(txtPassword,GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRole)
						.addComponent(cmbRole,GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(ComponentPlacement.RELATED, 400, Short.MAX_VALUE)
                                        .addComponent(btnAdd,GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 200, Short.MAX_VALUE)
					.addComponent(btnCancel)
					.addGap(45))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
        
        private int addUser() {      
            FileOutputStream fr=null;
            InputStream inputStream=null;
            int ret=1;
            try {
                //File file=new File("login.properties");
                Properties prop1=new Properties();
                String propFileName = "login.properties";
                inputStream = new FileInputStream(new File("login.properties"));
                URL resUrl=getClass().getClassLoader().getResource("login.properties");
                prop1.load(inputStream);
                inputStream.close();
                String loginIds=prop1.getProperty("loginIds");
                //Add login id
                String userId=txtUserId.getText();
                if(loginIds==null)
                    loginIds=userId;
                else
                    loginIds=loginIds+","+userId;
                prop1.remove("loginIds");
                prop1.setProperty("loginIds", loginIds);
                //Add role
                prop1.setProperty("password"+userId, txtPassword.getText());
                String role=cmbRole.getSelectedItem().toString();
                if(role.equals("Admin")){
                    role="A";
                }else if(role.equals("Director")){
                    role="D";
                }
                prop1.setProperty("role"+userId, role);
                File file = new File(resUrl.toURI());
                fr = new FileOutputStream(propFileName);
                prop1.store(fr,"Properties");
                fr.close();
                
                       
                       } catch (Exception ex) {
                           ret=0;
                           ex.printStackTrace();
                Logger.getLogger(user.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
               
                try {
                     inputStream.close();
                    fr.close();
                } catch (Exception ex) {
                    ex.printStackTrace();;
                    Logger.getLogger(user.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
             return ret;
    } 
}