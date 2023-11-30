package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BurgerKingMain extends JFrame {
	private int totalPrice = 0;
	private int count = 0;
	private String whopperName[] = { "치즈와퍼", "와퍼", "불고기와퍼", "갈릭불고기와퍼", "스태커4와퍼", "스태커3와퍼", "스태커2와퍼", "베이컨치즈와퍼" }; 	// 와퍼 종류 배열
																												
	private JFrame frmBurgerkingKiosk;
	private JPanel buttonPanel;
	private JPanel whopperPanel;
	private JPanel premiumPanel;
	private JPanel sidePanel;
	private JPanel drinkDessertPanel;
	private JPanel footerPanel;
	private JPanel totalPanel;

	// for AdminPWManager
	private JPasswordField setPW1;
	private JPasswordField setPW2;
	private String pw = "";
	private String pw2 = "";
	private JPanel AdminPWPanel;
	private JPanel AdminSuccessPanel;
	private JPanel totalPricePanel;

	// for burgerCompositionPanel
	private JPanel burgerCompositionPanel;
	JRadioButton jb[] = new JRadioButton[3];
	ButtonGroup bg = new ButtonGroup();
	JLabel lblNewLabel1;
	JLabel lblNewLabel2;
	JLabel lblNewLabel3;

	public BurgerKingMain() {
		initialize();
	}

	private void initialize() {
		frmBurgerkingKiosk = new JFrame();
		frmBurgerkingKiosk.setTitle("BurgerKing Kiosk");
		frmBurgerkingKiosk.setBounds(100, 100, 312, 646);
		frmBurgerkingKiosk.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBurgerkingKiosk.getContentPane().setLayout(null);

		// PW 저장하는 패털
		AdminPWPanel = new JPanel();
		AdminPWPanel.setBackground(new Color(255, 254, 244));
		AdminPWPanel.setBounds(0, 0, 312, 618);
		AdminPWPanel.setOpaque(true);
		frmBurgerkingKiosk.getContentPane().add(AdminPWPanel);
		AdminPWPanel.setLayout(null);

		// 버튼을 붙일 패널
		buttonPanel = new JPanel();
		buttonPanel.setBackground(new Color(255, 253, 240));
		buttonPanel.setBounds(0, 0, 312, 99);
		buttonPanel.setLayout(null);
		buttonPanel.setVisible(false);
		frmBurgerkingKiosk.getContentPane().add(buttonPanel);

		// 와퍼 메뉴를 붙일 패널
		whopperPanel = new JPanel();
		whopperPanel.setBackground(new Color(255, 253, 240));
		whopperPanel.setLayout(null);
		whopperPanel.setBounds(0, 99, 312, 343);
		whopperPanel.setVisible(false);
		frmBurgerkingKiosk.getContentPane().add(whopperPanel);

		// 프리미엄 메뉴를 붙일 패널
		premiumPanel = new JPanel();
		premiumPanel.setBackground(new Color(255, 253, 240));
		premiumPanel.setLayout(null);
		premiumPanel.setBounds(0, 99, 312, 343);
		premiumPanel.setVisible(false);
		frmBurgerkingKiosk.getContentPane().add(premiumPanel);

		// 사이드 메뉴를 붙일 패널
		sidePanel = new JPanel();
		sidePanel.setBackground(new Color(255, 253, 240));
		sidePanel.setLayout(null);
		sidePanel.setBounds(0, 99, 312, 343);
		sidePanel.setVisible(false);
		frmBurgerkingKiosk.getContentPane().add(sidePanel);

		// 음료 & 디저트 메뉴를 붙일 패널
		drinkDessertPanel = new JPanel();
		drinkDessertPanel.setBackground(new Color(255, 253, 240));
		drinkDessertPanel.setLayout(null);
		drinkDessertPanel.setBounds(0, 99, 312, 343);
		drinkDessertPanel.setVisible(false);
		frmBurgerkingKiosk.getContentPane().add(drinkDessertPanel);

		// 설정과 나가기 버튼을 붙일 footer 패널
		footerPanel = new JPanel();
		footerPanel.setOpaque(true);
		footerPanel.setLayout(null);
		footerPanel.setBounds(0, 578, 312, 40);
		footerPanel.setVisible(false);
		frmBurgerkingKiosk.getContentPane().add(footerPanel);

		// 총 결제 정보를 알려주는 컴포넌트를 붙일 패널
		totalPanel = new JPanel();
		totalPanel.setLayout(null);
		totalPanel.setOpaque(true);
		totalPanel.setVisible(true);
		totalPanel.setBounds(0, 442, 312, 136);
		totalPanel.setVisible(false);
		frmBurgerkingKiosk.getContentPane().add(totalPanel);

		// 버거 구성을 선택할 패널
		burgerCompositionPanel = new JPanel();
		burgerCompositionPanel.setBackground(new Color(255, 254, 240));
		burgerCompositionPanel.setBounds(0, 0, 312, 578);
		burgerCompositionPanel.setLayout(null);
		burgerCompositionPanel.setVisible(false);
		frmBurgerkingKiosk.getContentPane().add(burgerCompositionPanel);

/*------------------------------------------------------AdminPWManager PW 지정-----------------------------------------------------*/

		JLabel setPWLabel = new JLabel("패스워드를 지정하세요");
		setPWLabel.setForeground(new Color(87, 58, 52));
		setPWLabel.setHorizontalAlignment(SwingConstants.CENTER);
		setPWLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		setPWLabel.setBounds(12, 125, 274, 50);
		AdminPWPanel.add(setPWLabel);

		setPW1 = new JPasswordField();
		setPW1.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		setPW1.setColumns(10);
		setPW1.setBounds(20, 260, 258, 50);
		setPW1.setEchoChar('*');
		AdminPWPanel.add(setPW1);

		setPW2 = new JPasswordField();
		setPW2.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		setPW2.setColumns(10);
		setPW2.setBounds(20, 365, 258, 50);
		setPW2.setEchoChar('*');
		AdminPWPanel.add(setPW2);

		JLabel lblNewLabel1 = new JLabel("다시 입력");
		lblNewLabel1.setForeground(new Color(87, 58, 52));
		lblNewLabel1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel1.setBounds(20, 345, 70, 15);
		AdminPWPanel.add(lblNewLabel1);

		RoundedButton btn = new RoundedButton("확인");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pw = new String(setPW1.getPassword());
				pw2 = new String(setPW2.getPassword());

				if (pw.isEmpty() || pw2.isEmpty()) {
					JOptionPane.showMessageDialog(null, "password를 입력해주세요", "Message", JOptionPane.ERROR_MESSAGE);
				} else {
					if (pw.length() > 15 || pw2.length() > 15) {
						JOptionPane.showMessageDialog(null, "password는 1~15자 사이로 입력해주세요", "Message",
								JOptionPane.ERROR_MESSAGE);
					} else {

						if (!pw.equals(pw2))
							JOptionPane.showMessageDialog(null, "틀렸습니다.\n다시 입력해주세요.", "Message",
									JOptionPane.ERROR_MESSAGE);
						else {
							// nextComposition(AdminPWPanel, AdminSuccessPanel);
						}
					}
				}

			}
		});
		btn.setForeground(new Color(255, 254, 244));
		btn.setBackground(new Color(87, 58, 52));
		btn.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		btn.setBounds(20, 478, 258, 50);
		AdminPWPanel.add(btn);

