package gui.burgerOrderScreen.burgerComposition;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import gui.AdminSuccess;
import gui.RoundedButton;
import gui.UserStartManager;
import gui.burgerOrderScreen.BurgerOrderScreen;

import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

public class BurgerComposition4 extends JFrame {
	private JFrame frmBurgerkingKiosk;
	private static final long serialVersionUID = 1L;
	JRadioButton jb[] = new JRadioButton[3];
	ButtonGroup bg = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BurgerComposition4 window = new BurgerComposition4();
					window.frmBurgerkingKiosk.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BurgerComposition4() {
		frmBurgerkingKiosk = new JFrame();
		frmBurgerkingKiosk.setTitle("BurgerKing Kiosk");
		frmBurgerkingKiosk.setBounds(100, 100, 312, 646);
		frmBurgerkingKiosk.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBurgerkingKiosk.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 253, 240));
		panel.setBounds(0, 0, 298, 609);
		frmBurgerkingKiosk.getContentPane().add(panel);
		panel.setLayout(null);
		
		RoundedButton toFirstPage = new RoundedButton("나가기");
		toFirstPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserStartManager.main(null);
				frmBurgerkingKiosk.dispose();
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("갈릭불고기와퍼+프렌치프라이(L)+콜라(L)");
		lblNewLabel_1.setBackground(new Color(255, 254, 244));
		lblNewLabel_1.setForeground(new Color(87, 58, 52));
		lblNewLabel_1.setFont(new Font("나눔고딕", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(57, 222, 243, 30);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("갈릭불고기와퍼 단품");
		lblNewLabel_1_1_1.setBackground(new Color(255, 254, 244));
		lblNewLabel_1_1_1.setForeground(new Color(87, 58, 52));
		lblNewLabel_1_1_1.setFont(new Font("나눔고딕", Font.PLAIN, 13));
		lblNewLabel_1_1_1.setBounds(57, 415, 243, 30);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("갈릭불고기와퍼+프렌치프라이(R)+콜라(R)");
		lblNewLabel_1_1.setBackground(new Color(255, 254, 244));
		lblNewLabel_1_1.setForeground(new Color(87, 58, 52));
		lblNewLabel_1_1.setFont(new Font("나눔고딕", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(57, 317, 243, 30);
		panel.add(lblNewLabel_1_1);
		toFirstPage.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 15));
		toFirstPage.setHorizontalAlignment(SwingConstants.RIGHT);
		toFirstPage.setForeground(new Color(255, 254, 240));
		toFirstPage.setBackground(new Color(87, 58, 52));
		toFirstPage.setBounds(214, 567, 86, 38);
		panel.add(toFirstPage);
		
		JLabel settingIcon = new JLabel(" ");
		settingIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminSuccess.main(null);
				frmBurgerkingKiosk.dispose();
			}
		});
		settingIcon.setHorizontalAlignment(SwingConstants.CENTER);
		settingIcon.setIcon(new ImageIcon(BurgerOrderScreen.class.getResource("/images/setting.png")));
		settingIcon.setBounds(8, 562, 50, 50);
		panel.add(settingIcon);
		
		JLabel footer = new JLabel(" ");
		footer.setBackground(new Color(87, 58, 52));
		footer.setBounds(0, 566, 300, 43);
		footer.setOpaque(true);
		panel.add(footer);
		
		JLabel lblNewLabel = new JLabel("원하시는 구성을 선택하세요");
		lblNewLabel.setForeground(new Color(87, 58, 52));
		lblNewLabel.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(21, 95, 265, 50);
		panel.add(lblNewLabel);
		
		for(int i = 0; i < 3; i++) {
			jb[i] = new JRadioButton();
		}
		
		jb[0].setText("갈릭불고기와퍼 라지 세트");
		jb[0].setForeground(new Color(87, 58, 52));
		jb[0].setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 15));
		jb[0].setBackground(new Color(255, 254, 244));
		jb[0].setBounds(35, 180, 265, 50);
		panel.add(jb[0]);
		bg.add(jb[0]);
		
		
		jb[1].setText("갈릭불고기와퍼 세트");
		jb[1].setForeground(new Color(87, 58, 52));
		jb[1].setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 15));
		jb[1].setBackground(new Color(255, 254, 244));
		jb[1].setBounds(35, 276, 265, 50);
		panel.add(jb[1]);
		bg.add(jb[1]);
		
		jb[2].setText("갈릭불고기와퍼 단품");
		jb[2].setForeground(new Color(87, 58, 52));
		jb[2].setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 15));
		jb[2].setBackground(new Color(255, 254, 244));
		jb[2].setBounds(35, 373, 265, 50);
		panel.add(jb[2]);
		bg.add(jb[2]);
		
		RoundedButton btn = new RoundedButton("확인");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!jb[0].isSelected() && !jb[1].isSelected() && !jb[2].isSelected()) {
					JOptionPane.showMessageDialog(null, "구성을 선택해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btn.setForeground(new Color(255, 253, 240));
		btn.setBackground(new Color(87, 58, 52));
		btn.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 15));
		btn.setBounds(40, 479, 220, 50);
		panel.add(btn);
		
		JLabel toPreviousPage = new JLabel("X");
		toPreviousPage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BurgerOrderScreen.main(null);
				frmBurgerkingKiosk.dispose();
			}
		});
		toPreviousPage.setForeground(new Color(87, 58, 52));
		toPreviousPage.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 17));
		toPreviousPage.setBounds(12, 10, 19, 15);
		panel.add(toPreviousPage);
		
	}
}
