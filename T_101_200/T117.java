package T_101_200;

public class T117 {

//	相比116题，这次不一定是完美二叉树了，
//	递归处理，先解决同一root的左右子树连接，后解决当前root的唯一子树与兄弟节点的最左边子树的连接
//	击败速度97%
    public Node connect(Node root) {
        if(root==null || (root.left==null && root.right==null)) return root;
        
        if(root.left!=null && root.right!=null){
        	root.left.next=root.right;//处理左子树连接右子树情况
        }
        Node child = root.right==null?root.left:root.right;//找到唯一的子节点
        child.next= getnext(root.next);//找到子节点应该连接到的地方并连接上
        
        connect(root.right);//这个地方要注意，先右子树后左子树，因为左子树的处理要用到右子树
        connect(root.left);
        
        return root;
    }
    
    private Node getnext(Node root){//寻找某个节点的下一层第一个node
    	while(root!=null){
    		if(root.left!=null)
    			return root.left;
    		else if(root.right!=null)
    			return root.right;
    		else
    			root=root.next;
    	}
    	return root;
    }
    
}
