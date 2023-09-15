package com.example.appleproduct.controller;


import com.example.appleproduct.entity.Apple;
import com.example.appleproduct.service.AppleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class AppleController {
    @Autowired
    private AppleService appleService;

    @GetMapping("/All")
    public List<Apple> getAllProducts(){
        return appleService.getProductList();
    }

    @GetMapping("/{id}")
    public Apple getProductById(@PathVariable Long id){
        return appleService.getProductList()
                .stream().filter(apple -> apple.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @PostMapping("/add")
    public Apple add(@RequestBody Apple apple){
        return appleService.addProduct(apple);
    }

    @PutMapping("/{id}")
    public Apple updateProduct(@RequestBody Apple apple,@PathVariable("id")Long id){
        return appleService.updateProduct(apple, id);
    }

    @DeleteMapping("/{id}")
    public String deleteProductById(@PathVariable("id")Long id){
        appleService.deleteProductById(id);
        return "Deleted Successfully";
    }
}
