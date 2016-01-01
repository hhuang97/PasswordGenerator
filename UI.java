import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class UI {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI window = new UI();
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
	public UI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private int length;
	private String password = "";
	
	private void initialize() {
		frame = new JFrame("Random Password Generator");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String s = textField.getText();
				int x = Integer.valueOf(s);
				length = x;
				System.out.println(length);
			}
		});
		btnSubmit.setBounds(301, 98, 89, 23);
		frame.getContentPane().add(btnSubmit);
		
		textField = new JTextField();
		textField.setBounds(119, 99, 166, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNoOfCharacters = new JLabel("No. of Characters:");
		lblNoOfCharacters.setBounds(10, 102, 107, 14);
		frame.getContentPane().add(lblNoOfCharacters);
		
		JButton btnGenerate = new JButton("Generate");
		JTextField label = new JTextField();
		label.setBounds(146, 193, 188, 30);
		frame.getContentPane().add(label);
		
		btnGenerate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String p = PasswordGen.generate(length);
				password = p;
				System.out.println(password);
				label.setText(password);
			}
		});
		btnGenerate.setBounds(167, 137, 89, 23);
		frame.getContentPane().add(btnGenerate);
		
		JLabel lblGeneratesPasswordConsisting = new JLabel("Generates password consisting of lower/uppercase, digits, and symbols.");
		lblGeneratesPasswordConsisting.setBounds(10, 21, 424, 14);
		frame.getContentPane().add(lblGeneratesPasswordConsisting);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(81, 193, 76, 30);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblEnterNumberOf = new JLabel("Enter the number of characters you wish the password to be.");
		lblEnterNumberOf.setBounds(10, 46, 348, 14);
		frame.getContentPane().add(lblEnterNumberOf);
		
		JLabel lblAfterEnteringA = new JLabel("Enter a non-negative integer, then click \"Submit\" followed by \"Generate\".");
		lblAfterEnteringA.setBounds(10, 71, 424, 14);
		frame.getContentPane().add(lblAfterEnteringA);
	}
}
