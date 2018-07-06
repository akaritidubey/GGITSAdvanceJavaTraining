package registerpage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class loginpage {

	private JFrame frame;
	private JTextField tf_user;
	private JTextField tf_pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginpage window = new loginpage();
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
	public loginpage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblEnterUsername = new JLabel("Enter Username");
		lblEnterUsername.setBounds(25, 41, 112, 14);
		frame.getContentPane().add(lblEnterUsername);
		
		tf_user = new JTextField();
		tf_user.setBounds(140, 38, 148, 20);
		frame.getContentPane().add(tf_user);
		tf_user.setColumns(10);
		
		JLabel lblEnterPassword = new JLabel("Enter password");
		lblEnterPassword.setBounds(25, 105, 89, 20);
		frame.getContentPane().add(lblEnterPassword);
		
		tf_pass = new JTextField();
		tf_pass.setBounds(140, 105, 148, 20);
		frame.getContentPane().add(tf_pass);
		tf_pass.setColumns(10);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//get the text values for user and pass 
			String user =tf_user.getText();
			String pwd = tf_pass.getText();
			//Register by sending data to database
			
		Database db = new Database();
		String result = db.register(user,pwd);
		JOptionPane.showMessageDialog(null,result);
		
				
			}
		});
		btnRegister.setBounds(48, 176, 89, 23);
		frame.getContentPane().add(btnRegister);
		
		JButton btnLogin = new JButton("login");
		btnLogin.setBounds(199, 176, 89, 23);
		frame.getContentPane().add(btnLogin);
	}
}
