package T_501_600;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class T508 {

//	给出二叉树的根，找出出现次数最多的子树元素和。一个结点的子树元素和定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。
//	然后求出出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的元素（不限顺序）。

//	hashmap存 后序遍历
//	击败65%
	private HashMap<Integer,Integer> map;
	List<Integer> ans = new LinkedList<>();
	int max=0;
    public int[] findFrequentTreeSum(TreeNode root) {
        map = new HashMap<>();
        dfs(root,0);
        int[] ret = new int[ans.size()];
        for(int i=0;i<ans.size();i++){
        	ret[i]=ans.get(i);
        }
        return ret;
    }
    
    private int dfs(TreeNode root,int sum){
    	if(root==null) return 0;
    	
    	int left = dfs(root.left,sum+root.val);
    	int right = dfs(root.right,sum+root.val);
    	int cur = left+right+root.val;
    	map.put(cur, map.getOrDefault(cur, 0)+1);
    	if(map.get(cur)>max){//更新
    		ans.clear();
    		ans.add(cur);
    		max = map.get(cur);
    	}else if(map.get(cur)==max){
    		ans.add(cur);
    	}
		return cur;
    }
}
