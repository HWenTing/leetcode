package T_101_200;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class T144 {

//	用非递归方式实现先序遍历
//	没有思路
//	用栈，先右后左 
//	速度一般
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        
        while(!st.empty()){
            TreeNode temp =st.pop();
            if(temp==null)
                continue;
            ans.add(temp.val);
            st.push(temp.right);
            st.push(temp.left);
        }
        return ans;
    
    }
}
