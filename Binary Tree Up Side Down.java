/*
就一题 reverse a binary tree and return the head node
这个head node 是神马意思呢，就是reverse以后没有parent 的node 
比如说
          a
   b          c
                   d 

你要变成 

d 
    c      b
        a 
head node 就是 b d
但是这个node class 呢，是没有parent这个reference的，不过这个倒是不难。
*/

import java.util.*;

public class Binary_Tree_Up_Side_Down { 
        public List<TreeNode> upSideDown(TreeNode root) {
                if (root == null) {
                        return null; 
                }
                
                List<TreeNode> result = new ArrayList<>();
                
                dfs(root, result);
                
                // remove root 的左右节点。
                // 返回后，root作为唯一的叶节点。 
                root.left = null;
                root.right = null;
                
                return result;
        }
        
        private void dfs(TreeNode root, List<TreeNode> result) {
                if (root == null) {// null 
                        return;
                } else if (root.left == null && root.right == null) {// leaf
                        result.add(root);
                        return;
                }
                
                // general case
                // 旋转180度，所以先右，后左。 
                if (root.right != null) {
                        dfs(root.right, result);
                        root.right.right = root;
                }                
                
                if (root.left != null) { 
                        dfs(root.left, result);
                        root.left.left = root;
                }
        } 
}





//我也写了一个版本，你要是还有兴趣，可以看看我的方法。要是错误的话，还希望能够指出。 
	public static void reverse(TreeNode root,TreeNode left,TreeNode right,List<TreeNode> list){
		if(root==null) return;
		if(left==null&&right==null){
				list.add(root); 
		}
		if(left!=null){
				TreeNode temp=left.left;
				left.left=root; 
				reverse(left,temp,left.right,list);
		}
		if(right!=null){ 
				TreeNode temp=right.right; 
				right.right=root;
				reverse(right,right.left,temp,list);
		}
	}
	
	
	//正确版本好像是
	
	vector<TreeNode*> reverse(TreeNode* root){  
        vector<TreeNode*> ans;
        helper(root, ans); 
}

void helper(TreeNode* root, vectot<TreeNode*>& ans){
        if(!root->left && !root->right){
                ans.push_back(root);
                return;
        }

        if(root->left){
                helper(root->left, ans);
                root->left->left = root;
                root->left = NULL;
        }
        if(root->right){
                helper(root->right, ans);
                root->right->right = root;
                root->right = NULL;
        }
}
		
		
		
		
		