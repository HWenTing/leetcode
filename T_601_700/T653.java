package T_601_700;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class T653 {
//	判断两树节点和是否与目标值相等
//	因为是bst，可以转化成有序数组，相当于已知有序数组，求解是够存在两数和为目标值
//	可以维护两个指针，向中间靠拢
//	这个方法很慢，效率很低

//	List<Integer> ans = new LinkedList<>();
//    public boolean findTarget(TreeNode root, int k) {
//    	getnums(root);
//    	return isEqual(k);
//    }
//    
//    private boolean isEqual(int k){//判断list中是否有两个元素和为k
//    	int len = ans.size();
//    	
//        int small = 0;
//        int large = len-1;
//        while(small<large){
//        	if(ans.get(small)+ans.get(large)==k)
//        		return true;
//        	else if(ans.get(small)+ans.get(large)<k)
//        		small++;
//        	else
//        		large--;
//        }
//        return false;
//    }
//    
//    private void getnums(TreeNode root){//中序遍历得到有序数组
//    	if(root==null)
//    		return ;
//    	getnums(root.left);
//    	ans.add(root.val);
//    	getnums(root.right);
//    }
	
	
//	hashset存出现过的数
	HashSet<Integer> set = new HashSet<>();
    public boolean findTarget(TreeNode root, int k) {
    	if(root==null) return false;
    	 Queue<TreeNode> queue = new LinkedList<>();
         queue.add(root);
         while(!queue.isEmpty()){
         	int len = queue.size();
         	for(int i=0;i<len;i++){
         		TreeNode cur = queue.poll();
         		if(set.contains(k-cur.val))
         			return true;
         		else
         			set.add(cur.val);
         		if(cur.left!=null) queue.add(cur.left);
         		if(cur.right!=null) queue.add(cur.right);
         	}
         }
         return false;
    }

    
}
