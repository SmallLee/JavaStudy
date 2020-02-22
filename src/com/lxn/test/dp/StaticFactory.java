package com.lxn.test.dp;

/*
*  简单工厂模式或者静态工厂模式，
* */
public class StaticFactory {
    public static Product createProduct(Class clazz) {
        Product p = null;
        try {
            p = (Product) clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return p;
    }
}
