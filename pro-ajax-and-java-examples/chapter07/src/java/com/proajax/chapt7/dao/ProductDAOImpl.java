package com.proajax.chapt7.dao;

import com.proajax.chapt7.domain.Product;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {
 
    public List<Product> findProductsByDepartment(String department) {
        if(department.trim().equalsIgnoreCase("grocery")) {
            return getGroceryProducts();
        }
        else if(department.trim().equalsIgnoreCase("clothing")) {
            return getClothingProducts();
        }
        else if(department.trim().equalsIgnoreCase("sporting")) {
            return getSportingGoodsProducts();
        }
        else if(department.trim().equalsIgnoreCase("home")) {
            return getHomeFurnishingsProducts();
        }
        
        return getGroceryProducts();
    }
    
    public void updateProductPrice(Long productId, Double price) {
        // persist the new price to the database
    }
    
    private List getGroceryProducts() {
        List products = new ArrayList();
        
        products.add(new Product(new Long(1), "WonderLoad Bread", 
                "Dual pack of healthy wheat bread", 1.59));
        products.add(new Product(new Long(2),"Heartland Gallon Milk", 
                "One gallon of 2% milk", 2.34));
        products.add(new Product(new Long(3), "Ultra Chip Cookies", 
                "Pack of chocolate chip cookies", 3.72));
        products.add(new Product(new Long(4),"Crunchy Potato Chips", 
                "Bag of super crunchy potato chips", 2.51));
        
        return products;
    }
    
    private List getClothingProducts() {
        List products = new ArrayList();
        
        products.add(new Product(new Long(5), "Minnesota Vikings Cap", 
                "Baseball cap featuring the Vikings logo", 15.99));
        products.add(new Product(new Long(6),"Jogging suit", 
                "All weather jogging suit", 44.99));
        products.add(new Product(new Long(7), "Leather Jacket", 
                "Leather jacket with removable liner", 115.89));
        products.add(new Product(new Long(8),"T-shirt", 
                "Cotton t-shirt in assorted colors", 9.99));
        
        return products;
        
    }

    private List getSportingGoodsProducts() {
        List products = new ArrayList();
        
        products.add(new Product(new Long(9), "Official Collegiate Football", 
                "The same football used in college football", 35.42));
        products.add(new Product(new Long(10),"Sleeve of Golf Balls", 
                "Sleeve of 3 golf balls", 12.71));
        products.add(new Product(new Long(11), "Spin Casting Reel", 
                "Spin casting fishing reel", 72.39));
        products.add(new Product(new Long(12),"Target", 
                "Paper bullseye target for target practice", 3.59));
        
        return products;
    }
    
    private List getHomeFurnishingsProducts() {
        List products = new ArrayList();
        
        products.add(new Product(new Long(13), "Coffee Table", 
                "Oak finished coffee table with glass top", 136.80));
        products.add(new Product(new Long(14),"Lamp", 
                "Single bulb lamp with brass finish", 41.65));
        products.add(new Product(new Long(15), "Glider Rocker", 
                "Glider rocker in assorted colors", 123.75));
        products.add(new Product(new Long(16),"Cordless Telephone", 
                "Cordless telephone with answering machine", 58.12));
        
        return products;
    }
}
