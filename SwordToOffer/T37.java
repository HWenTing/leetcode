package SwordToOffer;

import java.util.LinkedList;
import java.util.Queue;

public class T37 {

	class TreeNode {
	    int val;     
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
//	请实现两个函数，分别用来序列化和反序列化二叉树。
	
//	都是层序法
	class Codec {

	    // Encodes a tree to a single string.
	    public String serialize(TreeNode root) {
	    	if(root==null) return "";
	    	StringBuilder sb = new StringBuilder();
	    	sb.append("[");
	    	Queue<TreeNode> queue = new LinkedList<>();
	    	queue.add(root);
	    	while(!queue.isEmpty()){
	    		int len = queue.size();
	    		for(int i=0;i<len;i++){
	    			TreeNode cur = queue.poll();
	    			if(cur==null){
	    				sb.append("null,");
	    			}else{
	    				sb.append(cur.val+",");
	    				queue.add(cur.left);
	    				queue.add(cur.right);
	    			}
	    		}
	    	}
	    	sb.deleteCharAt(sb.length()-1);
	    	sb.append("]");
	    	return sb.toString();
	    }

	    // Decodes your encoded data to tree.
	    public TreeNode deserialize(String data) {
	    	if(data.length()<=2) return null;
	    	String temp = data.substring(1, data.length()-1);
	    	String[] vals = temp.split(",");
//	    	for(String s:vals) System.out.print(s+" "); System.out.println();
	    	int index = 0;
	    	TreeNode ret = new TreeNode(Integer.parseInt(vals[index]));
	    	Queue<TreeNode> queue = new LinkedList<>();
	    	queue.add(ret);
	    	
	    	while(index<vals.length){
	    		TreeNode cur = queue.poll(); 
	    		index++;
	    		if(index<vals.length && !vals[index].equals("null")){
	    			cur.left = new TreeNode(Integer.parseInt(vals[index]));
	    			queue.add(cur.left);
	    		}
	    		index++;
	    		if(index<vals.length && !vals[index].equals("null")){
	    			cur.right = new TreeNode(Integer.parseInt(vals[index]));
	    			queue.add(cur.right);
	    		}
	    	}
	    	
	    	return ret;
	    }
	}
	
}
