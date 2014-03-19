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



public class Product {
  
    private String _manufacturerName;
    private String _productType;
    private float _unitPrice;
    
    public Product()
    {
        _manufacturerName = "";
        _productType = "";
        _unitPrice = 0;
    }
    
    public Product(String _manufacturerName, String _productType, float _unitPrice)
    {
        this._manufacturerName = _manufacturerName;
        this._productType = _productType;
        this._unitPrice = _unitPrice;
    }

      
    /**
     * @return the _manufacturerName
     */
    public String getManufacturerName() {
        return _manufacturerName;
    }

    /**
     * @param _manufacturerName the _manufacturerName to set
     */
    public void setManufacturerName(String _manufacturerName) {
        this._manufacturerName = _manufacturerName;
    }

    /**
     * @return the _productType
     */
    public String getProductType() {
        return _productType;
    }

    /**
     * @param _productType the _productType to set
     */
    public void setProductType(String _productType) {
        this._productType = _productType;
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

    /**
     * @return the _productTypeshould
     */

}
