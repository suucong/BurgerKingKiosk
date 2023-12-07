package jdbc;

import java.sql.*;
import java.io.BufferedReader;
import java.io.FileReader;

public class MysqlJdbc {
	String DRIVER = "com.mysql.cj.jdbc.Driver";
	String URL = "jdbc:mysql://localhost:3306/burgerkingdb?serverTimezZone=UTC";
	String USER = "admin";
	String PASSWORD = "1210";
	Connection con = null;
	Statement stmt = null;
	
	public MysqlJdbc() {
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = con.createStatement();
			
			// 시작하기 전에 테이블 모두 삭제
			stmt.execute("DROP TABLE IF EXISTS `burgerkingdb`.`AddIngredient`, `burgerkingdb`.`BurgerIngredient`, `burgerkingdb`.`OrderMenu`, `burgerkingdb`.`Type`, `burgerkingdb`.`Order`, `burgerkingdb`.`admin`, `burgerkingdb`.`Menu`;");
		
			// 테이블 생성
			stmt.execute("CREATE TABLE `burgerkingdb`.`Menu` (\r\n"
			        + "  `menu_id` INT NOT NULL AUTO_INCREMENT,\r\n"
			        + "  `menu_name` VARCHAR(15) NOT NULL,\r\n"
			        + "  `menu_price` BIGINT NOT NULL,\r\n"
			        + "  `type_id` INT NOT NULL,\r\n"
			        + "  PRIMARY KEY (`menu_id`)\r\n"
			        + ") ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;\r\n"
			);

			stmt.execute("CREATE TABLE `burgerkingdb`.`Admin` (\r\n"
			        + "  `admin_id` INT NOT NULL AUTO_INCREMENT,\r\n"
			        + "  `admin_password` VARCHAR(20) NOT NULL,\r\n"
			        + "  PRIMARY KEY (`admin_id`)\r\n"
			        + ") ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;\r\n"
			);

			stmt.execute("CREATE TABLE `burgerkingdb`.`Order` (\r\n"
			        + "  `order_id` BIGINT NOT NULL AUTO_INCREMENT,\r\n"
			        + "  `totalPrice` BIGINT NOT NULL,\r\n"
			        + "  `order_time` DATETIME NOT NULL,\r\n"
			        + "  PRIMARY KEY (`order_id`)\r\n"
			        + ") ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;\r\n"
			);

			stmt.execute("CREATE TABLE `burgerkingdb`.`Type` (\r\n"
			        + "  `type_id` INT NOT NULL AUTO_INCREMENT,\r\n"
			        + "  `type_name` VARCHAR(15) NOT NULL,\r\n"
			        + "  PRIMARY KEY (`type_id`)\r\n"
			        + ") ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;\r\n"
			);

			stmt.execute("CREATE TABLE `burgerkingdb`.`OrderMenu` (\r\n"
			        + "  `ordermenu_id` BIGINT NOT NULL AUTO_INCREMENT,\r\n"
			        + "  `quantity` BIGINT NOT NULL,\r\n"
			        + "  `side` VARCHAR(15) NULL,\r\n"
			        + "  `drink` VARCHAR(15) NULL,\r\n"
			        + "  `menu_id` INT NOT NULL,\r\n"
			        + "  `order_id` BIGINT NOT NULL,\r\n"
			        + "  PRIMARY KEY (`ordermenu_id`)\r\n"
			        + ") ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;\r\n"
			);

			stmt.execute("CREATE TABLE `burgerkingdb`.`BurgerIngredient` (\r\n"
			        + "  `ingredient_id` INT NOT NULL AUTO_INCREMENT,\r\n"
			        + "  `ingredient_name` VARCHAR(15) NOT NULL,\r\n"
			        + "  `ingredient_price` INT NOT NULL,\r\n"
			        + "  PRIMARY KEY (`ingredient_id`)\r\n"
			        + ") ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;\r\n"
			);

			stmt.execute("CREATE TABLE `burgerkingdb`.`AddIngredient` (\r\n"
			        + "  `addIngredient_id` BIGINT NOT NULL AUTO_INCREMENT,\r\n"
			        + "  `ingredient_id` INT NOT NULL,\r\n"
			        + "  `ordermenu_id` BIGINT NOT NULL,\r\n"
			        + "  PRIMARY KEY (`addIngredient_id`)\r\n"
			        + ") ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;\r\n"
			);

            // 파일 경로 및 이름
            String filePath = "datafiles/admin.txt";

            // BufferedReader를 사용하여 파일에서 데이터 읽기
            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = br.readLine()) != null) {
                    // 데이터를 탭으로 분리
                    String[] data = line.split("\t");

                    // 데이터베이스에 데이터 삽입
                    insertData(con, data);
                }
            }

            System.out.println("데이터 삽입 완료.");

            con.close();
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	
	// Check if a table exists in the database
	public void dropAllTables(String schemaName) {
        try {
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement stmt = con.createStatement();

            // Use the specified schema
            stmt.execute("USE `" + schemaName + "`;");

            // Get the list of tables
            ResultSet rs = stmt.executeQuery("SHOW TABLES;");
            while (rs.next()) {
                String tableName = rs.getString(1);
                stmt.execute("DROP TABLE IF EXISTS `" + schemaName + "`.`" + tableName + "`;");
                System.out.println("Table " + tableName + " dropped.");
            }

            // Close resources
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // PreparedStatement를 사용하여 데이터베이스에 데이터 삽입
    private static void insertData(Connection con, String[] data) {
        try {
            // INSERT 쿼리
            String insertQuery = "INSERT INTO burgerkingdb.admin (admin_id, admin_password) VALUES (?, ?)";

            // PreparedStatement 생성
            try (PreparedStatement pstmt = con.prepareStatement(insertQuery)) {
                // 데이터 셋팅
                pstmt.setInt(1, Integer.parseInt(data[0])); // admin_id
                pstmt.setString(2, data[1]); // admin_password

                // 쿼리 실행
                pstmt.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}