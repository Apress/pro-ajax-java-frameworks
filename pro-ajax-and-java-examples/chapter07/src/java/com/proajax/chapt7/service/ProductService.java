package com.proajax.chapt7.service;

import com.proajax.chapt7.domain.Product;
import java.util.List;

public interface ProductService {
    public List<Product> findProductsByDepartment(String department);

    public void updatePrice(Long productId, Double newPrice);
    
}
