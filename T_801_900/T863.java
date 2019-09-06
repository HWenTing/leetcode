package T_801_900;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class T863 {

	
//	给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K 。
//  返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。
        
//	先找到根到target的路径，然后dfs找
//	击败99%
	
	List<Integer> ans;
	Queue<TreeNode> path;
	public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        ans = new LinkedList<>();
        path = new LinkedList<>();
        findpath(root,target);
        int h = path.size();
        TreeNode before = path.poll();
        dfs(before,K);
        K--;

        for(int i=0;i<h;i++){
        	TreeNode temp = path.poll();
        	if(K==0){//迭代结束
        		ans.add(temp.val);
        		break;
        	}
        	if(temp.left==before){//判断接下来在哪个分支找
        		dfs(temp.right,K-1);
        	}else
        		dfs(temp.left,K-1);
        	before = temp;
        	K--;
        }
        return ans;
    }
    
	private boolean findpath(TreeNode root, TreeNode target){//寻找路径
		if(root==null) return false;
		if(root==target || findpath(root.left,target) || findpath(root.right,target)){
			path.add(root);
			return true;
		}else
			return false;
	}
	
    private void dfs(TreeNode root,int K){//寻找距离为K的子孙节点
    	if(root==null || K<0) return;
    	if(K==0){
    		ans.add(root.val);
    		return;
    	}
    	dfs(root.left,K-1);
    	dfs(root.right,K-1);
    }
}

