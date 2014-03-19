/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.org.warehouse;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.util.ArrayList;
import javax.annotation.Resource;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.servlet.ServletContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/**
 *
 * @author deven.collette
 */
@WebService(serviceName = "WarehouseWS")
public class WarehouseWS {

    @Resource private WebServiceContext wsc;
    private static int orderNum=0;
     
    private void replenish(){
    
        MessageContext ctxt = wsc.getMessageContext();
        ServletContext req = (ServletContext) ctxt.get(ctxt.SERVLET_CONTEXT);
        String path = req.getRealPath("WEB-INF");
        path += "/inventory.xml";
        File file = new File(path);
        try{
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            InputSource is = new InputSource();
            is.setCharacterStream(new FileReader(file));
            Document doc = db.parse(is);
            NodeList product = doc.getElementsByTagName("item");
            for (int i = 0; i < product.getLength(); i++) {
                Element xmlItem = (Element) product.item(i);

                if (Integer.parseInt(xmlItem.getAttribute("quantity"))< 100) 
                {
                    // need to custom order
                    //PurchaseOrder order = new PurchaseOrder();
                }
                    
            }
        } catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "shipGoods")
    public ArrayList<OrderItem> shipGoods(@WebParam(name = "items") ArrayList<OrderItem> itemList) {
        ArrayList<OrderItem> shippedItems = new ArrayList<>();
        try { 
            DocumentBuilderFactory domfac = DocumentBuilderFactory.newInstance();
            DocumentBuilder dombuilder;
            dombuilder = domfac.newDocumentBuilder();
            MessageContext ctxt = wsc.getMessageContext();
            ServletContext req = (ServletContext) ctxt.get(ctxt.SERVLET_CONTEXT);
            String path = req.getRealPath("WEB-INF");
            InputStream is = new FileInputStream(path + "/inventory.xml");
            Document doc;
            doc = dombuilder.parse(is);
            Element titleInfo = doc.getDocumentElement();
            NodeList inventory = titleInfo.getElementsByTagName("product");
            
            
            for(int t=0;t<itemList.size();t++)
            {
                OrderItem tmp = (OrderItem) itemList.get(t);
               
                for(int i=0;i<inventory.getLength();i++)
                {
                    Element xmlItem = (Element) inventory.item(i);
                    
                    if(tmp.getProduct().getProductType().equals(xmlItem.getAttribute("productType")) &&
                       tmp.getProduct().getManufacturerName().equals(xmlItem.getAttribute("manufacturerName")))
                    {
                        int newQuantity = Integer.parseInt(xmlItem.getAttribute("quantity")) - tmp.getQuantity();

                        if(newQuantity >= 0)
                        {
                            xmlItem.getElementsByTagName("quantity").item(0).setTextContent(Integer.toString(newQuantity));
                            shippedItems.add(tmp);

                        }
                        else
                        {
                            tmp.setQuantity(Integer.parseInt(xmlItem.getAttribute("quantity")));
                            shippedItems.add(tmp);
                            xmlItem.getElementsByTagName("quantity").item(0).setTextContent("0");
                        }
                        break;
                    }
                }
            }
        }
        catch (Exception e)
        {
                System.out.println("Caught Exception: ");
                e.printStackTrace();		
        }
        replenish();
        return shippedItems;
        
    }
}
