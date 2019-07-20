package T_201_300;
import java.util.ArrayList;

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}


public class T206 {
	
//	迭代
    public ListNode reverseList(ListNode head) {
    	if(head.next==null)
    		return head;
    	
    	ListNode curNode,nextNode,temp;
    	curNode = head;
    	nextNode = head.next;
    	
		temp = nextNode.next;
		nextNode.next=curNode;
		curNode.next=null;
		curNode = nextNode;
		nextNode = temp;
		
    	while(nextNode!=null){
    		temp = nextNode.next;
    		nextNode.next=curNode;
    		curNode = nextNode;
    		nextNode = temp;
    	}
    	return curNode;
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
