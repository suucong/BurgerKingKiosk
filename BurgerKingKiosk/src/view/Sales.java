package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import jdbc.MysqlJdbc;
import model.dao.OrderDAO;
import model.dao.OrdersDAO;
import model.vo.OrdersVO;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

public class Sales extends JFrame {

    JFrame frmBurgerkingKiosk;
    private JPanel contentPane;
    private JTable table;
    private DefaultTableModel tableModel;
    private static final String[] COL_NAMES = { "주문 번호", "가격", "주문 시간" };
    private JPanel detailsPanel = new JPanel();
    private JLabel lblNewLabel;

    public Sales() {
        initialize();
        loadOrderData();
    }

    private void initialize() {
        frmBurgerkingKiosk = new JFrame();
        frmBurgerkingKiosk.setTitle("BurgerKing Kiosk");
        frmBurgerkingKiosk.setBounds(100, 100, 800, 600);
        frmBurgerkingKiosk.setLocationRelativeTo(null);
        frmBurgerkingKiosk.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmBurgerkingKiosk.getContentPane().setLayout(null);
        frmBurgerkingKiosk.setVisible(true);

        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 254, 244));
        frmBurgerkingKiosk.setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(14, 78, 754, 397);
        contentPane.add(scrollPane);

        table = new JTable();
        JTableHeader header = table.getTableHeader();
        header.setBackground(Color.WHITE);
        table.setRowHeight(30);

        tableModel = new DefaultTableModel(null, COL_NAMES);
        table.setModel(tableModel);
        scrollPane.setViewportView(table);
        
        JLabel exitbtn = new JLabel("X");
        exitbtn.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		frmBurgerkingKiosk.setVisible(false);
        	}
        });
        exitbtn.setHorizontalAlignment(SwingConstants.RIGHT);
        exitbtn.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        exitbtn.setBounds(711, 22, 50, 27);
        contentPane.add(exitbtn);
        
        lblNewLabel = new JLabel("매출 확인");
        lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        lblNewLabel.setBounds(25, 22, 101, 27);
        contentPane.add(lblNewLabel);
        
        RoundedButton deleteOrderbtn = new RoundedButton("주문 삭제");
        deleteOrderbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow == -1) { // 테이블에서 선택된 행이 없으면
                    JOptionPane.showMessageDialog(deleteOrderbtn, "삭제할 주문을 선택하세요.", "알림", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                String[] options = {"취소", "삭제"};
                int confirm = JOptionPane.showOptionDialog(deleteOrderbtn, "주문을 삭제하겠습니까?", "확인", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
                if (confirm == 1) {
                    int no = Integer.parseInt(tableModel.getValueAt(selectedRow, 0).toString());
                    OrderDAO.deleteOrderAndOrderMenuByOrderId(no);
                    tableModel.removeRow(selectedRow); // 테이블에서 행 삭제
                    loadOrderData();
                    JOptionPane.showMessageDialog(deleteOrderbtn, "삭제가 완료되었습니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        deleteOrderbtn.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        deleteOrderbtn.setBounds(650, 500, 100, 50);
        contentPane.add(deleteOrderbtn);


        ListSelectionModel selectionModel = table.getSelectionModel();
        selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        selectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow != -1) {
                        showOrderDetails(selectedRow);
                    }
                }
            }
        });
    }

    private void loadOrderData() {
        try {
            List<OrdersVO> list = OrderDAO.getAllOrders();
            for (OrdersVO o : list) {
                addOrderToTableModel(o);
            }
        } catch (SQLException e) {
            // SQLException 처리 로직 추가
            e.printStackTrace(); // 또는 로깅 라이브러리를 사용하여 로깅
        }
    }


    private void addOrderToTableModel(OrdersVO o) {
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        Object[] rowData = { o.getOrderId(), o.getTotalPrice(), o.getOrderTime().format(formatter) };
        tableModel.addRow(rowData);
    }

    private void showOrderDetails(int selectedRow) {
        contentPane.remove(detailsPanel);
        detailsPanel = new JPanel();
        detailsPanel.setBackground(new Color(255, 254, 244));
        detailsPanel.setBounds(14, 487, 754, 100);
        contentPane.add(detailsPanel);
        detailsPanel.setLayout(null);

        int orderId = (int) table.getValueAt(selectedRow, 0);

        try {
            Optional<OrdersVO> ordersOptional = OrderDAO.getOrderByOrderID(orderId);

            if (ordersOptional.isPresent()) {
                OrdersVO orders = ordersOptional.get();
                int totalPrice = orders.getTotalPrice();
                LocalDateTime orderTime = orders.getOrderTime();

                JLabel orderIdLabel = new JLabel("주문 번호: " + orderId);
                orderIdLabel.setBounds(10, 10, 150, 30);
                detailsPanel.add(orderIdLabel);

                JLabel totalPriceLabel = new JLabel("가격: " + totalPrice);
                totalPriceLabel.setBounds(170, 10, 150, 30);
                detailsPanel.add(totalPriceLabel);

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                JLabel orderTimeLabel = new JLabel("주문 시간: " + orderTime.format(formatter));
                orderTimeLabel.setBounds(370, 10, 300, 30);
                detailsPanel.add(orderTimeLabel);
            } else {
                JLabel errorLabel = new JLabel("주문 정보를 가져올 수 없습니다.");
                errorLabel.setBounds(10, 10, 400, 30);
                detailsPanel.add(errorLabel);
            }

        } catch (SQLException e) {
            // SQLException 처리 로직 추가
            e.printStackTrace(); // 또는 로깅 라이브러리를 사용하여 로깅
        }

        contentPane.revalidate();
        contentPane.repaint();
    }

    

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Sales window = new Sales();
                    window.frmBurgerkingKiosk.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
