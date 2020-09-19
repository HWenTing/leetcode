package T_101_200;

public class T147 {

	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
//	对链表进行插入排序。
    public ListNode insertionSortList(ListNode head) {
    	if(head==null || head.next==null) return head;
    	ListNode dummyhead = new ListNode(-1);//加一个头节点
    	dummyhead.next = head; 
    			
    	ListNode temp = head;
    	while(temp.next!=null){
    		if(temp.val<=temp.next.val){//如果当前节点比前缀节点要大，则处于顺序状态
    			temp = temp.next;
    			continue;
    		}
    		
    		ListNode cur = temp.next;//拎出来的节点
    		temp.next = temp.next.next;
    		
    		ListNode pre = dummyhead;
    		while(pre.next!=null && pre.next.val<=cur.val)//找到插入位置
    			pre = pre.next;
    		
    		cur.next = pre.next;
    		pre.next = cur;
    	}
    	
    	return dummyhead.next;
    }
    
}
