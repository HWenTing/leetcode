package T_501_600;

import java.util.LinkedList;
import java.util.Queue;

public class T513 {

//	 得到最后一层最左边的节点
//	 首要任务是找到最后一层
//	 第一反应 可以借助T637，把每层最左边记录下来；最后返回的就是最后一层，同理可以返回倒数第二层
//
//	 还有另外的方法，
	
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {//不停的遍历，因为最后一个元素即为所求
            root = queue.poll();
          //要特别注意这里的顺序，先右后左，保证最后一个加入队列的肯定是最后一层最左边的元素
            if (root.right != null) queue.add(root.right);
            if (root.left != null) queue.add(root.left);
        }
        return root.val;
    }
}
