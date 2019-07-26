package T_1_100;

public class T83 {

//	删除链表中重复元素
//	递归解决
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null)
        	return head;
        
        if(head.val==head.next.val){//若当前与下一个重复，则跳过下一个，
        	head.next=head.next.next;
        	deleteDuplicates(head);
        }else{
        	head.next=deleteDuplicates(head.next);
        }
        return head;
    }
    
    
	public static void main(String[] args) {
		ListNode list1  = new ListNode(0);
    	list1.next = new ListNode(0);
    	list1.next.next= new ListNode(0);
    	list1.next.next.next = new ListNode(2);
    	list1.next.next.next.next = new ListNode(5);
    	list1.next.next.next.next.next = new ListNode(7);
    	list1.next.next.next.next.next.next = new ListNode(3);
    	
    	
    	T83 t =new T83();
    	ListNode ans = t.deleteDuplicates(list1);
    	while(ans!=null){
    		System.out.println(ans.val);
    		ans = ans.next;
    	}
    	
    	
    	
    	
	}

}
