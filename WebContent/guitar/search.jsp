<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>吉他搜索页面</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		
		<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
		
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.2/css/bootstrap-select.min.css">
		<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.15/css/jquery.dataTables.min.css">
		<script type="text/javascript" language="javascript" src="//code.jquery.com/jquery-1.12.4.js">
		</script>
		<script type="text/javascript" language="javascript" src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js">
		</script>
		<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.2/js/bootstrap-select.min.js"></script>
		<style type="text/css">
			form table tr td {
				padding:5px;
			}
			form table tr thead {
				padding:5px;
			}
		</style>
		
					
</head>
<body>
<div style="padding: 100px 100px 10px;">
		    <form  method="post" action="InstrumentService">
		    	<table>
		    		<tr>
		    			<td>
		    				  <label for="builder">Builder:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
		    			</td>
		    			<td>
					    	  <select id="builder" name="builder"  class="selectpicker" data-hide-disabled="true">
			                      <option value=""></option>
			                       <option value="Fender">Fender</option>
			                       <option value="Gibson">Gibson</option>
			                       <option value="Collings">Collings</option>
			                       
			                  </select>
		    			</td>
		    			<td>
			                  <label for="type">&emsp;Type:&emsp;</label>
		    			</td>
		    			<td>
					    	  <select id="type" name="type" class="selectpicker" data-hide-disabled="true">
			                       <option value=""></option>
			                       <option value="acoustic">acoustic</option>
			                       <option value="electric">electric</option>
			                       <option value="ANY">Unspecified</option>
			                  </select>
		    			</td>
		    		</tr>
		    		<tr>
		    			<td>
		    	  			<label for="backWood">BackWood:&emsp;</label>
		    			</td>
		    			<td>
		    				<select id="backWood" name="backWood" class="selectpicker" data-hide-disabled="true">
		                        <option value=""></option>
		                        <option value="Maple">Maple</option>
		                       <option value="Cocobolo">Cocobolo</option>
		                       <option value="Alder">Alder</option>
		                      
		                  </select>
		    			</td>
		    			<td>
		    				<label for="topWood">&emsp;TopWood:&emsp;</label>
		    			</td>
		    			<td>
		    				<select id="topWood" name="topWood" class="selectpicker" data-hide-disabled="true">
		                       <option value=""></option>
		                       <option value="Indian_Rosewood">Indian_Rosewood</option>
		                       <option value="Brazilian_Rosewood">Brazilian_Rosewood</option>
		                       <option value="Mahogany">Mahogany</option>
		                       <option value="Maple">Maple</option>
		                       <option value="Cocobolo">Cocobolo</option>
		                       <option value="Cedar">Cedar</option>
		                       <option value="Adirondack">Adirondack</option>
		                       <option value="Alder">Alder</option>
		                       <option value="Sitka">Sitka</option>
		                  </select>
		    			</td>
		    		</tr>
		    		
		    		
		    	  			
		    			 <tr>
             <td>
		    	  			<label for="backWood">&emsp;Style:&emsp;</label>
		    			</td>
             <td>
            <select id="style" name="style"  class="selectpicker" data-hide-disabled="true">
               <option value =""></option>
               <option value ="A style">A style</option>
               <option value ="F style">F style</option>
               
             
            
             </select>
           </td>
         
		    		</tr>
		    		
		    	</table>
		    	<br>
		        <button id="btn" class="btn btn-default">提交</button>
		        <br/>
		    </form>
		    <br>
		       
		    <br /><br /><br />
		    
			<table>
	 <tr>${requestScope.rs}</tr>
       <c:forEach items="${requestScope.guitarList}" var="guitar">
   
    	<tr><td>serialNumber:${guitar.serialNumber}</td></tr>
        <tr><td>price:${guitar.price}</td></tr>
        <tr><td>builder:${guitar.builder}</td></tr>
        <tr><td>style:${guitar.style}</td></tr>
        <tr><td>backWood:${guitar.backWood}</td></tr>
        <tr><td>topWood:${guitar.topWood}</td></tr>
    
    </c:forEach>
		</div>
</body>
</html>