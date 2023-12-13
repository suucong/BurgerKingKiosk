package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import jdbc.MysqlJdbc;
import model.dao.AdminDAO;
import model.dao.MenuDAO;
import model.dto.MenuByTypeDTO;
import model.vo.MenuTypeVO;
import model.vo.MenuVO;
import model.vo.OrderMenuVO;

import java.util.ArrayList;
import java.util.List;

public class BurgerKingMain extends JFrame {
	private int totalPrice = 0;
	private int count = 0;
	private List<MenuByTypeDTO> menuByTypeDTOs;	// 타입의 정보와 타입에 따른 메뉴 리스트를 가져오는 MenuByDTO List
	private List<RoundedButton> typeButtons = new ArrayList<RoundedButton>();	// 메뉴 타입들을 선택할 수 있게 해주는 버튼
	private List<JPanel> menuByTypePanels = new ArrayList<JPanel>();	// 타입별 메뉴를 보여줄 패널
	private List<JScrollPane> scrollPanes = new ArrayList<JScrollPane>();	// menuByTypePanels에 사용될 스크롤팬
	private int type_index = 0;	// 어떤 메뉴 타입 패널이 선택되었는지 구분하는 변수
	private int menubytype_index = 0;	// 어떤 타입에 따른 메뉴가 선택되었는지 구분하는 변수
	private ArrayList<OrderMenuVO> basket = new ArrayList<OrderMenuVO>();	// 메뉴를 담을 장바구니

	private JFrame frmBurgerkingKiosk;

	// for AdminPWManager
	private JPasswordField setPW1;
	private JPasswordField setPW2;
	private String pw = "";
	private String pw2 = "";
	private JPanel AdminPWPanel;
	private JPanel AdminSuccessPanel;
	
	//for Login
	private JPanel loginPanel;
	private JPasswordField enterPW;
	private String pw3 = "";

	//for UserStartManager
	private JPanel UserStartManagerPanel;
	
	// for 메뉴 선택 메인 화면
	private JPanel buttonPanel;
	private JPanel footerPanel;
	// for 장바구니 화면
	private JPanel basketHeaderPanel;
	private JPanel basketListPanel;
	private JScrollPane basketScroll;
	private JPanel basketFooterPanel;
	private JLabel totalPriceLabel;
	private JLabel countLabel;
	
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
		frmBurgerkingKiosk.setLocationRelativeTo(null);
		
		// PW 저장하는 패널
		AdminPWPanel = new JPanel();
		AdminPWPanel.setBackground(new Color(255, 254, 244));
		AdminPWPanel.setBounds(0, 0, 312, 618);
		AdminPWPanel.setOpaque(true);
		frmBurgerkingKiosk.getContentPane().add(AdminPWPanel);
		AdminPWPanel.setLayout(null);
		
		//Login 패널
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
		
		// 장바구니 정보를 나타내는 패널과 스크롤팬 구성
  		basketHeaderPanel = new JPanel();
  		basketHeaderPanel.setBackground(new Color(252, 248, 228));
  		basketHeaderPanel.setBounds(0, 442, 312, 43);	// 136
  		basketHeaderPanel.setVisible(false);
  		basketHeaderPanel.setLayout(null);
  		frmBurgerkingKiosk.getContentPane().add(basketHeaderPanel);
  		
  		basketListPanel = new JPanel();
  		basketListPanel.setBackground(new Color(252, 248, 228));
  		basketListPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
	  	
  		// 스크롤 가능한 패널 생성
        basketScroll = new JScrollPane(basketListPanel);
        basketScroll.setBorder(null);	// 테두리 없애기
        basketScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER); // 가로 스크롤 막기
        frmBurgerkingKiosk.getContentPane().add(basketScroll);
        basketScroll.setBounds(0, 485, 312, 60);
        basketScroll.setVisible(false);
        
        basketFooterPanel = new JPanel();
        basketFooterPanel.setBackground(new Color(252, 248, 228));
        basketFooterPanel.setBounds(0, 545, 312, 33);
        basketFooterPanel.setLayout(null);
        basketFooterPanel.setVisible(false);
  		frmBurgerkingKiosk.getContentPane().add(basketFooterPanel);

		// 설정과 나가기 버튼을 붙일 footer 패널
		footerPanel = new JPanel();
		footerPanel.setOpaque(true);
		footerPanel.setLayout(null);
		footerPanel.setBounds(0, 578, 312, 40);
		footerPanel.setVisible(false);
		frmBurgerkingKiosk.getContentPane().add(footerPanel);
		
