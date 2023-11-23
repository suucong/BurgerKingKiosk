package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;

public class UserStartManager extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public UserStartManager() {
		setBackground(new Color(255, 254, 243));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 254, 244));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.RED);
		panel.setBounds(0, 435, 312, 183);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("화면을 터치하세요!");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Inter", Font.BOLD, 20));
		lblNewLabel.setBounds(78, 29, 158, 33);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Burger");
		lblNewLabel_1.setForeground(new Color(87, 58, 52));
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.BOLD, 36));
		lblNewLabel_1.setBounds(87, 44, 130, 50);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("King");
		lblNewLabel_2.setForeground(new Color(87, 58, 52));
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.BOLD, 36));
		lblNewLabel_2.setBounds(109, 94, 92, 50);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon(UserStartManager.class.getResource("/images/startLogoImage.png")));
		lblNewLabel_3.setBounds(76, 144, 155, 173);
		contentPane.add(lblNewLabel_3);
		setSize(312, 646);
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserStartManager frame = new UserStartManager();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
