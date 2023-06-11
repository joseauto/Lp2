package dao.impl;

import dao.ClienteDao;
import db.DB;

public class FactoryDao {

	public static ClienteDao createClienteDao() {
		return new ClienteDaoJDBC(DB.getConnection());
	}
}
