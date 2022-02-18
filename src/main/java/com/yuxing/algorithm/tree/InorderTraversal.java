package com.yuxing.algorithm.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 二叉树的中序遍历
 *
 * 二叉树三种遍历：
 *  1.先(根)序遍历：根 左 右
 *  2.中(根)序遍历：左 根 右
 *  3.后(根)序遍历：左 右 根
 *
 * @author yuxing
 * @since 2022/2/18
 */
public class InorderTraversal {

    /**
     * 中序遍历：左树 根 右树
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> result = new ArrayList<>();
        result.addAll(this.inorderTraversal(root.left));
        result.add(root.val);
        result.addAll(this.inorderTraversal(root.right));
        return result;
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
