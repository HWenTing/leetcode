package T_1_100;

public class T61 {

//	给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
	
//	先构造成循环链表，再重新寻找头节点
    public ListNode rotateRight(ListNode head, int k) {
    	if(head==null) return head;
        int len=1;
        ListNode temp = head;
        while(temp.next!=null){
        	temp = temp.next;
        	len++;
        }
        k=len - k%len;
        temp.next=head;
        
        while(k>0){
        	temp = temp.next;
        	k--;
        }
        head = temp.next;
        temp.next=null;
        return head;
    	
    }
    
}
