package aplicacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

import dao.clientesDAO;
import db.DB;
import implementacaoDao.ClienteDaoJDBC;
import implementacaoDao.DaoFactory;
import Entidades.Clientes;

public class programa {

	public static void main(String[] args) {
		
		clientesDAO clientesdao = DaoFactory.createClientesDao();
		
		//Encontra cliente pelo ID
		//Clientes cliente = clientesdao.findById(4);
		//System.out.println(cliente); 
		
		//Mostra todos clientes
		//List<Clientes> cliente1 = clientesdao.findAll();
		//System.out.println(cliente1);
		
		//Insere novo cliente
		//Clientes newCliente = new Clientes(null, "a", "122345677", "a@gmail.com");
		//clientesdao.insert(newCliente);
		//System.out.println("Inserção efetuada, o ID do cliente inserido é: "+newCliente.getId_cliente());
		
		//UPDATE NÃO ESTÁ FUNCIONANDO
		/*Clientes clientes = clientesdao.findById(4);
		System.out.println(clientes);
			clientes.setNome("Tamires Cardoso");
			clientesdao.update(clientes);
		
		System.out.println("Atualização executada"); */
		
		//Deletando cliente
		//Scanner sc = new Scanner(System.in);
		//int id = sc.nextInt();
		//clientesdao.deleteById(id);
		//System.out.println("Exclusão executada");
		//sc.close();

	}
}