package de.ait.springproducts.repositories.impl;

import de.ait.springproducts.models.Product;
import de.ait.springproducts.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Component;


import java.io.*;
import java.util.List;
import java.util.stream.Collectors;
@Repository
public class ProductsRepositoryFileImpl implements ProductsRepository {
    private final String fileName;

    public ProductsRepositoryFileImpl(@Value("${file.name}") String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void save(Product product) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(product.getTitle() + "#" + product.getBarcode());
            writer.newLine();
        }catch (IOException e){
            throw new IllegalArgumentException("Problems with file");
        }
    }
    @Override
    public List<Product> findAll() {
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            return br.lines()
                    .map(line -> line.split("#"))
                    .map(array -> new Product(array[0], array[1]))
                    .collect(Collectors.toList());
        }catch (IOException e) {
            throw new IllegalArgumentException("Problem with file");
        }
}
}
