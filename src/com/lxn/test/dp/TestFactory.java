package com.lxn.test.dp;

public class TestFactory {
    public static void main(String[] args) {
        Factory factory = new ConcretFactory();
        Product product = factory.createProduct(ProductB.class);
        product.method();
    }
}
