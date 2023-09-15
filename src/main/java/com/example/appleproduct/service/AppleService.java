package com.example.appleproduct.service;

import com.example.appleproduct.entity.Apple;

import java.util.List;

public interface AppleService {

    Apple addProduct(Apple apple);

    List<Apple> getProductList();

    Apple updateProduct(Apple apple, Long id);

    void deleteProductById(Long id);
}
