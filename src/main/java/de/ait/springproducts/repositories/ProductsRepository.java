package de.ait.springproducts.repositories;

import de.ait.springproducts.models.Product;

import java.util.List;

public interface ProductsRepository {
    void save (Product product);
    List<Product> findAll();
}