/*-----------------------------========--------------- 상단 메뉴 종류 선택 버튼 ----------------==---------------------------------------*/

		RoundedButton whopper = new RoundedButton("와퍼");
		whopper.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toggleMenuPanel(premiumPanel, sidePanel, drinkDessertPanel, whopperPanel);
			}
		});
		whopper.setBackground(new Color(250, 242, 205));
		whopper.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 15));
		whopper.setBounds(0, 0, 155, 50);
		buttonPanel.add(whopper);

		RoundedButton premium = new RoundedButton("프리미엄");
		premium.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toggleMenuPanel(whopperPanel, sidePanel, drinkDessertPanel, premiumPanel);
			}
		});
		premium.setBackground(new Color(250, 242, 205));
		premium.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 15));
		premium.setBounds(157, 0, 155, 50);
		buttonPanel.add(premium);

		RoundedButton side = new RoundedButton("사이드");
		side.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toggleMenuPanel(whopperPanel, drinkDessertPanel, premiumPanel, sidePanel);
			}
		});
		side.setBackground(new Color(250, 242, 205));
		side.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 15));
		side.setBounds(0, 49, 155, 50);
		buttonPanel.add(side);

		RoundedButton beverage = new RoundedButton("음료&디저트");
		beverage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toggleMenuPanel(whopperPanel, premiumPanel, sidePanel, drinkDessertPanel);
			}
		});
		beverage.setBackground(new Color(250, 242, 205));
		beverage.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 15));
		beverage.setBounds(157, 49, 155, 50);
		buttonPanel.add(beverage);

