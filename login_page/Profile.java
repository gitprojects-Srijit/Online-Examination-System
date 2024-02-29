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

public class Profile extends JFrame {

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
					Profile frame = new Profile();
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
	public Profile() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 579, 347);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("          Profile");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 28));
		lblNewLabel.setBounds(161, 10, 215, 37);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Your User ID :");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setBounds(80, 79, 145, 37);
		contentPane.add(lblNewLabel_1);
		
		idtxt = new JTextField();
		idtxt.setBounds(254, 78, 243, 38);
		contentPane.add(idtxt);
		idtxt.setColumns(10);
		idtxt.setText(MyData.ids.get(MyData.loggedInIndex));
		
		JLabel lblNewLabel_2 = new JLabel("Your Name :");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_2.setBounds(80, 134, 175, 37);
		contentPane.add(lblNewLabel_2);
		
		idtxt1 = new JTextField();
		idtxt1.setBounds(254, 134, 243, 37);
		contentPane.add(idtxt1);
		idtxt1.setColumns(10);
		idtxt1.setText(MyData.names.get(MyData.loggedInIndex));
		
		JLabel lblNewLabel_3 = new JLabel("Your Password :");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_3.setBounds(80, 192, 215, 37);
		contentPane.add(lblNewLabel_3);
		
		ptxt = new JTextField();
		ptxt.setBounds(254, 194, 243, 37);
		contentPane.add(ptxt);
		ptxt.setColumns(10);
		ptxt.setText(MyData.passwords.get(MyData.loggedInIndex));
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.setBackground(SystemColor.controlHighlight);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = idtxt.getText().toString();
				String n = idtxt1.getText().toString();
				String pass = ptxt.getText().toString();
				
				if(id.equals(" ") || n.equals(" ") || pass.equals(" ")) {
					JOptionPane.showMessageDialog(null, "Sorry Invalid Userid or Password");
				}
				else {
					MyData.ids.set(MyData.loggedInIndex, id);
					MyData.names.set(MyData.loggedInIndex, n);
					MyData.passwords.set(MyData.loggedInIndex, pass);
					
					JOptionPane.showMessageDialog(null, "Profile Updated Successfully....!!!!!!");
					
					Dashboard ob = new Dashboard();
					ob.setVisible(true);
					
					Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
					ob.setLocation(dim.width/2-ob.getSize().width/2, dim.height/2-ob.getSize().height/2);

					
					setVisible(false);
				}
				
				
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton.setBounds(218, 251, 118, 37);
		contentPane.add(btnNewButton);
	}
}
