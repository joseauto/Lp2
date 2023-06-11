package aplicacao;

import Entidades.clientes;
import dao.ClienteDao;
import dao.impl.FactoryDao;

public class programa {

	public static void main(String[] args) {
		
		ClienteDao clienteDao = FactoryDao.createClienteDao();
		
		clientes cliente = ClienteDao.findById(3);
		
		System.out.println(clientes);
		
		
	/*	Connection conn = null;
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
	*/
		}		
}