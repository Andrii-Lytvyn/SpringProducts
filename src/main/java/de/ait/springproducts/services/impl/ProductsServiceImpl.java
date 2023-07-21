package de.ait.springproducts.services.impl;

import de.ait.springproducts.models.Product;
import de.ait.springproducts.repositories.ProductsRepository;
import de.ait.springproducts.services.ProductsService;
import de.ait.springproducts.validators.TitleValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductsServiceImpl  implements ProductsService {
    private final ProductsRepository productsRepository;
    private final TitleValidator titleValidator;

    @Override
    public void addProduct (String title, String barcode) {
        titleValidator.validate(title);
        Product product = new Product(title,barcode);
        productsRepository.save(product);
    }
    @Override
    public List<Product> getAllProducts() {
        return productsRepository.findAll();
    }
}
