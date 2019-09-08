package T_401_500;

import java.util.LinkedList;
import java.util.List;

public class T450 {

//	给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
//	要求算法时间复杂度为 O(h)，h 为树的高度。
//	与左子树最大值或者右子树最小值交换，然后删除 递归
	
	public TreeNode deleteNode(TreeNode root, int key) {

        if(root==null) return null;
        if(root.val<key){
        	root.right = deleteNode(root.right,key);
        }else if(root.val>key){
        	root.left = deleteNode(root.left,key);
        }else{
        	if(root.left==null) return root.right;
        	else if(root.right==null) return root.left;
        	else{//左右子树都存在的情况
        		TreeNode newroot = new TreeNode(next(root.right));
        		newroot.left = root.left;
        		newroot.right = deleteMin(root.right);
        		return newroot;
        	}
        }

        return root;
    }
    
	private TreeNode deleteMin(TreeNode right) {//删除最小的节点，并构造新的二叉搜索树
		TreeNode before = right;
		TreeNode next = right.left;
		if(next==null) return before.right;
		
		while(next.left!=null){

			next = next.left;
			before = before.left;
		}
		before.left=next.right;
		return right;
	}

	private int next(TreeNode root){//求后继节点，此处选右子树的最小值,为了防止该断的节点没断开，直接返回val值

		while(root.left!=null){
			root=root.left;
		}
		return root.val;
	}
}















