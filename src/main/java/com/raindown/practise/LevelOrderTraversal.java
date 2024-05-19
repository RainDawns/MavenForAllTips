package com.raindown.practise;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    List<TreeNode> children;

    TreeNode(int val) {
        this.val = val;
        this.children = new ArrayList<>();
    }
}

public class LevelOrderTraversal {
    public static List<Integer> levelOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                result.add(node.val);

                for (TreeNode child : node.children) {
                    queue.offer(child);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // 创建一个多叉树
        TreeNode root = new TreeNode(1);
        TreeNode child1 = new TreeNode(2);
        TreeNode child2 = new TreeNode(3);
        TreeNode child3 = new TreeNode(4);
        TreeNode grandchild1 = new TreeNode(5);
        TreeNode grandchild2 = new TreeNode(6);
        TreeNode grandchild3 = new TreeNode(7);

        root.children.add(child1);
        root.children.add(child2);
        root.children.add(child3);

        child1.children.add(grandchild1);
        child1.children.add(grandchild2);

        child3.children.add(grandchild3);

        // 层序遍历多叉树
        List<Integer> levelOrderTraversal = levelOrder(root);

        // 打印结果
        for (int val : levelOrderTraversal) {
            System.out.print(val + " ");
        }
    }
}