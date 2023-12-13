package model.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import jdbc.MysqlJdbc;
import model.dto.MenuByTypeDTO;
import model.vo.MenuTypeVO;
import model.vo.MenuVO;

public class MenuDAO {
	// Type별로 isVisible이 1인 Menu 정보를 가져와서 MenuByTypeDTO로 묶어 반환하는 메서드(실질적으로 BurgerKingMain에서 이용할 메서드)
    public static List<MenuByTypeDTO> getMenuByTypes() throws Exception {
        List<MenuByTypeDTO> menuByTypeDTOs = new ArrayList<>();

        // 모든 Type 정보 가져오기
        List<MenuTypeVO> allTypes = getAllTypes();

        // 각 Type에 대해 isVisible이 1인 Menu 정보 가져오기
        for (MenuTypeVO type : allTypes) {
            ArrayList<MenuVO> menuVos = getMenuInfoByType(type.getId());

            // MenuByTypeDTO 생성 및 추가
            MenuByTypeDTO menuByTypeDTO = new MenuByTypeDTO(type, menuVos);
            menuByTypeDTOs.add(menuByTypeDTO);
        }

        return menuByTypeDTOs;
    }
    
    // 메뉴 정보 가져오기
    public static MenuVO getMenuById(int menuId) {
        MenuVO menu = null;
        String query = "SELECT * FROM `burgerkingdb`.`Menu` WHERE `menu_id` = ?";

        try (Connection connection = DriverManager.getConnection(MysqlJdbc.URL, MysqlJdbc.USER, MysqlJdbc.PASSWORD);
        		PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, menuId);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    menu = new MenuVO();
                    menu.setId(rs.getInt("menu_id"));
                    menu.setName(rs.getString("menu_name"));
                    menu.setPrice(rs.getLong("menu_price"));
                    menu.setIsPossible(rs.getInt("menu_isPossible"));
                    menu.setMenuImagepath(rs.getString("menu_imagepath"));
                    menu.setTypeId(rs.getInt("type_id"));
                    menu.setMenubytypeId(rs.getInt("menubytype_id"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return menu;
    }
    
    // 모든 Type 정보 가져오기
    private static List<MenuTypeVO> getAllTypes() throws Exception {
        List<MenuTypeVO> allTypes = new ArrayList<>();

        String query = "SELECT * FROM Type";

        try (Connection connection = DriverManager.getConnection(MysqlJdbc.URL, MysqlJdbc.USER, MysqlJdbc.PASSWORD);
        		PreparedStatement pstmt = connection.prepareStatement(query)) {
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int typeId = rs.getInt("type_id");
                String typeName = rs.getString("type_name");

                MenuTypeVO type = new MenuTypeVO(typeId, typeName);
                allTypes.add(type);
            }
        }

        return allTypes;
    }
    
    // Type별 isVisible이 1인 Menu 정보 가져오기
    private static ArrayList<MenuVO> getMenuInfoByType(int typeId) throws Exception {
        ArrayList<MenuVO> menuVos = new ArrayList<>();

        String query = "SELECT * FROM Menu WHERE type_id = ? AND menu_isPossible = 1";

        try (Connection connection = DriverManager.getConnection(MysqlJdbc.URL, MysqlJdbc.USER, MysqlJdbc.PASSWORD);
        		PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, typeId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int menuId = rs.getInt("menu_id");
                String menuName = rs.getString("menu_name");
                long menuPrice = rs.getLong("menu_price");
                int menuIsPossible = rs.getInt("menu_isPossible");
                String menuImagepath = rs.getString("menu_imagepath");
                int fetchedTypeId = rs.getInt("type_id");
                int menubytypeId = rs.getInt("menubytype_id");

                MenuVO menuVo = new MenuVO(menuId, menuName, menuPrice, menuIsPossible, menuImagepath, fetchedTypeId, menubytypeId);
                menuVos.add(menuVo);
            }
        }

        return menuVos;
    }
}