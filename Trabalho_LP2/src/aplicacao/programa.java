package aplicacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.Scanner;

import db.DB;

public class programa {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DB.getConnection();
			st = conn.prepareStatement(
					"INSERT INTO clientes"
					+ "(Nome, telefone, email)"
					+ "VALUES "
					+ "(?,?,?)",   
					Statement.RETURN_GENERATED_KEYS);
			st.setString(1,"rafael");     
			st.setString(2,"1"); 
			st.setString(3, "rafael@gmail");
			
			int linhasAcrescentadas = st.executeUpdate();
			
			if (linhasAcrescentadas > 0) {
				ResultSet rs = st.getGeneratedKeys();   
				while (rs.next()) {
					int id = rs.getInt(1);
					System.out.println("Executado! Id = "+ id);
				}
			}
			else {
				System.out.println("Nenhuma linha acrescentada!");
			}	
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}		
}