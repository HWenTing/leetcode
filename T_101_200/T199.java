package T_101_200;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class T199 {

//	给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
//	层序遍历，把每层的最右边加入list
//	击败97%
    public List<Integer> rightSideView(TreeNode root) {
    	List<Integer> ans = new LinkedList<>();
    	if(root==null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
        	int len = queue.size();
        	TreeNode temp = queue.poll();
        	for(int i=0;i<len-1;i++){
        		if(temp.left!=null) queue.add(temp.left);
        		if(temp.right!=null) queue.add(temp.right);
        		temp = queue.poll();
        	}
        	ans.add(temp.val);
        	if(temp.left!=null) queue.add(temp.left);
    		if(temp.right!=null) queue.add(temp.right);
        }
        return ans;
    }
    
}
