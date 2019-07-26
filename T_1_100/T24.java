package T_1_100;

public class T24 {

//	交换相邻节点
//	递归来解决，每次交换两个，递归进行
    public  ListNode swapPairs(ListNode head) {
    	if (head==null||head.next==null){
    		return head;
    	}
    	
    	ListNode nextnext = head.next.next;
    	ListNode temp = head;
    	head = head.next;
    	head.next = temp;
    	temp.next = swapPairs(nextnext);
    	return head;

    }
    
    
    public static void main(String[] args){
    	ListNode list1  = new ListNode(1);
    	list1.next = new ListNode(2);
    	list1.next.next = new ListNode(3);
    	list1.next.next.next = new ListNode(4);
    	list1.next.next.next.next = new ListNode(5);

    	T24 t =new T24();
    	ListNode ans = t.swapPairs(list1);
    	while(ans.next!=null){
    		System.out.print(ans.val+"--->");
    		ans = ans.next;
    	}
    	System.out.println(ans.val);
    }
    
}
