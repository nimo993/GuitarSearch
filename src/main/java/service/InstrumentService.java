package service;

import java.util.List;

import dao.InstrumentDao;
import dao.dataAccess1;
import model.Instrument;
import model.InstrumentSpec;
import model.Inventory;

public class InstrumentService {
	
	private InstrumentDao dao = dataAccess1.createInstrumentDao();
	private Inventory inventory;
	public InstrumentService(){}
	
	public Inventory getInventory(){
		inventory = new Inventory();
		
		List<Instrument> list = dao.getAllInstruments();
		System.out.print(list);
		for(Instrument i : list){			
			inventory.addInstrument(i.getSerialNumber(), i.getPrice(),  i.getSpec());
		}
		return inventory;
	}
	
	public List searchInstrument(InstrumentSpec searchSpec){		
		return this.getInventory().search(searchSpec);			
	}
	
}
