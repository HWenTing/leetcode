package T_801_900;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


class Pair{
	TreeNode node;
	int number;
	Pair(TreeNode node,int number){
		this.node = node;
		this.number = number;
	}
}

public class T865 {

//	具有所有最深结点的最小子树
//	返回能满足“以该结点为根的子树中包含所有最深的结点”这一条件的具有最大深度的结点。
	
//	我觉得还可以用编号的方法，，，记录下最深的层数，和最深层左端和右端的值，然后向上找到最近根节点的编号，以及层数，然后直接找
//	击败16% 慢一些，也比较占内存
//    public TreeNode subtreeWithAllDeepest(TreeNode root) {
//    	if(root==null) return null;
//    	Queue<Pair> queue = new LinkedList<>();
//    	List<HashMap<Integer,TreeNode>> storage = new LinkedList<>();
//    	
//        queue.add(new Pair(root,0));
//        
//        Pair first=queue.peek();//最后一层第一个叶子
//        Pair last=queue.peek();//最后一层最后一个叶子
//        int layer=0;//最深的层数
//        while(!queue.isEmpty()){
//        	int len = queue.size();
//        	first = queue.peek();
//        	last = first;
//        	
//        	HashMap<Integer,TreeNode> map = new HashMap<>();
//        	
//        	for(int i=0;i<len;i++){
//        		Pair cur = queue.poll();
//        		map.put(cur.number, cur.node);//保存编号与节点的关系
//        		TreeNode curnode = cur.node;
//        		last = cur;
//        		if(curnode.left!=null) queue.add(new Pair(curnode.left,2*cur.number));
//        		if(curnode.right!=null) queue.add(new Pair(curnode.right,2*cur.number+1));
//        	}
//        	storage.add(map);
//        	layer++;
//        }
//        
//        //找公共祖先的编号
//        int firstval = first.number;
//        int lastval = last.number;
//        while(firstval!=lastval){
//        	firstval/=2;
//        	lastval/=2;
//        	layer--;
//        }
//        return storage.get(layer).get(lastval);//返回对应编号的TreeNode
//    }
    
//	对于一个节点，如果左子树高度==右子树高度，这个节点就是答案，如果左子树高度<右子树高度，查找右子树，否则查找左子树
//	递归的过程有重复计算，
	
	HashMap<TreeNode, Integer> map=new HashMap<>();
	public TreeNode subtreeWithAllDeepest(TreeNode root) {
		if(root==null) return null;
		int left = dfs(root.left);
		int right = dfs(root.right);
		
		if(left==right)
			return root;
		else if(left<right)
			return subtreeWithAllDeepest(root.right);
		else
			return subtreeWithAllDeepest(root.left);
	}
	
	private int dfs(TreeNode root){
		if(root==null) return 0;
		if(map.containsKey(root))
			return map.get(root);
		int h=Math.max(dfs(root.left), dfs(root.right))+1;
		map.put(root, h);
		return h;
	}
}
