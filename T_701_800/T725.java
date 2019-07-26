package T_701_800;


class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

public class T725 {

//	分割链表
	
//	第一想法是先求出链表长度len，然后(len%k)个(len/k)+1的,(k-(len/k))个(len/k)的
//	....实现的巨慢。。。只击败了6%。。
    public ListNode[] splitListToParts(ListNode root, int k) {
    	int len=0;
    	ListNode temp = root;
    	while(temp!=null){
    		len++;
    		temp = temp.next;
    	}
    	
    	int gap = len/k;
    	int more = len%k;
    	ListNode[] ans = new ListNode[k];
    	temp = root;
    	
    	for(int i=0;i<k;i++){
    		ListNode lala = temp;
    		if(lala==null){
    			ans[i]=null;
    			continue;
    		}
    		System.out.println(temp.val);
    		ans[i]=lala;
    		for(int J=0;J<gap-1;J++){
    			temp = temp.next;
    		}
    		if(gap>0 && i<more ){
    			temp = temp.next;
    		}
    		ListNode newhead = temp.next;
    		temp.next =null;//注意断链
    		temp = newhead;
    	}
    	return ans;
    }
    
    
    public static void main(String[] args){
		ListNode list1  = new ListNode(1);
    	list1.next = new ListNode(2);
    	list1.next.next= new ListNode(3);
    	list1.next.next.next = new ListNode(4);
//    	list1.next.next.next.next = new ListNode(5);
//    	list1.next.next.next.next.next = new ListNode(6);
//    	list1.next.next.next.next.next.next = new ListNode(7);
//    	list1.next.next.next.next.next.next.next = new ListNode(8);
//    	list1.next.next.next.next.next.next.next.next = new ListNode(9);
//    	list1.next.next.next.next.next.next.next.next.next = new ListNode(10);
    	
    	T725 t = new T725();
    	ListNode[] ans = t.splitListToParts(list1, 5);
    	for(ListNode node:ans){
    		while(node!=null){
    			System.out.print(node.val+"-->");
    			node=node.next;
    		}
    		System.out.println();
    	}
    			
    }
}