/*---------------------------------------------------관리자 비밀번호 설정 여부 확인---------------------------------------------------------------*/
		
		if(AdminDAO.isAdminTableNotEmpty()) {	// 관리자 테이블에 계정이 존재 하면 관리자 로그인 화면
			AdminPWPanel.setVisible(false);
			loginPanel.setVisible(true);
		}
		else {	// 관리자 테이블에 계정이 존재하지 않으면 관리자 비밀번호 설정 화면
			AdminPWPanel.setVisible(true);
			loginPanel.setVisible(false);
		}
		
/*------------------------------------------------------ 관리자 패스워드 지정 Screen -----------------------------------------------------*/

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
							nextPanel(AdminPWPanel, AdminSuccessPanel);
							
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
		
/*------------------------------------------------------- Login Screen ----------------------------------------------------------------*/
		
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
							nextPanel(loginPanel, AdminSuccessPanel);
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
		
/*------------------------------------------------------ 관리자 화면 ----------------------------------------------------------*/
		
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

/*-------------------------------------------------------- 사용자 결제 시작 화면 ------------------------------------------------------------*/
		
		UserStartManagerPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UserStartManagerPanel.setVisible(false);
				setMenuScreenVisible(true);
			}
		});
		
		JPanel redpanel = new JPanel();
		redpanel.setBackground(Color.RED);
		redpanel.setBounds(0, 460, 312, 158);
		UserStartManagerPanel.add(redpanel);
		redpanel.setLayout(null);
		
		JLabel touchLabel = new JLabel("화면을 터치하세요!");
		touchLabel.setBounds(65, 25, 179, 33);
		redpanel.add(touchLabel);
		touchLabel.setHorizontalAlignment(SwingConstants.CENTER);
		touchLabel.setForeground(Color.WHITE);
		touchLabel.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 20));
		
		JLabel lblNewLabel_1 = new JLabel("Burger");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(87, 58, 52));
		lblNewLabel_1.setFont(new Font("Modak", Font.PLAIN, 40));
		lblNewLabel_1.setBounds(87, 81, 130, 50);
		UserStartManagerPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("King");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(new Color(87, 58, 52));
		lblNewLabel_2.setFont(new Font("Modak", Font.PLAIN, 40));
		lblNewLabel_2.setBounds(109, 131, 92, 50);
		UserStartManagerPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon(BurgerKingMain.class.getResource("/images/startLogoImage.png")));
		lblNewLabel_3.setIcon(new ImageIcon(BurgerKingMain.class.getResource("/images/startLogoImage.png")));
		lblNewLabel_3.setBounds(76, 193, 155, 173);
		UserStartManagerPanel.add(lblNewLabel_3);
		setSize(312, 646);
		
