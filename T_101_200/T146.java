package T_101_200;

import java.util.HashMap;

class dNode{
	int val;
	dNode next;
	dNode before;
	public dNode(int val){
		this.val = val;
	}
}

public class T146 {

//	O(1)时间内完成 LRU的插入删除操作

	int capacity,cnt;
	dNode head;
	dNode end;
	HashMap<Integer,dNode> map;
    public T146(int capacity) {
        cnt=0;
        this.capacity = capacity;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
        	dNode cur = map.get(key);
        	int ret = cur.val;
        	cur.before.next=cur.next;
        	cur.next.before = cur.before;
        	
        }else{
        	return -1;
        }
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
        	
        }else{
        	
        }
    }
    
}
