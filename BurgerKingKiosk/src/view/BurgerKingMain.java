package view;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
<<<<<<< HEAD
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import java.awt.Font;
import java.awt.GridBagLayout;

import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.CheckboxGroup;
=======
import javax.swing.JScrollPane;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.SwingConstants;

>>>>>>> main
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;

import jdbc.MysqlJdbc;
import model.dao.AdminDAO;
import model.dao.MenuDAO;
import model.dto.MenuByTypeDTO;
import model.vo.MenuTypeVO;
import model.vo.MenuVO;

import javax.swing.event.ChangeEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JScrollPane;

public class BurgerKingMain extends JFrame {
	private int totalPrice = 0;
	private int count = 0;
	private List<MenuByTypeDTO> menuByTypeDTOs;
	private List<RoundedButton> typeButtons = new ArrayList<RoundedButton>();
	private List<JPanel> menuPanels = new ArrayList<JPanel>();
	private List<JScrollPane> scrollPanes = new ArrayList<JScrollPane>();
	private int setMenuPanel = 0;
	private String whopperName[] = { "치즈와퍼", "와퍼", "불고기와퍼", "갈릭불고기와퍼", "스태커4와퍼", "스태커3와퍼", "스태커2와퍼", "베이컨치즈와퍼" }; 	// 와퍼 종류 배열
	private ImageIcon checked;
	private ImageIcon unchecked;
	
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
	
	//for LogIn
	private JPanel loginPanel;
	private JPasswordField enterPW;
	private String pw3 = "";

	//for UserStartManager
	private JPanel UserStartManagerPanel;
	
	// for burgerCompositionPanel
	private JPanel burgerCompositionPanel;
	JRadioButton jb[] = new JRadioButton[3];
	ButtonGroup bg = new ButtonGroup();
	JLabel lblNewLabel = new JLabel("");
	JLabel lblNewLabel2 = new JLabel("");
	JLabel lblNewLabel3 = new JLabel("");
	
	//for selectedMenuPanel
	int index;
	private JLabel sideLabel;
	private JLabel beverageLabel;
	JLabel ingredientLabel;
	JLabel ingredientLabel1;
	
	private JPanel selectedsetPanel;
	private JPanel selectedsinglePanel;
	private JPanel singleIngredientPanel;
	private JPanel ingredientPanel;
	private JPanel sideselectPanel;
	private JPanel beveragePanel;
	
	ButtonGroup bg1 = new ButtonGroup();
	ButtonGroup bg2 = new ButtonGroup();
	JCheckBox ingredientjb[] = new JCheckBox[3];
	JCheckBox singleingredientjb[] = new JCheckBox[3];
	JRadioButton sidejb[] = new JRadioButton[4];
	JRadioButton beveragejb[] = new JRadioButton[4];
	private String setMenu[] = { " (R)", " (L)" }; //사이즈 종류
	private String changeIngredient[] = {"토마토", "소스", "양상추"};
	private String changeSide[] = {"프렌치프라이", "치즈스틱", "어니언링", "콘샐러드"};
	private String changeBeverage[] = {"코카콜라", "코카콜라제로", "스프라이트", "물"};

	//for toGoPanel
	private JPanel toGoPanel;
	ButtonGroup bg3 = new ButtonGroup();
	JRadioButton whereToEatjb[] = new JRadioButton[2];
	private String whereToEat[] = {"매장 주문", "포장 주문"};
	
	//for orderCheckPanel
	private JScrollPane orderCheckScrollPane;
	private JPanel orderCheck;
	private JPanel orderPanel;
	private JPanel orderPanel1;
	private JPanel orderPanel2;
	private JPanel labelPanel;
	private JPanel labelFooter;
	
	
	public BurgerKingMain() {
		new MysqlJdbc();
		initialize();
	}

