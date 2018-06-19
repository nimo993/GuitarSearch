package testService;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.catalina.core.ApplicationContext;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.dataAccess;
import dao.dataAccess1;
import model.Instrument;
import model.Inventory;
import service.InstrumentService;

public class InstrumentServiceTest {
	@Test
	public void test() {
		Inventory inven = null;
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		InstrumentService us = 
				(InstrumentService)ac.getBean("instrumentService");
		//assertNotEquals(null, us);
		inven = us.getInventory();
		assertNotEquals(null, inven);
	}

}
