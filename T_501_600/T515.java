package T_501_600;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class T515 {

//	您需要在二叉树的每一行中找到最大的值。
    public List<Integer> largestValues(TreeNode root) {
    	List<Integer> ans=new LinkedList<>();
    	if(root==null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();	
        
        queue.add(root);
        while(!queue.isEmpty()){
        	int len = queue.size();
        	int max = Integer.MIN_VALUE;
        	for(int i=0;i<len;i++){
        		TreeNode temp = queue.poll();
        		max = Math.max(max, temp.val);
        		if(temp.left!=null) queue.add(temp.left);
        		if(temp.right!=null) queue.add(temp.right);
        	}
        	ans.add(max);
        }
        return ans;
    }
	
}
