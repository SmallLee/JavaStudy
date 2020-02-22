package com.lxn.test.dp;

import com.sun.deploy.net.proxy.ProxyUnavailableException;

public class ConcretFactory extends Factory {
    @Override
    Product createProduct(Class clazz) {
        Product p = null;
        try {
            p = (Product) clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return p;
    }
}
