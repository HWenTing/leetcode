package T_501_600;

import java.util.LinkedList;
import java.util.List;


public class T530 {

//	求bst任意两节点差的绝对值的最小值
//	中序转数组，找相邻
//	速度很慢，似乎对bst先转为数组再处理都很慢
	
//	List<Integer> ans = new LinkedList<>();
//    public int getMinimumDifference(TreeNode root) {
//    	int min=Integer.MAX_VALUE;
//    	getnums(root);
//    	
//    	for(int i=1;i<ans.size();i++){
//    		min = Math.min(min, ans.get(i)-ans.get(i-1));
//    	}
//        return min;
//    }
//    
//    private void getnums(TreeNode root){//中序遍历得到有序数组
//    	if(root==null)
//    		return ;
//    	getnums(root.left);
//    	ans.add(root.val);
//    	getnums(root.right);
//    }
	
//	在中序遍历的同时进行比较
//	...击败96%。。。应该是List消耗资源比较多，并且只遍历一次
	private TreeNode pre;
	private int min=Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        findmin(root);
        return min;
    }
    
    private void findmin(TreeNode root){//在中序遍历的同时，进行比较。因为中序遍历的顺序是升序，因此使用pre保存前一个节点，每次相减比较即可
    	if(root==null)
    		return ;
    	findmin(root.left);
    	if(pre!=null)
    		min = Math.min(min, root.val-pre.val);
    	pre = root;
    	findmin(root.right);
    }
}

