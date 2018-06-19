package dao;

import sqliteDao.InstrumentDaoImpl;
import sqliteDao.UserDaoImpl;

public class dataAccess1 {
	
	private static String daoName = "sqliteDao";

	public static InstrumentDao createInstrumentDao() {
		InstrumentDao result = null;
		try {
			Object o = Class.forName(daoName + "." + "InstrumentDaoImpl").newInstance();
			result = (InstrumentDaoImpl)o;
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	

	public static UserDao createUserDao() {
		UserDao result = null;
		try {
			Object o = Class.forName(daoName + "." + "UserDaoImpl").newInstance();
			result = (UserDaoImpl)o;
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
