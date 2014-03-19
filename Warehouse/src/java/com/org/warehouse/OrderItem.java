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
public class OrderItem {
    
    private Product _product;
    private int _quantity;
    
    public OrderItem(Product p, int q)
    {
        _product = p;
        _quantity = q;
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
    
}
