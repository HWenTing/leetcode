package T_401_500;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};


public class T429 {
//	给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
//	层序遍历
    public List<List<Integer>> levelOrder(Node root) {
    	List<List<Integer>> ans = new LinkedList<>();
    	if(root==null) return ans;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
        	int len = queue.size();
        	List<Integer> temp = new LinkedList<>();
        	while(len>0){
        		Node cur = queue.poll();
        		temp.add(cur.val);
        		for(Node n:cur.children)
        			queue.add(n);
        		len--;
        	}
        	ans.add(temp);
        }
        return ans;
    }
    
    
}
