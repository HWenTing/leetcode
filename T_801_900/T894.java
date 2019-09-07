package T_801_900;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class T894 {

//	满二叉树是一类二叉树，其中每个结点恰好有 0 或 2 个子结点。
//	返回包含 N 个结点的所有可能满二叉树的列表。 答案的每个元素都是一个可能树的根结点。
//	答案中每个树的每个结点都必须有 node.val=0。
//	你可以按任何顺序返回树的最终列表。
	
//	递归
	HashMap<Integer,List<TreeNode>> storage=new HashMap<>();//记忆化
	
    public List<TreeNode> allPossibleFBT(int N) {
    	if(storage.containsKey(N)) return storage.get(N);
    	
    	List<TreeNode> ans = new LinkedList<>();
    	if(N==1){
    		ans.add(new TreeNode(0));
        	storage.put(1,ans);
        	return ans;
    	}else if(N%2==0) return ans;//不合理

    	
    	for(int i=0;i<N;i++){
    		int j=N-1-i;
    		for(TreeNode left : allPossibleFBT(i)){//递归的方式要注意
    			for(TreeNode right : allPossibleFBT(j)){
    	        	TreeNode root = new TreeNode(0);
    	        	root.left=left;
    	        	root.right=right;
    	        	ans.add(root);
    			}
    		}
    	}
    	storage.put(N,ans);
    	return ans;
    }
    
    
    
//    复制一棵树
    private TreeNode copyTree(TreeNode root){
    	if(root==null) return null;
    	TreeNode newroot = new TreeNode(root.val);
    	newroot.left = copyTree(root.left);
    	newroot.right = copyTree(root.right);
    	return newroot;
    }
}