/*--------------------------------------------------------- 와퍼 메뉴 패널 -------------------------------------------------------------*/

		// 버거 종류 1
		JPanel whopper_1 = new JPanel();
		whopper_1.setOpaque(false);
		whopper_1.setBounds(6, 16, 94, 95);
		whopperPanel.add(whopper_1);
		whopper_1.setLayout(null);
		whopper_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setCompositionName(0);
				nextComposition(whopperPanel, burgerCompositionPanel);
			}
		});

		JLabel burgerName1 = new JLabel("치즈와퍼");
		burgerName1.setBounds(0, 63, 94, 15);
		whopper_1.add(burgerName1);
		burgerName1.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 13));
		burgerName1.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel burgerPrice1 = new JLabel("7000원~");
		burgerPrice1.setBounds(0, 77, 94, 15);
		whopper_1.add(burgerPrice1);
		burgerPrice1.setForeground(new Color(255, 0, 0));
		burgerPrice1.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 13));
		burgerPrice1.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel burger1 = new JLabel(" ");
		burger1.setBounds(0, 0, 94, 62);
		whopper_1.add(burger1);
		burger1.setOpaque(false);
		burger1.setIcon(new ImageIcon(BurgerKingMain.class.getResource("/images/whopper.png")));

		// 버거 종류 2
		JPanel whopper_2 = new JPanel();
		whopper_2.setBounds(107, 16, 94, 95);
		whopper_2.setOpaque(false);
		whopperPanel.add(whopper_2);
		whopper_2.setLayout(null);
		whopper_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setCompositionName(1);
				nextComposition(whopperPanel, burgerCompositionPanel);
			}
		});

		JLabel burgerName2 = new JLabel("와퍼");
		burgerName2.setBounds(0, 63, 94, 15);
		whopper_2.add(burgerName2);
		burgerName2.setHorizontalAlignment(SwingConstants.CENTER);
		burgerName2.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 13));

		JLabel burgerPrice2 = new JLabel("6400원~");
		burgerPrice2.setBounds(0, 77, 94, 15);
		whopper_2.add(burgerPrice2);
		burgerPrice2.setHorizontalAlignment(SwingConstants.CENTER);
		burgerPrice2.setForeground(Color.RED);
		burgerPrice2.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 13));

		JLabel burger2 = new JLabel(" ");
		burger2.setIcon(new ImageIcon(BurgerKingMain.class.getResource("/images/whopper.png")));
		burger2.setOpaque(false);
		burger2.setBounds(0, 0, 94, 62);
		whopper_2.add(burger2);

		// 와퍼 종류 3
		JPanel whopper_3 = new JPanel();
		whopper_3.setBounds(206, 16, 94, 95);
		whopper_3.setOpaque(false);
		whopperPanel.add(whopper_3);
		whopper_3.setLayout(null);
		whopper_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setCompositionName(2);
				nextComposition(whopperPanel, burgerCompositionPanel);
			}
		});

		JLabel burger3 = new JLabel(" ");
		burger3.setBounds(0, 0, 94, 62);
		whopper_3.add(burger3);
		burger3.setIcon(new ImageIcon(BurgerKingMain.class.getResource("/images/whopper.png")));
		burger3.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel burgerName3 = new JLabel("불고기와퍼");
		burgerName3.setBounds(0, 63, 94, 15);
		whopper_3.add(burgerName3);
		burgerName3.setHorizontalAlignment(SwingConstants.CENTER);
		burgerName3.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 13));

		JLabel burgerPrice3 = new JLabel("6400원~");
		burgerPrice3.setBounds(0, 77, 94, 15);
		whopper_3.add(burgerPrice3);
		burgerPrice3.setHorizontalAlignment(SwingConstants.CENTER);
		burgerPrice3.setForeground(Color.RED);
		burgerPrice3.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 13));

		// 와퍼 종류 4
		JPanel whopper_4 = new JPanel();
		whopper_4.setBounds(6, 123, 94, 95);
		whopper_4.setOpaque(false);
		whopperPanel.add(whopper_4);
		whopper_4.setLayout(null);

		JLabel burger4 = new JLabel(" ");
		burger4.setBounds(0, 0, 94, 62);
		whopper_4.add(burger4);
		burger4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setCompositionName(3);
				nextComposition(whopperPanel, burgerCompositionPanel);
			}
		});
		burger4.setIcon(new ImageIcon(BurgerKingMain.class.getResource("/images/whopper.png")));
		burger4.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel burgerName4 = new JLabel("갈릭불고기와퍼");
		burgerName4.setBounds(0, 63, 94, 15);
		whopper_4.add(burgerName4);
		burgerName4.setHorizontalAlignment(SwingConstants.CENTER);
		burgerName4.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 13));

		JLabel burgerPrice4 = new JLabel("6800원~");
		burgerPrice4.setBounds(0, 77, 94, 15);
		whopper_4.add(burgerPrice4);
		burgerPrice4.setHorizontalAlignment(SwingConstants.CENTER);
		burgerPrice4.setForeground(Color.RED);
		burgerPrice4.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 13));

		// 와퍼 종류 5
		JPanel whopper_5 = new JPanel();
		whopper_5.setBounds(107, 123, 94, 95);
		whopper_5.setOpaque(true);
		whopperPanel.add(whopper_5);
		whopper_5.setLayout(null);
		whopper_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setCompositionName(4);
				nextComposition(whopperPanel, burgerCompositionPanel);
			}
		});

		JLabel burger5 = new JLabel(" ");
		burger5.setBounds(0, 0, 94, 62);
		whopper_5.add(burger5);
		burger5.setIcon(new ImageIcon(BurgerKingMain.class.getResource("/images/whopper.png")));
		burger5.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel burgerName5 = new JLabel("스태커4와퍼");
		burgerName5.setBounds(0, 63, 94, 15);
		whopper_5.add(burgerName5);
		burgerName5.setHorizontalAlignment(SwingConstants.CENTER);
		burgerName5.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 13));

		JLabel burgerPrice5 = new JLabel("13000원~");
		burgerPrice5.setBounds(0, 77, 94, 15);
		whopper_5.add(burgerPrice5);
		burgerPrice5.setHorizontalAlignment(SwingConstants.CENTER);
		burgerPrice5.setForeground(Color.RED);
		burgerPrice5.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 13));

		// 와퍼 종류 6
		JPanel whopper_6 = new JPanel();
		whopper_6.setBounds(206, 123, 94, 95);
		whopper_6.setOpaque(false);
		whopperPanel.add(whopper_6);
		whopper_6.setLayout(null);
		whopper_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setCompositionName(5);
				nextComposition(whopperPanel, burgerCompositionPanel);
			}
		});

		JLabel burger6 = new JLabel(" ");
		burger6.setBounds(0, 0, 94, 62);
		whopper_6.add(burger6);
		burger6.setIcon(new ImageIcon(BurgerKingMain.class.getResource("/images/whopper.png")));
		burger6.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel burgerName6 = new JLabel("스태커3와퍼");
		burgerName6.setBounds(0, 63, 94, 15);
		whopper_6.add(burgerName6);
		burgerName6.setHorizontalAlignment(SwingConstants.CENTER);
		burgerName6.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 13));

		JLabel burgerPrice6 = new JLabel("11000원~");
		burgerPrice6.setBounds(0, 77, 94, 15);
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
				setCompositionName(6);
				nextComposition(whopperPanel, burgerCompositionPanel);
			}
		});

		JLabel burger7 = new JLabel(" ");
		burger7.setBounds(0, 0, 94, 62);
		whopper_7.add(burger7);
		burger7.setIcon(new ImageIcon(BurgerKingMain.class.getResource("/images/whopper.png")));
		burger7.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel burgerName7 = new JLabel("스태커2와퍼");
		burgerName7.setBounds(0, 63, 94, 15);
		whopper_7.add(burgerName7);
		burgerName7.setHorizontalAlignment(SwingConstants.CENTER);
		burgerName7.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 13));

		JLabel burgerPrice7 = new JLabel("9000원~");
		burgerPrice7.setBounds(0, 77, 94, 15);
		whopper_7.add(burgerPrice7);
		burgerPrice7.setHorizontalAlignment(SwingConstants.CENTER);
		burgerPrice7.setForeground(Color.RED);
		burgerPrice7.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 13));

		// 와퍼 종류 8
		JPanel whopper_8 = new JPanel();
		whopper_8.setLayout(null);
		whopper_8.setOpaque(false);
		whopper_8.setBounds(107, 232, 94, 95);
		whopperPanel.add(whopper_8);
		whopper_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setCompositionName(7);
				nextComposition(whopperPanel, burgerCompositionPanel);
			}
		});

		JLabel burger8 = new JLabel(" ");
		burger8.setIcon(new ImageIcon(BurgerKingMain.class.getResource("/images/whopper.png")));
		burger8.setHorizontalAlignment(SwingConstants.CENTER);
		burger8.setBounds(0, 0, 94, 62);
		whopper_8.add(burger8);

		JLabel burgerName8 = new JLabel("베이컨치즈와퍼");
		burgerName8.setHorizontalAlignment(SwingConstants.CENTER);
		burgerName8.setBounds(0, 63, 94, 15);
		whopper_8.add(burgerName8);

		JLabel burgerPrice8 = new JLabel("8200원~");
		burgerPrice8.setHorizontalAlignment(SwingConstants.CENTER);
		burgerPrice8.setForeground(Color.RED);
		burgerPrice8.setFont(new Font("Dialog", Font.PLAIN, 13));
		burgerPrice8.setBounds(0, 77, 94, 15);
		whopper_8.add(burgerPrice8);

