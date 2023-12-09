package jdbc;

import java.sql.*;
import java.io.BufferedReader;
import java.io.FileReader;

public class MysqlJdbc {
	public static String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static String URL = "jdbc:mysql://localhost:3306/burgerkingdb?serverTimezZone=UTC&allowLoadLocalInfile=true";
	public static String USER = "admin";
	public static String PASSWORD = "1210";
	Connection con = null;
	Statement stmt = null;
	
	public MysqlJdbc() {
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = con.createStatement();
			
			// MySQL 서버에서 LOAD DATA LOCAL INFILE을 사용할 수 있도록 설정하는 쿼리
			stmt.execute("SET GLOBAL local_infile = 1");
			
			// 시작하기 전에 테이블 모두 삭제
			stmt.execute("DROP TABLE IF EXISTS `burgerkingdb`.`AddIngredient`, `burgerkingdb`.`BurgerIngredient`, `burgerkingdb`.`OrderMenu`, `burgerkingdb`.`Type`, `burgerkingdb`.`Order`, `burgerkingdb`.`admin`, `burgerkingdb`.`Menu`;");
		
			// 테이블 생성
			stmt.execute("CREATE TABLE `burgerkingdb`.`Menu` (\r\n"
			        + "  `menu_id` INT NOT NULL AUTO_INCREMENT,\r\n"
			        + "  `menu_name` VARCHAR(15) NOT NULL,\r\n"
			        + "  `menu_price` BIGINT NOT NULL,\r\n"
			        + "  `menu_isPossible` INT NOT NULL,\r\n"
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
					+ "  `order_date` DATE NOT NULL,\r\n"
			        + "  `order_id` BIGINT NOT NULL,\r\n"
			        + "  `totalPrice` BIGINT NOT NULL,\r\n"
			        + "  `order_time` DATETIME NOT NULL,\r\n"
			        + "  PRIMARY KEY (`order_id`, `order_date`)\r\n"
			        + ") ENGINE=InnoDB DEFAULT CHARSET=utf8;\r\n"
			);
			
			stmt.execute("CREATE TABLE `burgerkingdb`.`OrderMenu` (\r\n"
			        + "  `ordermenu_id` BIGINT NOT NULL,\r\n"
			        + "  `quantity` BIGINT NOT NULL,\r\n"
			        + "  `side` VARCHAR(15) NULL,\r\n"
			        + "  `drink` VARCHAR(15) NULL,\r\n"
			        + "  `menu_id` INT NOT NULL,\r\n"
			        + "  `order_date` DATE NOT NULL,\r\n"
			        + "  `order_id` BIGINT NOT NULL,\r\n"
			        + "  PRIMARY KEY (`ordermenu_id`)\r\n"
			        + ") ENGINE=InnoDB DEFAULT CHARSET=utf8;\r\n"
			);

			stmt.execute("CREATE TABLE `burgerkingdb`.`Type` (\r\n"
			        + "  `type_id` INT NOT NULL AUTO_INCREMENT,\r\n"
			        + "  `type_name` VARCHAR(15) NOT NULL,\r\n"
			        + "  PRIMARY KEY (`type_id`)\r\n"
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

			// datafiles의 데이터 파일들을 테이블에 적재  
			String[] tables = "admin,type,menu".split(",");
			
			try {
			    for (String table : tables) {
			        stmt.execute("LOAD DATA LOCAL INFILE 'datafiles/" + table + ".txt'"
			                + " INTO TABLE " + table
			                + " CHARACTER SET 'utf8'"
			                + " FIELDS TERMINATED BY '|'"
			                + " LINES TERMINATED BY '\\n'");
			    }
			    
			    System.out.println("Datafiles inserted successfully!");
			} catch (SQLException e) {
			    e.printStackTrace();
			    System.out.println("SQLException: " + e.getMessage());
			}

            con.close();
		} catch(Exception e) {
			System.out.println(e);
		}
	}
}