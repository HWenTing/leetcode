package T_1_100;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

//给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。

//dfs+记忆化搜索  //加了记忆化搜索似乎变慢了
public class T95 {
	private Map<Integer,List<TreeNode>> map;
    public List<TreeNode> generateTrees(int n) {
        if(n==0){
            List<TreeNode> res = new LinkedList<>();
            return res;
        }
        map = new HashMap<>();
        return subgenerateTrees(1,n);
    }
    
    private List<TreeNode> subgenerateTrees(int s,int e){

    	List<TreeNode> res = new LinkedList<>();

    	if(s>e){
    		res.add(null);
    		return res;
    	}

    	for(int i=s;i<=e;i++){
    		List<TreeNode> left = map.containsKey(s*10+i-1)?map.get(s*10+i-1):subgenerateTrees(s,i-1);
    		List<TreeNode> right = map.containsKey((i+1)*10+e)?map.get((i+1)*10+e):subgenerateTrees(i+1,e);
    		
    		for (TreeNode l : left){
    			for(TreeNode r:right){
    				TreeNode root = new TreeNode(i);
    				root.left = l;
    				root.right = r;
    				res.add(root);
    			}
    		}
    	}
    	map.put(s*10+e, res);
    	return res;
    }

    public static void main(String[] args){
    	T95 t = new T95();
    	System.out.println(t.generateTrees(3));
    }
}
