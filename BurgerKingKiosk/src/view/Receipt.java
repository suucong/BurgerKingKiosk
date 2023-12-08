package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import jdbc.MysqlJdbc;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Receipt extends JFrame {

	private JFrame frmBurgerkingKiosk;
	private JPanel receiptPanel;

	/**
	 * Create the frame.
	 */
	public Receipt() {
		new MysqlJdbc();
		initialize();
	}

	private void initialize() {
		frmBurgerkingKiosk = new JFrame();
		frmBurgerkingKiosk.setTitle("BurgerKing Kiosk");
		frmBurgerkingKiosk.setBounds(100, 100, 312, 646);
		frmBurgerkingKiosk.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBurgerkingKiosk.getContentPane().setLayout(null);
		
		receiptPanel = new JPanel();
		receiptPanel.setBackground(new Color(255, 254, 244));
		receiptPanel.setBounds(0, 0, 312, 618);
		receiptPanel.setLayout(null);
		receiptPanel.setOpaque(true);
		frmBurgerkingKiosk.getContentPane().add(receiptPanel);
		
		JLabel receiptLabel = new JLabel("영수증");
		receiptLabel.setForeground(new Color(87, 58, 52));
		receiptLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		receiptLabel.setHorizontalAlignment(SwingConstants.CENTER);
		receiptLabel.setBounds(12, 24, 272, 27);
		receiptPanel.add(receiptLabel);
		
		JLabel lblNewLabel = new JLabel("[판매영수증] 버거킹 자바응용점");
		lblNewLabel.setForeground(new Color(87, 58, 52));
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblNewLabel.setBounds(12, 61, 184, 25);
		receiptPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("제2과학관 306호");
		lblNewLabel_1.setForeground(new Color(87, 58, 52));
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblNewLabel_1.setBounds(12, 83, 184, 25);
		receiptPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("대표:노수진");
		lblNewLabel_1_1.setForeground(new Color(87, 58, 52));
		lblNewLabel_1_1.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(12, 106, 184, 25);
		receiptPanel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("T. 02-970-5114");
		lblNewLabel_1_1_1.setForeground(new Color(87, 58, 52));
		lblNewLabel_1_1_1.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1.setBounds(187, 83, 100, 25);
		receiptPanel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("[POS 02-69262]");
		lblNewLabel_1_1_1_1.setForeground(new Color(87, 58, 52));
		lblNewLabel_1_1_1_1.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1_1.setBounds(187, 106, 100, 25);
		receiptPanel.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("--------------------------------------------------------");
		lblNewLabel_2.setForeground(new Color(87, 58, 52));
		lblNewLabel_2.setBounds(0, 133, 387, 15);
		receiptPanel.add(lblNewLabel_2);
		
		JLabel lblE = new JLabel("E 치즈와퍼세트");
		lblE.setForeground(new Color(87, 58, 52));
		lblE.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblE.setBounds(12, 151, 100, 25);
		receiptPanel.add(lblE);
		
		JLabel lblE_2 = new JLabel("E 베이컨치즈와퍼");
		lblE_2.setForeground(new Color(87, 58, 52));
		lblE_2.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblE_2.setBounds(12, 176, 106, 25);
		receiptPanel.add(lblE_2);
		
		JLabel lblE_1 = new JLabel("1");
		lblE_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblE_1.setForeground(new Color(87, 58, 52));
		lblE_1.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblE_1.setBounds(169, 151, 26, 25);
		receiptPanel.add(lblE_1);
		
		JLabel lblE_1_1 = new JLabel("1");
		lblE_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblE_1_1.setForeground(new Color(87, 58, 52));
		lblE_1_1.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblE_1_1.setBounds(169, 176, 26, 25);
		receiptPanel.add(lblE_1_1);
		
		JLabel lblE_1_2 = new JLabel("7000");
		lblE_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblE_1_2.setForeground(new Color(87, 58, 52));
		lblE_1_2.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblE_1_2.setBounds(213, 151, 71, 25);
		receiptPanel.add(lblE_1_2);
		
		JLabel lblE_1_2_1 = new JLabel("8200");
		lblE_1_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblE_1_2_1.setForeground(new Color(87, 58, 52));
		lblE_1_2_1.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblE_1_2_1.setBounds(213, 176, 71, 25);
		receiptPanel.add(lblE_1_2_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("--------------------------------------------------------");
		lblNewLabel_2_1.setForeground(new Color(87, 58, 52));
		lblNewLabel_2_1.setBounds(0, 233, 387, 15);
		receiptPanel.add(lblNewLabel_2_1);
		
		JLabel lblE_2_1 = new JLabel("전체금액");
		lblE_2_1.setForeground(new Color(87, 58, 52));
		lblE_2_1.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblE_2_1.setBounds(12, 247, 106, 25);
		receiptPanel.add(lblE_2_1);
		
		JLabel lblE_2_1_1 = new JLabel("물품가액");
		lblE_2_1_1.setForeground(new Color(87, 58, 52));
		lblE_2_1_1.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblE_2_1_1.setBounds(12, 271, 106, 25);
		receiptPanel.add(lblE_2_1_1);
		
		JLabel lblE_2_1_2 = new JLabel("부가세액");
		lblE_2_1_2.setForeground(new Color(87, 58, 52));
		lblE_2_1_2.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblE_2_1_2.setBounds(12, 296, 106, 25);
		receiptPanel.add(lblE_2_1_2);
		
		JLabel lblE_2_1_3 = new JLabel("합계");
		lblE_2_1_3.setForeground(new Color(87, 58, 52));
		lblE_2_1_3.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblE_2_1_3.setBounds(12, 320, 106, 25);
		receiptPanel.add(lblE_2_1_3);
		
		JLabel lblE_1_2_2 = new JLabel("15200");
		lblE_1_2_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblE_1_2_2.setForeground(new Color(87, 58, 52));
		lblE_1_2_2.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblE_1_2_2.setBounds(213, 247, 71, 25);
		receiptPanel.add(lblE_1_2_2);
		
		JLabel lblE_1_2_3 = new JLabel("13818");
		lblE_1_2_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblE_1_2_3.setForeground(new Color(87, 58, 52));
		lblE_1_2_3.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblE_1_2_3.setBounds(213, 271, 71, 25);
		receiptPanel.add(lblE_1_2_3);
		
		JLabel lblE_1_2_4 = new JLabel("1382");
		lblE_1_2_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblE_1_2_4.setForeground(new Color(87, 58, 52));
		lblE_1_2_4.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblE_1_2_4.setBounds(213, 296, 71, 25);
		receiptPanel.add(lblE_1_2_4);
		
		JLabel lblE_1_2_5 = new JLabel("15200");
		lblE_1_2_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblE_1_2_5.setForeground(new Color(87, 58, 52));
		lblE_1_2_5.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblE_1_2_5.setBounds(213, 320, 71, 25);
		receiptPanel.add(lblE_1_2_5);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("--------------------------------------------------------");
		lblNewLabel_2_1_1.setForeground(new Color(87, 58, 52));
		lblNewLabel_2_1_1.setBounds(0, 347, 387, 15);
		receiptPanel.add(lblNewLabel_2_1_1);
		
		JLabel lblE_2_1_4 = new JLabel("신용카드");
		lblE_2_1_4.setForeground(new Color(87, 58, 52));
		lblE_2_1_4.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblE_2_1_4.setBounds(12, 363, 106, 25);
		receiptPanel.add(lblE_2_1_4);
		
		JLabel lblE_2_1_1_1 = new JLabel("거스름돈");
		lblE_2_1_1_1.setForeground(new Color(87, 58, 52));
		lblE_2_1_1_1.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblE_2_1_1_1.setBounds(12, 387, 106, 25);
		receiptPanel.add(lblE_2_1_1_1);
		
		JLabel lblE_1_2_2_1 = new JLabel("15200");
		lblE_1_2_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblE_1_2_2_1.setForeground(new Color(87, 58, 52));
		lblE_1_2_2_1.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblE_1_2_2_1.setBounds(213, 363, 71, 25);
		receiptPanel.add(lblE_1_2_2_1);
		
		JLabel lblE_1_2_3_1 = new JLabel("0");
		lblE_1_2_3_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblE_1_2_3_1.setForeground(new Color(87, 58, 52));
		lblE_1_2_3_1.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblE_1_2_3_1.setBounds(213, 387, 71, 25);
		receiptPanel.add(lblE_1_2_3_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("--------------------------------------------------------");
		lblNewLabel_2_1_1_1.setForeground(new Color(87, 58, 52));
		lblNewLabel_2_1_1_1.setBounds(0, 415, 387, 15);
		receiptPanel.add(lblNewLabel_2_1_1_1);
		
		JLabel lblE_2_1_4_1 = new JLabel("담당자:오규리");
		lblE_2_1_4_1.setForeground(new Color(87, 58, 52));
		lblE_2_1_4_1.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblE_2_1_4_1.setBounds(12, 430, 106, 25);
		receiptPanel.add(lblE_2_1_4_1);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("**********************************************************");
		lblNewLabel_2_1_1_1_1.setForeground(new Color(87, 58, 52));
		lblNewLabel_2_1_1_1_1.setBounds(0, 453, 387, 15);
		receiptPanel.add(lblNewLabel_2_1_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_2 = new JLabel("서비스/제품/청결/위생/기타 문의사항은 전화주시면");
		lblNewLabel_2_1_1_1_2.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblNewLabel_2_1_1_1_2.setForeground(new Color(87, 58, 52));
		lblNewLabel_2_1_1_1_2.setBounds(10, 468, 300, 15);
		receiptPanel.add(lblNewLabel_2_1_1_1_2);
		
		JLabel lblNewLabel_2_1_1_1_2_1 = new JLabel("바로 해결해드리겠습니다.");
		lblNewLabel_2_1_1_1_2_1.setForeground(new Color(87, 58, 52));
		lblNewLabel_2_1_1_1_2_1.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblNewLabel_2_1_1_1_2_1.setBounds(10, 488, 300, 15);
		receiptPanel.add(lblNewLabel_2_1_1_1_2_1);
		
		JLabel lblNewLabel_2_1_1_1_2_1_1 = new JLabel("지역담당 : 010-6760-9034");
		lblNewLabel_2_1_1_1_2_1_1.setForeground(new Color(87, 58, 52));
		lblNewLabel_2_1_1_1_2_1_1.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblNewLabel_2_1_1_1_2_1_1.setBounds(10, 507, 300, 15);
		receiptPanel.add(lblNewLabel_2_1_1_1_2_1_1);
		
		JLabel lblNewLabel_2_1_1_1_2_1_1_1 = new JLabel("고객 상담실 : 080-022-8163");
		lblNewLabel_2_1_1_1_2_1_1_1.setForeground(new Color(87, 58, 52));
		lblNewLabel_2_1_1_1_2_1_1_1.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblNewLabel_2_1_1_1_2_1_1_1.setBounds(10, 527, 300, 15);
		receiptPanel.add(lblNewLabel_2_1_1_1_2_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_2_1_1_1_1 = new JLabel("10:00~24:00 딜리버리 실시");
		lblNewLabel_2_1_1_1_2_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1_1_2_1_1_1_1.setForeground(new Color(87, 58, 52));
		lblNewLabel_2_1_1_1_2_1_1_1_1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblNewLabel_2_1_1_1_2_1_1_1_1.setBounds(0, 546, 300, 50);
		receiptPanel.add(lblNewLabel_2_1_1_1_2_1_1_1_1);
		
	}
/*---------------------------------------------main------------------------------------*/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Receipt window = new Receipt();
					window.frmBurgerkingKiosk.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
