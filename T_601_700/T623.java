package T_601_700;

import java.util.LinkedList;
import java.util.Queue;


public class T623 {

//	在第d层增加一层值为v的节点
	
//	层次遍历，遍历到d-1开始处理
	
    public TreeNode addOneRow(TreeNode root, int v, int d) {
    	if(d==1){//特殊处理
    		TreeNode newroot = new TreeNode(v);
    		newroot.left=root;
    		return newroot;
    	}
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
        	int len = queue.size();
        	if(d<=2){//要增加的上一层
            	for(int i=0;i<len;i++){//修改树
            		TreeNode cur = queue.poll();
            		
            		TreeNode addleft = new TreeNode(v);
            		addleft.left=cur.left;
            		TreeNode addright = new TreeNode(v);
            		addright.right=cur.right;
            				
            		cur.left = addleft;
            		cur.right = addright;
            		
            	}

        		break;
        	}else{//正常层次遍历
            	for(int i=0;i<len;i++){
            		TreeNode cur = queue.poll();
            		if(cur.left!=null) queue.add(cur.left);
            		if(cur.right!=null) queue.add(cur.right);
            	}
        	}
        	d--;
        }
        return root;
    }
    
    
}
