package T_101_200;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class T133 {
	
	class Node {
	    public int val;
	    public List<Node> neighbors;
	    
	    public Node() {
	        val = 0;
	        neighbors = new ArrayList<Node>();
	    }
	    
	    public Node(int _val) {
	        val = _val;
	        neighbors = new ArrayList<Node>();
	    }
	    
	    public Node(int _val, ArrayList<Node> _neighbors) {
	        val = _val;
	        neighbors = _neighbors;
	    }
	}
	
//	给你无向 连通 图中一个节点的引用，请你返回该图的 深拷贝（克隆）。
//	图中的每个节点都包含它的值 val（int） 和其邻居的列表（list[Node]）。
	
//	bfs
    public Node cloneGraph(Node node) {
    	if(node==null) return null;
        Node[] nodes_new = new Node[101];//存放新构造的点
        boolean[] marked = new boolean[101];//记录完全处理过的点
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        nodes_new[node.val] = new Node(node.val);
        
        while(!queue.isEmpty()){
        	Node cur = queue.poll();
        	Node cur_new = nodes_new[cur.val];
        	marked[cur.val]=true;//标记一下当前处理的点

        	for(Node neigh:cur.neighbors){
        		if(!marked[neigh.val]){
        			if(nodes_new[neigh.val]==null){//没有初始化过，那么加入queue中，并初始化对应的节点
        				queue.add(neigh);
        				nodes_new[neigh.val] = new Node(neigh.val);
        			}
    				nodes_new[neigh.val].neighbors.add(cur_new);
    				cur_new.neighbors.add(nodes_new[neigh.val]);
        		}
        	}
        }
        return nodes_new[node.val];
    }
    
}
