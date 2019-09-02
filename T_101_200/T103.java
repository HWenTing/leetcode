package T_101_200;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class T103 {

//	给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
	
//	用两个栈，奇数层先左子树后右子树，偶数层先右子树后左子树
//	慢一点，击败20%
//    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
//    	if(root==null)
//    		return new LinkedList<>();
//    	List<List<Integer>> ans = new LinkedList<>();
//    	int layer=1;
//        Stack<TreeNode> stack = new Stack<>();
//        Stack<TreeNode> stack2 = new Stack<>();//备用数组，存储下一层
//        stack.add(root);
//        
//        while(!stack.isEmpty()){
//        	int len = stack.size();//当前层大小
//        	List<Integer> temp= new LinkedList<>();
//        	for(int i=0;i<len;i++){
//        		TreeNode cur = stack.pop();
//        		temp.add(cur.val);
//        		if(layer%2==1){
//            		if(cur.left!=null) stack2.add(cur.left);
//            		if(cur.right!=null) stack2.add(cur.right);
//        		}else{
//            		if(cur.right!=null) stack2.add(cur.right);
//            		if(cur.left!=null) stack2.add(cur.left);
//        		}
//        		
//        	}
//        	layer++;
//        	stack = (Stack<TreeNode>) stack2.clone();//深度克隆
//        	stack2.clear();
//        	ans.add(temp);
//        }
//        return ans;
//    }
    
	
//	击败60% ，直接用102的代码，在最后向ans添加的时候反转一下就可以
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    	if(root==null)
    		return new LinkedList<>();
    	List<List<Integer>> ans = new LinkedList<>();
    	boolean reverse = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
        	int len = queue.size();
        	List<Integer> temp= new LinkedList<>();
        	for(int i=0;i<len;i++){
        		TreeNode cur = queue.poll();
        		temp.add(cur.val);
        		if(cur.left!=null) queue.add(cur.left);
        		if(cur.right!=null) queue.add(cur.right);
        	}
        	if(reverse)//隔一层反转一次
        		temp = reverse(temp);//反转
        	reverse = !reverse;
        	ans.add(temp);
        }
        return ans;
    }
    private List<Integer> reverse(List<Integer> temp){//反转
    	List<Integer> ans = new LinkedList<>();
    	for(int i=temp.size()-1;i>=0;i--){
    		ans.add(temp.get(i));
    	}
    	return ans;
    }
}
