package T_101_200;

import java.util.Arrays;


public class T105 {

	
//	根据一棵树的前序遍历与中序遍历构造二叉树。
//	套路与106 889 相似，递归解决，关键是找到左右子树的分界点
//	速度慢一些，在复制数组的时候比较慢，可以改为索引
	
//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        int N = preorder.length;
//        if(N==0) return null;
//        TreeNode root = new TreeNode(preorder[0]);
//        if(N==1) return root;
//        
//        int L=0;
//        for(;L<N;L++){
//        	if(preorder[0]==inorder[L])
//        		break;
//        }
//        
//        root.left = buildTree(Arrays.copyOfRange(preorder, 1, L+1),Arrays.copyOfRange(inorder, 0, L));
//        root.right = buildTree(Arrays.copyOfRange(preorder, L+1,N),Arrays.copyOfRange(inorder, L+1, N));
//        
//        return root;
//    }
	
	
	//改为索引
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    	return buildTree(preorder,inorder,0,0,preorder.length);
    }
    
    /**
     * 
     * @param preorder 前序遍历结果
     * @param inorder 中序遍历的结果
     * @param pstart 当前子树根节点在前序遍历中的位置
     * @param start 当前子树在中序遍历的起点（包括）
     * @param end 当前子树在中序遍历的终点（不包括）
     * @return
     */
    private TreeNode buildTree(int[] preorder, int[] inorder,int pstart,int start,int end){
    	if(end-start==0) return null;
    	
    	TreeNode root = new TreeNode(preorder[pstart]);
    	if(end-start==1) return root;
    	
    	int pos=start;//找到当前子树的根节点在中序遍历的位置 ，方便划分左右子树的范围
    	while(pos<end){
    		if(inorder[pos]==preorder[pstart])
    			break;
    		pos++;
    	}
    	
    	root.left = buildTree(preorder, inorder,pstart+1,start,pos);//左子树
    	root.right = buildTree(preorder, inorder,pstart+1+pos-start,pos+1,end);//右子树
    	return root;
    }
    
//  下边是速度非常快的一种方法 尽量理解
	  class Solution {
		  int [] preorder;
	      int [] inorder;
	      int preindex=0;
	      int inindex=0;
	      public TreeNode buildTree(int[] preorder, int[] inorder) {
	    	  this.preorder = preorder;
	    	  this.inorder = inorder;
	    	  return help(Integer.MAX_VALUE);
	      }
	      
	      TreeNode help(int stop){//stop大概表示当前子树在中序遍历中到达的最大位置
				if(preindex == preorder.length||inindex == inorder.length) return null;
				if(stop == inorder[inindex]){
				    inindex++;
				    return null;
				}
				TreeNode  root  = new TreeNode(preorder[preindex++]);
				root.left = help(root.val);//root是其左子树在中序遍历中到达的最大位置
				root.right = help(stop);//stop是该子树能够到达的最大位置，也是右子树到达的最大位置
				return root;
	      }
	  }
  
  
}
