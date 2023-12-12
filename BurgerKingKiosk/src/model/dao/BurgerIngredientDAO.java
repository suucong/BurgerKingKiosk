package model.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import jdbc.MysqlJdbc;
import model.vo.BurgerIngredientVO;

public class BurgerIngredientDAO {
	// 모든 버거 재료를 가져와 반환하는 메서드
	public static List<BurgerIngredientVO> getAllIngredients() throws Exception {
	    String query = "SELECT * FROM BurgerIngredient";
	    List<BurgerIngredientVO> ingredientList = new ArrayList<>();

	    try (Connection connection = DriverManager.getConnection(MysqlJdbc.URL, MysqlJdbc.USER, MysqlJdbc.PASSWORD);
	            PreparedStatement pstmt = connection.prepareStatement(query)) {
	        ResultSet rs = pstmt.executeQuery();

	        while (rs.next()) {
	            int id = rs.getInt("ingredient_id");
	            String name = rs.getString("ingredient_name");
	            int price = rs.getInt("ingredient_price");

	            BurgerIngredientVO ingredient = new BurgerIngredientVO(id, name, price);
	            ingredientList.add(ingredient);
	        }

	        return ingredientList;
	    }
	}
	
//	public static void main(String[] args) {
//	    try {
//	        List<BurgerIngredientVO> ingredients = getAllIngredients();
//	        for (BurgerIngredientVO ingredient : ingredients) {
//	            System.out.println("ID: " + ingredient.getId() + ", Name: " + ingredient.getName() + ", Price: " + ingredient.getPrice());
//	        }
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	    }
//	}
}
