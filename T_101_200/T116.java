package T_101_200;

class Node {
	public int val;
	public Node left;
	public Node right;
	public Node next;

	public Node() {
	}

	public Node(int _val, Node _left, Node _right, Node _next) {
		val = _val;
		left = _left;
		right = _right;
		next = _next;
	}
}

public class T116 {

//	层次遍历，queue存放,每行最后节点特殊处理

//	啊没有注意到给的是完美二叉树，并且要求常数级空间，下边的解决方案用了O(n)空间，但是不管是否完美二叉都没问题
//	时间击败30% 空间47%

//    public Node connect(Node root) {
//    	if(root==null) return root;
//        Queue<Node> queue = new LinkedList<>();
//        queue.add(root);
//        
//        while(!queue.isEmpty()){
//        	int len = queue.size();
//        	Node temp = queue.poll();
//        	for(int i=0;i<len-1;i++){
//        		temp.next = queue.peek();
//        		if(temp.left!=null) queue.add(temp.left);
//        		if(temp.right!=null) queue.add(temp.right);
//        		temp = queue.poll();
//        	}
//        	if(temp.left!=null) queue.add(temp.left);
//    		if(temp.right!=null) queue.add(temp.right);
//        	temp.next=null;
//        }
//        return root;
//    }

//	递归的方法
//	速度击败70%
	public Node connect(Node root) {
		if (root == null || root.left == null)
			return root;
		root.left.next = root.right;// 左孩子连接到右孩子
		if (root.next != null) {
			root.right.next = root.next.left;// 右孩子连接到兄弟的左孩子
		}
		connect(root.left);
		connect(root.right);
		return root;
	}

}
