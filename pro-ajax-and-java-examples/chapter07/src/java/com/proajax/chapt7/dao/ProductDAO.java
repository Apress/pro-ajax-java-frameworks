package com.proajax.chapt7.dao;

import com.proajax.chapt7.domain.Product;
import java.util.List;

public interface ProductDAO {
    
    public List<Product> findProductsByDepartment(String department);

    public void updateProductPrice(Long productId, Double price);
}
