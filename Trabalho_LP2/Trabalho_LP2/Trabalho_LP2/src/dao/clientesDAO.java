package dao;

import java.util.List;
import Entidades.Clientes;


public interface clientesDAO {
	
	void insert(Clientes obj);
	void update(Clientes obj);
	void deleteById(Integer id);
	Clientes findById(Integer id);
	List <Clientes> findAll();
	
}