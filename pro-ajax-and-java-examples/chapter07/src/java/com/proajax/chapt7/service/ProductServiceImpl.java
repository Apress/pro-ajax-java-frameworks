package com.proajax.chapt7.service;

import com.proajax.chapt7.dao.ProductDAO;
import com.proajax.chapt7.domain.Product;
import com.proajax.chapt7.ui.ProductSearchResult;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    private ProductDAO productDAO = null;
    
    public List<Product> findProductsByDepartment(String department) {
        List<Product> products = 
                productDAO.findProductsByDepartment(department);
        return products;
    }

    public ProductDAO getProductDAO() {
        return productDAO;
    }

    public void setProductDAO(ProductDAO inventoryDAO) {
        this.productDAO = inventoryDAO;
    }
    
    public void updatePrice(Long productId, Double newPrice) {
        productDAO.updateProductPrice(productId, newPrice);
    }
}
