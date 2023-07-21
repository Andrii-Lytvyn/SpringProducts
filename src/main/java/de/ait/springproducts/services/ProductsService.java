package de.ait.springproducts.services;

import de.ait.springproducts.models.Product;

import java.util.List;

public interface ProductsService {
    void addProduct(String title, String barcode);
    List<Product> getAllProducts();
}
