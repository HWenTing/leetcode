package T_101_200;

import java.util.HashSet;
import java.util.Set;

public class T142 {

//	给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
	
//	第一种方法 哈希表  挺慢的
//    public ListNode detectCycle(ListNode head) {
//   	 Set<ListNode> nodesSeen = new HashSet<>();
//   	 while(head!=null){
//   		 if(nodesSeen.contains(head))
//   			 return head;
//   		 else
//   			 nodesSeen.add(head);
//   		 head = head.next;
//   	 }
//   	 return null;
//   }
    
    
//    使用双指针（一个走一步，一个走两步）的话，当下重合的时候，快指针多走的距离正好是圈的长度
//	使用快慢指针，如果有相等的地方，则存在圈
//	将慢指针移回链表头部，慢指针和快指针同时一步一步的往前走，再次相同的地方就是循环部分的第一个节点
	
//	速度击败97%，啦啦啦
    public ListNode detectCycle(ListNode head) {
    	if(head==null||head.next==null)
    		return null;
    	ListNode slow = head.next;
    	ListNode fast = head.next.next;
    	while(slow!=fast){
    		if(fast==null||fast.next==null)
    			return null;
        	slow = slow.next;
        	fast = fast.next.next;
    	}
    	slow = head;
    	while(slow!=fast){
    		slow=slow.next;
    		fast = fast.next;
    	}
    	return slow;
    }
    
    
    
    
    
}