/*------------------------------------------------------------- totalPanel -------------------------------------------------------------------------*/

		// 총 메뉴 주문 개수
		JLabel countLabel = new JLabel(count + "개");
		countLabel.setForeground(new Color(255, 255, 255));
		countLabel.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 15));
		countLabel.setHorizontalAlignment(SwingConstants.CENTER);
		countLabel.setBounds(71, 14, 29, 15);
		totalPanel.add(countLabel);

		RoundedButton btnNewButton = new RoundedButton(" ");
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.setEnabled(false);
		btnNewButton.setBounds(60, 11, 50, 23);
		totalPanel.add(btnNewButton);

		// 총 주문 금액
		JLabel totalPriceLabel = new JLabel(totalPrice + "원");
		totalPriceLabel.setForeground(new Color(255, 0, 0));
		totalPriceLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		totalPriceLabel.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 15));
		totalPriceLabel.setBounds(227, 14, 79, 15);
		totalPanel.add(totalPriceLabel);

		// 결제하기 버튼
		RoundedButton payButton = new RoundedButton("결제하기");
		payButton.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (totalPrice == 0) {
					payButton.setEnabled(false);
				} else {
					payButton.setEnabled(true);
				}
			}
		});
		payButton.setForeground(new Color(255, 255, 255));
		payButton.setBackground(Color.RED);
		payButton.setEnabled(false);
		payButton.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 15));
		payButton.setBounds(175, 97, 100, 23);
		totalPanel.add(payButton);

		// 결제 취소 버튼
		RoundedButton cancelButton = new RoundedButton("취소");
		cancelButton.setForeground(new Color(255, 255, 255));
		cancelButton.setBackground(new Color(87, 58, 52));
		cancelButton.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 15));
		cancelButton.setBounds(34, 97, 100, 23);
		totalPanel.add(cancelButton);

		// 총 주문금액
		JLabel totalPriceLabel2 = new JLabel("총 주문금액");
		totalPriceLabel2.setFont(new Font("나눔고딕", Font.BOLD, 15));
		totalPriceLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		totalPriceLabel2.setBounds(140, 14, 86, 15);
		totalPanel.add(totalPriceLabel2);

		// 카트
		JLabel cart = new JLabel("카트");
		cart.setHorizontalAlignment(SwingConstants.CENTER);
		cart.setFont(new Font("나눔고딕", Font.BOLD, 15));
		cart.setBounds(22, 13, 29, 15);
		totalPanel.add(cart);

		JLabel yellowFooter = new JLabel(" ");
		yellowFooter.setForeground(new Color(245, 233, 171));
		yellowFooter.setBackground(new Color(250, 242, 205));
		yellowFooter.setBounds(0, 0, 312, 136);
		yellowFooter.setOpaque(true);
		totalPanel.add(yellowFooter);

