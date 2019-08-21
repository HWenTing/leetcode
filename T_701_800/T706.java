package T_701_800;

import java.util.ArrayList;
import java.util.List;

public class T706 {
//	不使用任何内建的哈希表库设计一个哈希映射
//	速度击败80% 内存击败76%，还行
	int num=10000;
	List<int[]>[] bucket = new List[10000];
	
    public void put(int key, int value) {
    	int temp=key%num;
        if(bucket[temp] ==null)
        	bucket[temp]=new ArrayList<>();
        
        for(int[] kv:bucket[temp]){
        	if(kv[0]==key){
        		kv[1] = value;
        		return ;
        	}
        }
        bucket[temp].add(new int[]{key,value});
        
    }
    
    public int get(int key) {
    	int temp=key%num;
    	if(bucket[temp]!=null){
    		for(int[] kv:bucket[temp]){
    			if(kv[0]==key){
    				return kv[1];
    			}
    		}
    	}
        return -1;
    }
    
    public void remove(int key) {
    	int temp=key%num;
    	if(bucket[temp]!=null){
    		for(int[] kv:bucket[temp]){
    			if(kv[0]==key){
    				bucket[temp].remove(kv);
    				return;
    			}
    		}
    	}
    }
    
}
