package com.lxn.test.dp;

/**
 * 用户自定义的拦截器
 */
public class UserInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) {
        System.out.println("UserInterceptor before");
        Response response = chain.proceed(chain.request());
        System.out.println("UserInterceptor after");
        return response;
    }
}
