package dao;

import java.util.List;

import Entidades.jogos;

public interface JogosDao {

	void insert(jogos obj);
	void update(jogos obj);
	void deleteById(Integer id_jogos);
	jogos findById(Integer id_jogos);
	List<jogos> findAll();	
}
