package T_1001;

import java.util.HashMap;

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}
public class T1171 {

//	给你一个链表的头节点 head，请你编写代码，反复删去链表中由 总和 值为 0 的连续节点组成的序列，直到不存在这样的序列为止。
//	删除完毕后，请你返回最终结果链表的头节点。

//	前缀和 前缀和相等说明中间的和为0可以直接去掉。
    public ListNode removeZeroSumSublists(ListNode head) {
        HashMap<Integer,ListNode> map = new HashMap<>();
        ListNode fakeHead = new ListNode(0);
        fakeHead.next=head;
        ListNode p = fakeHead;
        int cur=0;
        while(p!=null){
        	cur+=p.val;
        	if(map.containsKey(cur))
        		map.get(cur).next=p.next;
        	else
        		map.put(cur, p);
        	p=p.next;
        }
        return fakeHead.next;
    }
}
