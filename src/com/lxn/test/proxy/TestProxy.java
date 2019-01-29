package com.lxn.test.proxy;

import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Proxy;

public class TestProxy {
    public static void main(String[] args) {
        MethodImpl imp = new MethodImpl();
        MethodInvocationHandler handler = new MethodInvocationHandler(imp);
        IMethod method = (IMethod) Proxy.newProxyInstance(IMethod.class.getClassLoader(), new Class[]{IMethod.class}, handler);
        method.callMethod();

        byte[] bytes = ProxyGenerator.generateProxyClass("Proxy0", new Class[]{IMethod.class});
        String fileName = System.getProperty("user.dir") + "/Proxy.class";
        File file = new File(fileName);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(bytes);
            fos.flush();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
