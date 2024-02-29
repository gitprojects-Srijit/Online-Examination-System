import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class Registration extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField idtxt;
	private JTextField idtxt1;
	private JTextField ptxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration frame = new Registration();
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
	public Registration() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 566, 347);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registration Form");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(160, 10, 215, 37);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Your User ID :");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setBounds(44, 68, 198, 37);
		contentPane.add(lblNewLabel_1);
		
		idtxt = new JTextField();
		idtxt.setBounds(252, 75, 243, 28);
		contentPane.add(idtxt);
		idtxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Enter Your Name :");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_2.setBounds(44, 125, 175, 24);
		contentPane.add(lblNewLabel_2);
		
		idtxt1 = new JTextField();
		idtxt1.setBounds(252, 124, 243, 32);
		contentPane.add(idtxt1);
		idtxt1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Enter Your Password :");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_3.setBounds(44, 179, 215, 24);
		contentPane.add(lblNewLabel_3);
		
		ptxt = new JTextField();
		ptxt.setBounds(252, 178, 243, 32);
		contentPane.add(ptxt);
		ptxt.setColumns(10);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.setBackground(SystemColor.controlHighlight);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = idtxt.getText().toString();
				String n = idtxt1.getText().toString();
				String pass = ptxt.getText().toString();
				
				MyData.ids.add(id);
				MyData.names.add(n);
				MyData.passwords.add(pass);
				
				JOptionPane.showMessageDialog(null, "New User Created Successfully....!!!!!!");
				
				Login ob = new Login();
				ob.setVisible(true);
				
				Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
				ob.setLocation(dim.width/2-ob.getSize().width/2, dim.height/2-ob.getSize().height/2);

				
				setVisible(false);
				
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton.setBounds(205, 239, 118, 37);
		contentPane.add(btnNewButton);
	}
}

