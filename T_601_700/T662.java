package T_601_700;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Queue;

class Pair{
	TreeNode node;
	int number;
	Pair(TreeNode node,int number){
		this.node = node;
		this.number = number;
	}
}
public class T662 {
	
//	给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。这个二叉树与满二叉树（full binary tree）结构相同，但一些节点为空。
//	每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。

//	层序遍历，增加序号。对每个节点进行编号，
	
//	二进制编号左子树加0，右子树加1
//    public int widthOfBinaryTree(TreeNode root) {
//    	if(root==null) return 0;
//   	 	Queue<Pair> queue = new LinkedList<>();
//        queue.add(new Pair(root,"0"));
//        int ans=0;
//        while(!queue.isEmpty()){
//        	int len = queue.size();
//        	String firstnumber = queue.peek().number;
//        	String curnumber = firstnumber;
//        	for(int i=0;i<len;i++){
//        		Pair cur = queue.poll();
//        		TreeNode curnode = cur.node;
//        		curnumber = cur.number;
//
//        		if(curnode.left!=null) queue.add(new Pair(curnode.left,curnumber+"0"));
//        		if(curnode.right!=null) queue.add(new Pair(curnode.right,curnumber+"1"));
//        	}
//        	ans = (int) Math.max(ans, Integer.parseInt(curnumber, 2)-Integer.parseInt(firstnumber, 2)+1);
//        }
//    	return ans;
//    }
    
	
//	十进制编号，左子树等于根节点*2,右子树等于根节点*2+1
    public int widthOfBinaryTree(TreeNode root) {
    	if(root==null) return 0;
   	 	Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root,0));
        int ans=0;
        while(!queue.isEmpty()){
        	int len = queue.size();
        	int firstnumber = queue.peek().number;
        	int curnumber = firstnumber;
        	for(int i=0;i<len;i++){
        		Pair cur = queue.poll();
        		TreeNode curnode = cur.node;
        		curnumber = cur.number;

        		if(curnode.left!=null) queue.add(new Pair(curnode.left,2*curnumber));
        		if(curnode.right!=null) queue.add(new Pair(curnode.right,2*curnumber+1));
        	}
//        	ans = (int) Math.max(ans, (BigInteger.valueOf(curnumber).subtract(BigInteger.valueOf(firstnumber)).add(BigInteger.ONE)).intValue());
        	ans = Math.max(curnumber-firstnumber+1, ans);
        }
    	return ans;
    }
    
    
}
