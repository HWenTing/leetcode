package SwordToOffer;


public class T35 {

	class Node {
	    int val;
	    Node next;
	    Node random;

	    public Node(int val) {
	        this.val = val;
	        this.next = null;
	        this.random = null;
	    }
	}
	
//	请实现 copyRandomList 函数，复制一个复杂链表。
//	在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
// 同T138
//	A->B->C  变成A->A'->B->B'->C->C' 然后对A'B'C'进行random链接，最后断开新链于旧链即可。
//	也可以hashmap，hashmap存储是否出现过，没出现的话就new一个，出现了就直接使用
	
    public Node copyRandomList(Node head) {
    	
    	Node temp = head;
    	while(temp!=null){//先都复制一遍
    		Node cur = new Node(temp.val);
    		cur.next = temp.next;
    		temp.next = cur;
    		temp = cur.next;
    	}
    	
    	temp = head;
    	while(temp!=null){//更新ramdom
    		if(temp.random==null) temp.next.random = null;
    		else temp.next.random = temp.random.next;
    		temp = temp.next.next;
    	}
    	
    	temp = head;
    	Node dummyhead = new Node(-1);
    	Node cur = dummyhead;
    	
    	while(temp!=null){//断开连接
    		cur.next = temp.next;
    		temp.next = temp.next.next;
    		temp = temp.next;
    		cur = cur.next;
    	}
    	return dummyhead.next;
    	
    }
    
}
