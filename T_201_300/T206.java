package T_201_300;

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}


public class T206 {
	
//	迭代 头插法
//    public ListNode reverseList(ListNode head) {
//    	ListNode newhead = new ListNode(-1);//虚假头节点，便于操作
//    	while(head!=null){//下边的转化过程有个特点，上一行被保存的值下一行被更新。
//    		ListNode next = head.next;
//    		head.next=newhead.next;
//    		newhead.next=head;
//    		head = next;
//    	}
//    	return newhead.next;
//    }
    
	
//    递归 速度竟然比头插法还要快一些
	public ListNode reverseList(ListNode head) { 
		if (head == null || head.next == null) { 
			return head; 
		}
		ListNode next = head.next; 
		ListNode newHead = reverseList(next);//反转好后边的 
		next.next = head; //此时next是最后一个，将head挂接到其后
		head.next = null; //断开连接
		return newHead; 
	}
	
	
	public static void main(String [] args){
		T206 t =new T206();
		ListNode ans = new ListNode(1);
		ans.next=new ListNode(2);
		ans.next.next=new ListNode(3);
		ans.next.next.next=new ListNode(4);
		ans.next.next.next.next=new ListNode(5);
		
		ans = t.reverseList(ans);
		while(ans!=null){
			System.out.print(ans.val+"--->");
			ans = ans.next;
		}
	}
}
