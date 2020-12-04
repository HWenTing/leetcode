package T_101_200;

public class T148 {

	// 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
	// 自上而下归并排序，递归，无可避免的空间复杂度为logn，没有达到常数级的要求
//    public ListNode sortList(ListNode head) {
//    	if(head==null || head.next==null)
//    		return head;
//    	ListNode mid = getMid(head);
//    	ListNode right = sortList(mid.next);
//    	mid.next=null;
//    	ListNode left = sortList(head);
//    	return merge(left,right);
//    }
//    
////    找链表中间节点
//    private ListNode getMid(ListNode head){
//    	ListNode fast = head.next;
//    	ListNode slow = head;
//    	
//    	while(fast!=null && fast.next!=null){
//    		fast = fast.next.next;
//    		slow = slow.next;
//    	}
//    	return slow;
//    }
//    
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
	
//	自下而上归并 空间复杂度可降到O1  代码好丑
    public ListNode sortList(ListNode head) {
    	
    	ListNode temp = head;
    	int len = 0;
    	while(temp!=null){//求链表长度
    		len++;
    		temp = temp.next;
    	}
    	
    	ListNode dummyhead = new ListNode(-1);
    	dummyhead.next = head;
    	
    	int sublen = 1;
    	while(sublen<len){
    		ListNode before = dummyhead;
    		ListNode cur = dummyhead.next;
    		int cnt = 0;
    		
    		while(cur!=null){

    			ListNode head1 = cur;//第一个链表的头
    			cnt = 0;
    			while(cur!=null && cnt<sublen-1){
    				cur = cur.next;
    				cnt++;
    			}
    			
    			ListNode head2 = null;//第二个链表的头
    			if(cur!=null){//断开链接
    				head2 = cur.next;
    				cur.next = null;
    			}
    			
    			cur = head2;
    			cnt = 0;
    			while(cur!=null && cnt<sublen-1){
    				cur = cur.next;
    				cnt++;
    			}
    			ListNode t=null;
    			if(cur!=null){//断开链接
    				t = cur.next;
    				cur.next = null;
    			}
    			
    			cur = t;
    			ListNode m = merge(head1,head2);
    			before.next = m;
    			
    			while(m.next!=null){
    				m = m.next;
    			}
    			
    			before = m;
    			m.next = cur;
    		}
    		sublen*=2;
    		
    	}
    	return dummyhead.next;

    }
    
}
