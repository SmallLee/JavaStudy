package com.lxn.test.dp;

import java.util.List;

public class RealInterceptChain implements Chain {
    private List<Interceptor> interceptorList;
    private int index = -1;
    Request request;

    public RealInterceptChain(Request request, List<Interceptor> interceptorList, int index) {
        this.request = request;
        this.interceptorList = interceptorList;
        this.index = index;
    }

    @Override
    public Request request() {
        return request;
    }

    @Override
    public Response proceed(Request request) {
        RealInterceptChain realInterceptChain = new RealInterceptChain(request, interceptorList, index + 1);
        Interceptor interceptor = interceptorList.get(index);
        Response response = interceptor.intercept(realInterceptChain);
        return response;
    }

}
