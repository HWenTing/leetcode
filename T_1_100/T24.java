package T_1_100;

public class T24 {

    public static ListNode swapPairs(ListNode head) {
    	if (head==null||head.next==null){
    		return head;
    	}
    	
    	ListNode anshead ,l1,l2,temp;
    	
    	anshead = head.next;
    	head.next = head.next.next;
    	anshead.next = head;

    	temp = head;
    	l2=head.next;
    	try{
	    	while(l2!=null){
	    		System.out.println(temp.val);
	    		System.out.println(l2.val);
	    		temp.next = l2.next;
	    		l2.next = l2.next.next;
	    		temp.next.next = l2;
	    		temp =  temp.next.next;
	    		l2 = l2.next;

	    	}
    	}catch(Exception e){
    		temp.next=l2;
    	}
    	return anshead;
    }
    
    public static void main(String[] args){
    	ListNode list1  = new ListNode(1);
    	list1.next = new ListNode(2);
    	list1.next.next = new ListNode(3);
    	list1.next.next.next = new ListNode(4);
    	list1.next.next.next.next = new ListNode(5);

    	
    	ListNode ans = swapPairs(list1);
    	while(ans.next!=null){
    		System.out.print(ans.val+"--->");
    		ans = ans.next;
    	}
    	System.out.println(ans.val);
    }
    
}
