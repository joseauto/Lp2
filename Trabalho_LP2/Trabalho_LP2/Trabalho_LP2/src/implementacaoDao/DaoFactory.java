package implementacaoDao;

import dao.clientesDAO;
import db.DB;

public class DaoFactory {
	
	public static clientesDAO createClientesDao() {
		return new ClienteDaoJDBC(DB.getConnection());
	}
}
