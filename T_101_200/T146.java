package T_101_200;

import java.util.HashMap;

class dNode{
	int key;
	int val;
	dNode next;
	dNode before;
	public dNode(int key,int val){
		this.key = key;
		this.val = val;
	}
}

public class T146 {

//	O(1)时间内完成 LRU的插入删除操作

	int capacity,cnt;
	dNode dummyhead,dummyend;
	HashMap<Integer,dNode> map;
    public T146(int capacity) {
        cnt=0;
        this.capacity = capacity;
        map = new HashMap<>();
        dummyhead = new dNode(0,-1);
        dummyend = new dNode(0,-1);
        dummyhead.next = dummyend;
        dummyend.before = dummyhead;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
        	dNode cur = map.get(key);
        	int ret = cur.val;
        	cur.before.next=cur.next;
        	cur.next.before = cur.before;
        	
        	cur.next = dummyhead.next;
        	dummyhead.next.before = cur;
        	
        	cur.before = dummyhead;
        	dummyhead.next = cur;
        	
        	return ret;
        }else{
        	return -1;
        }
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
        	
          	dNode cur = map.get(key);
          	cur.val = value;
          	
        	cur.before.next=cur.next;
        	cur.next.before = cur.before;
        	
        	cur.next = dummyhead.next;
        	dummyhead.next.before = cur;
        	
        	cur.before = dummyhead;
        	dummyhead.next = cur;
        	
        }else{
        	
    		dNode cur = new dNode(key,value);
    		map.put(key, cur);
    		
    		cur.next = dummyhead.next;
    		dummyhead.next.before = cur;
    		
    		cur.before = dummyhead;
    		dummyhead.next = cur;
        		
    		if(cnt>=capacity){
    			dNode delete = dummyend.before;
    			key = delete.key;
    			map.remove(key);
    			
    			delete.before.next = delete.next;
    			delete.next.before = delete.before;
    			
    		}else{
    			cnt++;
    		}
        }
    }
}
