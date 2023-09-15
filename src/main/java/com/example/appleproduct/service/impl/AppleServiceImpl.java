package com.example.appleproduct.service.impl;

import com.example.appleproduct.entity.Apple;
import com.example.appleproduct.repo.AppleRepo;
import com.example.appleproduct.service.AppleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class AppleServiceImpl implements AppleService {

    @Autowired
    private AppleRepo appleRepo;

    @Override
    public Apple addProduct(Apple apple){
        return appleRepo.save(apple);
    }

    @Override
    public List<Apple> getProductList(){
        return (List<Apple>) appleRepo.findAll();
    }

    @Override
    public Apple updateProduct(Apple apple,Long id){
        Apple appleDB = appleRepo.findById(id).get();

        if (apple.getSeries() > 0 ) appleDB.setSeries(apple.getSeries());

        if (Objects.nonNull(apple.getProduct_name())
        && !"".equalsIgnoreCase(
                apple.getProduct_name())){
            appleDB.setProduct_name(
                    apple.getProduct_name()
            );
        }

        if (Objects.nonNull(apple.getProduct_series())
                && !"".equalsIgnoreCase(
                apple.getProduct_series())){
            appleDB.setProduct_series(
                    apple.getProduct_series()
            );
        }

        if (Objects.nonNull(apple.getStorage())
                && !"".equalsIgnoreCase(
                apple.getStorage())){
            appleDB.setSeries(
                    apple.getSeries()
            );
        }

        if (apple.getPrice() > 0 ) appleDB.setPrice(apple.getPrice());

        return appleRepo.save(appleDB);
    }

    @Override
    public void deleteProductById(Long id) {
        appleRepo.deleteById(id);
    }
}
