package T1k_101_200;

import java.util.LinkedList;
import java.util.Queue;


public class T1161 {
	
//	给你一个二叉树的根节点 root。设根节点位于二叉树的第 1 层，而根节点的子节点位于第 2 层，依此类推。
//	请你找出层内元素之和 最大 的那几层（可能只有一层）的层号，并返回其中 最小 的那个。

//	层序遍历
    public int maxLevelSum(TreeNode root) {
    	
    	int ans=0;
    	long max=Long.MIN_VALUE;
    	int layer=0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
        	int len = queue.size();
        	long temp=0;
        	layer++;

        	for(int i=0;i<len;i++){
        		TreeNode cur = queue.poll();
        		temp+=cur.val;
        		if(cur.left!=null) queue.add(cur.left);
        		if(cur.right!=null) queue.add(cur.right);
        	}
        	if(temp>max){
        		max = temp;
        		ans=layer;
        	}
        }
        return ans;
    }
    
}
