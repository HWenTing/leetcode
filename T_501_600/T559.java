package T_501_600;

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
}

public class T559 {

//	给定一个 N 叉树，找到其最大深度。
//	层序遍历计算层数？击败15%好像比较慢
	
    public int maxDepth(Node root) {
    	int ans=0;
    	if(root==null) return ans;
        Queue<Node> queue = new LinkedList<>();	
        
        queue.add(root);
        while(!queue.isEmpty()){
        	ans++;
        	int len = queue.size();
        	for(int i=0;i<len;i++){
        		Node temp = queue.poll();
        		for(Node node:temp.children )
        			queue.add(node);
        	}
        }
        return ans;
    }
    
}
