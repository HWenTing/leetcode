package T_401_500;

import java.util.Stack;

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

public class T445 {

//	呃。。我的第一反应是直接把数从中取出来，算完再塞回链表（当然要考虑溢出的问题），，
//	如果不对列表中的节点进行反转，可以使用栈先处理一下，
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while(l1!=null){
        	s1.push(l1.val);
        	l1=l1.next;
        }
        while(l2!=null){
        	s2.push(l2.val);
        	l2=l2.next;
        }
        
        int carry = 0;

        Stack<Integer> ans = new Stack<>();
        while(!s1.empty() || !s2.empty()){
        	int t1 = s1.empty()?0:s1.pop();
        	int t2 = s2.empty()?0:s2.pop();
        	int temp = t1+t2+carry;
        	carry=temp/10;
        	ans.add(temp%10);
        }
        if(carry==1){
        	ans.add(1);
        }
        
        ListNode ret = new ListNode(-1);
        ListNode head = ret;
        while(!ans.empty()){
        	head.next = new ListNode(ans.pop());
        	head = head.next;
        }
        return ret;
        
    }
    
    
}
