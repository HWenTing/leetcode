package T_1_100;

public class T86 {

//	给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
//	你应当保留两个分区中每个节点的初始相对位置。
//	双指针 dummyhead 
//    public ListNode partition(ListNode head, int x) {
//    	ListNode lefthead = new ListNode(-1);
//    	ListNode leftend = lefthead;
//    	ListNode righthead = new ListNode(-1);
//    	ListNode rightend = righthead;
//    	
//    	while(head!=null){
//
//    		if(head.val<x){
//    			leftend.next = head;
//    			leftend = leftend.next;
//    			//leftend.next=null;
//    		}else{
//    			rightend.next = head;
//    			rightend = rightend.next;
//    			//rightend.next=null;
//    		}
//    		head = head.next;
//    	}
//    	rightend.next=null;
//    	leftend.next=null;
//    	ListNode temp = lefthead;
//    	while(temp!=null){
//    		System.out.println(temp.val);
//    		temp = temp.next;
//    	}
//    	
//    	leftend.next = righthead.next;
//    	return lefthead.next;
//    }
    
	
    public ListNode partition(ListNode head, int x) {
    	ListNode lefthead = new ListNode(-1);
    	ListNode leftend = lefthead;
    	ListNode righthead = new ListNode(-1);
    	ListNode rightend = righthead;
    	
    	while(head!=null){

    		if(head.val<x){
    			leftend.next = head;
    			head = head.next;//需要放在这里处理head，放在最后会断掉
    			leftend = leftend.next;
    			leftend.next=null;
    		}else{
    			rightend.next = head;
    			head = head.next;
    			rightend = rightend.next;
    			rightend.next=null;
    		}
//    		head = head.next; //不可以在这里一起处理
    	}
    	
    	leftend.next = righthead.next;
    	return lefthead.next;
    }
    
    
}
