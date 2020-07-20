package SwordToOffer;


public class T52 {

	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		 	next = null;
		 }
	}
	
//	输入两个链表，找出它们的第一个公共节点。
//	同T160
//	双指针
	
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    	ListNode l1 = headA;
    	ListNode l2 = headB;
    	while(l1!=l2){
    		l1 = l1==null?headB:l1.next;
    		l2 = l2==null?headA:l2.next;
    	}
    	return l1;
    	
    }
    
}
