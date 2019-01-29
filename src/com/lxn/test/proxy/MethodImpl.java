package com.lxn.test.proxy;

public class MethodImpl implements IMethod {
    @Override
    public void callMethod() {
        System.out.println("业务方法");
    }
}
