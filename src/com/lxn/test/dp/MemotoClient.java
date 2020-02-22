package com.lxn.test.dp;

import javax.swing.text.Caret;

public class MemotoClient {
    public static void main(String[] args) {
        Originator originator = new Originator();
        originator.play();
        CareTaker careTaker = new CareTaker();
        // 存档
        careTaker.archive(originator.createMemoto());
        // 恢复游戏
        Originator newOriginator = new Originator();
        newOriginator.restoreMemoto(careTaker.getMemoto());
    }
}