	private void initialize() {
		frmBurgerkingKiosk = new JFrame();
		frmBurgerkingKiosk.setTitle("BurgerKing Kiosk");
		frmBurgerkingKiosk.setBounds(100, 100, 312, 646);
		frmBurgerkingKiosk.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBurgerkingKiosk.getContentPane().setLayout(null);
<<<<<<< HEAD
		frmBurgerkingKiosk.setLocationRelativeTo(null);
		
=======
>>>>>>> main

		// PW 저장하는 패널
		AdminPWPanel = new JPanel();
		AdminPWPanel.setBackground(new Color(255, 254, 244));
		AdminPWPanel.setBounds(0, 0, 312, 618);
		AdminPWPanel.setOpaque(true);
		frmBurgerkingKiosk.getContentPane().add(AdminPWPanel);
		AdminPWPanel.setLayout(null);
		
		//LogIn 패널
		loginPanel = new JPanel();
		loginPanel.setBackground(new Color(255, 253, 240));
		loginPanel.setBounds(0, 0, 312, 618);
		loginPanel.setOpaque(true);
		frmBurgerkingKiosk.getContentPane().add(loginPanel);
		loginPanel.setLayout(null);
		loginPanel.setVisible(false);
		
		//AdminSuccess 패널
		AdminSuccessPanel = new JPanel();
		AdminSuccessPanel.setBackground(new Color(255, 253, 240));
		AdminSuccessPanel.setBounds(0, 0, 312, 618);
		frmBurgerkingKiosk.getContentPane().add(AdminSuccessPanel);
		AdminSuccessPanel.setLayout(null);
		AdminSuccessPanel.setVisible(false);
		
		//UserStartManager 패널
		UserStartManagerPanel = new JPanel();
		UserStartManagerPanel.setBackground(new Color(255, 253, 240));
		UserStartManagerPanel.setBounds(0, 0, 312, 618);
		frmBurgerkingKiosk.getContentPane().add(UserStartManagerPanel);
		UserStartManagerPanel.setLayout(null);
		UserStartManagerPanel.setVisible(false);

		// 버튼을 붙일 패널
		buttonPanel = new JPanel();
		buttonPanel.setBackground(new Color(255, 253, 240));
		buttonPanel.setBounds(0, 0, 312, 99);
		buttonPanel.setLayout(new GridLayout(0, 4));
		buttonPanel.setVisible(false);
		frmBurgerkingKiosk.getContentPane().add(buttonPanel);

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
		
		//선택 메뉴를 확인할 패널
		selectedsetPanel = new JPanel();
		selectedsetPanel.setBackground(new Color(255, 254, 240));
		selectedsetPanel.setBounds(0, 0, 312, 578);
		selectedsetPanel.setVisible(false);
		frmBurgerkingKiosk.getContentPane().add(selectedsetPanel);
		selectedsetPanel.setLayout(null);
		
		//선택 메뉴를 확인할 패널
		selectedsinglePanel = new JPanel();
		selectedsinglePanel.setBackground(new Color(255, 254, 240));
		selectedsinglePanel.setBounds(0, 0, 312, 578);
		selectedsinglePanel.setVisible(false);
		frmBurgerkingKiosk.getContentPane().add(selectedsinglePanel);
		selectedsinglePanel.setLayout(null);
		
		//재료 추가 패널
		ingredientPanel = new JPanel();
		ingredientPanel.setBackground(new Color(255, 254, 240));
		ingredientPanel.setBounds(0, 0, 312, 578);
		ingredientPanel.setVisible(false);
		frmBurgerkingKiosk.getContentPane().add(ingredientPanel);
		ingredientPanel.setLayout(null);
		
		//단품 재료 추가 패널
		singleIngredientPanel = new JPanel();
		singleIngredientPanel.setBackground(new Color(255, 254, 240));
		singleIngredientPanel.setBounds(0, 0, 312, 578);
		singleIngredientPanel.setVisible(false);
		frmBurgerkingKiosk.getContentPane().add(singleIngredientPanel);
		singleIngredientPanel.setLayout(null);
		
		//사이드 추가 패널
		sideselectPanel = new JPanel();
		sideselectPanel.setBackground(new Color(255, 254, 240));
		sideselectPanel.setBounds(0, 0, 312, 578);
		sideselectPanel.setVisible(false);
		frmBurgerkingKiosk.getContentPane().add(sideselectPanel);
		sideselectPanel.setLayout(null);
		
		//음료 추가 패널
		beveragePanel = new JPanel();
		beveragePanel.setBackground(new Color(255, 254, 240));
		beveragePanel.setBounds(0, 0, 312, 578);
		beveragePanel.setVisible(false);
		frmBurgerkingKiosk.getContentPane().add(beveragePanel);
		beveragePanel.setLayout(null);
		
<<<<<<< HEAD
		//매장 혹은 포장 패널
		toGoPanel = new JPanel();
		toGoPanel.setBackground(new Color(255, 254, 240));
		toGoPanel.setBounds(0, 0, 312, 578);
		toGoPanel.setVisible(false);
		frmBurgerkingKiosk.getContentPane().add(toGoPanel);
		toGoPanel.setLayout(null);
		
		//주문확인 패널
		orderCheckScrollPane = new JScrollPane(orderCheck);
		orderCheckScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		orderCheckScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		orderCheckScrollPane.setBounds(0, 99, 312, 343);
		frmBurgerkingKiosk.getContentPane().add(orderCheckScrollPane, BorderLayout.CENTER);
		
		orderCheck = new JPanel();
		orderCheck.setBackground(new Color(255, 254, 244));
		orderCheck.setPreferredSize(new Dimension(312,1000));
		orderCheckScrollPane.setViewportView(orderCheck);
		orderCheck.setLayout(new BorderLayout());
		
		
		//주문확인 header
		labelPanel = new JPanel();
		labelPanel.setBackground(new Color(255, 254, 240));
		labelPanel.setBounds(0, 0, 312, 99);
		labelPanel.setVisible(false);
		frmBurgerkingKiosk.getContentPane().add(labelPanel);
		labelPanel.setLayout(null);
		
		//주문확인 footer
		labelFooter = new JPanel();
		labelFooter.setBackground(new Color(255, 254, 240));
		labelFooter.setBounds(0, 442, 312, 136);
		labelFooter.setVisible(false);
		frmBurgerkingKiosk.getContentPane().add(labelFooter);
		labelFooter.setLayout(null);
		
=======
>>>>>>> main
/*---------------------------------------------------login 여부 확인---------------------------------------------------------------*/
		
		if(AdminDAO.isAdminTableNotEmpty()) {
			AdminPWPanel.setVisible(false);
			loginPanel.setVisible(true);
		}
		else {
			AdminPWPanel.setVisible(true);
			loginPanel.setVisible(false);
		}
		
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
							setPW1.setText("");
							setPW2.setText("");
							AdminDAO.insertAdmin(pw2);
							nextComposition(AdminPWPanel, AdminSuccessPanel);
							
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
		
<<<<<<< HEAD
		
		
		
		
=======
>>>>>>> main
/*-------------------------------------------------------LogIn 패널----------------------------------------------------------------*/
		
		JLabel setLoginLabel = new JLabel("패스워드를 입력해주세요");
		setLoginLabel.setForeground(new Color(87, 58, 52));
		setLoginLabel.setHorizontalAlignment(SwingConstants.CENTER);
		setLoginLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		setLoginLabel.setBounds(12, 125, 274, 50);
		loginPanel.add(setLoginLabel);

		enterPW = new JPasswordField();
		enterPW.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		enterPW.setColumns(10);
		enterPW.setBounds(20, 280, 258, 50);
		enterPW.setEchoChar('*');
		loginPanel.add(enterPW);

		RoundedButton pwBtn = new RoundedButton("확인");
		pwBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pw3 = new String(enterPW.getPassword());

				if (pw3.isEmpty()) {
					JOptionPane.showMessageDialog(null, "password를 입력해주세요", "Message", JOptionPane.ERROR_MESSAGE);
				} else {
					if (pw3.length() > 15) {
						JOptionPane.showMessageDialog(null, "password는 1~15자 사이로 입력해주세요", "Message",
								JOptionPane.ERROR_MESSAGE);
					} else {

						if (!pw3.equals(AdminDAO.getAdminPassword(1))) {
							JOptionPane.showMessageDialog(null, "틀렸습니다.\n다시 입력해주세요.", "Message",
									JOptionPane.ERROR_MESSAGE);
							}
						else {
							nextComposition(loginPanel, AdminSuccessPanel);
							enterPW.setText("");
						}
					}
				}

			}
		});
		pwBtn.setForeground(new Color(255, 254, 244));
		pwBtn.setBackground(new Color(87, 58, 52));
		pwBtn.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		pwBtn.setBounds(20, 478, 258, 50);
		loginPanel.add(pwBtn);
		
/*------------------------------------------------------AdminSuccess 패널----------------------------------------------------------*/
		
		RoundedButton AdminSuccesstoStartPage = new RoundedButton("나가기");
		AdminSuccesstoStartPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminSuccessPanel.setVisible(false);
				loginPanel.setVisible(true);
			}
		});
		AdminSuccesstoStartPage.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 15));
		AdminSuccesstoStartPage.setHorizontalAlignment(SwingConstants.RIGHT);
		AdminSuccesstoStartPage.setForeground(new Color(255, 254, 240));
		AdminSuccesstoStartPage.setBackground(new Color(87, 58, 52));
		AdminSuccesstoStartPage.setBounds(220, 577, 86, 38);
		AdminSuccessPanel.add(AdminSuccesstoStartPage);
		
		
		RoundedButton price = new RoundedButton("매출 확인");
		price.setBackground(new Color(87, 58, 52));
		price.setForeground(new Color(255, 253, 240));
		price.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 20));
		price.setBounds(43, 157, 220, 50);
		AdminSuccessPanel.add(price);
		
		RoundedButton startMenu = new RoundedButton("시작 화면으로 가기");
		startMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminSuccessPanel.setVisible(false);
				UserStartManagerPanel.setVisible(true);
			}
		});
		startMenu.setBackground(new Color(87, 58, 52));
		startMenu.setForeground(new Color(255, 253, 240));
		startMenu.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 20));
		startMenu.setBounds(43, 246, 220, 50);
		AdminSuccessPanel.add(startMenu);
		
		JLabel AdminSuccessfooter = new JLabel(" ");
		AdminSuccessfooter.setBackground(new Color(87, 58, 52));
		AdminSuccessfooter.setBounds(0, 575, 312, 43);
		AdminSuccessfooter.setOpaque(true);
		AdminSuccessPanel.add(AdminSuccessfooter);

