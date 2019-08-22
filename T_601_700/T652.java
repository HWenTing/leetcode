package T_601_700;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class T652 {

//	给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
//	两棵树重复是指它们具有相同的结构以及相同的结点值。
	
	
//	hash判断是否重复出现
//	速度击败23%。。。
	
	List<TreeNode> ans;
	HashMap<String,Integer> map ;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
    	map = new HashMap<>();
    	ans = new LinkedList<>();
    	dfs(root);
    	return ans;
    	
    }
    
    private String dfs(TreeNode root){
    	if(root==null)
    		return "";
    	String cur = dfs(root.left)+" "+root.val+" "+dfs(root.right)+" ";//最后这个" "一定要有，防止出现dfs(root.right)=""时的错误
    	int cnt = map.getOrDefault(cur, 0);
    	if(cnt==1)
    		ans.add(root);
    	map.put(cur, cnt+1);
    	return cur;
    }
    
}
