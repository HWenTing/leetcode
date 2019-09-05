package T_601_700;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class T655 {

	
//	根据树返回二维数组
//	感觉和上一题很像，应该递归解决
//	先求出树的高度，然后搭建出矩阵，然后递归填充
	
	List<List<String>> ans;
    public List<List<String>> printTree(TreeNode root) {
        int h = getheight(root);
        int width = (int) (Math.pow(2, h)-1);
        
//        初始化
        ans = new LinkedList<>();
        for(int i=0;i<h;i++){
        	List<String> temp = new LinkedList<>();
        	for(int j=0;j<width;j++){
        		temp.add("");
        	}
        	ans.add(temp);
        }
        dfs(root,0,0,width);
        return ans;
    }
    
    private void dfs(TreeNode root,int layer,int start,int end){//递归填充
    	
    	if(root==null) return;
    	int pos = (end+start)/2;
    	ans.get(layer).set(pos, root.val+"");
    	dfs(root.left,layer+1,start,pos);
    	dfs(root.right,layer+1,pos+1,end);
    }
    
    private int getheight(TreeNode root){//得到树的高度
    	if(root==null) return 0;
    	int h=0;
    	Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
        	h++;
        	int len = queue.size();
        	for(int i=0;i<len;i++){
        		TreeNode cur = queue.poll();
        		if(cur.left!=null) queue.add(cur.left);
        		if(cur.right!=null) queue.add(cur.right);
        	}
        }
        return h;
    }
    
}
