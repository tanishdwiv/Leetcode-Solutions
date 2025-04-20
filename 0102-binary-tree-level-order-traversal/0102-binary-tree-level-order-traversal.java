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
    public List<List<Integer>> levelOrder(TreeNode root) {
        // List<List<Integer>> ans=new LinkedList<List<Integer>>();
        // Queue<TreeNode> q=new LinkedList<TreeNode>();
        // if(root==null)
        // return ans;
        // q.add(root);
        // while(!q.isEmpty()){
        //     int size=q.size();
           
        //     List<Integer> list=new LinkedList<Integer>();
            
        //     for(int i=0;i<size;i++){
        //         TreeNode node=q.poll();
        //         list.add(node.val);
        //         if(node.left!=null)
        //         q.add(node.left);
        //         if(node.right!=null)
        //         q.add(node.right);
            
        //     }
        //     ans.add(list);
        // }
        // return ans;
        //remove print add children

        List<List<Integer>> ans=new LinkedList<List<Integer>>();
        Queue<TreeNode> queue=new LinkedList<>();
        if(root==null)
        return ans;
        queue.add(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            List<Integer> list=new LinkedList<>();
            for(int i=0;i<size;i++){
            TreeNode num=queue.poll();
            list.add(num.val);
            if(num.left!=null)
            queue.add(num.left);
            if(num.right!=null)
            queue.add(num.right);
        }
         ans.add(list);
        }
        return ans;
    }
}
//root node ko queue mai add krdenge than uss node ka left aur right exist krta h toh usse bhi queue mai daal denge ...aur root ko list mai alag se list bna ke ...than uske childs ka aise hi check krenge