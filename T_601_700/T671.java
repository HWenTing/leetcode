package T_601_700;

public class T671 {

	
//	维护最小值和次小值
//	把每个节点处理一遍就好
//	要注意的是 min和secmin的初始值，不能简单取Integer.MAX_VALUE;（因为测试用例就有意外。。）可以改为Long.MAX_VALUE;
	
    private long min= Long.MAX_VALUE;
    private long secmin= Long.MAX_VALUE;
    
    public int findSecondMinimumValue(TreeNode root) {
        if(root==null)
            return -1;
        if(root.val<min){
            secmin = min;
            min=root.val;
        }else if(root.val>min && root.val<secmin){
            secmin = root.val;
        }
        findSecondMinimumValue(root.left);
        findSecondMinimumValue(root.right);
        
        return secmin==Long.MAX_VALUE?-1:(int)secmin;            
    }
	
}