/*--------------------------------------------------------UserStartManager 패널------------------------------------------------------------*/
		
		JPanel redpanel = new JPanel();
		redpanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UserStartManagerPanel.setVisible(false);
				buttonPanel.setVisible(true);
				footerPanel.setVisible(true);
				totalPanel.setVisible(true);
				if(scrollPanes.size() > 0) {
					scrollPanes.get(setMenuPanel).setVisible(true);
				}
			}
		});
		redpanel.setBackground(Color.RED);
		redpanel.setBounds(0, 460, 312, 158);
		UserStartManagerPanel.add(redpanel);
		redpanel.setLayout(null);
		
		JLabel touchLabel = new JLabel("화면을 터치하세요!");
		touchLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UserStartManagerPanel.setVisible(false);
				buttonPanel.setVisible(true);
				footerPanel.setVisible(true);
				totalPanel.setVisible(true);
				if(scrollPanes.size() > 0) {
					scrollPanes.get(setMenuPanel).setVisible(true);
				}
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
				UserStartManagerPanel.setVisible(false);
				buttonPanel.setVisible(true);
				footerPanel.setVisible(true);
				totalPanel.setVisible(true);
				if(scrollPanes.size() > 0) {
					scrollPanes.get(setMenuPanel).setVisible(true);
				}
			}
		});
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(87, 58, 52));
		lblNewLabel_1.setFont(new Font("Modak", Font.PLAIN, 40));
		lblNewLabel_1.setBounds(87, 81, 130, 50);
		UserStartManagerPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("King");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UserStartManagerPanel.setVisible(false);
				buttonPanel.setVisible(true);
				footerPanel.setVisible(true);
				totalPanel.setVisible(true);
				if(scrollPanes.size() > 0) {
					scrollPanes.get(setMenuPanel).setVisible(true);
				}
			}
		});
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(new Color(87, 58, 52));
		lblNewLabel_2.setFont(new Font("Modak", Font.PLAIN, 40));
		lblNewLabel_2.setBounds(109, 131, 92, 50);
		UserStartManagerPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UserStartManagerPanel.setVisible(false);
				buttonPanel.setVisible(true);
				footerPanel.setVisible(true);
				totalPanel.setVisible(true);
				if(scrollPanes.size() > 0) {
					scrollPanes.get(setMenuPanel).setVisible(true);
				}
			}
		});
		lblNewLabel_3.setIcon(new ImageIcon(BurgerKingMain.class.getResource("/images/startLogoImage.png")));
		lblNewLabel_3.setIcon(new ImageIcon(BurgerKingMain.class.getResource("/images/startLogoImage.png")));
		lblNewLabel_3.setBounds(76, 193, 155, 173);
		UserStartManagerPanel.add(lblNewLabel_3);
		setSize(312, 646);
		
/*--------------------------------------------- 상단 메뉴 종류 선택 버튼과 메뉴 패널에 메뉴 구성 -------------------------------------------------------*/
		
		try {
            // 모든 Type 정보에 대해 isVisible이 1인 Menu 정보 가져오기
            menuByTypeDTOs = MenuDAO.getMenuByTypes();
            int num = 0;

            for (MenuByTypeDTO menuByTypeDTO : menuByTypeDTOs) {
                MenuTypeVO menuTypeVo = menuByTypeDTO.getMenuTypeVo();
                ArrayList<MenuVO> menuVos = menuByTypeDTO.getMenuVos();

                // 메뉴 타입 버튼 생성
                RoundedButton typeButton = new RoundedButton(menuTypeVo.getName());
        		typeButton.setBackground(new Color(250, 242, 205));
        		typeButton.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 15));
        		buttonPanel.add(typeButton);
        		typeButtons.add(typeButton);
        		
        		// 타입별로 메뉴 패널 생성 및 menuPanels에 추가
        		JPanel menuPanel = new JPanel();
        		menuPanel.setBackground(new Color(255, 253, 240));
        		menuPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        		menuPanel.setPreferredSize(new Dimension(312, 343));
        		menuPanel.setVisible(true);
        		menuPanels.add(menuPanel);
        		
        		// 스크롤 가능한 패널 생성
                JScrollPane scrollPane = new JScrollPane(menuPanel);
                scrollPane.setBounds(0, 99, 312, 343);
                scrollPane.setBorder(null);	// 테두리 없애기
                scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); // 가로 스크롤 막기
                scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); // 스크롤이 필요할 때만 나타나도록 설정
                frmBurgerkingKiosk.getContentPane().add(scrollPane);
                
                scrollPanes.add(scrollPane);
                
                for (MenuVO menuVo : menuVos) {
            		JPanel menu = new JPanel();
            		menu.setOpaque(false);
            		menu.setPreferredSize(new Dimension(94, 95));
            		if (!menuPanels.isEmpty())	menuPanels.get(num).add(menu);
            		menu.setLayout(null);
            		menu.addMouseListener(new MouseAdapter() {
            			@Override
            			public void mouseClicked(MouseEvent e) {
            				index = 0;
            				setCompositionName(0);
            				nextComposition(scrollPane, burgerCompositionPanel);
            			}
            		});

            		JLabel menuName = new JLabel(menuVo.getName());
            		menuName.setBounds(0, 63, 94, 15);
            		menu.add(menuName);
            		menuName.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 13));
            		menuName.setHorizontalAlignment(SwingConstants.CENTER);

            		JLabel menuPrice = new JLabel(menuVo.getPrice()+"원~");
            		menuPrice.setBounds(0, 77, 94, 15);
            		menu.add(menuPrice);
            		menuPrice.setForeground(new Color(255, 0, 0));
            		menuPrice.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 13));
            		menuPrice.setHorizontalAlignment(SwingConstants.CENTER);

            		JLabel menuImage = new JLabel(" ");
            		menuImage.setBounds(0, 0, 94, 62);
            		menu.add(menuImage);
            		menuImage.setOpaque(false);
            		menuImage.setIcon(new ImageIcon(BurgerKingMain.class.getResource("/images/whopper.png")));
                }
                num++;
            }
            
            for(int i = 0; i < typeButtons.size(); i++) {
            	int currentIndex = i; // 현재 인덱스 저장
            	typeButtons.get(i).addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// 모든 scrollPanes의 scrollPane들을 숨김
			            for (int j = 0; j < scrollPanes.size(); j++) {
			            	scrollPanes.get(j).setVisible(false);
			            }

			            // 현재 클릭된 버튼에 해당하는 scrollPane을 보이도록 설정
			            if (currentIndex < scrollPanes.size()) {
			            	setMenuPanel = currentIndex;
			            	scrollPanes.get(setMenuPanel).setVisible(true);
			            }
					}
				});
            }
            
            scrollPanes.get(setMenuPanel).setVisible(true);
            
            for(int i = 1; i < typeButtons.size(); i++) {
            	scrollPanes.get(i).setVisible(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

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
		totalPriceLabel.setBounds(207, 14, 79, 15);
		totalPanel.add(totalPriceLabel);

		// 결제하기 버튼
		RoundedButton payButton = new RoundedButton("결제하기");
		payButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toGoPanel.setVisible(true);
				totalPanel.setVisible(false);
				buttonPanel.setVisible(false);
				whopperPanel.setVisible(false);
				burgerCompositionPanel.setVisible(false);
			}
		});
		payButton.setForeground(new Color(255, 255, 255));
		payButton.setBackground(Color.RED);
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
				AdminSuccessPanel.setVisible(false);
				loginPanel.setVisible(true);
				buttonPanel.setVisible(false);
				footerPanel.setVisible(false);
				totalPanel.setVisible(false);
<<<<<<< HEAD
				whopperPanel.setVisible(false);
				burgerCompositionPanel.setVisible(false);
				selectedsetPanel.setVisible(false);
				selectedsinglePanel.setVisible(false);
				orderCheck.setVisible(false);
=======
				if(scrollPanes.size() > 0) {
					scrollPanes.get(setMenuPanel).setVisible(true);
				}
