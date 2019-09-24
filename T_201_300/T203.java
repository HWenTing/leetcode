package T_201_300;

public class T203 {

//	删除链表中等于给定值 val 的所有节点。
	
//	先加伪头节点，然后两个指针一前一后
//	击败100%
    public ListNode removeElements(ListNode head, int val) {
    	ListNode dummyhead = new ListNode(-1);
    	dummyhead.next=head;
    	ListNode t1 = dummyhead;
    	ListNode t2 = head;
    	while(t2!=null){
    		
    		while(t2!=null && t2.val==val){
    			t2 = t2.next;
    		}
    		t1.next=t2;
    		if(t2==null) break;
    		t1=t1.next;
    		t2=t2.next;
    	}
    	return dummyhead.next;
    }

	
//	递归感觉也不错
//	时间击败100%。。空间94%
//    public ListNode removeElements(ListNode head, int val) {
//    	if(head==null) return head;
//        if(head.val==val)
//        	return removeElements(head.next,val);
//        head.next = removeElements(head.next,val);
//        return head;
//    }
    
}
