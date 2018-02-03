package com.bala.camel.demo.bean;

/**
 * Created by engan.bala on 31-01-2018.
 */
public class CamelBean {

    public String map(String input){
        return input.replaceAll(",","*");
    }
}
