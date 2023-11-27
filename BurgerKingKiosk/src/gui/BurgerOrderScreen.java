package gui;

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
import javax.swing.event.ChangeEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class BurgerOrderScreen extends JFrame{
	private int totalPrice = 0;
	private int count = 0;
	private JFrame frmBurgerkingKiosk;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the application.
	 */
	public BurgerOrderScreen() {
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
		panel.setBounds(0, 0, 298, 609);
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
		settingIcon.setBounds(8, 562, 50, 50);
		panel.add(settingIcon);
		
		
		
		//버거 8개
		
		JLabel burger1 = new JLabel(" ");
		burger1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BurgerComposition1.main(null);
				frmBurgerkingKiosk.dispose();
			}
		});
		burger1.setIcon(new ImageIcon(BurgerOrderScreen.class.getResource("/images/whopper.png")));
		burger1.setHorizontalAlignment(SwingConstants.CENTER);
		burger1.setBounds(8, 109, 87, 56);
		panel.add(burger1);
		
		JLabel burger2 = new JLabel(" ");
		burger2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BurgerComposition2.main(null);
				frmBurgerkingKiosk.dispose();
			}
		});
		burger2.setIcon(new ImageIcon(BurgerOrderScreen.class.getResource("/images/whopper.png")));
		burger2.setHorizontalAlignment(SwingConstants.CENTER);
		burger2.setBounds(107, 109, 87, 56);
		panel.add(burger2);
		
		JLabel burger3 = new JLabel(" ");
		burger3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BurgerComposition3.main(null);
				frmBurgerkingKiosk.dispose();
			}
		});
		burger3.setIcon(new ImageIcon(BurgerOrderScreen.class.getResource("/images/whopper.png")));
		burger3.setHorizontalAlignment(SwingConstants.CENTER);
		burger3.setBounds(207, 109, 87, 56);
		panel.add(burger3);
		
		JLabel burger4 = new JLabel(" ");
		burger4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BurgerComposition4.main(null);
				frmBurgerkingKiosk.dispose();
			}
		});
		burger4.setIcon(new ImageIcon(BurgerOrderScreen.class.getResource("/images/whopper.png")));
		burger4.setHorizontalAlignment(SwingConstants.CENTER);
		burger4.setBounds(8, 218, 87, 56);
		panel.add(burger4);
		
		JLabel burger5 = new JLabel(" ");
		burger5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BurgerComposition5.main(null);
				frmBurgerkingKiosk.dispose();
			}
		});
		burger5.setIcon(new ImageIcon(BurgerOrderScreen.class.getResource("/images/whopper.png")));
		burger5.setHorizontalAlignment(SwingConstants.CENTER);
		burger5.setBounds(107, 218, 87, 56);
		panel.add(burger5);
		
		JLabel burger6 = new JLabel(" ");
		burger6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BurgerComposition6.main(null);
				frmBurgerkingKiosk.dispose();
			}
		});
		burger6.setIcon(new ImageIcon(BurgerOrderScreen.class.getResource("/images/whopper.png")));
		burger6.setHorizontalAlignment(SwingConstants.CENTER);
		burger6.setBounds(206, 218, 87, 56);
		panel.add(burger6);
		
		JLabel burger7 = new JLabel(" ");
		burger7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BurgerComposition7.main(null);
				frmBurgerkingKiosk.dispose();
			}
		});
		burger7.setIcon(new ImageIcon(BurgerOrderScreen.class.getResource("/images/whopper.png")));
		burger7.setHorizontalAlignment(SwingConstants.CENTER);
		burger7.setBounds(13, 326, 87, 56);
		panel.add(burger7);
		
		JLabel burger8 = new JLabel(" ");
		burger8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BurgerComposition8.main(null);
				frmBurgerkingKiosk.dispose();
			}
		});
		burger8.setIcon(new ImageIcon(BurgerOrderScreen.class.getResource("/images/whopper.png")));
		burger8.setHorizontalAlignment(SwingConstants.CENTER);
		burger8.setBounds(108, 326, 87, 56);
		panel.add(burger8);
		
		
		
		
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
		
		JLabel totalPriceLabel = new JLabel(totalPrice + "원");
		totalPriceLabel.setForeground(new Color(255, 0, 0));
		totalPriceLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		totalPriceLabel.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 15));
		totalPriceLabel.setBounds(215, 467, 79, 15);
		panel.add(totalPriceLabel);
		
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
		payButton.setBackground(new Color(87, 58, 52));
		payButton.setEnabled(false);
		payButton.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 15));
		payButton.setBounds(164, 533, 100, 23);
		panel.add(payButton);
		
		RoundedButton cancelButton = new RoundedButton("취소");
		cancelButton.setForeground(new Color(255, 255, 255));
		cancelButton.setBackground(new Color(87, 58, 52));
		cancelButton.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 15));
		cancelButton.setBounds(31, 533, 100, 23);
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
		toFirstPage.setBounds(214, 567, 86, 38);
		panel.add(toFirstPage);
		
		JLabel footer = new JLabel(" ");
		footer.setBackground(new Color(87, 58, 52));
		footer.setBounds(0, 566, 300, 43);
		footer.setOpaque(true);
		panel.add(footer);
		
		RoundedButton beverage = new RoundedButton("음료&디저트");
		beverage.setBackground(new Color(250, 242, 205));
		beverage.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 15));
		beverage.setBounds(145, 49, 155, 50);
		panel.add(beverage);
		
		RoundedButton side = new RoundedButton("사이드");
		side.setBackground(new Color(250, 242, 205));
		side.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 15));
		side.setBounds(0, 49, 155, 50);
		panel.add(side);
		
		RoundedButton premium = new RoundedButton("프리미엄");
		premium.setBackground(new Color(250, 242, 205));
		premium.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 15));
		premium.setBounds(145, 0, 155, 50);
		panel.add(premium);
		
		RoundedButton whopper = new RoundedButton("와퍼");
		whopper.setBackground(new Color(250, 242, 205));
		whopper.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 15));
		whopper.setBounds(0, 0, 155, 50);
		panel.add(whopper);
		
		JLabel yellowFooter = new JLabel(" ");
		yellowFooter.setForeground(new Color(245, 233, 171));
		yellowFooter.setBackground(new Color(250, 242, 205));
		yellowFooter.setBounds(0, 442, 298, 167);
		panel.add(yellowFooter);
		yellowFooter.setOpaque(true);
		
		JLabel burgerName1 = new JLabel("치즈와퍼");
		burgerName1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		burgerName1.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 13));
		burgerName1.setHorizontalAlignment(SwingConstants.CENTER);
		burgerName1.setBounds(8, 175, 87, 15);
		panel.add(burgerName1);
		
		JLabel burgerName2 = new JLabel("와퍼");
		burgerName2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		burgerName2.setHorizontalAlignment(SwingConstants.CENTER);
		burgerName2.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 13));
		burgerName2.setBounds(107, 175, 87, 15);
		panel.add(burgerName2);
		
		JLabel burgerName3 = new JLabel("불고기와퍼");
		burgerName3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		burgerName3.setHorizontalAlignment(SwingConstants.CENTER);
		burgerName3.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 13));
		burgerName3.setBounds(207, 175, 87, 15);
		panel.add(burgerName3);
		
		
		
		JLabel burgerName4 = new JLabel("갈릭불고기와퍼");
		burgerName4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		burgerName4.setHorizontalAlignment(SwingConstants.CENTER);
		burgerName4.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 13));
		burgerName4.setBounds(8, 284, 87, 15);
		panel.add(burgerName4);
		
		
		
		JLabel burgerName5 = new JLabel("스태커4와퍼");
		burgerName5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		burgerName5.setHorizontalAlignment(SwingConstants.CENTER);
		burgerName5.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 13));
		burgerName5.setBounds(107, 284, 87, 15);
		panel.add(burgerName5);
		
		
		
		JLabel burgerName6 = new JLabel("스태커3와퍼");
		burgerName6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		burgerName6.setHorizontalAlignment(SwingConstants.CENTER);
		burgerName6.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 13));
		burgerName6.setBounds(206, 284, 87, 15);
		panel.add(burgerName6);
		
		
		
		JLabel burgerName7 = new JLabel("스태커2와퍼");
		burgerName7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		burgerName7.setHorizontalAlignment(SwingConstants.CENTER);
		burgerName7.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 13));
		burgerName7.setBounds(13, 392, 87, 15);
		panel.add(burgerName7);
		
		
		
		JLabel burgerName8 = new JLabel("베이컨치즈와퍼");
		burgerName8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		burgerName8.setHorizontalAlignment(SwingConstants.CENTER);
		burgerName8.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 13));
		burgerName8.setBounds(108, 392, 87, 15);
		panel.add(burgerName8);
		
		JLabel burgerPrice1 = new JLabel("7000원~");
		burgerPrice1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		burgerPrice1.setForeground(new Color(255, 0, 0));
		burgerPrice1.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 13));
		burgerPrice1.setHorizontalAlignment(SwingConstants.CENTER);
		burgerPrice1.setBounds(8, 193, 87, 15);
		panel.add(burgerPrice1);
		
		JLabel burgerPrice2 = new JLabel("6400원~");
		burgerPrice2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		burgerPrice2.setHorizontalAlignment(SwingConstants.CENTER);
		burgerPrice2.setForeground(Color.RED);
		burgerPrice2.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 13));
		burgerPrice2.setBounds(107, 193, 87, 15);
		panel.add(burgerPrice2);
		
		JLabel burgerPrice3 = new JLabel("6400원~");
		burgerPrice3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		burgerPrice3.setHorizontalAlignment(SwingConstants.CENTER);
		burgerPrice3.setForeground(Color.RED);
		burgerPrice3.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 13));
		burgerPrice3.setBounds(207, 193, 87, 15);
		panel.add(burgerPrice3);
		
		JLabel burgerPrice4 = new JLabel("6800원~");
		burgerPrice4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		burgerPrice4.setHorizontalAlignment(SwingConstants.CENTER);
		burgerPrice4.setForeground(Color.RED);
		burgerPrice4.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 13));
		burgerPrice4.setBounds(8, 309, 87, 15);
		panel.add(burgerPrice4);
		
		JLabel burgerPrice5 = new JLabel("13000원~");
		burgerPrice5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		burgerPrice5.setHorizontalAlignment(SwingConstants.CENTER);
		burgerPrice5.setForeground(Color.RED);
		burgerPrice5.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 13));
		burgerPrice5.setBounds(107, 309, 87, 15);
		panel.add(burgerPrice5);
		
		JLabel burgerPrice6 = new JLabel("11000원~");
		burgerPrice6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		burgerPrice6.setHorizontalAlignment(SwingConstants.CENTER);
		burgerPrice6.setForeground(Color.RED);
		burgerPrice6.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 13));
		burgerPrice6.setBounds(207, 309, 87, 15);
		panel.add(burgerPrice6);
		
		JLabel burgerPrice7 = new JLabel("9000원~");
		burgerPrice7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		burgerPrice7.setHorizontalAlignment(SwingConstants.CENTER);
		burgerPrice7.setForeground(Color.RED);
		burgerPrice7.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 13));
		burgerPrice7.setBounds(8, 417, 87, 15);
		panel.add(burgerPrice7);
		
		JLabel burgerPrice8 = new JLabel("8200원~");
		burgerPrice8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		burgerPrice8.setHorizontalAlignment(SwingConstants.CENTER);
		burgerPrice8.setForeground(Color.RED);
		burgerPrice8.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 13));
		burgerPrice8.setBounds(107, 417, 87, 15);
		panel.add(burgerPrice8);
		
		
		
		
	}
}
