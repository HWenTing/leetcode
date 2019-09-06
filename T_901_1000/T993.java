package T_901_1000;

import java.util.LinkedList;
import java.util.Queue;

class Pair{
	TreeNode node;
	int number;
	Pair(TreeNode node,int number){
		this.node = node;
		this.number = number;
	}
}

public class T993 {

//	判断两个节点是否同一层，且父节点不一样
	
//	标号，然后层序遍历
//	或者分别找到两个节点，并记录下层数和父节点
	
    public boolean isCousins(TreeNode root, int x, int y) { 	
   	 	Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root,0));
        while(!queue.isEmpty()){
        	int len = queue.size();
        	int firstnumber = queue.peek().number;
        	int curnumber = firstnumber;
        	
        	int xnumber = -1;
        	int ynumber = -1;
        	for(int i=0;i<len;i++){
        		Pair cur = queue.poll();
        		TreeNode curnode = cur.node;
        		curnumber = cur.number;
        		
        		//判断是否出现在同一层
        		if(curnode.val==x){
        			xnumber=curnumber;
        			if(ynumber!=-1 && (xnumber/2)!=(ynumber/2))
        				return true;
        		}
        		if(curnode.val==y){
        			ynumber=curnumber;
        			if(xnumber!=-1 && (xnumber/2)!=(ynumber/2))
        				return true;
        		}
        			
        			
        			
        		if(curnode.left!=null) queue.add(new Pair(curnode.left,2*curnumber));
        		if(curnode.right!=null) queue.add(new Pair(curnode.right,2*curnumber+1));
        	}
        	
        	//如果某一个数字出现过，运行到这里了，返回false，剪枝
        	if(xnumber!=-1 || ynumber!=-1)
        		return false;
        }
    	return false;
    }
    
}
