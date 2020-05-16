package SwordToOffer;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import SwordToOffer.T32_2.TreeNode;

public class T32_3 {

//	请实现一个函数按照之字形顺序打印二叉树，
//	即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
	
	class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
	
//	偶数层反转一下
    public List<List<Integer>> levelOrder(TreeNode root) {

    	if(root==null)
    		return new LinkedList<>();
    	List<List<Integer>> ans = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
        	int len = queue.size();
        	List<Integer> temp= new LinkedList<>();
        	for(int i=0;i<len;i++){
        		TreeNode cur = queue.poll();
        		temp.add(cur.val);
        		if(cur.left!=null) queue.add(cur.left);
        		if(cur.right!=null) queue.add(cur.right);
        	}
        	if(ans.size()%2==1)
        		Collections.reverse(temp);
        	ans.add(temp);
        }
        return ans;
        
    }
}
