package T_101_200;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class T107 {

//	给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
//	和102一样，插入的时候插入到头节点就好了
	
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
        	ans.add(0, temp);;
        }
        return ans;
    }
}
