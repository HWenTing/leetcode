package T_601_700;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class T637 {
	
	
//	求每层的平均值
//	判断每层很简单，因为在开始遍历一层的节点时，当前队列中的节点数就是当前层的节点数，
//	只要控制遍历这么多节点数，就能保证这次遍历的都是当前层的节点。
	
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans=new ArrayList<>();
        if(root==null){
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int len;
        while(!queue.isEmpty()){//方法名是isEmpty 
            double sum=0;
            len = queue.size();
            for(int i=0;i<len;i++){
                TreeNode temp = queue.poll();
                sum+=temp.val;
                if(temp.left!=null)
                    queue.add(temp.left);
                if(temp.right!=null)
                    queue.add(temp.right);
            }
            ans.add(sum/len);
            
        }
        
        
        return ans;
        
    }
}
