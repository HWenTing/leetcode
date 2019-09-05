package T_501_600;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class T589 {

	
//	给定一个 N 叉树，返回其节点值的前序遍历
	
    public List<Integer> preorder(Node root) {
    	List<Integer> ans = new LinkedList<>();
    	if(root==null) return ans;
    	Stack<Node> st = new Stack<>();//stack存放
        st.add(root);
        while(!st.isEmpty()){
        	Node temp = st.pop();
        	ans.add(temp.val);
        	List<Node> nodes = temp.children;
        	for(int i=nodes.size()-1;i>=0;i--)//从右往左
        		st.push(nodes.get(i));
        }
        return ans;
    }
    
}
