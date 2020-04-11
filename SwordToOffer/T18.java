package SwordToOffer;

public class T18 {
//	给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
//	返回删除后的链表的头节点。
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	 
	 
    public ListNode deleteNode(ListNode head, int val) {
    	if(head==null) return head;
    	else if(head.val==val)
    		return head.next;
    	
    	ListNode ret = head;
    	ListNode f = head;
    	ListNode l = head.next;
    	
    	while(l!=null){
    		if(l.val==val){
    			f.next = l.next;
    			return ret;
    		}
    		f =  f.next;
    		l = l.next;
    	}
    	return ret;
    }
    
    
}