//				burgerCompositionPanel.setVisible(false);
>>>>>>> main
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
				setMenuPanel = 0;	
				UserStartManagerPanel.setVisible(true);
				buttonPanel.setVisible(false);
				footerPanel.setVisible(false);
				totalPanel.setVisible(false);
//				burgerCompositionPanel.setVisible(false);
				selectedsetPanel.setVisible(false);
				ingredientPanel.setVisible(false);
				sideselectPanel.setVisible(false);
				beveragePanel.setVisible(false);
				loginPanel.setVisible(false);
				toGoPanel.setVisible(false);
				orderCheck.setVisible(false);
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
		/*
		checked = new ImageIcon(BurgerKingMain.class.getResource("/images/checkButton1.png"));
		unchecked = new ImageIcon(BurgerKingMain.class.getResource("/images/checkButton.png"));
		
		lblNewLabel = new JLabel("치즈와퍼+프렌치프라이(L)+콜라(L)");
		lblNewLabel.setForeground(new Color(87, 58, 52));
		lblNewLabel.setFont(new Font("나눔고딕", Font.PLAIN, 13));
		lblNewLabel.setBounds(57, 222, 243, 30);
		burgerCompositionPanel.add(lblNewLabel);

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

		JLabel compositionSelectLabel = new JLabel("원하시는 구성을 선택하세요");
		compositionSelectLabel.setForeground(new Color(87, 58, 52));
		compositionSelectLabel.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 20));
		compositionSelectLabel.setHorizontalAlignment(SwingConstants.CENTER);
		compositionSelectLabel.setBounds(21, 95, 265, 50);
		burgerCompositionPanel.add(compositionSelectLabel);

		for (int i = 0; i < 3; i++) {
			jb[i] = new JRadioButton();
			jb[i].setIcon(unchecked);
			jb[i].setSelectedIcon(checked);
			jb[i].setForeground(new Color(87, 58, 52));
			jb[i].setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 15));
			jb[i].setBackground(new Color(255, 254, 244));
			burgerCompositionPanel.add(jb[i]);
			bg.add(jb[i]);
		}

		jb[0].setText("치즈와퍼 라지 세트");
		jb[0].setBounds(35, 180, 265, 50);
		
		jb[1].setText("치즈와퍼 세트");
		jb[1].setBounds(35, 276, 265, 50);

		jb[2].setText("치즈와퍼 단품");
		jb[2].setBounds(35, 373, 265, 50);

		RoundedButton compositionBtn = new RoundedButton("확인");
		compositionBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!jb[0].isSelected() && !jb[1].isSelected() && !jb[2].isSelected()) {
					JOptionPane.showMessageDialog(null, "구성을 선택해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
				}
				else if(jb[0].isSelected()) {
					setSetName(index, 1);
					burgerCompositionPanel.setVisible(false);
					footerPanel.setVisible(true);
					selectedsetPanel.setVisible(true);
				}
				else if(jb[1].isSelected()){
					setSetName(index, 0);
					burgerCompositionPanel.setVisible(false);
					footerPanel.setVisible(true);
					selectedsetPanel.setVisible(true);
				}
				else if(jb[2].isSelected()) {
					setSingleName(index);
					burgerCompositionPanel.setVisible(false);
					footerPanel.setVisible(true);
					selectedsinglePanel.setVisible(true);
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
				scrollPanes.get(setMenuPanel).setVisible(true);
				totalPanel.setVisible(true);
			}
		});
		compositionToPreviousPage.setForeground(new Color(87, 58, 52));
		compositionToPreviousPage.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 17));
		*/
		
/*---------------------------------------------------------------selectedsetMenu 패널--------------------------------------------*/
		
		JLabel lblNewLabel_4 = new JLabel("선택한 메뉴를 확인해주세요");
		lblNewLabel_4.setForeground(new Color(87, 58, 52));
		lblNewLabel_4.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(12, 65, 270, 50);
		selectedsetPanel.add(lblNewLabel_4);
		
		ingredientLabel = new JLabel("치즈와퍼");
		ingredientLabel.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		ingredientLabel.setForeground(new Color(87, 58, 52));
		ingredientLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ingredientLabel.setBounds(81, 125, 139, 40);
		selectedsetPanel.add(ingredientLabel);
		
		sideLabel = new JLabel("프렌치프라이");
		sideLabel.setHorizontalAlignment(SwingConstants.CENTER);
		sideLabel.setForeground(new Color(87, 58, 52));
		sideLabel.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		sideLabel.setBounds(12, 235, 270, 40);
		selectedsetPanel.add(sideLabel);
		
		beverageLabel = new JLabel("코카콜라");
		beverageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		beverageLabel.setForeground(new Color(87, 58, 52));
		beverageLabel.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		beverageLabel.setBounds(31, 354, 224, 40);
		selectedsetPanel.add(beverageLabel);
		
		RoundedButton changeIngredientsbtn = new RoundedButton("재료 추가");
		changeIngredientsbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setIngredientName();
				selectedsetPanel.setVisible(false);
				ingredientPanel.setVisible(true);
			}
		});
		changeIngredientsbtn.setFont(new Font("나눔고딕", Font.BOLD, 15));
		changeIngredientsbtn.setForeground(new Color(255, 254, 244));
		changeIngredientsbtn.setBackground(new Color(87, 58, 52));
		changeIngredientsbtn.setBounds(91, 175, 120, 40);
		selectedsetPanel.add(changeIngredientsbtn);
		
		RoundedButton changeSidebtn = new RoundedButton("사이드 변경");
		changeSidebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setSideName(0);
				selectedsetPanel.setVisible(false);
				sideselectPanel.setVisible(true);
			}
		});
		changeSidebtn.setFont(new Font("나눔고딕", Font.BOLD, 15));
		changeSidebtn.setForeground(new Color(255, 254, 244));
		changeSidebtn.setBackground(new Color(87, 58, 52));
		changeSidebtn.setBounds(91, 291, 120, 40);
		selectedsetPanel.add(changeSidebtn);
		
		RoundedButton changeBeveragebtn = new RoundedButton("음료 변경");
		changeBeveragebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setbeverageName(0);
				selectedsetPanel.setVisible(false);
				beveragePanel.setVisible(true);
			}
		});
		changeBeveragebtn.setFont(new Font("나눔고딕", Font.BOLD, 15));
		changeBeveragebtn.setForeground(new Color(255, 254, 244));
		changeBeveragebtn.setBackground(new Color(87, 58, 52));
		changeBeveragebtn.setBounds(91, 411, 120, 40);
		selectedsetPanel.add(changeBeveragebtn);
		
		RoundedButton addToCartbtn = new RoundedButton("카트 담기");
		addToCartbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedsetPanel.setVisible(false);
				buttonPanel.setVisible(true);
				whopperPanel.setVisible(true);
				totalPanel.setVisible(true);
				footerPanel.setVisible(true);
				bg.clearSelection();
				bg1.clearSelection();
				bg2.clearSelection();
				ingredientjb[0].setSelected(false);
				ingredientjb[1].setSelected(false);
				ingredientjb[2].setSelected(false);
				singleingredientjb[0].setSelected(false);
				singleingredientjb[1].setSelected(false);
				singleingredientjb[2].setSelected(false);
			}
		});
		addToCartbtn.setFont(new Font("나눔고딕", Font.BOLD, 15));
		addToCartbtn.setForeground(new Color(255, 254, 244));
		addToCartbtn.setBackground(new Color(87, 58, 52));
		addToCartbtn.setBounds(31, 498, 243, 40);
		selectedsetPanel.add(addToCartbtn);
		
		JLabel toPreviousPage = new JLabel("X");
		toPreviousPage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedsetPanel.setVisible(false);
				burgerCompositionPanel.setVisible(true);
			}
		});
		toPreviousPage.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		toPreviousPage.setForeground(new Color(87, 58, 52));
		toPreviousPage.setHorizontalAlignment(SwingConstants.RIGHT);
		toPreviousPage.setBounds(222, 10, 60, 15);
		selectedsetPanel.add(toPreviousPage);
	
