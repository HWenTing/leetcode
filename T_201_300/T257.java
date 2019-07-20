package T_201_300;

import java.util.ArrayList;
import java.util.List;

public class T257 {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root==null)
        	return res;
        StringBuffer temp = new StringBuffer();
        
        getcon(root,temp,res);
        return res;
        
        
    }
    
    private void getcon(TreeNode root,StringBuffer temp,List<String> res){
    	if(root.left==null && root.right==null){
    		String part = root.val+"";
    		if(temp.length()!=0)
    			part="->"+part;
    		temp.append(part);
    		res.add(temp.toString());
    		temp.delete(temp.length()-part.length(), temp.length());
    		return;
    	}
    	
    	if(root.left!=null){
    		String part = root.val+"";
    		if(temp.length()!=0)
    			part="->"+part;
    		temp.append(part);
    		getcon(root.left,temp,res);
    		temp.delete(temp.length()-part.length(), temp.length());
    	}
    		
       	if(root.right!=null){
    		String part = root.val+"";
    		if(temp.length()!=0)
    			part="->"+part;
    		temp.append(part);
    		getcon(root.right,temp,res);
    		temp.delete(temp.length()-part.length(), temp.length());
    	}
	
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
