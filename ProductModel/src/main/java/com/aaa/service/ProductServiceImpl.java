package com.aaa.service;

import com.aaa.entity.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements IProductService{

    @Override
    public List<Product> findAll() {
        List<Product> productList=new ArrayList<Product>();
        Product p=new Product("testp8472",1,"58",78);
        Product p2=new Product("testp284722",2,"78",87);
        productList.add(p);
        productList.add(p2);
        //productList.add();

        return productList;
    }
}
