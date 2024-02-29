import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.SystemColor;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField useridtxt;
	private JTextField passwordtxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
					
					Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
					frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 565, 340);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter User ID :");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 21));
		lblNewLabel.setBounds(46, 74, 168, 29);
		contentPane.add(lblNewLabel);
		
		useridtxt = new JTextField();
		useridtxt.setBounds(212, 77, 258, 29);
		contentPane.add(useridtxt);
		useridtxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Password :");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 21));
		lblNewLabel_1.setBounds(46, 129, 158, 29);
		contentPane.add(lblNewLabel_1);
		
		passwordtxt = new JTextField();
		passwordtxt.setBounds(212, 132, 258, 29);
		contentPane.add(passwordtxt);
		passwordtxt.setColumns(10);
		
		JButton btnNewButton = new JButton("Log In");
		btnNewButton.setForeground(SystemColor.activeCaptionText);
		btnNewButton.setBackground(SystemColor.control);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Click");
				String id = useridtxt.getText().toString();
				String password = passwordtxt.getText().toString();
				
				int size = MyData.ids.size();
				int flag = 0 ;
				for(int i= 0; i < size ; i++) {
					
					if(MyData.ids.get(i).equals(id) && MyData.passwords.get(i).equals(password)) {
						flag = 1;
						MyData.loggedInIndex = i;
						break;
					}
				}
				if(flag == 1) {
					Dashboard frame = new Dashboard();
					frame.setVisible(true);
					
					Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
					frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);

				}
				else {
					JOptionPane.showMessageDialog(null, "Sorry Invalid Userid or Password");
					useridtxt.setText("");
					passwordtxt.setText("");
				}
	
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 22));
		btnNewButton.setBounds(196, 190, 140, 35);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("Examination Login Form");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 26));
		lblNewLabel_3.setBounds(119, 10, 291, 49);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("New User?");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_2.setBounds(164, 246, 98, 35);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("Click Here");
		btnNewButton_1.setForeground(SystemColor.activeCaptionText);
		btnNewButton_1.setBackground(SystemColor.controlHighlight);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registration obj = new Registration();
				obj.setVisible(true);
				
				Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
				obj.setLocation(dim.width/2-obj.getSize().width/2, dim.height/2-obj.getSize().height/2);

				}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton_1.setBounds(264, 252, 104, 25);
		contentPane.add(btnNewButton_1);
	}
}
