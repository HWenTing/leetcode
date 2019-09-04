package T_201_300;

public class T222 {

//	给出一个完全二叉树，求出该树的节点个数。
	
//	笨办法就是一个一个数。。但是没有用到完全二叉树的性质
	
//	一种想法就是先一直找右子树，找到倒数第二层，然后再一个一个的找最后一层
//	遍历的节点应该比全部遍历一遍少一些
//	击败90%
	private int h=1;
	private int curh=0;
	private int ans=0;
	private boolean finish;
    public int countNodes(TreeNode root) {
    	if(root==null) return 0;
        
        TreeNode temp = root.right;
        while(temp!=null){//找到有多少层是满的
        	temp=temp.right;
        	h++;
        }
        dfs(root);//递归寻找最后一层
        return (int) (Math.pow(2, h)-1+ans);
    }
    
   
    private void dfs(TreeNode root){
    	if(finish ||root==null) return;
    	curh++;//返回前要记得恢复curh值
    	if(root.left==null && root.right==null){//叶节点
    		if(curh>h) ans++;
    		else finish=true;
    		curh--;
    		return;
    	}
    	dfs(root.left);
    	dfs(root.right);
    	curh--;
    }
    
    
//	直接递归遍历每个节点
//	击败90%...太扯淡了
//    public int countNodes(TreeNode root) {
//    	if(root==null) return 0;
//        return countNodes(root.left)+1+countNodes(root.right);
//    }
    
    
}
