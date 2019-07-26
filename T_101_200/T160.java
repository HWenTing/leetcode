package T_101_200;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
         next = null;
     }
}

public class T160 {

//	求两个链表交叉的地方
//	啊啊啊这个题一开始没做出来，看了一下题解原来如此简单
	
//	设 A 的长度为 a + c，B 的长度为 b + c，其中 c 为尾部公共部分长度，可知 a + c + b = b + c + a。
//	当访问 A 链表的指针访问到链表尾部时，令它从链表 B 的头部开始访问链表 B；同样地，当访问 B 链表的指针访问
//	到链表尾部时，令它从链表 A 的头部开始访问链表 A。这样就能控制访问 A 和 B 两个链表的指针能同时访问到交
//	点。
//	真的是漂亮啊
	
	
	
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    	ListNode l1 = headA;
    	ListNode l2 = headB;
    	while(l1!=l2){
    		l1 = l1==null?headB:l1.next;
    		l2 = l2==null?headA:l2.next;
    	}
    	return l1;
    }
    
//    如果只是判断是否存在交点，那么就是另一个问题。有两种解法：
//    把第一个链表的结尾连接到第二个链表的开头，看第二个链表是否存在环；
//    或者直接比较两个链表的最后一个节点是否相同。
    
    
	public static void main(String[] args) {
		ListNode a1 = new ListNode(4);
		ListNode a2 = new ListNode(1);
		ListNode b1 = new ListNode(5);
		ListNode b2 = new ListNode(0);
		ListNode b3 = new ListNode(1);
		ListNode z1 = new ListNode(8);
		ListNode z2 = new ListNode(4);
		ListNode z3 = new ListNode(5);
		a1.next=a2;
		a2.next=z1;
		z1.next=z2;
		z2.next=z3;
		b1.next=b2;
		b2.next=b3;
		b3.next=z1;
		
		T160 t =new T160();
		
		System.out.println(t.getIntersectionNode(a1, b1).val);
		
	}

}
