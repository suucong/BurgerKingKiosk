package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;

public class AdminSuccess {

	private JFrame frmBurgerkingKiosk;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminSuccess window = new AdminSuccess();
					window.frmBurgerkingKiosk.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminSuccess() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBurgerkingKiosk = new JFrame();
		frmBurgerkingKiosk.setTitle("BurgerKing Kiosk");
		frmBurgerkingKiosk.setBounds(100, 100, 312, 646);
		frmBurgerkingKiosk.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBurgerkingKiosk.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 253, 240));
		panel.setBounds(0, 0, 454, 701);
		frmBurgerkingKiosk.getContentPane().add(panel);
		panel.setLayout(null);
		
		RoundedButton toFirstPage = new RoundedButton("나가기");
		toFirstPage.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 15));
		toFirstPage.setHorizontalAlignment(SwingConstants.RIGHT);
		toFirstPage.setForeground(new Color(255, 254, 240));
		toFirstPage.setBackground(new Color(87, 58, 52));
		toFirstPage.setBounds(214, 567, 86, 38);
		panel.add(toFirstPage);
		
		RoundedButton price = new RoundedButton("매출 확인");
		price.setBackground(new Color(87, 58, 52));
		price.setForeground(new Color(255, 253, 240));
		price.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 20));
		price.setBounds(43, 157, 220, 50);
		panel.add(price);
		
		RoundedButton startMenu = new RoundedButton("시작 화면으로 가기");
		startMenu.setBackground(new Color(87, 58, 52));
		startMenu.setForeground(new Color(255, 253, 240));
		startMenu.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 20));
		startMenu.setBounds(43, 246, 220, 50);
		panel.add(startMenu);
		
		JLabel footer = new JLabel(" ");
		footer.setBackground(new Color(87, 58, 52));
		footer.setBounds(0, 566, 300, 43);
		footer.setOpaque(true);
		panel.add(footer);
	}

}
