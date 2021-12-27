package com.example.be.service;

import com.example.be.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPoductService {
    Product save(Product product);
//    Page<Product> showAllProduct(Pageable pageable);
    Iterable<Product> showAllProduct();
    void delete(long id);
}
