package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.dataAccess;
import model.Builder;
import model.Guitar;
import model.Instrument;
import model.InstrumentSpec;
import model.Inventory;
import model.Style;
import model.Type;
import model.Wood;
import service.InstrumentService;

/**
 * Servlet implementation class InstrumentService
 */
@WebServlet("/guitar/InstrumentService")
public class InstrumentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InstrumentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("null")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		InstrumentService instrumentSrv = new InstrumentService();
		List<Guitar> guitarList=new ArrayList();
		//根据查询条件构造InstrumentSpec，通常可以使用对象反序列化技术
		Inventory inventory=instrumentSrv.getInventory();
		System.out.println(inventory);
		Map properties = new HashMap();
		System.out.println(Style.fromString(request.getParameter("style")));
		if(request.getParameter("builder")!=""){
			properties.put("builder",  Builder.fromString(request.getParameter("builder")));
		}
		if(request.getParameter("backWood")!=""){
			properties.put("backWood",  Wood.fromString(request.getParameter("backWood")));
			System.out.println("---------------"+properties.get("backWood"));
		}
		if(request.getParameter("topWood")!=""){
			properties.put("topWood", Wood.fromString(request.getParameter("topWood")));
		}
		if(request.getParameter("style")!=""){
			properties.put("style", Style.fromString(request.getParameter("style")));
		}
		if(request.getParameter("type")!=""){
			properties.put("type", Type.fromString(request.getParameter("type")));
		}
		
//		
//		properties.put("topWood", Wood.fromString(request.getParameter("topWood")));
//		
//		
//		
		
		InstrumentSpec spec = new InstrumentSpec(properties);
		if(spec!=null) {
			System.out.println(spec);
		}
		
		List result = inventory.search(spec);
		if (!result.isEmpty()) {
		      System.out.println("Bryan, you might like these instruments:");
		      for (Iterator i = result.iterator(); i.hasNext(); ) {
		    	Guitar guitar=new Guitar();
		        Instrument instrument = (Instrument)i.next();
		        InstrumentSpec spec1 = instrument.getSpec();
		        System.out.println("We have a " + spec1.getProperty("type") +
		          " with the following properties:");
		        System.out.println("9999999"+instrument.getSerialNumber());
//		        System.out.println("9999999"+instrument.getSerialNumber());
		        guitar.setSerialNumber(instrument.getSerialNumber());
		        guitar.setPrice(instrument.getPrice());
		       ;
		        guitar.setBuilder(spec1.getProperty("builder").toString());
		        guitar.setStyle(spec1.getProperty("style").toString());
		        guitar.setBackWood(spec1.getProperty("backWood").toString());
		        guitar.setTopWood(spec1.getProperty("topWood").toString());
		        guitarList.add(guitar);
		        for (Iterator j = spec1.getProperties().keySet().iterator(); 
		             j.hasNext(); ) {
		          String propertyName = (String)j.next();
		          if (propertyName.equals("type"))
		            continue;
		          System.out.println("    " + propertyName + ": " +
		            spec1.getProperty(propertyName));
		        }  
		        System.out.println("  You can have this " + 
		          spec1.getProperty("type") + " for $" + 
		          instrument.getPrice() + "\n---");
		        
		        
		      }
		      String rs="you might like these instruments:";
		      request.setAttribute("rs", rs);
		      request.setAttribute("guitarList", guitarList);
		      
		    } else {
		      System.out.println("Sorry, Bryan, we have nothing for you.");
		      String rs="we have nothing for you.";
		      request.setAttribute("rs", rs);
		      request.setAttribute("result", result);
		    }
		  
		
		// TODO Auto-generated method stub
		RequestDispatcher rd = 
                request.getRequestDispatcher("/guitar/search.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		Inventory inventory=null;
//		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
//		InstrumentService us = 
//				(InstrumentService)ac.getBean("instrumentService");
		//assertNotEquals(null, us);
		
		doGet(request, response);
		
	}
	
	public void initInventory(Inventory inventory){
		
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		InstrumentService us = 
				(InstrumentService)ac.getBean("instrumentService");
		//assertNotEquals(null, us);
		inventory = us.getInventory();
	}

}
