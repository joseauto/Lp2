package dao;

 
import java.util.List;

import Entidades.clientes;

public interface ClienteDao {

	void insert(clientes obj);
	void update(clientes obj);
	void deleteById(Integer Id_cliente);
	clientes findById(Integer Id_cliente);
	List<clientes> findAll();
	
}
