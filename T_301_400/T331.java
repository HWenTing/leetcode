package T_301_400;

public class T331 {
	
//	序列化二叉树的一种方法是使用前序遍历。当我们遇到一个非空节点时，我们可以记录下这个节点的值。如果它是一个空节点，我们可以使用一个标记值记录，例如 #。
//	给定一串以逗号分隔的序列，验证它是否是正确的二叉树的前序序列化。编写一个在不重构树的条件下的可行算法。
	
//	第一想法是 分别计算左右子树长度 来判断是否满足。
//	击败93%
//	boolean ans;
//    public boolean isValidSerialization(String preorder) {
//    	String[] items = preorder.split(",");
//    	ans = true;
//    	if(items.length!=dfs(0,items))
//    		ans = false;
//    	return ans;
//    }
////    返回以start为root的子树的长度。
//	private int dfs(int start, String[] items) {
//		if(!ans || start>=items.length){//剪枝
//			ans = false;
//			return 0;
//		}
//		if(items[start].equals("#"))//当前为空
//			return 1;
//		int left = dfs(start+1,items);//左子树的起始位置为start+1
//		int right = dfs(start+1+left,items);//右子树的起始位置为start+left+1
//		return left+right+1;
//	}
    
    /*
    root: 入度 0， 出度 2；
    inner node: 入度 1， 出度 2；
    leaf: 入度 1， 出度 0；
    */
    public boolean isValidSerialization(String preorder) {
        int degree = 1;
        for (String str: preorder.split(",")) {
            if (degree == 0) return false;
            if (str.equals("#"))
                degree -= 1;
            else
                degree += 1;
        }
        return degree == 0;
    }
    
    
}
