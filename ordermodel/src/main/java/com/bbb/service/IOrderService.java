package com.bbb.service;

import com.aaa.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@FeignClient(value="product",fallback =OrderServiceImpl.class)
public interface IOrderService {
    @RequestMapping("pgetAll")
    List<Product> findAll();
}
