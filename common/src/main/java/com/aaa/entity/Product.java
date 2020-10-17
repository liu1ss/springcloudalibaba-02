package com.aaa.entity;


import lombok.Data;

@Data
public class Product {

    private String pname;
    private Integer pid;
    private String price;
    private Integer kucun;

    public Product() {
    }

//    public String getPname() {
//        return pname;
//    }
//
//    public void setPname(String pname) {
//        this.pname = pname;
//    }
//
//    public Integer getPid() {
//        return pid;
//    }
//
//    public void setPid(Integer pid) {
//        this.pid = pid;
//    }
//
//    public String getPrice() {
//        return price;
//    }
//
//    public void setPrice(String price) {
//        this.price = price;
//    }
//
//    public Integer getKucun() {
//        return kucun;
//    }
//
//    public void setKucun(Integer kucun) {
//        this.kucun = kucun;
//    }

    public Product(String pname, Integer pid, String price, Integer kucun) {
        this.pname = pname;
        this.pid = pid;
        this.price = price;
        this.kucun = kucun;
    }
}
