package implementacaoDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Entidades.Clientes;
import dao.clientesDAO;
import db.DB;
import db.DbException;


public class ClienteDaoJDBC implements clientesDAO {
	private Connection conn;
	
	public ClienteDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	public void insert(Clientes clientes) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("INSERT INTO clientes " + "(Nome, telefone, email) " + "VALUES (?, ?, ?)",
			Statement.RETURN_GENERATED_KEYS); 
			st.setString(1, clientes.getNome());
			st.setString(2, clientes.getTelefone());
			st.setString(3, clientes.getEmail());
			
			int linhasAfetadas = st.executeUpdate();
			
			if (linhasAfetadas > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					clientes.setId_cliente(id);
				}
				DB.closeResultSet(rs);
			}
			else {
				throw new DbException("Erro inesperado! Nenhuma inserção ocorreu");
			}
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}
	
	public void update(Clientes clientes) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("UPDATE clientes " + "SET Nome = ?, telefone = ?, email = ? " + "WHERE id_cliente = ? "); 
			st.setString(1, clientes.getNome());
			st.setString(2, clientes.getTelefone());
			st.setString(3, clientes.getEmail());
			st.setInt(4, clientes.getId_cliente());
			st.executeUpdate();
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}	
	}
	
	public void deleteById(Integer id) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("DELETE FROM clientes " + "WHERE id_cliente = ?"); 
			st.setInt(1, id);
			int linhasAfetadas = st.executeUpdate();
			if (linhasAfetadas == 0) {
				throw new DbException("Nenhuma exclusão ocorreu! Id inexistente");
			}
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}
	
	
	public List<Clientes> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT * " + "FROM clientes");
			
			rs = st.executeQuery();
			
			List <Clientes> lista = new ArrayList<>();
			
			while (rs.next()) {
				Clientes clientes = instanciaClientes(rs);
				lista.add(clientes);
			}
			return lista;
		} 
		catch (SQLException e){
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	public Clientes findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT * "	+ "FROM clientes " + " WHERE id_cliente = ?");
			st.setInt(1,id);
			rs = st.executeQuery();
			if (rs.next()) {

				Clientes cliente = instanciaClientes(rs);
				return cliente;
			}
		} 
		catch (SQLException e){
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		return null;
	}
	
	public Clientes instanciaClientes(ResultSet rs) throws SQLException {
		Clientes clientes = new Clientes();
		
		clientes.setNome(rs.getNString("Nome"));
		clientes.setTelefone(rs.getNString("Telefone"));
		clientes.setEmail(rs.getNString("Email"));
		return clientes;
	}	
}
