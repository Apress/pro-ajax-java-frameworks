package com.proajax.chapt7.ui;

import com.proajax.chapt7.domain.Product;
import java.util.List;

public class ProductSearchResult {

    private List<Product> products;
    private int resultCount;
    
    public ProductSearchResult(List<Product> products) {
        this.products = products;
        resultCount = products.size();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public int getResultCount() {
        return resultCount;
    }

    public void setResultCount(int resultCount) {
        this.resultCount = resultCount;
    }
    
}
