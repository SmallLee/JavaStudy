package com.lxn.test.dp;

public class LoginState implements UserState {
    @Override
    public void forward() {
        System.out.println("转发");
    }

    @Override
    public void comment() {
        System.out.println("评论");
    }
}
