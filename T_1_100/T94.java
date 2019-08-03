package T_1_100;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class T94 {

//	当 cur节点不为空，cur加入到stack中，cur=cur.left//向左子树方向遍历
//	当cur节点为空，cur=stack.pop();  将cur值加入ans中，cur=cur.right//当前节点加入答案，向右子树方向遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        Stack<TreeNode> qu = new Stack<>();
        TreeNode cur = root;
        while(cur!=null || !qu.empty()){ 
            if(cur!=null){
                qu.push(cur);
                cur=cur.left;
            }else{
                cur = qu.pop();
                ans.add(cur.val);
                cur=cur.right;
            }
        }
        return ans;
        
    }	
}
