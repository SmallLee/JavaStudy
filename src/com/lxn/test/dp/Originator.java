package com.lxn.test.dp;

import java.lang.reflect.Modifier;

/**
 * 需要被备忘录存储的对象
 */
public class Originator {
    private int life;

    public void play() {
        life -= 10;
    }

    public Memoto createMemoto() {
        Memoto memoto = new Memoto();
        memoto.life = life;
        return memoto;
    }

    public void restoreMemoto(Memoto memoto) {
        life = memoto.life;
    }
}
