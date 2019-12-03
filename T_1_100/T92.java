package T_1_100;

public class T92 {

//	反转从位置 m 到 n 的链表。请使用一趟扫描完成反转
	
//	反转部分头插法，其他顺着插
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummyhead = new ListNode(-1);
        ListNode ptr = dummyhead;
        int pos=1;
        for(;pos<m;pos++){//前m
        	ptr.next = head;
        	head = head.next;
        	ptr = ptr.next;
        }
        ListNode nextptr = head;
        for(;pos<=n;pos++){//反转部分
        	ListNode headnext = head.next;
        	head.next = ptr.next;
        	ptr.next = head;
        	head = headnext;
        }
        ptr = nextptr;
        ptr.next=null;//要记得断开
        while(head!=null){//余下部分
        	ptr.next=head;
        	head = head.next;
        	ptr = ptr.next;
        }
        return dummyhead.next;
    }
    
}













