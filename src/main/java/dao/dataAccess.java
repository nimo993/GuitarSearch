package dao;

public class dataAccess {
	private static String db = "sqlite";

	public static InstrumentDao createInstrumentDao() {
		InstrumentDao result = null;
		switch (db) {
		case "sqlite":
			result = new sqliteDao.InstrumentDaoImpl();
			break;
		case "mysql":
			result = new mysqlDao.InstrumentDaoImpl();
			break;
		}
		return result;
	}

	public static UserDao createUserDao() {
		UserDao ret = null;
		switch (db) {
		case "sqlite":
			ret = new sqliteDao.UserDaoImpl();
			break;
		case "mysql":
			ret = new mysqlDao.UserDaoImpl();
			break;
		case "xml":
			ret = new xmlDao.UserDaoImpl();
			break;

		}
		return ret;

	}
}
