package com.bbb.service;

import com.aaa.entity.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {

    public List<Product> findAll() {
        List<Product> plist=new ArrayList<>();
        Product p=new Product();
        p.setPname("错误的产品信息");
        plist.add(p);
       // List<Product> plist= restTemplate.getForObject("http://product/pgetAll",List.class);
        return plist;
    }
}