/*--------------------------------------------- Menu Screen -------------------------------------------------------*/
		
		try {
            // 모든 Type 정보에 대해 isVisible이 1인 Menu 정보 가져오기
            menuByTypeDTOs = MenuDAO.getMenuByTypes();

            for (int i = 0; i < menuByTypeDTOs.size(); i++) {
                MenuTypeVO menuTypeVo = menuByTypeDTOs.get(i).getMenuTypeVo();
                ArrayList<MenuVO> menuVos = menuByTypeDTOs.get(i).getMenuVos();

                // 메뉴 타입 버튼 생성
                RoundedButton typeButton = new RoundedButton(menuTypeVo.getName());
        		typeButton.setBackground(new Color(250, 242, 205));
        		typeButton.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 15));
        		buttonPanel.add(typeButton);
        		typeButtons.add(typeButton);
        		
        		// 타입별로 메뉴 패널 생성 및 menuPanels에 추가
        		JPanel menuPanel = new JPanel();
        		menuPanel.setBackground(new Color(255, 253, 240));
        		menuPanel.setLayout(new GridLayout(0, 3));
        		menuPanel.setVisible(true);
        		menuByTypePanels.add(menuPanel);
        		
        		// 스크롤 가능한 패널 생성
                JScrollPane scrollPane = new JScrollPane(menuPanel);
                scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); // 가로 스크롤 막기
                scrollPane.setBounds(0, 99, 312, 343);
                scrollPane.setBorder(null);	// 테두리 없애기
                frmBurgerkingKiosk.getContentPane().add(scrollPane);
                scrollPane.setVisible(false);
                scrollPanes.add(scrollPane);
                
                for (int j = 0; j < menuVos.size(); j++) {
                	int currentIndex = j;
            		JPanel menu = new JPanel();
            		menu.setOpaque(false);
            		menu.setPreferredSize(new Dimension(94, 95));
            		if (!menuByTypePanels.isEmpty())	menuByTypePanels.get(i).add(menu);
            		menu.setLayout(null);
            		menu.addMouseListener(new MouseAdapter() {
            			@Override
            			public void mouseClicked(MouseEvent e) {
            				menubytype_index = currentIndex;	// 어떤 타입 별 메뉴 번호(menubytype_index)가 눌렸는지 업데이트
        					basket.add(new OrderMenuVO(menuVos.get(menubytype_index).getId()));
        					totalPrice += menuVos.get(menubytype_index).getPrice();
        					count++;
        					System.out.println("basket size: " + basket.size());
        					updateBasketPanel();
            			}
            		});

            		JLabel menuName = new JLabel(menuVos.get(j).getName());
            		menuName.setBounds(0, 63, 94, 15);
            		menu.add(menuName);
            		menuName.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 13));
            		menuName.setHorizontalAlignment(SwingConstants.CENTER);

            		JLabel menuPrice = new JLabel(menuVos.get(j).getPrice()+"원~");
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
			            	type_index = currentIndex;	// type_index에 현재 선택된 타입이 무엇인지 업데이트
			            	scrollPanes.get(type_index).setVisible(true);
			            }
					}
				});
            }
            
            scrollPanes.get(type_index).setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }

/*------------------------------------------------------------- totalPanel -------------------------------------------------------------------------*/
  		
  		// 카트
		JLabel cart = new JLabel("카트");
		cart.setHorizontalAlignment(SwingConstants.CENTER);
		cart.setFont(new Font("나눔고딕", Font.BOLD, 15));
		cart.setBounds(18, 14, 29, 15);
		basketHeaderPanel.add(cart);
  		
  		// 총 메뉴 주문 개수
		countLabel = new JLabel(count+"");
		countLabel.setForeground(new Color(255, 255, 255));
		countLabel.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 15));
		countLabel.setHorizontalAlignment(SwingConstants.CENTER);
		countLabel.setBounds(71, 14, 29, 15);
		basketHeaderPanel.add(countLabel);

		RoundedButton btnNewButton = new RoundedButton(" ");
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.setEnabled(false);
		btnNewButton.setBounds(60, 11, 50, 23);
		basketHeaderPanel.add(btnNewButton);
  		
  		// 총 주문금액
		JLabel totalPriceLabel2 = new JLabel("총 주문금액");
		totalPriceLabel2.setFont(new Font("나눔고딕", Font.BOLD, 15));
		totalPriceLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		totalPriceLabel2.setBounds(140, 14, 86, 15);
		basketHeaderPanel.add(totalPriceLabel2);
		
		// 총 주문 금액
		totalPriceLabel = new JLabel(totalPrice + "원");
		totalPriceLabel.setForeground(new Color(255, 0, 0));
		totalPriceLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		totalPriceLabel.setFont(new Font("Dialog", Font.BOLD, 13));
		totalPriceLabel.setBounds(227, 14, 79, 15);
		basketHeaderPanel.add(totalPriceLabel);
  		
  		// 결제 취소 버튼
		RoundedButton cancelButton = new RoundedButton("취소");
		cancelButton.setForeground(new Color(255, 255, 255));
		cancelButton.setBackground(new Color(87, 58, 52));
		cancelButton.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 15));
		cancelButton.setBounds(28, 5, 100, 23);
		basketFooterPanel.add(cancelButton);
		
		// 결제하기 버튼
		RoundedButton payButton = new RoundedButton("결제하기");
		payButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 로직 구현
			}
		});
		payButton.setForeground(new Color(255, 255, 255));
		payButton.setBackground(Color.RED);
		payButton.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 15));
		payButton.setBounds(179, 5, 100, 23);
		basketFooterPanel.add(payButton);

