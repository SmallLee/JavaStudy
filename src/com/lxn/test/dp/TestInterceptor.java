package com.lxn.test.dp;

import java.util.ArrayList;
import java.util.List;

public class TestInterceptor {
    public static void main(String[] args) {
        UserInterceptor userInterceptor = new UserInterceptor();
        RetryAndFollowInterceptor retryAndFollowInterceptor = new RetryAndFollowInterceptor();
        List<Interceptor> interceptorList = new ArrayList<>();
        interceptorList.add(userInterceptor);
        interceptorList.add(retryAndFollowInterceptor);
        interceptorList.add(new CacheInterceptor());
        Request request = new Request();
        RealInterceptChain realInterceptChain = new RealInterceptChain(request,interceptorList, 0);
        realInterceptChain.proceed(request);
    }
}
