package T_101_200;

public class T143 {

//	重排链表
//	给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
//	将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
//	你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

//	O(n)的空间给每个节点建立个索引，最后再穿起来 O(n)的时间复杂度
//	或者分成前后两半，后一半反转 插进前一半   O(1)的空间O(n)的时间复杂度
	
//	找中点的时候要记得断开
    public void reorderList(ListNode head) {
    	if(head==null || head.next==null)
			return ;
    	ListNode mid = findmidandbreak(head);
    	mid = reverse(mid);
    	ListNode ptr = head;
    	
    	while(ptr!=null && mid!=null){
    		ListNode tempmid = mid.next;
    		ListNode tempptr = ptr.next;
    		ptr.next = mid;
    		mid.next = tempptr;
    		ptr = tempptr;
    		mid = tempmid;
    	}
    }
    
    private ListNode reverse(ListNode head){
    	ListNode dummyhead = new ListNode(-1);
    	while(head!=null){
    		ListNode temp = head.next;
    		head.next = dummyhead.next;
    		dummyhead.next = head;
    		head = temp;
    	}
    	return dummyhead.next;
    }
    
	private ListNode findmidandbreak(ListNode head){//找链表中点
		ListNode fast = head.next;
		ListNode slow = head;
		while(fast!=null && fast.next!=null){
			slow = slow.next;
			fast = fast.next.next;
		}
		fast = slow.next;
		slow.next = null;//断开链
		return fast;
	}
}
