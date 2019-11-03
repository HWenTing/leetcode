package T_101_200;

public class T148 {

	// 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
	// 归并排序，递归，无可避免的空间复杂度为n，没有达到常数级的要求
    public ListNode sortList(ListNode head) {
    	if(head==null || head.next==null)
    		return head;
    	ListNode mid = getMid(head);
    	ListNode right = sortList(mid.next);
    	mid.next=null;
    	ListNode left = sortList(head);
    	return merge(left,right);
    }
    
//    找链表中间节点
    private ListNode getMid(ListNode head){
    	ListNode fast = head.next;
    	ListNode slow = head;
    	
    	while(fast!=null && fast.next!=null){
    		fast = fast.next.next;
    		slow = slow.next;
    	}
    	return slow;
    }
    
//    合并有序链表
    private ListNode merge(ListNode left,ListNode right){
    	ListNode dummyhead = new ListNode(-1);
    	ListNode cur = dummyhead;
    	
    	while(left!=null && right!=null){
    		if(left.val<=right.val){
    			cur.next = left;
    			left = left.next;
    		}else{
    			cur.next = right;
    			right = right.next;
    		}
    		cur = cur.next;
    	}
    	
    	if(left==null)
    		cur.next = right;
    	else
    		cur.next = left;
    	
    	return dummyhead.next;
    }
    
}
