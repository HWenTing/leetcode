package T1k_1_100;

public class T1008 {

	
//	根据先序遍历构建搜索二叉树
//	根左右
//	递归吧，根据大小找到左右节点的分界处 
	
    public TreeNode bstFromPreorder(int[] preorder) {
    	return dfs(preorder,0,preorder.length);
    }
    
    private TreeNode dfs(int[] preorder,int start,int end){
    	if(end-start<=0) return null;
    	else if(end-start==1) return new TreeNode(preorder[start]);
    	
    	TreeNode root = new TreeNode(preorder[start]);
    	int i=start+1;
    	for(;i<end;i++){//找到分界点
    		if(preorder[i]>root.val)
    			break;
    	}
    	root.left = dfs(preorder,start+1,i);//左右递归
    	root.right = dfs(preorder,i,end);
    	return root;
    }
}
