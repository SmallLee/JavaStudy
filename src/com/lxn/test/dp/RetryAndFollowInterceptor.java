package com.lxn.test.dp;

/**
 * 用户自定义的拦截器
 */
public class RetryAndFollowInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) {
        System.out.println("RetryAndFollowInterceptor before");
        Response response = chain.proceed(chain.request());
        System.out.println("RetryAndFollowInterceptor after");
        return response;
    }
}
