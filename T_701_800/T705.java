package T_701_800;

import java.util.ArrayList;
import java.util.List;

public class T705 {
//	不使用任何内建的哈希表库设计一个哈希集合
//	速度击败85% 内存击败93%，还行
	
	int num=10000;
	List<Integer>[] bucket = new List[10000];
    
    public void add(int key) {
    	int temp=key%num;
        if(bucket[temp] ==null)
        	bucket[temp]=new ArrayList<>();
        if(!bucket[key%num].contains(new Integer(key)))
        	bucket[temp].add(key);
    }
    
    public void remove(int key) {
        if(contains(key)){
        	bucket[key%num].remove(new Integer(key));
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return bucket[key%num]!=null && bucket[key%num].contains(new Integer(key));
    }
    
    
}
