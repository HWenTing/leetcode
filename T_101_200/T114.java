package T_101_200;

import java.util.LinkedList;
import java.util.Queue;

public class T114 {

//	给定一个二叉树，原地将它展开为链表。
	
//	使用额外n空间 队列先序遍历存起来，再重新生成 速度69%，内存81%
//	private Queue<TreeNode> queue = new LinkedList<>();
//    public void flatten(TreeNode root) {
//    	if(root==null) return;
//    	dfs(root);
//    	TreeNode cur = queue.poll();
//    	while(!queue.isEmpty()){
//    		cur.left=null;//左子树置为空
//    		cur.right=queue.poll();
//    		cur = cur.right;
//    	}
//    }
//    private void dfs(TreeNode root){//先序遍历
//    	if(root==null) return;
//    	queue.add(root);
//    	dfs(root.left);
//    	dfs(root.right);
//    	
//    }
   

//	不使用额外空间 
//	一种思路是flatten(左子树)，flatten(右子树)，然后把右子树挂到左子树最后一个节点，再把左子树挂到root.right,root.left置为空
//	但是寻找左子树最后一个节点需要遍历

//	还有一种似乎不需要遍历寻找左子树最后一个节点,十分巧妙

	TreeNode last =null;
    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.right);//先右后左
        flatten(root.left);
        root.right = last;//在右子树遍历完时，last表示右子树的根，而此时root为左子树最右边的节点
        root.left = null;//左置空
        last = root;
    }
}
