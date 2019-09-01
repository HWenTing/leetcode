package T_801_900;

import java.util.Arrays;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


public class T889 {

//	根据前序和后序构造二叉树
//	很伤这个题，南大机试有个很相似的没做出来
	
//	前序遍历  根左右
//	后序遍历  左右根
//	可以用递归的方法，根为pre[0],然后确定左子树大小L，然后确定分别递归左子树和右子树
//	套路与105 106 相似，递归解决，关键是找到左右子树的分界点
//	速度慢一些，在复制数组的时候比较慢，可以改为索引
	
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
    	int N = pre.length;
    	if(N==0) return null;
        TreeNode root = new TreeNode(pre[0]);
        if(N==1) return root;
        if(N==2) System.out.println("No");//当子树只有一个节点时，即除了pre[0]根节点以后，只有一个节点（N=2）,无法判断是左子树还是右子树
        
        
        int L = 0;//左子树的大小
        for(;L<N;L++)//	pre[1]是左子树的根，在后序遍历时在左子树的最后遍历
        	if(post[L]==pre[1])
        		break;
        L++;
        
        root.left = constructFromPrePost(Arrays.copyOfRange(pre,1,L+1),Arrays.copyOfRange(post,0,L));
        root.right = constructFromPrePost(Arrays.copyOfRange(pre,L+1,N),Arrays.copyOfRange(post,L,N-1));
        
        return root;
    }
    
}










