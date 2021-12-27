package com.example.be.service.impl;

import com.example.be.model.Product;
import com.example.be.repository.IProductRepository;
import com.example.be.service.IPoductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IPoductService {
    @Autowired
    IProductRepository productRepository;

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

//    @Override
//    public Page<Product> showAllProduct(Pageable pageable) {
//        return productRepository.findAll(pageable);
//    }
@Override
public Iterable<Product> showAllProduct() {
    return productRepository.findAll();
}


    @Override
    public void delete(long id) {
        productRepository.deleteById(id);
    }

    public List<Product> searchByName(String name) {
        return productRepository.searchByName(name);
    }
    public Optional<Product> findById(long id){
        return productRepository.findById(id);
    }
}
