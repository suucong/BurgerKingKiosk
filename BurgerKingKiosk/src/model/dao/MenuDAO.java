package model.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuDAO {
	// type_id를 기준으로 타입 이름, 메뉴 이름, 메뉴 가격을 가져오는 메서드
	public static Map<Object[], List<Object[]>> getMenuInfoByTypeIdWithJoin(Connection connection) throws Exception {
	    String query = "SELECT m.type_id, t.type_name, m.menu_name, m.menu_price FROM Menu m " +
	            "JOIN Type t ON m.type_id = t.type_id " +
	            "WHERE m.menu_isPossible = 1";
	    try (PreparedStatement pstmt = connection.prepareStatement(query)) {
	        ResultSet rs = pstmt.executeQuery();

	        Map<Object[], List<Object[]>> menuInfoMap = new HashMap<>();
	        while (rs.next()) {
	            int typeId = rs.getInt("type_id");
	            String typeName = rs.getString("type_name");
	            String menuName = rs.getString("menu_name");
	            int menuPrice = rs.getInt("menu_price");

	            // 복합키 생성
	            Object[] key = {typeId, typeName};

	            // Object 배열에 데이터 저장
	            Object[] menuInfo = {menuName, menuPrice};

	            // Map에 추가
	            menuInfoMap.computeIfAbsent(key, k -> new ArrayList<>()).add(menuInfo);
	        }

	        return menuInfoMap;
	    }
	}
}