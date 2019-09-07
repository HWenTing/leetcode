package T_1001;

import java.util.HashMap;


public class T1123 {

//	最深叶节点的最近公共祖先
//	感觉和T865咋这么像呢。。	
//    mmp哦，T865的答案这里能直接ac。。
	HashMap<TreeNode, Integer> map=new HashMap<>();
	public TreeNode lcaDeepestLeaves(TreeNode root) {
		if(root==null) return null;
		int left = dfs(root.left);
		int right = dfs(root.right);
		
		if(left==right)
			return root;
		else if(left<right)
			return lcaDeepestLeaves(root.right);
		else
			return lcaDeepestLeaves(root.left);
	}
	
	private int dfs(TreeNode root){
		if(root==null) return 0;
		if(map.containsKey(root))
			return map.get(root);
		int h=Math.max(dfs(root.left), dfs(root.right))+1;
		map.put(root, h);
		return h;
	}
}
