package T_1_100;

public class T19 {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
    	if(head==null){
    		return head;
    	}
    	
    	
        int totalLen = 1;
        ListNode temp  = head;
    	while(temp.next!=null){
    		totalLen++;
    		temp = temp.next;
    	}
    	
    	if(totalLen==n){
    		return head.next;
    	}
    	
    	temp  = head;
    	
    	for(int i =0;i<totalLen-n-1;i++){
    		temp = temp.next;
    	}
    	temp.next = temp.next.next;
    	return head;
    }

	
}
