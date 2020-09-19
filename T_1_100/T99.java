package T_1_100;

public class T99 {
//	二叉搜索树中的两个节点被错误地交换。
//	请在不改变其结构的情况下，恢复这棵树。
	
//	找到有问题的节点，然后操作
//	关键是如何通过常数空间来解决
//	morris遍历 可以O(1)的空间复杂度 中序遍历
//	Morris遍历算法的步骤如下：
//	1， 根据当前节点，找到其前序节点，如果前序节点的右孩子是空，那么把前序节点的右孩子指向当前节点，然后进入当前节点的左孩子。
//	2， 如果当前节点的左孩子为空，打印当前节点，然后进入右孩子。
//	3，如果当前节点的前序节点其右孩子指向了它本身，那么把前序节点的右孩子设置为空，打印当前节点，然后进入右孩子。

	
//	通过中序遍历，若a[i]>a[i+1] 则a[i]节点一定是错误的节点之一
//	如果只有一个i位置不对 那么需要调换的节点即为 i，i+1；
//	如果还有另一个a[j]>a[j+1] 那么需要调换的位置是i，j+1
	
    public void recoverTree(TreeNode root) {
    	TreeNode r = root;
//    	n1 n2 指向错误的节点
    	TreeNode n1 = null;
    	TreeNode n2 = null;
    	TreeNode pre = null;//前一个节点
    	
//    	morris 遍历法
    	while(r!=null){
    		if(r.left==null){//步骤2
    			if(pre!=null && pre.val>r.val){
    				n1 = n1==null?pre:n1;
    				n2 = r;
    			}
    			pre = r;
    			r = r.right;
    			continue;
    		}
    		
    		TreeNode front = findpre(r);///前序节点
    		if(front.right==r){//步骤3
    			front.right=null;
    			if(pre.val>r.val){
    				n1 = n1==null?pre:n1;
    				n2 = r;
    			}
    			pre = r;
    			r=r.right;
    		}else if(front.right==null){//步骤1
    			front.right = r;
    			r = r.left;
    		}
    	}
    	
//    	交换n1 n2
    	int temp = n1.val;
    	n1.val = n2.val;
    	n2.val = temp;
    	
    }
    
//    寻找前序节点
    private TreeNode findpre(TreeNode root){
    	if(root.left==null) return root;
    	
    	TreeNode pre = root;
    	pre = pre.left;
    	while(pre.right!=null && pre.right!=root)
    		pre = pre.right;
    	return pre;
    }
}
