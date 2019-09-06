package T_801_900;

import java.util.LinkedList;
import java.util.List;

public class T872 {

//	判断两个树的叶子节点 从左往右序列是否相等
	
//	先求的叶子节点序列，然后对比是否相同
	
	
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new LinkedList<>();
        List<Integer> l2 = new LinkedList<>();
        
        findleave(root1,l1);
        findleave(root2,l2);
        
        return l1.equals(l2);
    }
  //先序后序中序应该都行吧我觉得，只要先左后右就好（好吧先右后左也无所谓）。中序好像相对慢一些
	private void findleave(TreeNode root, List<Integer> list) {
		if(root==null) return;
		if(root.left==null && root.right==null){//叶节点
			list.add(root.val);
			return;
		}
		findleave(root.left,list);
		findleave(root.right,list);
	}
    
}
