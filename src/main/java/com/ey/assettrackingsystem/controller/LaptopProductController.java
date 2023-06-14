package com.ey.assettrackingsystem.controller;

import com.ey.assettrackingsystem.entity.LaptopProduct;
import com.ey.assettrackingsystem.service.LaptopProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LaptopProductController {
    @Autowired
    private LaptopProductService productService;

    @GetMapping("/get-all-laptop")
    public List<LaptopProduct> getAllProducts() {
        List<LaptopProduct> products = productService.getAllProducts();
        return products;
    }

    @GetMapping("/{id}")
    public LaptopProduct getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PostMapping("/create-product")
    public LaptopProduct createProduct(@RequestBody LaptopProduct product) {
        return productService.createProduct(product);
    }

    @PutMapping("/{id}")
    public LaptopProduct updateProduct(@PathVariable Long id, @RequestBody LaptopProduct product) {
        LaptopProduct existingProduct = productService.getProductById(id);
        if (existingProduct == null) {
            throw new IllegalArgumentException("Product not found with id: " + id);
        }
        existingProduct.setName(product.getName());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setProcessor(product.getProcessor());
        existingProduct.setRam(product.getRam());
        existingProduct.setStorage(product.getStorage());
        return productService.updateProduct(existingProduct);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}
