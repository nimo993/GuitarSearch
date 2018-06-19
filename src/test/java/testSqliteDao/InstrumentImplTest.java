package testSqliteDao;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

public class InstrumentImplTest {

	@Test
	public void test(){
		sqliteDao.InstrumentDaoImpl impl = new sqliteDao.InstrumentDaoImpl();
		assertEquals(impl.getAllInstruments().size(),4);
	}


}
