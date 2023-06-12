package dao;

import java.util.List;

import Entidades.Jogos;

public interface JogosDAO {
	
	void insert(Jogos obj);
	void update(Jogos obj);
	void deleteById(Integer id);
	Jogos findById(Integer id);
	List <Jogos> findAll();
	
}

