package T_1_100;

import java.util.LinkedList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class T95 {
    public List<TreeNode> generateTrees(int n) {
        if(n==0){
            List<TreeNode> res = new LinkedList<>();
            return res;
        }
        return subgenerateTrees(1,n);
    }
    
    private List<TreeNode> subgenerateTrees(int s,int e){
    	List<TreeNode> res = new LinkedList<>();

    	if(s>e){
    		res.add(null);
    		return res;
    	}
    	
    	for(int i=s;i<=e;i++){
    		List<TreeNode> left = subgenerateTrees(s,i-1);
    		List<TreeNode> right = subgenerateTrees(i+1,e);
    		
    		for (TreeNode l : left){
    			for(TreeNode r:right){
    				TreeNode root = new TreeNode(i);
    				root.left = l;
    				root.right = r;
    				res.add(root);
    			}
    		}
    	}
    	
    	return res;

    }

    public static void main(String[] args){
    	T95 t = new T95();
    	System.out.println(t.generateTrees(3));
    }
}
