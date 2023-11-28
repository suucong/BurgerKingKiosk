package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminPWManager extends JFrame{

	private JFrame frmBurgerkingKiosk;
	private JTextField firstPW;
	private JTextField secondPW;
	private static String pw; //password
	private static String pw2; //password

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPWManager window = new AdminPWManager();
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
	public AdminPWManager() {
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
		panel.setBounds(0, 0, 312, 618);
		frmBurgerkingKiosk.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel setPW = new JLabel("패스워드를 지정하세요");
		setPW.setForeground(new Color(87, 58, 52));
		setPW.setBackground(new Color(255, 255, 255));
		setPW.setHorizontalAlignment(SwingConstants.CENTER);
		setPW.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 20));
		setPW.setBounds(0, 159, 300, 50);
		panel.add(setPW);
		
		firstPW = new JTextField();
		firstPW.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField t = (JTextField)e.getSource();
				pw = t.getText();
				if(pw.isEmpty()) {
					JOptionPane.showMessageDialog(null, "password를 입력해주세요", "Message", JOptionPane.ERROR_MESSAGE);
				}
				else {
					if(pw.length() > 15) {
						JOptionPane.showMessageDialog(null, "password는 1~15자 사이로 입력해주세요", "Message", JOptionPane.ERROR_MESSAGE);
					}
					else {
						String showPW = "";
						for(int i = 1; i <= pw.length(); i++) {
							showPW += "*";
						}
						firstPW.setText(showPW);
					}
				}
			}
		});
		firstPW.setColumns(10);
		firstPW.setBounds(40, 264, 220, 50);
		panel.add(firstPW);
		
		secondPW = new JTextField();
		secondPW.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField t = (JTextField)e.getSource();
				pw2 = t.getText();
				if(pw.isEmpty()) {
					JOptionPane.showMessageDialog(null, "password를 입력해주세요", "Message", JOptionPane.ERROR_MESSAGE);
				}
				else {
					if(pw.length() > 15) {
						JOptionPane.showMessageDialog(null, "password는 1~15자 사이로 입력해주세요", "Message", JOptionPane.ERROR_MESSAGE);
					}
					else {
						String showPW = "";
						for(int i = 1; i <= pw.length(); i++) {
							showPW += "*";
						}
						secondPW.setText(showPW);
					}
				}
			}
		});
		secondPW.setColumns(10);
		secondPW.setBounds(40, 358, 220, 50);
		panel.add(secondPW);
		
		JLabel rePW = new JLabel("다시 입력");
		rePW.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 12));
		rePW.setBounds(40, 342, 50, 15);
		panel.add(rePW);
		
		RoundedButton btn = new RoundedButton("확인");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!pw.equals(pw2))
					JOptionPane.showMessageDialog(null, "틀렸습니다.\n다시 입력해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
				else {
					AdminSuccess.main(null);
					frmBurgerkingKiosk.dispose();
				}
			}
		});
		btn.setForeground(new Color(255, 253, 240));
		btn.setBackground(new Color(87, 58, 52));
		btn.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 15));
		btn.setBounds(40, 479, 220, 50);
		panel.add(btn);
	}
}
