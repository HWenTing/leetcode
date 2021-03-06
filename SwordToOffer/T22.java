package SwordToOffer;


public class T22 {

//	输入一个链表，输出该链表中倒数第k个节点。
//	为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
//	例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。

	
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	//双指针
    public ListNode getKthFromEnd(ListNode head, int k) {
    	ListNode left = head;
    	ListNode right = head;
    	while(k>0 && right!=null){
    		k--;
    		right = right.next;
    	}
    	if(k>0) return null;//总长度小于k
    	
    	while(right!=null){
    		right = right.next;
    		left = left.next;
    	}
    	return left;
    }
    
}
