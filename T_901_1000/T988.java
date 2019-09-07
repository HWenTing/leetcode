package T_901_1000;

import java.util.List;

public class T988 {

//	从叶结点开始的最小字符串
//	给定一颗根结点为 root 的二叉树，书中的每个结点都有一个从 0 到 25 的值，分别代表字母 'a' 到 'z'：值 0 代表 'a'，值 1 代表 'b'，依此类推。
//	找出按字典序最小的字符串，该字符串从这棵树的一个叶结点开始，到根结点结束。
	
	
//	有个样例过不去，左子树小，加上根节点不一定
//    public String smallestFromLeaf(TreeNode root) {
//    	if(root==null) return "";
//    	else if(root.left==null && root.right!=null)
//    		return smallestFromLeaf(root.right)+(char)('a'+root.val);
//    	else if(root.left!=null && root.right==null)
//    		return smallestFromLeaf(root.left)+(char)('a'+root.val);
//    	else{
//            String left = smallestFromLeaf(root.left);
//            String right = smallestFromLeaf(root.right);
//            return max(left+(char)('a'+root.val),right+(char)('a'+root.val));
//    	}
//    }
//    
//    private String max(String s1,String s2){
//    	if(s1.compareTo(s2)>0)//s1>s2 返回1
//    		return s2;
//    	else
//    		return s1;
//    }
	
//	从根到叶子节点，依次判断取最小
    private String ans =null;
    public void dfs(TreeNode root, StringBuffer sb) {
        if (root != null) {
            if (root.left == null && root.right == null) {//叶节点
                sb.insert(0, (char) (root.val + 'a'));
                if (ans == null || sb.toString().compareTo(ans) < 0) {
                    ans = sb.toString();
                }
                sb.deleteCharAt(0);
                return;
            }
            sb.insert(0, (char) (root.val + 'a'));
            dfs(root.left, sb);
            dfs(root.right, sb);
            sb.deleteCharAt(0);
        }
    }

    public String smallestFromLeaf(TreeNode root) {
        dfs(root, new StringBuffer());
        return ans;
    }
}