/*---------------------------------------------------------------selectedsinglePanel 패널--------------------------------------------*/
		JLabel lblNewLabel_5 = new JLabel("선택한 메뉴를 확인해주세요");
		lblNewLabel_5.setForeground(new Color(87, 58, 52));
		lblNewLabel_5.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(12, 65, 270, 50);
		selectedsinglePanel.add(lblNewLabel_5);
		
		ingredientLabel1 = new JLabel("치즈와퍼");
		ingredientLabel1.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		ingredientLabel1.setForeground(new Color(87, 58, 52));
		ingredientLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		ingredientLabel1.setBounds(81, 200, 139, 40);
		selectedsinglePanel.add(ingredientLabel1);
		
		
		RoundedButton changeIngredientsbtn1 = new RoundedButton("재료 추가");
		changeIngredientsbtn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setSingleIngredientName();
				singleIngredientPanel.setVisible(true);
				selectedsinglePanel.setVisible(false);
			}
		});
		changeIngredientsbtn1.setFont(new Font("나눔고딕", Font.BOLD, 15));
		changeIngredientsbtn1.setForeground(new Color(255, 254, 244));
		changeIngredientsbtn1.setBackground(new Color(87, 58, 52));
		changeIngredientsbtn1.setBounds(91, 250, 120, 40);
		selectedsinglePanel.add(changeIngredientsbtn1);
		
		
		RoundedButton addToCartbtn1 = new RoundedButton("카트 담기");
		addToCartbtn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedsinglePanel.setVisible(false);
				buttonPanel.setVisible(true);
				whopperPanel.setVisible(true);
				totalPanel.setVisible(true);
				footerPanel.setVisible(true);
				bg.clearSelection();
				bg1.clearSelection();
				bg2.clearSelection();
				ingredientjb[0].setSelected(false);
				ingredientjb[1].setSelected(false);
				ingredientjb[2].setSelected(false);
				singleingredientjb[0].setSelected(false);
				singleingredientjb[1].setSelected(false);
				singleingredientjb[2].setSelected(false);
			}
		});
		addToCartbtn1.setFont(new Font("나눔고딕", Font.BOLD, 15));
		addToCartbtn1.setForeground(new Color(255, 254, 244));
		addToCartbtn1.setBackground(new Color(87, 58, 52));
		addToCartbtn1.setBounds(31, 498, 243, 40);
		selectedsinglePanel.add(addToCartbtn1);
		
		JLabel toPreviousPage111 = new JLabel("X");
		toPreviousPage111.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedsinglePanel.setVisible(false);
				burgerCompositionPanel.setVisible(true);
			}
		});
		toPreviousPage111.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		toPreviousPage111.setForeground(new Color(87, 58, 52));
		toPreviousPage111.setHorizontalAlignment(SwingConstants.RIGHT);
		toPreviousPage111.setBounds(222, 10, 60, 15);
		selectedsinglePanel.add(toPreviousPage111);
	
/*----------------------------------------------------------ingredientPanel --------------------------------------------------*/
		
		for (int i = 0; i < 3; i++) {
			ingredientjb[i] = new JCheckBox();
			ingredientjb[i].setIcon(unchecked);
			ingredientjb[i].setSelectedIcon(checked);
			ingredientjb[i].setBackground(new Color(255, 254, 244));
			ingredientjb[i].setFont(new Font("나눔고딕", Font.BOLD, 17));
			ingredientjb[i].setForeground(new Color(87, 58, 52));
		}
		
		
		ingredientjb[0].setBounds(22, 159, 220, 40);
		ingredientjb[1].setBounds(22, 255, 220, 40);
		ingredientjb[2].setBounds(22, 353, 220, 40);
		
		
		JLabel addIngredientLabel = new JLabel("재료 추가");
		addIngredientLabel.setForeground(new Color(87, 58, 52));
		addIngredientLabel.setFont(new Font("나눔고딕", Font.BOLD, 18));
		addIngredientLabel.setBounds(22, 84, 234, 40);
		ingredientPanel.add(addIngredientLabel);
		ingredientPanel.add(ingredientjb[0]);
		ingredientPanel.add(ingredientjb[1]);
		ingredientPanel.add(ingredientjb[2]);
		
		RoundedButton btnNewButton_1 = new RoundedButton("확인");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ingredientPanel.setVisible(false);
				selectedsetPanel.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		btnNewButton_1.setForeground(new Color(255, 254, 244));
		btnNewButton_1.setBackground(new Color(87, 58, 52));
		btnNewButton_1.setBounds(22, 499, 249, 50);
		ingredientPanel.add(btnNewButton_1);
		
		JLabel toPreviousPage1 = new JLabel("X");
		toPreviousPage1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ingredientPanel.setVisible(false);
				selectedsetPanel.setVisible(true);
			}
		});
		toPreviousPage1.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		toPreviousPage1.setForeground(new Color(87, 58, 52));
		toPreviousPage1.setHorizontalAlignment(SwingConstants.RIGHT);
		toPreviousPage1.setBounds(222, 10, 60, 15);
		ingredientPanel.add(toPreviousPage1);
		
/*----------------------------------------------------------singleingredientPanel --------------------------------------------------*/
		
		for (int i = 0; i < 3; i++) {
			singleingredientjb[i] = new JCheckBox();
			singleingredientjb[i].setIcon(unchecked);
			singleingredientjb[i].setSelectedIcon(checked);
			singleingredientjb[i].setBackground(new Color(255, 254, 244));
			singleingredientjb[i].setFont(new Font("나눔고딕", Font.BOLD, 17));
			singleingredientjb[i].setForeground(new Color(87, 58, 52));
		}
		
		
		singleingredientjb[0].setBounds(22, 159, 220, 40);
		singleingredientjb[1].setBounds(22, 255, 220, 40);
		singleingredientjb[2].setBounds(22, 353, 220, 40);
		
		
		JLabel addIngredientLabel1 = new JLabel("재료 추가");
		addIngredientLabel1.setForeground(new Color(87, 58, 52));
		addIngredientLabel1.setFont(new Font("나눔고딕", Font.BOLD, 18));
		addIngredientLabel1.setBounds(22, 84, 234, 40);
		singleIngredientPanel.add(addIngredientLabel1);
		singleIngredientPanel.add(singleingredientjb[0]);
		singleIngredientPanel.add(singleingredientjb[1]);
		singleIngredientPanel.add(singleingredientjb[2]);
		
		RoundedButton btnNewButton_11 = new RoundedButton("확인");
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				singleIngredientPanel.setVisible(false);
				selectedsinglePanel.setVisible(true);
			}
		});
		btnNewButton_11.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		btnNewButton_11.setForeground(new Color(255, 254, 244));
		btnNewButton_11.setBackground(new Color(87, 58, 52));
		btnNewButton_11.setBounds(22, 499, 249, 50);
		singleIngredientPanel.add(btnNewButton_11);
		
		JLabel toPreviousPage11 = new JLabel("X");
		toPreviousPage11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				singleIngredientPanel.setVisible(false);
				selectedsinglePanel.setVisible(true);
			}
		});
		toPreviousPage11.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		toPreviousPage11.setForeground(new Color(87, 58, 52));
		toPreviousPage11.setHorizontalAlignment(SwingConstants.RIGHT);
		toPreviousPage11.setBounds(222, 10, 60, 15);
		singleIngredientPanel.add(toPreviousPage11);
		
