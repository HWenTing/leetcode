package T_101_200;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class T102 {

//	给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
	
//	有个相似的题，用队列，队列的长度就是当前层的长度

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
        	ans.add(temp);
        }
        return ans;
    }
    
    
    
    
    
    
    
    
    
    
}
