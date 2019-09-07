package T_901_1000;

import java.util.LinkedList;
import java.util.List;

public class T971 {

	
//	通过反转节点,先序遍历符合voyage，返回需要反转的节点，如果不可以，返回-1
	
//	递归，如果当前值不等于voyage[index++]，直接返回错误
//	否则判断node.left.val与voyage[index]，如果相等，继续递归左右，如果不等，交换节点，递归右左
	
    List<Integer> flipped;
    int index;
    int[] voyage;

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        flipped = new LinkedList<>();
        index = 0;
        this.voyage = voyage;

        dfs(root);
        if (!flipped.isEmpty() && flipped.get(0) == -1) {
            flipped.clear();
            flipped.add(-1);
        }

        return flipped;
    }

    public void dfs(TreeNode node) {
        if (node != null) {
            if (node.val != voyage[index++]) {
                flipped.clear();
                flipped.add(-1);
                return;
            }

            if (index < voyage.length && node.left != null &&
                    node.left.val != voyage[index]) {//交换节点
                flipped.add(node.val);
                dfs(node.right);
                dfs(node.left);
            } else {
                dfs(node.left);
                dfs(node.right);
            }
        }
    }

    
}
