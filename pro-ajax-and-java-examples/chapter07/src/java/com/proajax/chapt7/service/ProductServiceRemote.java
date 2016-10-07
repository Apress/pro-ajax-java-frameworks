package com.proajax.chapt7.service;

import com.proajax.chapt7.domain.Product;
import com.proajax.chapt7.ui.ProductSearchResult;
import com.proajax.chapt7.ui.UpdateProductPriceResult;
import java.util.List;

public class ProductServiceRemote {

    private ProductService productService;
    
    public ProductSearchResult findProductsByDepartment(String department) {
        List<Product> products = productService.findProductsByDepartment(department);
        ProductSearchResult result = new ProductSearchResult(products);
        return result;
    }
    
    public UpdateProductPriceResult updateProductPrice(Long productId
            , Double newPrice) {
        UpdateProductPriceResult result = new UpdateProductPriceResult();
        result.setSuccessful(true);
        
        try {
            productService.updatePrice(productId, newPrice);
        }
        catch(Throwable t) {
            result.setSuccessful(false);
            result.setErrorMessage(t.toString());
        }
        
        return result;
    }

    public ProductService getProductService() {
        return productService;
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
}
