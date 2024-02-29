import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class Dashboard extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard frame = new Dashboard();
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
	public Dashboard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 351);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Dashboard");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setBounds(206, 23, 153, 30);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Profile");
		btnNewButton.setBackground(SystemColor.controlHighlight);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("click here");
				
				Profile ob = new Profile();
				ob.setVisible(true);
				
				Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
				ob.setLocation(dim.width/2-ob.getSize().width/2, dim.height/2-ob.getSize().height/2);

			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.setBounds(146, 85, 261, 41);
		contentPane.add(btnNewButton);
		
		JButton myexam = new JButton("Exam");
		myexam.setBackground(SystemColor.controlHighlight);
		myexam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("click here");
				 Questions ob = new Questions(1*30);
				 ob.setVisible(true);
				 
				Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
				ob.setLocation(dim.width/2-ob.getSize().width/2, dim.height/2-ob.getSize().height/2);

			}
		});
		myexam.setFont(new Font("Times New Roman", Font.BOLD, 18));
		myexam.setBounds(146, 151, 261, 41);
		contentPane.add(myexam);
		
		JButton btnNewButton_2 = new JButton("Log Out");
		btnNewButton_2.setBackground(SystemColor.controlHighlight);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("click here");
				
				Login ob = new Login();
				ob.setVisible(true);
				
				Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
				ob.setLocation(dim.width/2-ob.getSize().width/2, dim.height/2-ob.getSize().height/2);

			}
		});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton_2.setBounds(146, 219, 261, 41);
		contentPane.add(btnNewButton_2);
	}

}

