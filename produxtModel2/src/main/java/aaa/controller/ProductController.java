package aaa.controller;

import com.aaa.entity.Product;
import aaa.service.IProductService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class ProductController {

    @Resource
private IProductService productService;
    //查询所有的商品信息
    @RequestMapping("pgetAll")
    public List<Product> getAll(){

        return productService.findAll();
    }

}
