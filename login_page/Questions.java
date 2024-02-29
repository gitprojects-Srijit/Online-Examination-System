import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class Questions extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JButton btnNewButton;
	JLabel lblNewLabel;
	JRadioButton rdbtnNewRadioButton;
	JRadioButton rdbtnNewRadioButton_1;
	JRadioButton rdbtnNewRadioButton_2;
	JRadioButton rdbtnNewRadioButton_3;
	JButton btnNewButton_1;
	ButtonGroup bg;
	
	//Timer
	JButton  showTimer;
	private Timer timer;
    private int countdownSeconds;
	
	int index=0;
	
	String arr[][] = {
			{"Arrays in java are-","object references","objects","primitive datatype","none","objects"},
			{"Number of primitive data types in Java are?","6","7","8","9","8"},
			{"What is the size of float and double in java?","32 and 64","32 and 32","64 and 64","64 and 32","32 and 64"},
			{"What is the extension of java code files?",".txt",".js",".class",".java",".java"},
			{"Select the valid statement-","char[] ch = new char(5)","char[] ch = new char[5]","char[] ch = new char()","char[] ch = new char[]","char[] ch = new char[5]"}
	};
	private JLabel lblNewLabel_1;
	private JButton btnNewButton_2;
	
	String userAnswer[] = {"", "", "", "", ""};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					int examDurationSeconds = 1 * 30; // 1 hour exam duration
					Questions frame = new Questions(examDurationSeconds);
					frame.setVisible(true);
					
					Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
					frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void displayQue(){
		
		bg.clearSelection();
		
		if(userAnswer[index]!="")
		{
			if(arr[index][1].equals(userAnswer[index]))
			{
				rdbtnNewRadioButton.setSelected(true);
			}
			if(arr[index][2].equals(userAnswer[index]))
			{
				rdbtnNewRadioButton_1.setSelected(true);
			}
			if(arr[index][3].equals(userAnswer[index]))
			{
				rdbtnNewRadioButton_2.setSelected(true);
			}
			if(arr[index][4].equals(userAnswer[index]))
			{
				rdbtnNewRadioButton_3.setSelected(true);
			}
		}
		
	
		lblNewLabel_1.setText("Q." + (index+1)+ ")"+" ");
		lblNewLabel.setText(arr[index][0]);
		rdbtnNewRadioButton.setText(arr[index][1]);
		rdbtnNewRadioButton_1.setText(arr[index][2]);
		rdbtnNewRadioButton_2.setText(arr[index][3]);
		rdbtnNewRadioButton_3.setText(arr[index][4]);
		
		if(index == 0)
		{
			btnNewButton.setVisible(false);	
			btnNewButton_1.setBounds(288, 270, 128, 33);
		}
		else
		{
			btnNewButton.setVisible(true);
			btnNewButton_1.setBounds(353, 270, 128, 33);
		}
		
		
		if(arr.length-1 == index)
		{
			btnNewButton_1.setVisible(false);
			btnNewButton_2.setVisible(true);
			
		}
		else
		{
			btnNewButton_1.setVisible(true);
			btnNewButton_2.setVisible(false);
				
		}
		
		
	}
	
	public void checkAnswer()
	{
		String uans = "";
		if(rdbtnNewRadioButton.isSelected())
		{
			uans = rdbtnNewRadioButton.getText().toString();
		}
		else if(rdbtnNewRadioButton_1.isSelected())
		{
			uans = rdbtnNewRadioButton_1.getText().toString();
		}
		else if(rdbtnNewRadioButton_2.isSelected())
		{
			uans = rdbtnNewRadioButton_2.getText().toString();
		}
		else if(rdbtnNewRadioButton_3.isSelected())
		{
			uans = rdbtnNewRadioButton_3.getText().toString();
		}
		userAnswer[index] = uans;
		//JOptionPane.showMessageDialog(null, uans);
	}
	
	 private void updateCountdownLabel() {
	        int hours = countdownSeconds / 3600;
	        int minutes = (countdownSeconds % 3600) / 60;
	        int seconds = countdownSeconds % 60;
	        String timeString = String.format("%02d:%02d Left",minutes, seconds);
	        showTimer.setText(timeString);
	    }
	
	/**
	 * Create the frame.
	 */
	public Questions(int seconds) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 713, 372);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnNewButton = new JButton("Previous");
		btnNewButton.setBackground(SystemColor.controlShadow);
		btnNewButton.setForeground(SystemColor.window);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkAnswer();
				index--;
				displayQue();
			}
		});
		btnNewButton.setBounds(231, 270, 112, 33);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Next");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkAnswer();
				index++;
				displayQue();			
				}
		});
		btnNewButton_1.setBackground(SystemColor.controlShadow);
		btnNewButton_1.setForeground(SystemColor.window);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.setBounds(353, 270, 128, 33);
		contentPane.add(btnNewButton_1);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 21));
		lblNewLabel.setBounds(51, 44, 638, 36);
		contentPane.add(lblNewLabel);
		
		showTimer = new JButton("Time Left: 10:00");
		showTimer.setFont(new Font("Tahoma", Font.BOLD, 14));
		showTimer.setEnabled(false);
		showTimer.setBounds(549, 0, 150, 36);
		contentPane.add(showTimer);
		
		//Timer
		countdownSeconds = seconds;
		updateCountdownLabel();
		
		timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                countdownSeconds--;
                if (countdownSeconds >= 0) {
                    updateCountdownLabel();
                } else {
                    timer.stop();
                    JOptionPane.showMessageDialog(Questions.this, "Time's up!");
                    
                    checkAnswer();
    				
    				int marks = 0;
    				
    				for(int i=0; i<userAnswer.length; i++)
    				{
    					
    					if(userAnswer[i].trim().equals((arr[i][5]).trim()))
    					{
//    					System.out.println(userAnswer[i]+" : "+arr[i][5]);
    						marks++;
    					}
    				}
    				
    				
    				
    				JOptionPane.showMessageDialog(null, "Total Marks: "+marks);
    				
    				Dashboard frame = new Dashboard();
					frame.setVisible(true);
					
					Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
					frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);

                }
            }
        });
        timer.start();
		
		rdbtnNewRadioButton = new JRadioButton(" 6");
		rdbtnNewRadioButton.setBackground(new Color(204, 255, 255));
		rdbtnNewRadioButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		rdbtnNewRadioButton.setBounds(51, 96, 549, 21);
		contentPane.add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_1 = new JRadioButton(" 7");
		rdbtnNewRadioButton_1.setBackground(new Color(204, 255, 255));
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		rdbtnNewRadioButton_1.setBounds(51, 129, 549, 21);
		contentPane.add(rdbtnNewRadioButton_1);
		
		rdbtnNewRadioButton_2 = new JRadioButton(" 8");
		rdbtnNewRadioButton_2.setBackground(new Color(204, 255, 255));
		rdbtnNewRadioButton_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		rdbtnNewRadioButton_2.setBounds(51, 163, 549, 21);
		contentPane.add(rdbtnNewRadioButton_2);
		
	    rdbtnNewRadioButton_3 = new JRadioButton(" 9");
	    rdbtnNewRadioButton_3.setBackground(new Color(204, 255, 255));
		rdbtnNewRadioButton_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		rdbtnNewRadioButton_3.setBounds(51, 197, 549, 21);
		contentPane.add(rdbtnNewRadioButton_3);
		
		bg = new ButtonGroup();
		bg.add(rdbtnNewRadioButton);
		bg.add(rdbtnNewRadioButton_1);
		bg.add(rdbtnNewRadioButton_2);
		bg.add(rdbtnNewRadioButton_3);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setBounds(10, 44, 47, 36);
		contentPane.add(lblNewLabel_1);
		
		btnNewButton_2 = new JButton("Submit");
		btnNewButton_2.setBackground(SystemColor.controlShadow);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkAnswer();
				
				int marks = 0;
				
				for(int i=0; i<userAnswer.length; i++)
				{
					
					if(userAnswer[i].trim().equals((arr[i][5]).trim()))
					{
//					System.out.println(userAnswer[i]+" : "+arr[i][5]);
						marks++;
					}
				}
				
				
				
				JOptionPane.showMessageDialog(null, "Total Marks: "+marks);
				
				Dashboard frame = new Dashboard();
				frame.setVisible(true);
				
				Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
				frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);

			}
		});
		btnNewButton_2.setForeground(SystemColor.desktop);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_2.setBounds(353, 270, 128, 33);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_2 = new JLabel("Questions");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel_2.setBounds(279, 0, 135, 43);
		contentPane.add(lblNewLabel_2);
		
		displayQue();
	}
}
