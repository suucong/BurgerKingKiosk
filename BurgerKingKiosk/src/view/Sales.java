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
import model.dao.OrdersDAO;
import model.vo.OrdersVO;

public class Sales extends JFrame {

    JFrame frmBurgerkingKiosk;
    private JPanel contentPane;
    private JTable table;
    private DefaultTableModel tableModel;
    private static final String[] COL_NAMES = { "주문 번호", "가격", "주문 시간" };
    private JPanel detailsPanel = new JPanel();

    public Sales() {
        new MysqlJdbc();
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
            List<OrdersVO> list = OrdersDAO.getAllOrders();
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

        /*-try {
            Optional<OrdersVO> ordersOptional = OrdersDAO.getOrderByOrderID(orderId);

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
        }-*/

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
