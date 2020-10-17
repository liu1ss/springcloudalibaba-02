package com.bbb.controller;

import com.aaa.entity.Product;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.bbb.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class OrderControler {

    private int i=0;

    @Resource
    private IOrderService orderService;

    @RequestMapping("oqueryAll")
    public List<Product> queryAll(){
        //查询出所有的商品的信息
       List<Product> plist=orderService.findAll();
       return plist;
    }


    @RequestMapping("test1")
    public String test1(){

        i++;
        if(i%2==0){
            throw new RuntimeException("异常！！！！");
        }
        return "test1";
    }
    @RequestMapping("test2")
    public String test2(){
        return "test1";
    }


    @RequestMapping("test3")
    @SentinelResource(value = "testt")
    public String test3(String name,Integer age){
        return name+age;

    }
}
