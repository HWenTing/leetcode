package T_501_600;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class T590 {
//	给定一个 N 叉树，返回其节点值的后序遍历。
//	因为前序是根左中右，后序为左中右根，因此将根右中左的顺序反转过来就好
//递归比较简单
	
    public List<Integer> postorder(Node root) {
    	List<Integer> ans = new LinkedList<>();
    	if(root==null) return ans;
    	Stack<Node> st = new Stack<>();//stack存放
        st.add(root);
        while(!st.isEmpty()){
        	Node temp = st.pop();
        	
        	List<Node> nodes = temp.children;
        	for(int i=0;i<nodes.size();i++)//从右往左
        		st.push(nodes.get(i));
        	ans.add(temp.val);
        }
        Collections.reverse(ans);
        return ans;
    }
    
}

