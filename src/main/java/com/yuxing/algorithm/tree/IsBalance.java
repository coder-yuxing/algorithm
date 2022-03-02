package com.yuxing.algorithm.tree;

/**
 * 判断一颗二叉树是否是平衡二叉树
 *
 * @author yuxing
 * @since 2022/3/2
 */
public class IsBalance {

    /**
     * 是否为平衡二叉树
     * 平衡二叉树：左右子树高度差不能超过1
     *
     * @param tree 二叉树
     * @return 是|否
     */
    public static boolean isBalance(TreeNode tree) {
        if (tree == null) {
            return true;
        }
        return Math.abs(height(tree.left) - height(tree.right)) <= 1 && isBalance(tree.left) && isBalance(tree.right);
    }

    /**
     * 计算树的高度
     *
     * @param tree 二叉树
     * @return 树高
     */
    public static int height(TreeNode tree) {
        if (tree == null) {
            return 0;
        }
        return Math.max(height(tree.left), height(tree.right)) + 1;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
        }
    }
}
