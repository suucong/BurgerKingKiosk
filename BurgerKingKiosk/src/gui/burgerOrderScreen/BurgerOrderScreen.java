package gui.burgerOrderScreen;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;

import gui.AdminSuccess;
import gui.RoundedButton;
import gui.UserStartManager;
import gui.burgerOrderScreen.burgerComposition.BurgerComposition1;
import gui.burgerOrderScreen.burgerComposition.BurgerComposition2;
import gui.burgerOrderScreen.burgerComposition.BurgerComposition3;
import gui.burgerOrderScreen.burgerComposition.BurgerComposition4;
import gui.burgerOrderScreen.burgerComposition.BurgerComposition5;
import gui.burgerOrderScreen.burgerComposition.BurgerComposition6;
import gui.burgerOrderScreen.burgerComposition.BurgerComposition7;

import javax.swing.event.ChangeEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BurgerOrderScreen extends JFrame{
	private int totalPrice = 0;
	private int count = 0;
	private int menuNum = 0;
	private JFrame frmBurgerkingKiosk;
	private JPanel whopperPanel;
	private JPanel premiumPanel;

	public BurgerOrderScreen() {
		initialize();
	}
	
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
		settingIcon.setBounds(11, 583, 38, 30);
		panel.add(settingIcon);
		
		// 와퍼 메뉴를 붙일 패널
		whopperPanel = new JPanel();
		whopperPanel.setOpaque(false);
		whopperPanel.setLayout(null);
		whopperPanel.setBounds(0, 99, 312, 343);
		panel.add(whopperPanel);
		
		// 프리미엄 메뉴를 붙일 패널
		premiumPanel = new JPanel();
		premiumPanel.setOpaque(false);
		premiumPanel.setLayout(null);
		premiumPanel.setBounds(0, 99, 312, 343);
		premiumPanel.setVisible(false);
		panel.add(premiumPanel);
		
		// 버거 종류 1
		JPanel whopper_1 = new JPanel();
		whopper_1.setOpaque(false);
		whopper_1.setBounds(6, 16, 94, 95);
		whopperPanel.add(whopper_1);
		whopper_1.setLayout(null);
		whopper_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BurgerComposition1.main(null);
				frmBurgerkingKiosk.dispose();
			}
		});
		
		JLabel burger1 = new JLabel(" ");
		burger1.setBounds(7, 0, 87, 56);
		whopper_1.add(burger1);
		burger1.setIcon(new ImageIcon(BurgerOrderScreen.class.getResource("/images/whopper.png")));
		
		JLabel burgerName1 = new JLabel("치즈와퍼");
		burgerName1.setBounds(7, 57, 87, 15);
		whopper_1.add(burgerName1);
		burgerName1.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 13));
		burgerName1.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel burgerPrice1 = new JLabel("7000원~");
		burgerPrice1.setBounds(7, 74, 87, 15);
		whopper_1.add(burgerPrice1);
		burgerPrice1.setForeground(new Color(255, 0, 0));
		burgerPrice1.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 13));
		burgerPrice1.setHorizontalAlignment(SwingConstants.CENTER);
		
		// 버거 종류 2
		JPanel whopper_2 = new JPanel();
		whopper_2.setBounds(107, 16, 87, 95);
		whopper_2.setOpaque(false);
		whopperPanel.add(whopper_2);
		whopper_2.setLayout(null);
		whopper_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BurgerComposition2.main(null);
				frmBurgerkingKiosk.dispose();
			}
		});
		
		JLabel burger2 = new JLabel(" ");
		burger2.setBounds(6, 0, 81, 56);
		whopper_2.add(burger2);
		burger2.setIcon(new ImageIcon(BurgerOrderScreen.class.getResource("/images/whopper.png")));
		burger2.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel burgerName2 = new JLabel("와퍼");
		burgerName2.setBounds(0, 57, 87, 15);
		whopper_2.add(burgerName2);
		burgerName2.setHorizontalAlignment(SwingConstants.CENTER);
		burgerName2.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 13));
		
		JLabel burgerPrice2 = new JLabel("6400원~");
		burgerPrice2.setBounds(0, 80, 87, 15);
		whopper_2.add(burgerPrice2);
		burgerPrice2.setHorizontalAlignment(SwingConstants.CENTER);
		burgerPrice2.setForeground(Color.RED);
		burgerPrice2.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 13));
		
		// 와퍼 종류 3
		JPanel whopper_3 = new JPanel();
		whopper_3.setBounds(206, 16, 87, 95);
		whopper_3.setOpaque(false);
		whopperPanel.add(whopper_3);
		whopper_3.setLayout(null);
		whopper_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BurgerComposition3.main(null);
				frmBurgerkingKiosk.dispose();
			}
		});
		
		JLabel burger3 = new JLabel(" ");
		burger3.setBounds(0, 0, 87, 56);
		whopper_3.add(burger3);
		burger3.setIcon(new ImageIcon(BurgerOrderScreen.class.getResource("/images/whopper.png")));
		burger3.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel burgerName3 = new JLabel("불고기와퍼");
		burgerName3.setBounds(0, 68, 87, 15);
		whopper_3.add(burgerName3);
		burgerName3.setHorizontalAlignment(SwingConstants.CENTER);
		burgerName3.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 13));
		
		JLabel burgerPrice3 = new JLabel("6400원~");
		burgerPrice3.setBounds(0, 80, 87, 15);
		whopper_3.add(burgerPrice3);
		burgerPrice3.setHorizontalAlignment(SwingConstants.CENTER);
		burgerPrice3.setForeground(Color.RED);
		burgerPrice3.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 13));
		
		// 와퍼 종류 4
		JPanel whopper_4 = new JPanel();
		whopper_4.setBounds(6, 123, 94, 97);
		whopper_4.setOpaque(false);
		whopperPanel.add(whopper_4);
		whopper_4.setLayout(null);
		
		JLabel burger4 = new JLabel(" ");
		burger4.setBounds(7, 0, 87, 56);
		whopper_4.add(burger4);
		burger4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BurgerComposition4.main(null);
				frmBurgerkingKiosk.dispose();
			}
		});
		burger4.setIcon(new ImageIcon(BurgerOrderScreen.class.getResource("/images/whopper.png")));
		burger4.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel burgerName4 = new JLabel("갈릭불고기와퍼");
		burgerName4.setBounds(0, 57, 87, 15);
		whopper_4.add(burgerName4);
		burgerName4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		burgerName4.setHorizontalAlignment(SwingConstants.CENTER);
		burgerName4.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 13));
		
		JLabel burgerPrice4 = new JLabel("6800원~");
		burgerPrice4.setBounds(0, 82, 87, 15);
		whopper_4.add(burgerPrice4);
		burgerPrice4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		burgerPrice4.setHorizontalAlignment(SwingConstants.CENTER);
		burgerPrice4.setForeground(Color.RED);
		burgerPrice4.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 13));
		
		// 와퍼 종류 5
		JPanel whopper_5 = new JPanel();
		whopper_5.setBounds(107, 123, 87, 97);
		whopper_5.setOpaque(false);
		whopperPanel.add(whopper_5);
		whopper_5.setLayout(null);
		whopper_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BurgerComposition5.main(null);
				frmBurgerkingKiosk.dispose();
			}
		});
		
		JLabel burger5 = new JLabel(" ");
		burger5.setBounds(0, 0, 87, 56);
		whopper_5.add(burger5);
		burger5.setIcon(new ImageIcon(BurgerOrderScreen.class.getResource("/images/whopper.png")));
		burger5.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel burgerName5 = new JLabel("스태커4와퍼");
		burgerName5.setBounds(0, 58, 87, 15);
		whopper_5.add(burgerName5);
		burgerName5.setHorizontalAlignment(SwingConstants.CENTER);
		burgerName5.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 13));
		
		JLabel burgerPrice5 = new JLabel("13000원~");
		burgerPrice5.setBounds(0, 82, 87, 15);
		whopper_5.add(burgerPrice5);
		burgerPrice5.setHorizontalAlignment(SwingConstants.CENTER);
		burgerPrice5.setForeground(Color.RED);
		burgerPrice5.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 13));
		
		// 와퍼 종류 6
		JPanel whopper_6 = new JPanel();
		whopper_6.setBounds(206, 123, 87, 95);
		whopper_6.setOpaque(false);
		whopperPanel.add(whopper_6);
		whopper_6.setLayout(null);
		whopper_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BurgerComposition6.main(null);
				frmBurgerkingKiosk.dispose();
			}
		});
		
		JLabel burger6 = new JLabel(" ");
		burger6.setBounds(0, 0, 87, 56);
		whopper_6.add(burger6);
		burger6.setIcon(new ImageIcon(BurgerOrderScreen.class.getResource("/images/whopper.png")));
		burger6.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel burgerName6 = new JLabel("스태커3와퍼");
		burgerName6.setBounds(0, 56, 87, 15);
		whopper_6.add(burgerName6);
		burgerName6.setHorizontalAlignment(SwingConstants.CENTER);
		burgerName6.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 13));
		
		JLabel burgerPrice6 = new JLabel("11000원~");
		burgerPrice6.setBounds(0, 80, 87, 15);
		whopper_6.add(burgerPrice6);
		burgerPrice6.setHorizontalAlignment(SwingConstants.CENTER);
		burgerPrice6.setForeground(Color.RED);
		burgerPrice6.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 13));
		
		// 와퍼 종류 7
		JPanel whopper_7 = new JPanel();
		whopper_7.setBounds(6, 232, 94, 95);
		whopper_7.setOpaque(false);
		whopperPanel.add(whopper_7);
		whopper_7.setLayout(null);
		whopper_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BurgerComposition7.main(null);
				frmBurgerkingKiosk.dispose();
			}
		});
		
		JLabel burger7 = new JLabel(" ");
		burger7.setBounds(6, 0, 81, 56);
		whopper_7.add(burger7);
		burger7.setIcon(new ImageIcon(BurgerOrderScreen.class.getResource("/images/whopper.png")));
		burger7.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel burgerName7 = new JLabel("스태커2와퍼");
		burgerName7.setBounds(6, 56, 71, 15);
		whopper_7.add(burgerName7);
		burgerName7.setHorizontalAlignment(SwingConstants.CENTER);
		burgerName7.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 13));
		
		JLabel burgerPrice7 = new JLabel("9000원~");
		burgerPrice7.setBounds(6, 74, 87, 15);
		whopper_7.add(burgerPrice7);
		burgerPrice7.setHorizontalAlignment(SwingConstants.CENTER);
		burgerPrice7.setForeground(Color.RED);
		burgerPrice7.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 13));
		
		// 와퍼 종류 8
		JPanel whopper_8 = new JPanel();
		whopper_8.setLayout(null);
		whopper_8.setOpaque(false);
		whopper_8.setBounds(100, 232, 94, 95);
		whopperPanel.add(whopper_8);
		whopper_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BurgerComposition1.main(null);
				frmBurgerkingKiosk.dispose();
			}
		});
		
		JLabel burger8 = new JLabel(" ");
		burger8.setIcon(new ImageIcon(BurgerOrderScreen.class.getResource("/images/whopper.png")));
		burger8.setHorizontalAlignment(SwingConstants.CENTER);
		burger8.setBounds(12, 0, 81, 56);
		whopper_8.add(burger8);
		
		JLabel burgerName8 = new JLabel("스태커2와퍼");
		burgerName8.setBounds(16, 56, 71, 15);
		whopper_8.add(burgerName8);
		
		JLabel burgerPrice8 = new JLabel("9000원~");
		burgerPrice8.setHorizontalAlignment(SwingConstants.CENTER);
		burgerPrice8.setForeground(Color.RED);
		burgerPrice8.setFont(new Font("Dialog", Font.PLAIN, 13));
		burgerPrice8.setBounds(6, 74, 87, 15);
		whopper_8.add(burgerPrice8);
		
		// 총 메뉴 주문 개수
		JLabel countLabel = new JLabel(count + "개");
		countLabel.setForeground(new Color(255, 255, 255));
		countLabel.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 15));
		countLabel.setHorizontalAlignment(SwingConstants.CENTER);
		countLabel.setBounds(61, 465, 29, 15);
		panel.add(countLabel);
		
		RoundedButton btnNewButton = new RoundedButton(" ");
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.setEnabled(false);
		btnNewButton.setBounds(55, 462, 50, 23);
		panel.add(btnNewButton);
		
		// 총 주문 금액
		JLabel totalPriceLabel = new JLabel(totalPrice + "원");
		totalPriceLabel.setForeground(new Color(255, 0, 0));
		totalPriceLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		totalPriceLabel.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 15));
		totalPriceLabel.setBounds(215, 467, 79, 15);
		panel.add(totalPriceLabel);
		
		// 결제하기 버튼
		RoundedButton payButton = new RoundedButton("결제하기");
		payButton.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(totalPrice == 0) {
					payButton.setEnabled(false);
				}
				else {
					payButton.setEnabled(true);
				}
			}
		});
		payButton.setForeground(new Color(255, 255, 255));
		payButton.setBackground(Color.RED);
		payButton.setEnabled(false);
		payButton.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 15));
		payButton.setBounds(178, 544, 100, 23);
		panel.add(payButton);
		
		// 결제 취소 버튼
		RoundedButton cancelButton = new RoundedButton("취소");
		cancelButton.setForeground(new Color(255, 255, 255));
		cancelButton.setBackground(new Color(87, 58, 52));
		cancelButton.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 15));
		cancelButton.setBounds(33, 544, 100, 23);
		panel.add(cancelButton);
		
		JLabel totalPriceLabel2 = new JLabel("총 주문금액");
		totalPriceLabel2.setFont(new Font("나눔고딕", Font.BOLD, 15));
		totalPriceLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		totalPriceLabel2.setBounds(127, 467, 86, 15);
		panel.add(totalPriceLabel2);
		
		JLabel cart = new JLabel("카트");
		cart.setHorizontalAlignment(SwingConstants.CENTER);
		cart.setFont(new Font("나눔고딕", Font.BOLD, 15));
		cart.setBounds(20, 467, 29, 15);
		panel.add(cart);
		
		RoundedButton toFirstPage = new RoundedButton("나가기");
		toFirstPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserStartManager.main(null);
				frmBurgerkingKiosk.dispose();
			}
		});
		toFirstPage.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 15));
		toFirstPage.setHorizontalAlignment(SwingConstants.RIGHT);
		toFirstPage.setForeground(new Color(255, 254, 240));
		toFirstPage.setBackground(new Color(87, 58, 52));
		toFirstPage.setBounds(226, 579, 86, 38);
		panel.add(toFirstPage);
		
		JLabel footer = new JLabel(" ");
		footer.setBackground(new Color(87, 58, 52));
		footer.setBounds(0, 576, 312, 45);
		footer.setOpaque(true);
		panel.add(footer);
		
		RoundedButton beverage = new RoundedButton("음료&디저트");
		beverage.setBackground(new Color(250, 242, 205));
		beverage.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 15));
		beverage.setBounds(157, 49, 155, 50);
		panel.add(beverage);
		
		RoundedButton side = new RoundedButton("사이드");
		side.setBackground(new Color(250, 242, 205));
		side.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 15));
		side.setBounds(0, 49, 155, 50);
		panel.add(side);
		
		RoundedButton whopper = new RoundedButton("와퍼");
		whopper.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuNum = 0;
				togglePanels();
			}
		});
		whopper.setBackground(new Color(250, 242, 205));
		whopper.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 15));
		whopper.setBounds(0, 0, 155, 50);
		panel.add(whopper);
		
		RoundedButton premium = new RoundedButton("프리미엄");
		premium.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuNum = 1;
				togglePanels();
			}
		});
		premium.setBackground(new Color(250, 242, 205));
		premium.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 15));
		premium.setBounds(157, 0, 155, 50);
		panel.add(premium);
		
		JLabel yellowFooter = new JLabel(" ");
		yellowFooter.setForeground(new Color(245, 233, 171));
		yellowFooter.setBackground(new Color(250, 242, 205));
		yellowFooter.setBounds(0, 442, 312, 176);
		panel.add(yellowFooter);
		yellowFooter.setOpaque(true);
	}
	
	private void togglePanels() {
        if (menuNum == 0) {
            whopperPanel.setVisible(true);
            premiumPanel.setVisible(false);
        } else {
            whopperPanel.setVisible(false);
            premiumPanel.setVisible(true);
        }
    }
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BurgerOrderScreen window = new BurgerOrderScreen();
					window.frmBurgerkingKiosk.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
