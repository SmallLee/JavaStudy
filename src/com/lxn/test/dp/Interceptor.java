package com.lxn.test.dp;

/**
 * 拦截器
 */
public interface Interceptor {
    Response intercept(Chain chain);
}
