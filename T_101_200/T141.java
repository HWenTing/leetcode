package T_101_200;

import java.util.HashSet;
import java.util.Set;

public class T141 {

//	给定一个链表，判断链表中是否有环。
	
//	第一种方法 哈希表  挺慢的
//    public boolean hasCycle(ListNode head) {
//    	 Set<ListNode> nodesSeen = new HashSet<>();
//    	 while(head!=null){
//    		 if(nodesSeen.contains(head))
//    			 return true;
//    		 else
//    			 nodesSeen.add(head);
//    		 head = head.next;
//    	 }
//    	 return false;
//    }
    
//	双指针
//	速度很快
	public boolean hasCycle(ListNode head) {
		if (head == null || head.next == null) {
			return false;
		}
		
		ListNode slow = head;
	    ListNode fast = head.next;
	    
	    while(slow != fast){
	        if (fast == null || fast.next == null) {
	            return false;
	        }
	        slow = slow.next;
	        fast = fast.next.next;
	    }
	    return true;
	}
	
	
	
    
}
