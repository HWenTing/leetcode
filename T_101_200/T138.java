package T_101_200;

import java.util.HashMap;

class Node138 {
    int val;
    Node138 next;
    Node138 random;

    public Node138(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}


public class T138 {
	//给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
	//要求返回这个链表的深拷贝。 
	
//	hashmap存储是否出现过，没出现的话就new一个，出现了就直接使用
//	空间复杂度是O(n) ,需要存储新旧节点的对应关系
//	看了题解还有一种不需要存储对应关系的：A->B->C  变成A->A'->B->B'->C->C' 然后对A'B'C'进行random链接，最后断开新链于旧链即可。有一种有丝分裂的感觉？
    public Node138 copyRandomList(Node138 head) {
    	if(head==null) return null;
    	HashMap<Node138,Node138> map = new HashMap<>();
    	Node138 ans = new Node138(head.val);
    	map.put(head, ans);
    	Node138 cur = ans;
    	Node138 ycur = head;
    	while(ycur!=null ){
    		if(ycur.next!=null ){
    			if(map.containsKey(ycur.next))
    				cur.next = map.get(ycur.next);
    			else{
    				cur.next = new Node138(ycur.next.val);
    				map.put(ycur.next, cur.next);
    			}
    		}
    		
    		if(ycur.random!=null){
    			if(map.containsKey(ycur.random))
    				cur.random = map.get(ycur.random);
    			else{
    				cur.random = new Node138(ycur.random.val);
    				map.put(ycur.random, cur.random);
    			}
    		}
    		cur = cur.next;
    		ycur = ycur.next;
    	}
    	
    	return ans;
    	
    }
    
    
    
    
}
