/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.org.warehouse;

/**
 *
 * @author deven.collette
 */
public class PurchaseOrder {
    
    private int _orderNum;
    private String _customerRef; 
    private Product _product;
    private int _quantity;
    private float _unitPrice;
    
    public PurchaseOrder()
    {
        _orderNum = 0;
        _customerRef = ""; 
        _product = new Product();
        _quantity = 0;
        _unitPrice = 0;
    }
    
    public PurchaseOrder(int on, String cr, Product p, int q, float up)
    {
        _orderNum = on;
        _customerRef = cr; 
        _product = p;
        _quantity = q;
        _unitPrice = up;
    }

    /**
     * @return the _orderNum
     */
    public int getOrderNum() {
        return _orderNum;
    }

    /**
     * @param _orderNum the _orderNum to set
     */
    public void setOrderNum(int _orderNum) {
        this._orderNum = _orderNum;
    }

    /**
     * @return the _customerRef
     */
    public String getCustomerRef() {
        return _customerRef;
    }

    /**
     * @param _customerRef the _customerRef to set
     */
    public void setCustomerRef(String _customerRef) {
        this._customerRef = _customerRef;
    }

    /**
     * @return the _product
     */
    public Product getProduct() {
        return _product;
    }

    /**
     * @param _product the _product to set
     */
    public void setProduct(Product _product) {
        this._product = _product;
    }

    /**
     * @return the _quantity
     */
    public int getQuantity() {
        return _quantity;
    }

    /**
     * @param _quantity the _quantity to set
     */
    public void setQuantity(int _quantity) {
        this._quantity = _quantity;
    }

    /**
     * @return the _unitPrice
     */
    public float getUnitPrice() {
        return _unitPrice;
    }

    /**
     * @param _unitPrice the _unitPrice to set
     */
    public void setUnitPrice(float _unitPrice) {
        this._unitPrice = _unitPrice;
    }
    
}
