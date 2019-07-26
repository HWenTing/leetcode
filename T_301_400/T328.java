package T_301_400;


class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

public class T328 {

//	把奇数位节点放在前边
//	想法就是从后边提取节点插到前边（2i-1 插到i位置）
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null||head.next.next==null)
        	return head;
        
        ListNode faster = head.next;//保持在偶数位
        ListNode slow = head;//保持在插入位
        while(faster!=null && faster.next!=null){//以下注释以将第三位插到第二位为例
        	ListNode ji = faster.next;//3，表示要插到前边的节点
        	ListNode jinext = faster.next.next;//4，表示要插到前边的下一节点
        	ListNode cha = slow.next;//2，表示要被插入的位置
        	faster.next = jinext;//2的下一个连4
        	slow.next = ji;//1的下一个连3（插入）
        	ji.next=cha;//3的下一个连2（断掉的连起来）
        	faster=faster.next;//4，因为在操作时faster已经往后退了一位，因此再退一位即可
        	slow=slow.next;//退一位
        }
        return head;
    }
    
}
