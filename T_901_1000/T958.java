package T_901_1000;

import java.util.LinkedList;
import java.util.Queue;


public class T958 {

//	判断是否为完全二叉树
//	层序遍历,判断每层的个数，hasnaexlayer标记是否到达最后一层，hasnull标记是否存在null
//	通过，击败93%
	
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int len;
        while(!queue.isEmpty()){
            len = queue.size();
            boolean hasnull=false;//hasnull标记是否存在null
            boolean hasnaexlayer = false;//hasnaexlayer标记是否到达最后一层
            for(int i=0;i<len;i++){
                TreeNode temp = queue.poll();
                if(temp!=null){
                	if(hasnull) return false;//如果存在null在某层的中间
                	if(temp.left!=null || temp.right!=null) hasnaexlayer=true;//如果有下一层，hasnaexlayer设为true;
                	queue.add(temp.left);
                	queue.add(temp.right);
                }else{
                	hasnull=true;
                }
            }
            if(hasnaexlayer && hasnull) return false;//不是最后一层，但是有null
        }
        return true;
    }
    
}