/*----------------------------------------------------------- footer Panel --------------------------------------------------------------------*/

		// 관리자 화면으로 가는 아이콘
		JLabel settingIcon = new JLabel(" ");
		settingIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminSuccess.main(null);
				frmBurgerkingKiosk.dispose();
			}
		});
		settingIcon.setHorizontalAlignment(SwingConstants.CENTER);
		settingIcon.setIcon(new ImageIcon(BurgerKingMain.class.getResource("/images/setting.png")));
		settingIcon.setBounds(5, 5, 38, 30);
		footerPanel.add(settingIcon);

		// 나가기 버튼: 시작 화면으로
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
		toFirstPage.setBounds(226, 1, 86, 38);
		footerPanel.add(toFirstPage);

		JLabel footer = new JLabel(" ");
		footer.setBounds(0, 0, 312, 44);
		footerPanel.add(footer);
		footer.setBackground(new Color(87, 58, 52));
		footer.setOpaque(true);

/*------------------------------------------------- burgerCompositionPanel -------------------------------------------------------*/

		lblNewLabel1 = new JLabel(whopperName[0] + "+프렌치프라이(L)+콜라(L)");
		lblNewLabel1.setForeground(new Color(87, 58, 52));
		lblNewLabel1.setFont(new Font("나눔고딕", Font.PLAIN, 13));
		lblNewLabel1.setBounds(57, 222, 243, 30);
		burgerCompositionPanel.add(lblNewLabel1);

		lblNewLabel3 = new JLabel("치즈와퍼+프렌치프라이(R)+콜라(R)");
		lblNewLabel3.setForeground(new Color(87, 58, 52));
		lblNewLabel3.setFont(new Font("나눔고딕", Font.PLAIN, 13));
		lblNewLabel3.setBounds(57, 317, 243, 30);
		burgerCompositionPanel.add(lblNewLabel3);

		lblNewLabel2 = new JLabel("치즈와퍼 단품");
		lblNewLabel2.setForeground(new Color(87, 58, 52));
		lblNewLabel2.setFont(new Font("나눔고딕", Font.PLAIN, 13));
		lblNewLabel2.setBounds(57, 415, 243, 30);
		burgerCompositionPanel.add(lblNewLabel2);

		JLabel lblNewLabel = new JLabel("원하시는 구성을 선택하세요");
		lblNewLabel.setForeground(new Color(87, 58, 52));
		lblNewLabel.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(21, 95, 265, 50);
		burgerCompositionPanel.add(lblNewLabel);

		for (int i = 0; i < 3; i++) {
			jb[i] = new JRadioButton();
		}

		jb[0].setText("치즈와퍼 라지 세트");
		jb[0].setForeground(new Color(87, 58, 52));
		jb[0].setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 15));
		jb[0].setBackground(new Color(255, 254, 244));
		jb[0].setBounds(35, 180, 265, 50);
		burgerCompositionPanel.add(jb[0]);
		bg.add(jb[0]);

		jb[1].setText("치즈와퍼 세트");
		jb[1].setForeground(new Color(87, 58, 52));
		jb[1].setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 15));
		jb[1].setBackground(new Color(255, 254, 244));
		jb[1].setBounds(35, 276, 265, 50);
		burgerCompositionPanel.add(jb[1]);
		bg.add(jb[1]);

		jb[2].setText("치즈와퍼 단품");
		jb[2].setForeground(new Color(87, 58, 52));
		jb[2].setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 15));
		jb[2].setBackground(new Color(255, 254, 244));
		jb[2].setBounds(35, 373, 265, 50);
		burgerCompositionPanel.add(jb[2]);
		bg.add(jb[2]);

		RoundedButton compositionBtn = new RoundedButton("확인");
		compositionBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!jb[0].isSelected() && !jb[1].isSelected() && !jb[2].isSelected()) {
					JOptionPane.showMessageDialog(null, "구성을 선택해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		compositionBtn.setForeground(new Color(255, 253, 240));
		compositionBtn.setBackground(new Color(87, 58, 52));
		compositionBtn.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 15));
		compositionBtn.setBounds(40, 479, 220, 50);
		burgerCompositionPanel.add(compositionBtn);

		JLabel compositionToPreviousPage = new JLabel("X");
		compositionToPreviousPage.setBounds(14, 14, 19, 15);
		burgerCompositionPanel.add(compositionToPreviousPage);
		compositionToPreviousPage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				burgerCompositionPanel.setVisible(false);
				buttonPanel.setVisible(true);
				whopperPanel.setVisible(true);
				totalPanel.setVisible(true);
			}
		});
		compositionToPreviousPage.setForeground(new Color(87, 58, 52));
		compositionToPreviousPage.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 17));
	}

