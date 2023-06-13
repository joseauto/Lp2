package implementacaoDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Entidades.Jogos;
import dao.JogosDAO;
import db.DB;
import db.DbException;

public class JogosDaoJDBC implements JogosDAO{
	
	private Connection conn;
	
	public JogosDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Jogos jogos) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("INSERT INTO jogos " + "(Nome, plataforma, genero, preco) " + "VALUES (?, ?, ?, ?)",
			Statement.RETURN_GENERATED_KEYS); 
			st.setString(1, jogos.getNome());
			st.setString(2, jogos.getPlataforma());
			st.setString(3, jogos.getGenero());
			st.setDouble(3, jogos.getPreco());
			
			int linhasAfetadas = st.executeUpdate();
			
			if (linhasAfetadas > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					jogos.setId_jogos(id);
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

	@Override
	public void update(Jogos jogos) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("UPDATE jogos " + "SET Nome = ?, Plataforma = ?, Genero = ?, Preco = ?" + "WHERE id_jogos = ? "); 
			st.setString(1, jogos.getNome());
			st.setString(2, jogos.getPlataforma());
			st.setString(3, jogos.getGenero());
			st.setDouble(4, jogos.getPreco());
			st.setInt(5, jogos.getId_jogos());
			st.executeUpdate();
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}	
	}

	@Override
	public void deleteById(Integer id) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("DELETE FROM jogos" + "WHERE id_jogos = ?"); 
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
	
	@Override
	public Jogos findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT * "	+ "FROM jogos " + " WHERE id_jogos = ?");
			st.setInt(1,id);
			rs = st.executeQuery();
			if (rs.next()) {

				Jogos jogos = instanciaJogos(rs);
				return jogos;
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

	@Override
	public List<Jogos> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT * " + "FROM jogos");
			
			rs = st.executeQuery();
			
			List <Jogos> lista = new ArrayList<>();
			
			while (rs.next()) {
				Jogos jogos = instanciaJogos(rs);
				lista.add(jogos);
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

	public Jogos instanciaJogos(ResultSet rs) throws SQLException {
		Jogos jogos = new Jogos();
		
		jogos.setNome(rs.getNString("Nome"));
		jogos.setPlataforma(rs.getNString("Plataforma"));
		jogos.setGenero(rs.getNString("Genero"));
		jogos.setPreco(rs.getDouble(4));
		return jogos;
	}	
}
