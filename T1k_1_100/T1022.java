package T1k_1_100;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class T1022 {
	
//	给出一棵二叉树，其上每个结点的值都是 0 或 1 。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。例如，如果路径为 0 -> 1 -> 1 -> 0 -> 1，那么它表示二进制数 01101，也就是 13 。
//	对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。
//	以 10^9 + 7 为模，返回这些数字之和。
	
//	应该不考虑二进制数溢出问题
//	dfs遍历到叶节点，转为十进制并计算ans；
	
	private int MOD = (int) (Math.pow(10, 9)+7);
	private int ans = 0;
//    public int sumRootToLeaf(TreeNode root) {
//    	dfs(root,new StringBuffer());
//        return ans;
//    }
//    
//    private void dfs(TreeNode root,StringBuffer sb){
//    	if(root==null) return;
//    	sb.append(root.val);
//    	if(root.left==null && root.right==null){//叶节点
//    		ans= (ans+Integer.parseInt(sb.toString(),2)%MOD)%MOD;
//    		sb.deleteCharAt(sb.length()-1);
//    		return;
//    	}
//    	dfs(root.left,sb);
//    	dfs(root.right,sb);
//    	sb.deleteCharAt(sb.length()-1);
//    }
    
//	可以使用位运算，更快
	public int sumRootToLeaf(TreeNode root) {
        dfs(root,0);
        return ans ;
    }
	public void dfs(TreeNode root,int val){
		if(root==null) return;
        int newVal = val<<1 | root.val;//位运算，左移乘2加root.val
		if(root.left==null && root.right==null)//叶节点
			ans = (ans+newVal)%MOD;
		dfs(root.left,newVal);
		dfs(root.right,newVal);
	}
}









