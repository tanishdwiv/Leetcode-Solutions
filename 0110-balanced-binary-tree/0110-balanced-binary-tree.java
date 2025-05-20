/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
            return height(root)!=-1;
        
    }
    static int height(TreeNode node){
        if(node==null)
        return 0;
        int leftheight=height(node.left);
        if(leftheight==-1)
        return -1;
        int rightheight=height(node.right);
        if(rightheight==-1)
        return -1;
        if(Math.abs(leftheight-rightheight)>1)//i have applied this condition to check for balance binary tree if its greater than 1 than its unbalanced
        return -1;
        return 1+Math.max(leftheight,rightheight);//this will return the height of the binary tree

    }
}