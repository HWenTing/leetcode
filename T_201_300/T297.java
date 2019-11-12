package T_201_300;

import java.util.LinkedList;
import java.util.Queue;

public class T297 {

//	请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
//	不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。
	
//	运用层序遍历
	
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        StringBuffer sb = new StringBuffer();
        sb.append('[');
        
        boolean hasnextlayer = false;
        while(!queue.isEmpty()){
        	int len = queue.size();
        	for(int i=0;i<len;i++){
        		TreeNode cur = queue.poll();
        		if(cur==null)
        			sb.append("null,");
        		else{
        			hasnextlayer=true;
        			sb.append(cur.val+",");
        			queue.add(cur.left);
        			queue.add(cur.right);
        		}
        	}
        	if(!hasnextlayer)
        		break;
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append(']');
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals = data.substring(1, data.length()-1).split(",");
        TreeNode ret = null;
        int pos =0;
        Queue<TreeNode> queue = new LinkedList<>();
        if(!vals[0].equals("null")){
        	ret = new TreeNode(Integer.parseInt(vals[0]));
        	pos++;
        	queue.add(ret);
        }
        
        while(pos<vals.length){
        	TreeNode cur = queue.poll();
        	if(!vals[pos].equals("null")){
        		cur.left = new TreeNode(Integer.parseInt(vals[pos]));
        		queue.add(cur.left);
        	}
        	pos++;
        	if(pos<vals.length && !vals[pos].equals("null")){
        		cur.right = new TreeNode(Integer.parseInt(vals[pos]));
        		queue.add(cur.right);
        	}
        	pos++;
        }
        
        return ret;
        
    }
    
}
