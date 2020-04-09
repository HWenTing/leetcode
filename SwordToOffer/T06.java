package SwordToOffer;

public class T06 {

	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	 
	
//	输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
//	时间O(n) 空间O(1)
    public int[] reversePrint(ListNode head) {
    	
    	int count = 0;
    	ListNode temp = head;
    	while(temp!=null){
    		count++;
    		temp = temp.next;
    	}
    	
    	int[] ans = new int[count];
    	temp = head;
    	while(temp!=null){
    		ans[--count] = temp.val;
    		temp = temp.next;
    	}
    	return ans;
    	
    }
    
}
