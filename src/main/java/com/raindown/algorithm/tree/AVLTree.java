package com.raindown.algorithm.tree;


/**
 * @author: RainDown
 * @description: 平衡二叉树:左右子树
 * @date: 2023/11/17 17:23
 * @version: 1.0
 */
public class AVLTree {

    class Node {
        Node left;
        Node right;

        int value;
    }

    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());


    }


    public static boolean IsBalanced_Solution(Node root) {

        if (root == null) return true;

        if (Math.abs(getHeight(root.left) - getHeight(root.right)) > 1) return false;

        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }

    public static int getHeight(Node root) {

        if (root == null) return 0;
        return max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    private static int max(int a, int b) {

        return (a > b) ? a : b;
    }


}
