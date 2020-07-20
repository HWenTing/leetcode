package InterviewBook;

import java.util.HashSet;
import java.util.Set;

public class T0201 {

	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
//	编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
    public ListNode removeDuplicateNodes(ListNode head) {
    	
    	if(head==null || head.next==null) return head;
    	
    	Set<Integer> set = new HashSet<>();
    	ListNode cur = head;
    	set.add(cur.val);
    	while(cur.next!=null){
    		if(set.contains(cur.next.val)){
    			cur.next = cur.next.next;
    		}else{
    			set.add(cur.next.val);
    			cur = cur.next;
    		}
    	}
    	return head;
    }
    
}