/*----------------------------------------------------------sideselectPanel --------------------------------------------------*/
		
		for (int i = 0; i < 4; i++) {
			sidejb[i] = new JRadioButton();
			sidejb[i].setIcon(unchecked);
			sidejb[i].setSelectedIcon(checked);
			sidejb[i].setBackground(new Color(255, 254, 244));
			sidejb[i].setFont(new Font("나눔고딕", Font.BOLD, 17));
			sidejb[i].setForeground(new Color(87, 58, 52));
			bg1.add(sidejb[i]);
		}
		
		sidejb[0].setBounds(22, 129, 220, 40);
		sidejb[1].setBounds(22, 225, 220, 40);
		sidejb[2].setBounds(22, 323, 220, 40);
		sidejb[3].setBounds(22, 423, 220, 40);
		
		JLabel addsideLabel = new JLabel("사이드 변경");
		addsideLabel.setForeground(new Color(87, 58, 52));
		addsideLabel.setFont(new Font("나눔고딕", Font.BOLD, 18));
		addsideLabel.setBounds(22, 54, 234, 40);
		sideselectPanel.add(addsideLabel);
		sideselectPanel.add(sidejb[0]);
		sideselectPanel.add(sidejb[1]);
		sideselectPanel.add(sidejb[2]);
		sideselectPanel.add(sidejb[3]);
		
		RoundedButton btnNewButton_2 = new RoundedButton("확인");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sideselectPanel.setVisible(false);
				selectedsetPanel.setVisible(true);
				if(sidejb[0].isSelected()) sideLabel.setText(changeSide[0]);
				else if(sidejb[1].isSelected()) sideLabel.setText(changeSide[1]);
				else if(sidejb[2].isSelected()) sideLabel.setText(changeSide[2]);
				else if(sidejb[3].isSelected()) sideLabel.setText(changeSide[3]);
			}
		});
		btnNewButton_2.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		btnNewButton_2.setForeground(new Color(255, 254, 244));
		btnNewButton_2.setBackground(new Color(87, 58, 52));
		btnNewButton_2.setBounds(22, 499, 249, 50);
		sideselectPanel.add(btnNewButton_2);
		
		JLabel toPreviousPage2 = new JLabel("X");
		toPreviousPage2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				sideselectPanel.setVisible(false);
				selectedsetPanel.setVisible(true);
			}
		});
		toPreviousPage2.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		toPreviousPage2.setForeground(new Color(87, 58, 52));
		toPreviousPage2.setHorizontalAlignment(SwingConstants.RIGHT);
		toPreviousPage2.setBounds(222, 10, 60, 15);
		sideselectPanel.add(toPreviousPage2);
		
/*----------------------------------------------------------beveragePanel --------------------------------------------------*/
		
		for (int i = 0; i < 4; i++) {
			beveragejb[i] = new JRadioButton();
			beveragejb[i].setIcon(unchecked);
			beveragejb[i].setSelectedIcon(checked);
			beveragejb[i].setBackground(new Color(255, 254, 244));
			beveragejb[i].setFont(new Font("나눔고딕", Font.BOLD, 17));
			beveragejb[i].setForeground(new Color(87, 58, 52));
			bg2.add(beveragejb[i]);
		}
		
		beveragejb[0].setBounds(22, 159, 220, 40);
		beveragejb[1].setBounds(22, 235, 220, 40);
		beveragejb[2].setBounds(22, 313, 220, 40);
		beveragejb[3].setBounds(22, 393, 220, 40);
		
		JLabel addbeverageLabel = new JLabel("음료 변경");
		addbeverageLabel.setForeground(new Color(87, 58, 52));
		addbeverageLabel.setFont(new Font("나눔고딕", Font.BOLD, 18));
		addbeverageLabel.setBounds(22, 84, 234, 40);
		beveragePanel.add(addbeverageLabel);
		beveragePanel.add(beveragejb[0]);
		beveragePanel.add(beveragejb[1]);
		beveragePanel.add(beveragejb[2]);
		beveragePanel.add(beveragejb[3]);
		
		RoundedButton btnNewButton_3 = new RoundedButton("확인");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedsetPanel.setVisible(true);
				beveragePanel.setVisible(false);
				if(beveragejb[0].isSelected()) beverageLabel.setText(changeBeverage[0]);
				else if(beveragejb[1].isSelected()) beverageLabel.setText(changeBeverage[1]);
				else if(beveragejb[2].isSelected()) beverageLabel.setText(changeBeverage[2]);
				else if(beveragejb[3].isSelected()) beverageLabel.setText(changeBeverage[3]);
			}
		});
		btnNewButton_3.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		btnNewButton_3.setForeground(new Color(255, 254, 244));
		btnNewButton_3.setBackground(new Color(87, 58, 52));
		btnNewButton_3.setBounds(22, 499, 249, 50);
		beveragePanel.add(btnNewButton_3);
		
		JLabel toPreviousPage3 = new JLabel("X");
		toPreviousPage3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedsetPanel.setVisible(true);
				beveragePanel.setVisible(false);
			}
		});
		toPreviousPage3.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		toPreviousPage3.setForeground(new Color(87, 58, 52));
		toPreviousPage3.setHorizontalAlignment(SwingConstants.RIGHT);
		toPreviousPage3.setBounds(222, 10, 60, 15);
		beveragePanel.add(toPreviousPage3);
<<<<<<< HEAD
		
/*----------------------------------------------------------toGoPanel --------------------------------------------------*/
		
		for (int i = 0; i < 2; i++) {
			whereToEatjb[i] = new JRadioButton();
			whereToEatjb[i].setIcon(unchecked);
			whereToEatjb[i].setSelectedIcon(checked);
			whereToEatjb[i].setBackground(new Color(255, 254, 244));
			whereToEatjb[i].setFont(new Font("나눔고딕", Font.BOLD, 17));
			whereToEatjb[i].setForeground(new Color(87, 58, 52));
			bg3.add(whereToEatjb[i]);
		}
		
		whereToEatjb[0].setText(whereToEat[0]);
		whereToEatjb[1].setText(whereToEat[1]);
		whereToEatjb[0].setBounds(22, 159, 220, 40);
		whereToEatjb[1].setBounds(22, 255, 220, 40);
	
		
		JLabel chooseToGoLabel = new JLabel("선택해주세요");
		chooseToGoLabel.setForeground(new Color(87, 58, 52));
		chooseToGoLabel.setFont(new Font("나눔고딕", Font.BOLD, 18));
		chooseToGoLabel.setBounds(22, 84, 234, 40);
		toGoPanel.add(chooseToGoLabel);
		toGoPanel.add(whereToEatjb[0]);
		toGoPanel.add(whereToEatjb[1]);
		
		JLabel lblNewLabel_6 = new JLabel("----------------------------------------------------------------");
		lblNewLabel_6.setBounds(20, 125, 258, 15);
		lblNewLabel_6.setForeground(new Color(87, 58, 52));
		toGoPanel.add(lblNewLabel_6);
		
		RoundedButton btnNewButton_111 = new RoundedButton("확인");
		btnNewButton_111.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		btnNewButton_111.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toGoPanel.setVisible(false);
				orderCheck.setVisible(true);
				labelPanel.setVisible(true);
				labelFooter.setVisible(true);
			}
		});
		btnNewButton_111.setForeground(new Color(255, 254, 244));
		btnNewButton_111.setBackground(new Color(87, 58, 52));
		btnNewButton_111.setBounds(22, 499, 249, 50);
		toGoPanel.add(btnNewButton_111);
		
		JLabel toPreviousPage1111 = new JLabel("X");
		toPreviousPage1111.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				toGoPanel.setVisible(false);
				buttonPanel.setVisible(true);
				whopperPanel.setVisible(true);
				totalPanel.setVisible(true);
				footerPanel.setVisible(true);
			}
		});
		toPreviousPage1111.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		toPreviousPage1111.setForeground(new Color(87, 58, 52));
		toPreviousPage1111.setHorizontalAlignment(SwingConstants.RIGHT);
		toPreviousPage1111.setBounds(222, 10, 60, 15);
		toGoPanel.add(toPreviousPage1111);
