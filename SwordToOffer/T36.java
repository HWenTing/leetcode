package SwordToOffer;

public class T36 {
	class Node {
	    public int val;
	    public Node left;
	    public Node right;

	    public Node() {}

	    public Node(int _val) {
	        val = _val;
	    }

	    public Node(int _val,Node _left,Node _right) {
	        val = _val;
	        left = _left;
	        right = _right;
	    }
	};
	
//	输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
//	同T426 但是这个题是锁定的。。
	
	private Node pre;//记录前驱结点
	private Node head;//记录返回的头节点，也就是最小值
    public Node treeToDoublyList(Node root) {
        if(root==null) return root;
        dfs(root);
    	head.left = pre;
    	pre.right = head;
        return head;
    }
    
//    按照中序遍历的顺序 左子树->当前节点->右子树
    private void dfs(Node cur){
    	if(cur==null) return ;
    	
    	dfs(cur.left);
    	if(pre==null) head=cur; //找到头节点
    	else{//将当前节点和前驱结点关联上
    		pre.right = cur;
    		cur.left = pre;
    	}
    	pre = cur;//当前节点设置为前驱结点
    	dfs(cur.right);
    }
    
    
    
    
}
