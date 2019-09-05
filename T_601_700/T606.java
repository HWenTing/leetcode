package T_601_700;

public class T606 {

//	你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
//	空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
//	缺少左子树用()代替；
	
//	递归吧,字符串相加可能费点时间
	
    public String tree2str(TreeNode t) {
    	if(t==null) return "";
        return t.val+""+dfs(t.left,t.right==null)+dfs(t.right,true);
    }
    
    private String dfs(TreeNode t,boolean noright){
    	if(t==null){
    		if(noright) return "";
    		else return "()";
    	}
    		
    	return "("+t.val+dfs(t.left,t.right==null)+dfs(t.right,true)+")";
    }
}
