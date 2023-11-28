package gui;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UserStartManager extends JFrame {
	private static JFrame frmBurgerkingKiosk;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public UserStartManager() {		
		frmBurgerkingKiosk = new JFrame();
		frmBurgerkingKiosk.setTitle("BurgerKing Kiosk");
		frmBurgerkingKiosk.setBounds(100, 100, 312, 646);
		frmBurgerkingKiosk.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBurgerkingKiosk.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BurgerOrderScreen.main(null);
				frmBurgerkingKiosk.dispose();
			}
		});
		panel.setBackground(new Color(255, 253, 240));
		panel.setBounds(0, 0, 312, 618);
		frmBurgerkingKiosk.getContentPane().add(panel);
		panel.setLayout(null);
	
		JPanel redpanel = new JPanel();
		redpanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BurgerOrderScreen.main(null);
				frmBurgerkingKiosk.dispose();
			}
		});
		redpanel.setBackground(Color.RED);
		redpanel.setBounds(0, 460, 312, 158);
		panel.add(redpanel);
		redpanel.setLayout(null);
		
		JLabel touchLabel = new JLabel("화면을 터치하세요!");
		touchLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BurgerOrderScreen.main(null);
				frmBurgerkingKiosk.dispose();
			}
		});
		touchLabel.setBounds(65, 25, 179, 33);
		redpanel.add(touchLabel);
		touchLabel.setHorizontalAlignment(SwingConstants.CENTER);
		touchLabel.setForeground(Color.WHITE);
		touchLabel.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 20));
		
		JLabel lblNewLabel_1 = new JLabel("Burger");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BurgerOrderScreen.main(null);
				frmBurgerkingKiosk.dispose();
			}
		});
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(87, 58, 52));
		lblNewLabel_1.setFont(new Font("Modak", Font.PLAIN, 40));
		lblNewLabel_1.setBounds(87, 81, 130, 50);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("King");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BurgerOrderScreen.main(null);
				frmBurgerkingKiosk.dispose();
			}
		});
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(new Color(87, 58, 52));
		lblNewLabel_2.setFont(new Font("Modak", Font.PLAIN, 40));
		lblNewLabel_2.setBounds(109, 131, 92, 50);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BurgerOrderScreen.main(null);
				frmBurgerkingKiosk.dispose();
			}
		});
		lblNewLabel_3.setIcon(new ImageIcon(UserStartManager.class.getResource("/images/startLogoImage.png")));
		lblNewLabel_3.setBounds(76, 193, 155, 173);
		panel.add(lblNewLabel_3);
		setSize(312, 646);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserStartManager Frame = new UserStartManager();
					Frame.frmBurgerkingKiosk.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
