package T_101_200;

import java.util.HashMap;

public class T106 {
//	根据一棵树的中序遍历与后序遍历构造二叉树。假设树中没有重复的元素
//	套路与105 889 相似，递归解决，关键是找到左右子树的分界点
//	速度慢一些，在复制数组的时候比较慢，可以改为索引
	
//    public TreeNode buildTree(int[] inorder, int[] postorder) {
//    	int N = inorder.length;
//        if(N==0) return null;
//        TreeNode root = new TreeNode(postorder[N-1]);
//        if(N==1) return root;
//        
//        int L=0;
//        for(;L<N;L++){
//        	if(postorder[N-1]==inorder[L])//根节点
//        		break;
//        }
//        
//        root.left = buildTree(Arrays.copyOfRange(inorder, 0, L),Arrays.copyOfRange(postorder, 0, L));
//        root.right = buildTree(Arrays.copyOfRange(inorder, L+1, N),Arrays.copyOfRange(postorder, L,N-1));
//        
//        return root;
//    }
	
//	中序遍历  左中右 
//	后续遍历  左右中  反过来就是中右左 
	HashMap<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
    	for(int i=0;i<inorder.length;i++)
    		map.put(inorder[i], i);
    	return buildTree(inorder,postorder,0,inorder.length-1,0,inorder.length-1);
    	
    }
    
    private TreeNode buildTree(int[] inorder, int[] postorder,int istart,int iend,int pstart,int pend){
    	if(iend < istart) return null;
    	TreeNode root = new TreeNode(postorder[pend]);
    	if(iend == istart) return root;
    	
    	int L = map.get(postorder[pend]);
    	
    	root.left = buildTree(inorder,postorder,istart,L-1,pstart,pstart+L-istart-1);
    	root.right = buildTree(inorder,postorder,L+1,iend,pstart+L-istart,pend-1);
    	return root;
    	
    }
    
}
