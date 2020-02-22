package com.lxn.test;

import java.util.ArrayList;
import java.util.Collections;

public class TestBTree {
    public static void main(String[] args) {
        BTree bTree = new BTree();
//        bTree.createBTree();
//        System.out.print("前序遍历");
////        bTree.preOrder();
//        bTree.nonRecPreOrder(bTree.root);
//        System.out.print("中序遍历");
//        bTree.inOrder();
//        System.out.print("后序遍历");
//        bTree.postOrder();
//        System.out.println("高度" + bTree.getHeight());
//        System.out.println("节点数目" + bTree.getNodeCount());
        String[] arrArray = {"A","B","D","#","#","E","#","#","C","#","F"};
        ArrayList<String> dataList = new ArrayList<>();
        Collections.addAll(dataList, arrArray);
        bTree.createBTreePre(dataList);
//        bTree.preOrder();
        bTree.searchNode(0);
    }
}
