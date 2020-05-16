package SwordToOffer;


public class T24 {

//	定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
//	同T206
	 
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
//	头插法
//    public ListNode reverseList(ListNode head) {
//    	ListNode ret = new ListNode(-1);
//    	
//    	while(head!=null){
//
//    		ListNode temp = head;
//    		head = head.next;
//    		temp.next = ret.next;
//    		ret.next = temp;
//    	}
//    	return ret.next;
//    }
    
//	或者递归
    public ListNode reverseList(ListNode head) {
    	if(head==null || head.next==null) return head;
    	
    	ListNode tail = head.next;
    	ListNode ret = reverseList(head.next);
    	tail.next = head;
    	head.next = null;
    	
    	return ret;
    }
    
    
}
