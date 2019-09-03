package T_101_200;

import java.util.LinkedList;
import java.util.List;

public class T113 {

//	给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
	
//	dfs
//	速度很慢，因为在向下传递的时候 每次都复制一遍（new LinkedList<>(temp)），会慢很多
	List<List<Integer>> ans;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
    	ans = new LinkedList<>();
    	if(root==null) return ans;
    	sub(root,sum,new LinkedList<>());
    	return ans;
    }
    
    private void sub(TreeNode root, int sum,LinkedList<Integer> temp){
		if(isleaf(root) && sum==root.val){//到达叶子节点并且值相等
			temp.add(root.val);
			ans.add(temp);
			return;
		}
    	temp.add(root.val);
    	if(root.right!=null) sub(root.right,sum-root.val,new LinkedList<>(temp));//深度复制
    	if(root.left!=null) sub(root.left,sum-root.val,new LinkedList<>(temp));//因为每次都复制一遍，会慢很多
    	temp.removeLast();
    }
    
//    改成只在加入ans时复制一遍（new LinkedList<>(temp)）会快一些，击败60%
//    private void sub(TreeNode root, int sum,LinkedList<Integer> temp){
//		if(isleaf(root) && sum==root.val){//到达叶子节点并且值相等
//			temp.add(root.val);
//			ans.add(new LinkedList<>(temp));
//            temp.removeLast();
//			return;
//		}
//    	temp.add(root.val);
//    	if(root.right!=null) 
//            sub(root.right,sum-root.val,temp);
//        
//    	if(root.left!=null)
//            sub(root.left,sum-root.val,temp);
//         temp.removeLast();
//    }
    
    private boolean isleaf(TreeNode root){//判断是否是叶子节点
    	return root.left==null && root.right==null;
    }
    
    
}
