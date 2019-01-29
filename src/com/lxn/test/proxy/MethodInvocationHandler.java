package com.lxn.test.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MethodInvocationHandler implements InvocationHandler {
    private Object target;
    MethodInvocationHandler(Object target) {
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("前置通知");
        Object result = method.invoke(target, args);
        System.out.println("后置通知");
        return result;
    }
}
