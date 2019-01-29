package com.lxn.test;

import java.util.ArrayList;
import java.util.List;

public class TestPriority {
    private static List<Priority> list = new ArrayList<>();
    public static void main(String[] args) {
//        Priority priority2 = new Priority(2);
//        list.add(priority2);
        Priority priority3 = new Priority(3);
        for (int j = 0; j < 10 ; j++) {
            Priority p = new Priority(j);
            for (int i = 0; i <= list.size(); i++) {
                if (i == list.size() || p.priority > list.get(i).priority) {
                    list.add(i,p);
                    break;
                }
            }
        }

        printList();
    }

    public static void printList(){
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).priority);
        }
    }

}
