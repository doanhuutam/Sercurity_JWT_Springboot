package com.example.be.controller;

import com.example.be.dto.reponse.ReponseMessage;
import com.example.be.model.Product;
import com.example.be.security.userprincal.UserDetailServiceImpl;
import com.example.be.service.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/product")
@CrossOrigin("*")
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    UserDetailServiceImpl userDetailService;
//    @GetMapping("/show")
//    public ResponseEntity showProduct(@PageableDefault(value = 2,sort = {"id"},direction = Sort.Direction.ASC)Pageable pageable) {
//        Page<Product> list = productService.showAllProduct(pageable);
//        return new ResponseEntity(list, HttpStatus.OK);
//    }
//    list sản phẩm
    @GetMapping("/show")
    public ResponseEntity showProduct(){
        Iterable<Product> list=productService.showAllProduct();
        return new ResponseEntity(list,HttpStatus.OK);
    }
//    tìm kiếm 2 in 1
    @GetMapping("/seach")
    public ResponseEntity seachName(@RequestParam String name) {
        Iterable<Product> lists = productService.searchByName(name);
        return new ResponseEntity(lists, HttpStatus.OK);
    }
//    tìm kiếm sản phẩm
    @GetMapping("/findById/{id}")
    public ResponseEntity findById(@PathVariable long id){
        Optional<Product> list=productService.findById(id);
        return new ResponseEntity(list,HttpStatus.OK);
    }
//tạo mới sản phẩm
    @PostMapping("/create")
    public ResponseEntity<?> createProduct(@RequestBody Product product) {
        if (product.getName() == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
//        product.setNpp(userDetailService.getCurrentUser().getName());
//        System.out.println("----------"+userDetailService.getCurrentUser()+"---------");
        productService.save(product);
        return new ResponseEntity(new ReponseMessage("ahihi đồ ngốc"),HttpStatus.OK);
    }
//xoá sản phẩm
    @DeleteMapping("deleteProduct/{id}")
    public ResponseEntity deleteProduct(@PathVariable long id) {
        productService.delete(id);
        return new ResponseEntity(new ReponseMessage("đã xoá"),HttpStatus.OK);
    }
//sửa chữa sản phẩm
    @PutMapping("/update/{id}")
    public ResponseEntity updateProduct(@RequestBody Product product, @PathVariable long id) {
        productService.save(product);
        return new ResponseEntity(new ReponseMessage("update oke"), HttpStatus.OK);
    }
}

