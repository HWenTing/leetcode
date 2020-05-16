package SwordToOffer;

public class T33 {

//	输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
//	如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。

//	 右子树所有节点比根节点大，左子树所有节点比根节点小，找到分界点，然后递归处理两个子树
//	击败双百
    public boolean verifyPostorder(int[] postorder) {
    	return verifyPostorder(postorder,0,postorder.length-1);
    	
    }
    
    private boolean verifyPostorder(int[] postorder,int start,int end) {
    	if(end-start<=1) return true;
    	int root =  postorder[end];
    	
    	int cut = end-1;//cut是分界点
    	for(;cut>=start;cut--){
    		if(postorder[cut]<root)
    			break;
    	}
    	
    	for(int i=cut;i>=start;i--){
    		if(postorder[i]>root)//如果左子树存在元素比根节点大，return false
    			return false;
    	}
    	
    	return verifyPostorder(postorder,start,cut) && verifyPostorder(postorder,cut+1,end-1); 
    	
    }
    
    
}
