package com.lxn.test;


import com.sun.deploy.panel.TreeRenderers;
import javafx.scene.transform.Rotate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class BTree {
    TreeNode<String> root = null;
    private TreeNode<String> nodeB;
    private TreeNode<String> nodeC;
    private List<String> nodeList = Arrays.asList("B","C","D","E","F");
    BTree() {
        root = new TreeNode<>(1,"A");
    }

    /**
     * 构建如下的二叉树
     *           A
     *       B       C
     *   D      E        F
     */
    void createBTree() {
        for (int i = 0; i < nodeList.size(); i++) {
            String node = nodeList.get(i);
            TreeNode<String> treeNode = new TreeNode<>(i + 2,node);
            if (node.equals("B")) {
                root.leftChild = nodeB = treeNode;
            }
            if (node.equals("C")){
                root.rightChild = nodeC = treeNode;
            }
            if (node.equals("D")) {
                nodeB.leftChild = treeNode;
            }
            if (node.equals("E")) {
                nodeB.rightChild = treeNode;
            }
            if (node.equals("F")) {
                nodeC.rightChild = treeNode;
            }
        }
    }

    // 二叉树高度,叶子节点的最大高度
    public int getHeight() {
        return getHeight(root);
    }

    public int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            int i = getHeight(node.leftChild);
            int j = getHeight(node.rightChild);
            return Math.max(i,j) + 1;
        }
    }

    public int getNodeCount() {
        return getNodeCount(root);
    }

    public int getNodeCount(TreeNode treeNode) {
        if (treeNode != null) {
            return 1 + getNodeCount(treeNode.leftChild) + getNodeCount(treeNode.rightChild);
        } else {
            return 0;
        }
    }

    void preOrder() {
        preOrder(root);
    }

    // 前序遍历
    void preOrder(TreeNode treeNode) {
        if (treeNode != null) {
            System.out.print(treeNode.data);
            preOrder(treeNode.leftChild);
            preOrder(treeNode.rightChild);
        }
    }

    // 非迭代前序遍历,压入根节点，弹根节点，然后依次压入右节点和左节点
    public void nonRecPreOrder(TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(treeNode);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.println("nonRecPreOrder " + node.data);
            if (node.rightChild != null ){
                stack.push(node.rightChild);
            }
            if (node.leftChild != null) {
                stack.push(node.leftChild);
            }
        }
    }
    void inOrder() {
        inOrder(root);
    }
    // 中序遍历
    void inOrder(TreeNode treeNode) {
        if (treeNode != null) {
            inOrder(treeNode.leftChild);
            System.out.print(treeNode.data);
            inOrder(treeNode.rightChild);
        }
    }

    void postOrder() {
        postOrder(root);
    }
    // 后序遍历
    private void postOrder(TreeNode treeNode) {
        if (treeNode != null) {
            postOrder(treeNode.leftChild);
            postOrder(treeNode.rightChild);
            System.out.print(treeNode.data);
        }
    }

    /**
     * 根据前序数据构建二叉树
     *
     */
    TreeNode createBTreePre(ArrayList<String> data) {
        return createBTreePre(data.size(),data);
    }

    private TreeNode createBTreePre(int size, ArrayList<String> data) {
        if (data.size() == 0) {
            return null;
        }
        TreeNode<String> node;
        String nodeValue = data.get(0);
        int index = size - data.size();
        if ("#".equals(nodeValue)) {
            data.remove(0);
            node = null;
            return node;
        }
        node = new TreeNode<>(index,nodeValue);
        if (index == 0) {
            root = node;
        }
        data.remove(0);
        node.leftChild = createBTreePre(size,data);
        node.rightChild = createBTreePre(size,data);
        return node;
    }

    // 删除节点
    public TreeNode deleteNode(int key) {
        TreeNode node = searchNode(key);
        if (node == null) {
            return null;
        } else {
            TreeNode parent = node.parent;
            // 删除的节点没有左子树和右子树，判断该节点是父节点的左子树还是右子树，置为null
            if (node.leftChild == null && node.rightChild == null) {
                if (node == parent.leftChild) {
                    parent.leftChild = null;
                } else {
                    parent.rightChild = null;
                }
            }
            // 删除的节点有左子树，没有右子树
            if (node.leftChild != null && node.rightChild == null) {
                if (node == parent.leftChild) {
                    parent.leftChild = node.leftChild;
                } else {
                    parent.rightChild = node.leftChild;
                }
            }
            // 删除的节点有右子树，没有左子树
            if (node.leftChild == null && node.rightChild != null) {
                if (node == parent.leftChild) {
                    parent.leftChild = node.rightChild;
                } else {
                    parent.rightChild = node.rightChild;
                }
            }
        }
        return null;
    }

    // 查找节点
    public TreeNode searchNode(int key) {
        TreeNode<Integer> node = new TreeNode<>(1,50);
            while (node != null && node.data != key) {
                if (key > node.data) {
                    node = node.rightChild;
                } else {
                    node = node.rightChild;
                }
            }
            return node;
    }
    /*
    * 构建查找二叉树
    * */
    public void putTreeNode(int value) {

    }

    public class TreeNode<T> {
        private int index;
        private T data;
        TreeNode<T> leftChild;
        TreeNode<T> rightChild;
        TreeNode<T> parent;

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        TreeNode(int index, T data) {
            this.index = index;
            this.data = data;
            this.leftChild = null;
            this.rightChild = null;
        }
    }
}
