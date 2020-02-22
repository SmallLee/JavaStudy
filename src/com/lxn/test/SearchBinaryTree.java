package com.lxn.test;

import sun.awt.geom.AreaOp;

// 查找二叉树
public class SearchBinaryTree {
    public static void main(String[] args) {
        SearchBinaryTree tree = new SearchBinaryTree();
        int[] arr = {50,30,60,44,22,28,45};
        for(int i : arr) {
            tree.put(i);
        }
        tree.inOrder(tree.root);
    }
    private TreeNode root;

    private void put(int data) {
        TreeNode node;
        TreeNode parent = null;
        node = new TreeNode(0,data);
        if (root == null) {
            root = node;
        }
        node = root;
        while (node != null) {
            parent = node;
            if (data > node.data) {
                node = node.rightChild;
            } else if (data < node.data) {
                node = node.leftChild;
            } else {
                return;
            }
        }
        node = new TreeNode(0,data);
        if (data >parent.data) {
            parent.rightChild = node;
        } else {
            parent.leftChild = node;
        }
        node.parent = parent;
    }

    private void inOrder(TreeNode tree) {
        if (tree != null) {
            inOrder(tree.leftChild);
            System.out.println(tree.data);
            inOrder(tree.rightChild);
        }
    }

    class TreeNode{
        int key;
        TreeNode leftChild;
        TreeNode rightChild;
        TreeNode parent;
        int data;

        TreeNode(int key, int data) {
            this.key = key;
            this.data = data;
            this.leftChild = null;
            this.rightChild = null;
            this.parent = null;
        }
    }
}
