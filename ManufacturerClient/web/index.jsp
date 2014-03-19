<%-- 
    Document   : index
    Created on : 19-Mar-2014, 5:50:20 PM
    Author     : Maro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>    <%-- start web service invocation --%><hr/>
    <%
    try {
	com.org.manufacturer.ManufacturerWS_Service service = new com.org.manufacturer.ManufacturerWS_Service();
	com.org.manufacturer.ManufacturerWS port = service.getManufacturerWSPort();
	 // TODO initialize WS operation arguments here
	java.lang.String productType = "";
	// TODO process result here
	java.util.List<com.org.manufacturer.Product> result = port.getProductInfo(productType);
	out.println("Result = "+result);
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>    <%-- start web service invocation --%><hr/>
    <%
    try {
	com.org.warehouse.WarehouseWS_Service service = new com.org.warehouse.WarehouseWS_Service();
	com.org.warehouse.WarehouseWS port = service.getWarehouseWSPort();
	 // TODO initialize WS operation arguments here
	java.util.List<com.org.warehouse.OrderItem> items = null;
	// TODO process result here
	java.util.List<com.org.warehouse.OrderItem> result = port.shipGoods(items);
	out.println("Result = "+result);
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>

    <%-- end web service invocation --%><hr/>

    </body>
</html>
