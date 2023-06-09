package com.ey.assettrackingsystem.service;

import com.ey.assettrackingsystem.entity.LaptopProduct;
import com.ey.assettrackingsystem.repository.LaptopProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaptopProductService {

    @Autowired
    private LaptopProductRepository productRepository;

    public List<LaptopProduct> getAllProducts() {
        return productRepository.findAll();
    }

    public LaptopProduct getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public LaptopProduct createProduct(LaptopProduct product) {
        return productRepository.save(product);
    }

    public LaptopProduct updateProduct(LaptopProduct product) {
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
