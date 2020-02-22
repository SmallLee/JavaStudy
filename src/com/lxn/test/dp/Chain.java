package com.lxn.test.dp;

/**
 *  链
 */
public interface Chain {
    Request request();

    Response proceed(Request request);
}
