package T_1_100;

public class T21 {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

    	if(l1==null){
    		return l2;
    	}else if(l2==null){
    		return l1;
    	}else{
    		ListNode ans;
    		if(l1.val>l2.val){
    			ans =new ListNode(l2.val); 
    			l2 = l2.next;
    		}else{
    			ans =new ListNode(l1.val); 
    			l1 = l1.next;
    		}
    		
    		ListNode temp = ans;
    		while(l1!=null && l2!=null){
        		if(l1.val>l2.val){
        			ans.next =new ListNode(l2.val); 
        			ans  =ans.next;
        			l2 = l2.next;
        		}else{
        			ans.next =new ListNode(l1.val); 
        			ans  =ans.next;
        			l1 = l1.next;
        		}	
	        }
    		
    		if(l1==null){
    			ans.next=l2;
    		}else{
    			ans.next = l1;
    		}

    		return temp;
    	}

    }
    
    public static void main(String[] args){
    	ListNode list1  = new ListNode(1);
    	list1.next = new ListNode(2);
    	list1.next.next = new ListNode(4);

    	ListNode list2  = new ListNode(1);
    	list2.next = new ListNode(3);
    	list2.next.next = new ListNode(4);
    	
    	ListNode ans = mergeTwoLists(list1,list2);
    	while(ans.next!=null){
    		System.out.print(ans.val+"--->");
    		ans = ans.next;
    	}
    	System.out.println(ans.val);
    }

    
}
