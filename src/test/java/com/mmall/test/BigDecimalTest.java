package com.mmall.test;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created by Yelun on 2017/6/2.
 */
public class BigDecimalTest {

    @Test
    public void Test(){
        System.out.println(0.05+0.01);
        System.out.println(1.0-0.42);
        System.out.println(4.015*100);
        System.out.println(123.3/100);
    }

    @Test
    public void test2(){
        BigDecimal b1 = new BigDecimal(0.05);
        BigDecimal b2 = new BigDecimal(0.01);
        System.out.println(b1.add(b2));

    }
    //BigDecimal String类型构造器，封装这种类型的工具类与数据库的字段double与float数字类型兼容
    @Test
    public void test3(){
        BigDecimal b1 = new BigDecimal("0.05");
        BigDecimal b2 = new BigDecimal("0.01");
        System.out.println(b1.add(b2));

    }
}
