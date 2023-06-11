package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import Entidades.clientes;
import dao.ClienteDao;
import db.DB;
import db.DbException;
 
public class ClienteDaoJDBC implements ClienteDao {

	private  Connection conn;
	
	public ClienteDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	@Override
	public void insert(clientes obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(clientes obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer Id_cliente) {
	
	}
	@Override
	public clientes findById(Integer Id_cliente) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement(""
					+ "Select * "
					+ "from cliente"
					+ "where Id_cliente = ?");
		
			st.setInt(1, Id_cliente);
			rs = st.executeQuery();
			if (rs.next()) {
				clientes obj = new clientes();
				obj.setId_cliente(rs.getInt(Id_cliente));
				obj.setNome(rs.getString(nome));
				obj.setTelefone(rs.getString(telefone));
				obj.setEmail(rs.getString(email));
				return obj;
				
			}
			return null;
		}	
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		}

	

	@Override
	public List<clientes> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