/*---------------------------------------------------------- 메소드 -------------------------------------------------------------*/

	// 메뉴 종류(와퍼, 프리미엄, ...)에 따라 패널을 바꾸어주는 메소드
	private void toggleMenuPanel(JPanel other1, JPanel other2, JPanel other3, JPanel next) {
		if (!next.isVisible()) {
			other1.setVisible(false);
			other2.setVisible(false);
			other3.setVisible(false);
			next.setVisible(true);
		}
	}

	// 메뉴 선택 시 옵션을 선택하는 패널을 바꾸어주는 메소드
	private void nextComposition(JPanel nowPanel, JPanel next) {
		nowPanel.setVisible(false);
		buttonPanel.setVisible(false);
		totalPanel.setVisible(false);
		next.setVisible(true);
	}

	// composition 메뉴 이름을 바꾸어주는 메소드
	private void setCompositionName(int whopperNum) {
		lblNewLabel1.setText(whopperName[whopperNum] + "+프렌치프라이(L)+콜라(L)");
		lblNewLabel2.setText(whopperName[whopperNum] + " 단품");
		lblNewLabel3 = new JLabel("whopperName[whopperNum]+프렌치프라이(R)+콜라(R)");
		jb[0].setText(whopperName[whopperNum] + " 라지 세트");
		jb[1].setText(whopperName[whopperNum] + " 세트");
		jb[2].setText(whopperName[whopperNum] + " 단품");
	}

/*---------------------------------------------------- Main --------------------------------------------------------*/

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BurgerKingMain window = new BurgerKingMain();
					window.frmBurgerkingKiosk.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
