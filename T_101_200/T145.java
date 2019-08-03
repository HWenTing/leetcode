package T_101_200;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class T145 {

//	类似T145
//	前序遍历为 root -> left -> right，后序遍历为 left -> right -> root。可以修改前序遍历成为 root -> right -> left，那么
//	这个顺序就和后序遍历正好相反。
//	速度很慢
	
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        
        while(!st.empty()){
            TreeNode temp =st.pop();
            if(temp==null)
                continue;
            ans.add(temp.val);
            st.push(temp.left);
            st.push(temp.right);
        }
        Collections.reverse(ans);
        return ans;
        
    }
}
