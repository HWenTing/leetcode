package T_501_600;

import java.util.ArrayList;
import java.util.List;

public class T501 {

//	二叉搜索树中的众数
//	想法是在中序遍历的同时，进行计数
//	击败92%
	private TreeNode pre;
	private int cnt=1;
	private int max=1;
	List<Integer> ans = new ArrayList<>();
    public int[] findMode(TreeNode root) {
    	findmin(root);
        int len = ans.size();
        int []ret = new int[len];
        for(int i=0;i<len;i++){
        	ret[i] = ans.get(i);
        }
        
        return ret;
    }
    
    private void findmin(TreeNode root){
    	if(root==null)
    		return ;
    	findmin(root.left);
    	if(pre!=null ){
    		if(pre.val==root.val)
    			cnt++;
    		else
    			cnt=1;
    	}
    	
    	if(cnt==max){
			ans.add(root.val);
		}else if(cnt>max){
			ans.clear();
			ans.add(root.val);
			max = cnt;
		}
    	
    	pre = root;
    	findmin(root.right);
    }
	
    
}
