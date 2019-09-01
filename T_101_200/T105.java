package T_101_200;

import java.util.Arrays;

public class T105 {

	
//	根据一棵树的前序遍历与中序遍历构造二叉树。
//	套路与106 889 相似，递归解决，关键是找到左右子树的分界点
//	速度慢一些，在复制数组的时候比较慢，可以改为索引
	
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int N = preorder.length;
        if(N==0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        if(N==1) return root;
        
        int L=0;
        for(;L<N;L++){
        	if(preorder[0]==inorder[L])
        		break;
        }
        
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, L+1),Arrays.copyOfRange(inorder, 0, L));
        root.right = buildTree(Arrays.copyOfRange(preorder, L+1,N),Arrays.copyOfRange(inorder, L+1, N));
        
        return root;
    }
}