/*--------------------------------------------------------------orderCheckPanel---------------------------------------------------*/
		
		//주문확인 패널
			
		orderPanel = new JPanel();
		orderPanel.setBounds(10, 10, 280, 180);
		orderPanel.setBackground(new Color(255, 254, 244));
		orderCheck.add(orderPanel);
		orderPanel.setLayout(null);
		
		JLabel orderMenuLabel = new JLabel("치즈와퍼세트");
		orderMenuLabel.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		orderMenuLabel.setForeground(new Color(87, 58, 52));
		orderMenuLabel.setBounds(12, 6, 95, 20);
		orderPanel.add(orderMenuLabel);
		
		JLabel menuPrice = new JLabel("9000" + "원");
		menuPrice.setForeground(new Color(255, 0, 0));
		menuPrice.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		menuPrice.setBounds(12, 32, 67, 15);
		orderPanel.add(menuPrice);
		
		JLabel lblNewLabel_61_1 = new JLabel("----------------------------------------------------------------");
		lblNewLabel_61_1.setForeground(new Color(87, 58, 52));
		lblNewLabel_61_1.setBounds(0, 48, 258, 15);
		orderPanel.add(lblNewLabel_61_1);
		
		JLabel sideOrderLabel = new JLabel("사이드");
		sideOrderLabel.setForeground(new Color(87, 58, 52));
		sideOrderLabel.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		sideOrderLabel.setBounds(12, 60, 50, 15);
		orderPanel.add(sideOrderLabel);
		
		JLabel sideOrderLabel_1 = new JLabel("수량");
		sideOrderLabel_1.setForeground(new Color(87, 58, 52));
		sideOrderLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		sideOrderLabel_1.setBounds(12, 91, 50, 15);
		orderPanel.add(sideOrderLabel_1);
		
		JLabel lblNewLabel_61_1_1 = new JLabel("----------------------------------------------------------------");
		lblNewLabel_61_1_1.setForeground(new Color(87, 58, 52));
		lblNewLabel_61_1_1.setBounds(0, 73, 258, 15);
		orderPanel.add(lblNewLabel_61_1_1);
		
		JLabel sideOrder = new JLabel("코울슬로" + " 교환");
		sideOrder.setHorizontalAlignment(SwingConstants.RIGHT);
		sideOrder.setForeground(new Color(87, 58, 52));
		sideOrder.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		sideOrder.setBounds(149, 60, 95, 15);
		orderPanel.add(sideOrder);
		
		JLabel lblNewLabel_61_1_1_1 = new JLabel("----------------------------------------------------------------");
		lblNewLabel_61_1_1_1.setForeground(new Color(87, 58, 52));
		lblNewLabel_61_1_1_1.setBounds(0, 108, 258, 15);
		orderPanel.add(lblNewLabel_61_1_1_1);
		
		JLabel totalOrderPriceLabel = new JLabel("합계금액");
		totalOrderPriceLabel.setForeground(new Color(87, 58, 52));
		totalOrderPriceLabel.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		totalOrderPriceLabel.setBounds(12, 125, 95, 15);
		orderPanel.add(totalOrderPriceLabel);
		
		JLabel totalOrderPrice = new JLabel("18000" + " 원");
		totalOrderPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		totalOrderPrice.setForeground(new Color(255, 0, 0));
		totalOrderPrice.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		totalOrderPrice.setBounds(149, 125, 95, 15);
		orderPanel.add(totalOrderPrice);
		
		JLabel menuCount = new JLabel("2");
		menuCount.setForeground(new Color(87, 58, 52));
		menuCount.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		menuCount.setHorizontalAlignment(SwingConstants.CENTER);
		menuCount.setBounds(186, 91, 29, 15);
		orderPanel.add(menuCount);
		
		JLabel minus = new JLabel("");
		minus.setIcon(new ImageIcon(BurgerKingMain.class.getResource("/images/minus.png")));
		minus.setBounds(159, 87, 29, 20);
		orderPanel.add(minus);
		
		JLabel plus = new JLabel("");
		plus.setIcon(new ImageIcon(BurgerKingMain.class.getResource("/images/plus.png")));
		plus.setBounds(215, 87, 29, 20);
		orderPanel.add(plus);
		
		
		//메뉴 선택 두번째
		orderPanel1 = new JPanel();
		orderPanel1.setBounds(10, 210, 280, 180);
		orderPanel1.setBackground(new Color(255, 254, 244));
		orderCheck.add(orderPanel1);
		orderPanel1.setLayout(null);
		
		JLabel orderMenuLabel1 = new JLabel("치즈와퍼세트");
		orderMenuLabel1.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		orderMenuLabel1.setForeground(new Color(87, 58, 52));
		orderMenuLabel1.setBounds(12, 6, 95, 20);
		orderPanel1.add(orderMenuLabel1);
		
		JLabel menuPrice1 = new JLabel("9000" + "원");
		menuPrice1.setForeground(new Color(255, 0, 0));
		menuPrice1.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		menuPrice1.setBounds(12, 32, 67, 15);
		orderPanel1.add(menuPrice1);
		
		JLabel lblNewLabel_61_11 = new JLabel("----------------------------------------------------------------");
		lblNewLabel_61_11.setForeground(new Color(87, 58, 52));
		lblNewLabel_61_11.setBounds(0, 48, 258, 15);
		orderPanel1.add(lblNewLabel_61_11);
		
		JLabel sideOrderLabel1 = new JLabel("사이드");
		sideOrderLabel1.setForeground(new Color(87, 58, 52));
		sideOrderLabel1.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		sideOrderLabel1.setBounds(12, 60, 50, 15);
		orderPanel1.add(sideOrderLabel1);
		
		JLabel sideOrderLabel_11 = new JLabel("수량");
		sideOrderLabel_11.setForeground(new Color(87, 58, 52));
		sideOrderLabel_11.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		sideOrderLabel_11.setBounds(12, 91, 50, 15);
		orderPanel1.add(sideOrderLabel_11);
		
		JLabel lblNewLabel_61_1_11 = new JLabel("----------------------------------------------------------------");
		lblNewLabel_61_1_11.setForeground(new Color(87, 58, 52));
		lblNewLabel_61_1_11.setBounds(0, 73, 258, 15);
		orderPanel1.add(lblNewLabel_61_1_11);
		
		JLabel sideOrder1 = new JLabel("코울슬로" + " 교환");
		sideOrder1.setHorizontalAlignment(SwingConstants.RIGHT);
		sideOrder1.setForeground(new Color(87, 58, 52));
		sideOrder1.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		sideOrder1.setBounds(149, 60, 95, 15);
		orderPanel1.add(sideOrder1);
		
		JLabel lblNewLabel_61_1_1_11 = new JLabel("----------------------------------------------------------------");
		lblNewLabel_61_1_1_11.setForeground(new Color(87, 58, 52));
		lblNewLabel_61_1_1_11.setBounds(0, 108, 258, 15);
		orderPanel1.add(lblNewLabel_61_1_1_11);
		
		JLabel totalOrderPriceLabel1 = new JLabel("합계금액");
		totalOrderPriceLabel1.setForeground(new Color(87, 58, 52));
		totalOrderPriceLabel1.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		totalOrderPriceLabel1.setBounds(12, 125, 95, 15);
		orderPanel1.add(totalOrderPriceLabel1);
		
		JLabel totalOrderPrice1 = new JLabel("18000" + " 원");
		totalOrderPrice1.setHorizontalAlignment(SwingConstants.RIGHT);
		totalOrderPrice1.setForeground(new Color(255, 0, 0));
		totalOrderPrice1.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		totalOrderPrice1.setBounds(149, 125, 95, 15);
		orderPanel1.add(totalOrderPrice1);
		
		JLabel menuCount1 = new JLabel("2");
		menuCount1.setForeground(new Color(87, 58, 52));
		menuCount1.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		menuCount1.setHorizontalAlignment(SwingConstants.CENTER);
		menuCount1.setBounds(186, 91, 29, 15);
		orderPanel1.add(menuCount1);
		
		JLabel minus1 = new JLabel("");
		minus1.setIcon(new ImageIcon(BurgerKingMain.class.getResource("/images/minus.png")));
		minus1.setBounds(159, 87, 29, 20);
		orderPanel1.add(minus1);
		
		JLabel plus1 = new JLabel("");
		plus1.setIcon(new ImageIcon(BurgerKingMain.class.getResource("/images/plus.png")));
		plus1.setBounds(215, 87, 29, 20);
		orderPanel1.add(plus1);
		
		orderPanel2 = new JPanel();
		orderPanel2.setBounds(10, 490, 280, 180);
		orderPanel2.setBackground(new Color(255, 254, 244));
		orderCheck.add(orderPanel2);
		orderPanel2.setLayout(null);
		
