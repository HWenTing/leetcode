package T_101_200;

public class T111 {

	
//	求树的最小深度
//	和T104一样。。把max换成min就好了 递归求解 
//	啊不对，，和T104还不大一样，要考虑到叶子节点的定义  [1,2]给出1，但应该是2
	
    public int minDepth(TreeNode root) {
        if(root==null)
        	return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if(left==0 || right==0)
        	return left+right+1;//这个地方很巧妙的处理了非叶子节点
        return Math.min(left, right)+1;
    }
    
}
