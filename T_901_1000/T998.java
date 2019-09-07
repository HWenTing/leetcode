package T_901_1000;

public class T998 {
	
//	这个题不是很好说明白。。可以去看原题描述
//	附加值是在数组的最右边，所以该值大于最大值时，根在结点左子树，当小于最大值时，结点在根右子树。
	
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
    	TreeNode node = new TreeNode(val);
        if(root==null) return node;
        if(root.val<val){//newnode为新节点
        	node.left=root;
        	root=node;
        }else{
        	root.right=insertIntoMaxTree(root.right,val);
        }
        return root;
    }
    
}