/*----------------------------------------------------------- footer Panel --------------------------------------------------------------------*/

		// 관리자 화면으로 가는 아이콘
		JLabel settingIcon = new JLabel(" ");
		settingIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				type_index = 0;
				AdminSuccessPanel.setVisible(false);
				setMenuScreenVisible(false);
				loginPanel.setVisible(true);
				if(scrollPanes.size() > 0) {
					scrollPanes.get(type_index).setVisible(false);
				}
				clearTypeAndMenuIndex();
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
				UserStartManagerPanel.setVisible(true);
				setMenuScreenVisible(false);
				loginPanel.setVisible(false);
				if(scrollPanes.size() > 0) {
					scrollPanes.get(type_index).setVisible(false);
				}
				clearTypeAndMenuIndex();
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
	}
	
/*---------------------------------------------------------- 메소드 -------------------------------------------------------------*/

	private void nextPanel(JPanel nowPanel, JPanel next) {
		nowPanel.setVisible(false);
		buttonPanel.setVisible(false);
		basketHeaderPanel.setVisible(false);
		basketScroll.setVisible(false);
		basketFooterPanel.setVisible(false);
		next.setVisible(true);
	}
	
	// 장바구니 UI를 업데이트 해주는 메서드
	private void updateBasketPanel() {
	    // 기존의 모든 컴포넌트를 제거
	    basketListPanel.removeAll();

	    // 업데이트된 내용을 바탕으로 다시 추가
	    for (int i = basket.size() - 1; i >= 0; i--) {
	    	int currentIndex = i;
	        JPanel basketMenu = new JPanel();
	        basketMenu.setBackground(new Color(255, 255, 255));
	        basketMenu.setPreferredSize(new Dimension(90, 43));
	        basketMenu.setLayout(null);
	        basketListPanel.add(basketMenu);
	        
	        totalPriceLabel.setText(totalPrice+"");
            countLabel.setText(count+"");

	        JLabel cancelMenu = new JLabel("X");
	        cancelMenu.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
	            	// 전체 가격과 전체 메뉴 수 업데이트
	                count--;
	                totalPrice -= MenuDAO.getMenuById(basket.get(currentIndex).getMenuId()).getPrice();
	                
	                // basket에서 해당하는 인덱스의 객체 제거
	                if (currentIndex >= 0 && currentIndex < basket.size()) {
	                    basket.remove(currentIndex);
	                }

	                // basketListPanel에서 해당하는 JPanel 제거
	                basketListPanel.remove(basketMenu);
	                
	                // 장바구니에 담은 수 출력
	                System.out.println("basket size: " + basket.size());
	                
	                totalPriceLabel.setText(totalPrice+"");
	                countLabel.setText(count+"");
	                
	                // 변경된 내용을 반영하기 위해 다시 그리기
	                basketHeaderPanel.revalidate();
	                basketHeaderPanel.repaint();
	                basketListPanel.revalidate();
	                basketListPanel.repaint();
	            }
	        });
	        cancelMenu.setBounds(74, 6, 10, 10);
	        basketMenu.add(cancelMenu);

	        JLabel menuName = new JLabel(MenuDAO.getMenuById(basket.get(currentIndex).getMenuId()).getName());
	        menuName.setBounds(6, 18, 78, 10);
	        basketMenu.add(menuName);
	    }
	    
	    // 변경된 내용을 반영하기 위해 다시 그리기
	    basketListPanel.revalidate();
	    basketListPanel.repaint();
        basketHeaderPanel.revalidate();
        basketHeaderPanel.repaint();
	}
	
	// 메뉴 화면의 setVisible을 지정해주는 메서드
	private void setMenuScreenVisible(Boolean setVisible) {
		buttonPanel.setVisible(setVisible);
		basketHeaderPanel.setVisible(setVisible);
		basketScroll.setVisible(setVisible);
		basketFooterPanel.setVisible(setVisible);
		footerPanel.setVisible(setVisible);
		if(scrollPanes.size() > 0) {	// 메뉴 타입에 따른 메뉴판을 보여주는 스크롤 팬 리스트의 사이즈가 0보다 클 경우에만
			scrollPanes.get(type_index).setVisible(true);
		}
	}
	
	// 나가기 버튼을 누른 경우 장바구니와 타입 인덱스, 메뉴 인덱스를 초기화
	private void clearTypeAndMenuIndex() {
		basket.clear();	// 장바구니 비우기
		totalPrice = 0;
		count = 0;
		type_index = 0;
		menubytype_index = 0;
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
