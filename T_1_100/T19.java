package T_1_100;

public class T19 {

//	删除倒数第n个节点
//	两个指针，距离保持n，当前边的走到末尾，后边的刚好指到倒数第n个
	
    public static ListNode removeNthFromEnd(ListNode head, int n) {
    	ListNode faster=head;
    	ListNode slow = head;
    	while(n>0){
    		faster=faster.next;
    		n--;
    	}
    	if(faster==null){//说明删除头节点
    		return head.next;
    	}
    	
    	faster = faster.next;//为了让faster为null时，slow为要删除节点的前节点
    	while(faster!=null){
    		faster=faster.next;
    		slow=slow.next;
    	}
    	slow.next = slow.next.next;
    	return head;
    }

	
}
