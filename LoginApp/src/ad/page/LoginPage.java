package ad.page;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginPage {

	public  JFrame frmLoginPage;
	private JTextField tf_user;
	private JTextField tf_pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage window = new LoginPage();
					window.frmLoginPage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLoginPage = new JFrame();
		frmLoginPage.setTitle("Login page");
		frmLoginPage.setBounds(100, 100, 450, 300);
		frmLoginPage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmLoginPage.getContentPane().setLayout(null);
		
		JLabel lblEnterUsername = new JLabel("Enter Username:");
		lblEnterUsername.setBounds(45, 45, 102, 17);
		frmLoginPage.getContentPane().add(lblEnterUsername);
		
		tf_user = new JTextField();
		tf_user.setBounds(167, 43, 122, 19);
		frmLoginPage.getContentPane().add(tf_user);
		tf_user.setColumns(10);
		
		tf_pass = new JTextField();
		tf_pass.setColumns(10);
		tf_pass.setBounds(167, 84, 122, 19);
		frmLoginPage.getContentPane().add(tf_pass);
		
		JLabel lblEnterPassword = new JLabel("Enter Password:");
		lblEnterPassword.setBounds(45, 86, 102, 17);
		frmLoginPage.getContentPane().add(lblEnterPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				
				//get user and password
				String user = tf_user.getText();
				String pass = tf_pass.getText();
				//login using database
				database db = new database();
				String result = db.login(user,pass);
				
				//Display the result
				JOptionPane.showMessageDialog(null, result);
				
				
			}
		});
		btnLogin.setBounds(135, 138, 89, 23);
		frmLoginPage.getContentPane().add(btnLogin);
	}

}
