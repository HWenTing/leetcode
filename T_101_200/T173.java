package T_101_200;

import java.util.Stack;

public class T173 {

//	实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。
//	调用 next() 将返回二叉搜索树中的下一个最小的数。
	
//	维护一个stack存放左子树，最大为深度h
//	二叉搜索树的中序遍历序列是单调递增的。 利用二叉树的迭代方式的中序遍历，保存左子链，从而使用O(h)的内存。
	Stack<TreeNode> st = new Stack<TreeNode>();
    public T173(TreeNode root) {
        if(root!=null){
        	while(root!=null){
        		st.push(root);
        		root = root.left;
        	}
        }
    }
    
    /** @return the next smallest number */
    public int next() {
    	TreeNode temp = st.pop();
    	int ans =temp.val;
    	temp = temp.right;
    	while(temp!=null){
    		st.push(temp);
    		temp = temp.left;
    	}
    	return ans;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !st.isEmpty();
    }
    
}