/*--------------------------------------------------------주문확인 header------------------------------------------------------------*/
		JLabel orderCheckLabel = new JLabel("주문확인");
		orderCheckLabel.setForeground(new Color(87, 58, 52));
		orderCheckLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		orderCheckLabel.setHorizontalAlignment(SwingConstants.CENTER);
		orderCheckLabel.setBounds(0, 63, 300, 26);
		labelPanel.add(orderCheckLabel);

/*----------------------------------------------------------주문확인 footer-----------------------------------------------------------*/

				// 총 주문 금액
		JLabel totalPriceLabel1 = new JLabel(totalPrice + "원");
		totalPriceLabel1.setForeground(new Color(255, 0, 0));
		totalPriceLabel1.setHorizontalAlignment(SwingConstants.RIGHT);
		totalPriceLabel1.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 15));
		totalPriceLabel1.setBounds(207, 14, 79, 15);
		labelFooter.add(totalPriceLabel1);

				// 결제하기 버튼
		RoundedButton payButton1 = new RoundedButton("결제하기");
		payButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toGoPanel.setVisible(true);
				totalPanel.setVisible(false);
				buttonPanel.setVisible(false);
				whopperPanel.setVisible(false);
				burgerCompositionPanel.setVisible(false);
			}
		});
		payButton1.setForeground(new Color(255, 255, 255));
		payButton1.setBackground(Color.RED);
		payButton1.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 15));
		payButton1.setBounds(175, 97, 100, 23);
		labelFooter.add(payButton1);

				// 결제 취소 버튼
		RoundedButton cancelButton1 = new RoundedButton("취소");
		cancelButton1.setForeground(new Color(255, 255, 255));
		cancelButton1.setBackground(new Color(87, 58, 52));
		cancelButton1.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 15));
		cancelButton1.setBounds(34, 97, 100, 23);
		labelFooter.add(cancelButton1);

				// 총 주문금액
		JLabel totalPriceLabel21 = new JLabel("총 주문금액");
		totalPriceLabel21.setFont(new Font("나눔고딕", Font.BOLD, 15));
		totalPriceLabel21.setHorizontalAlignment(SwingConstants.CENTER);
		totalPriceLabel21.setBounds(140, 14, 86, 15);
		labelFooter.add(totalPriceLabel21);

				

		JLabel yellowFooter1 = new JLabel(" ");
		yellowFooter1.setForeground(new Color(245, 233, 171));
		yellowFooter1.setBackground(new Color(255, 254, 244));
		yellowFooter1.setBounds(0, 0, 312, 136);
		yellowFooter1.setOpaque(true);
		labelFooter.add(yellowFooter1);

	
=======
>>>>>>> main
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
	
	// 스크롤팬을 보이지 않게 하여 메뉴 선택 시 옵션을 선택하는 패널을 바꾸어주는 메서드
	private void nextComposition(JScrollPane scrollPane, JPanel next) {
		scrollPane.setVisible(false);
		buttonPanel.setVisible(false);
		totalPanel.setVisible(false);
		next.setVisible(true);
	}

	// composition 메뉴 이름을 바꾸어주는 메소드
	private void setCompositionName(int whopperNum) {
		lblNewLabel.setText(whopperName[whopperNum] + "+프렌치프라이(L)+콜라(L)");
		lblNewLabel2.setText(whopperName[whopperNum] + " 단품");
		lblNewLabel3.setText(whopperName[whopperNum]+" 프렌치프라이(R)+콜라(R)");
		jb[0].setText(whopperName[whopperNum] + " 라지 세트");
		jb[1].setText(whopperName[whopperNum] + " 세트");
		jb[2].setText(whopperName[whopperNum] + " 단품");
	}
	
	//selectedSetPanel 이름 바꾸어주는 메소드
	private void setSetName(int whopperNum, int setNum) {
		ingredientLabel.setText(whopperName[whopperNum]);
		sideLabel.setText("프렌치프라이" + setMenu[setNum]);
		beverageLabel.setText("코카콜라" + setMenu[setNum]);
	}
	
	//selectedSetPanel 이름 바꾸어주는 메소드
	private void setSingleName(int whopperNum) {
		ingredientLabel1.setText(whopperName[whopperNum]);
	}
	
	// 재료 추가 메뉴 이름을 바꾸어주는 메소드
	private void setIngredientName() {
		for(int i = 0; i < 3; i++) {
			ingredientjb[i].setText(changeIngredient[i] + " 추가");
		}
	}
	
	// 단품 재료 추가 메뉴 이름을 바꾸어주는 메소드
	private void setSingleIngredientName() {
		for(int i = 0; i < 3; i++) {
			singleingredientjb[i].setText(changeIngredient[i] + " 추가");
		}
	}
	
	// 사이드 메뉴 이름을 바꾸어주는 메소드
	private void setSideName(int sideNum) {
		for(int i = 0; i < 4; i++) {
			sidejb[i].setText(changeSide[i]);
		}
	}
	
	// 음료 추가 메뉴 이름을 바꾸어주는 메소드
	private void setbeverageName(int sideNum) {
		for(int i = 0; i < 4; i++) {
			beveragejb[i].setText(changeBeverage[i]);
		}
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
