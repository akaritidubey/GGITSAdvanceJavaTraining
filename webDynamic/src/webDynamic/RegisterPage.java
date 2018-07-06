package webDynamic;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



public class RegisterPage {

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
					RegisterPage window = new RegisterPage();
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
	public RegisterPage() {
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
		
		JLabel lblEnterUsername = new JLabel("Enter Username:");
		lblEnterUsername.setBounds(24, 29, 97, 23);
		frame.getContentPane().add(lblEnterUsername);
		
		tf_user = new JTextField();
		tf_user.setBounds(134, 30, 150, 22);
		frame.getContentPane().add(tf_user);
		tf_user.setColumns(10);
		
		JLabel lblEnterPassword = new JLabel("Enter Password:");
		lblEnterPassword.setBounds(24, 79, 97, 23);
		frame.getContentPane().add(lblEnterPassword);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//get the text values for user and pass
				String user = tf_user.getText();
				String pass = tf_pass.getText();
				//register by sanding to database 
				
				database db = new database();
				String result = db.register(user,pass);
				
				//Display response to the user
				JOptionPane.showMessageDialog(null,result);
			}
		});
		btnRegister.setBounds(47, 141, 89, 23);
		frame.getContentPane().add(btnRegister);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnLogin.setBounds(170, 141, 89, 23);
		frame.getContentPane().add(btnLogin);
		
		tf_pass = new JTextField();
		tf_pass.setColumns(10);
		tf_pass.setBounds(134, 80, 150, 22);
		frame.getContentPane().add(tf_pass);
	}
}
