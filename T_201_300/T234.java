package T_201_300;


public class T234 {
	
//	判断是否为回文链表
//	n的时间复杂度和1的空间复杂度
	
//	在中间切开（可用快慢指针寻找中间节点），将后边的反转，比对
    public boolean isPalindrome(ListNode head) {
    	if(head==null || head.next==null)
    		return true;
    	
        ListNode mid = findMin(head);
        ListNode reverse = reverse(mid);
        while(head!=null){
        	if(head.val != reverse.val)
        		return false;
        	head = head.next;
        	reverse = reverse.next;
        }
        return true;
    }
    
//    快慢指针找中间节点  n复杂度
    private ListNode findMin(ListNode l){//当传递的参数是对象的时候，这个时候java中的传递是引用传递
    	ListNode slow = l;
    	ListNode faster = l;
    	ListNode ret ;
    	while(faster.next!=null && faster.next.next!=null){
    		faster = faster.next.next;
    		slow = slow.next;
    	}
    	
    	if(faster.next==null){//奇数个节点
    		ret = new ListNode(slow.val);//为后半部分添加头节点，使前后一样
    		ret.next = slow.next;
    		slow.next=null;
    	}else{//偶数节点
    		ret = slow.next;
    		slow.next=null;
    	}
    	return ret;
    }
    
//    反转链表  n复杂度
    private ListNode reverse(ListNode head){
    	if(head==null || head.next==null)
    		return head;
		ListNode next = head.next; 
		ListNode newHead = reverse(next);//反转好后边的 
		next.next = head; //此时next是最后一个，将head挂接到其后
		head.next = null; //断开连接
		return newHead; 
    }
    
}
