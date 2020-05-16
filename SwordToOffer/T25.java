package SwordToOffer;

import T_1_100.ListNode;

public class T25 {
	
//	输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
//	同T21
	
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
//	迭代版本
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	ListNode dummyhead = new ListNode(-1);
    	ListNode temp = dummyhead;
    	
    	while(l1!=null && l2!=null){
    		if(l1.val<l2.val){
    			temp.next = l1;
    			l1 = l1.next;
    		}else{
    			temp.next = l2;
    			l2 = l2.next;
    		}
    		temp = temp.next;
//    		temp.next = null;//不加也可以
    	}
    	
    	if(l1!=null)
    		temp.next = l1;
    	if(l2!=null)
    		temp.next = l2;
    	
    	return dummyhead.next;
    }
    
    //递归版本
//    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//    	if(l1==null)
//    		return l2;
//    	if(l2==null)
//    		return l1;
//    	
//    	if(l1.val<l2.val){
//    		l1.next=mergeTwoLists(l1.next,l2);
//    		return l1;
//    	}else{
//    		l2.next=mergeTwoLists(l1,l2.next);
//    		return l2;
//    	}
//    }
    
}
