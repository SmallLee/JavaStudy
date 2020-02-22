package com.lxn.test.dp;

/**
 * 用户自定义的拦截器
 */
public class CacheInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) {
        System.out.println("CacheInterceptor before");
        Response response = new Response();
        System.out.println("CacheInterceptor after");
        return response;
    }
}
