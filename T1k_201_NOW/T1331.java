package T1k_201_NOW;

import java.util.Arrays;
import java.util.HashMap;

public class T1331 {

//	给你一个整数数组 arr ，请你将数组中的每个元素替换为它们排序后的序号。
//	序号代表了一个元素有多大。序号编号的规则如下：
//	序号从 1 开始编号。
//	一个元素越大，那么序号越大。如果两个元素相等，那么它们的序号相同。
//	每个数字的序号都应该尽可能地小。

//	sort + hashmap对应关系
	
    public int[] arrayRankTransform(int[] arr) {
    	int[] newarr = Arrays.copyOf(arr, arr.length);
    	Arrays.sort(newarr);
    	HashMap<Integer,Integer> map = new HashMap<>();
    	
    	int cnt = 1;
    	for(int i:newarr){
    		if(!map.containsKey(i))
    			map.put(i, cnt++);
    	}
    	
    	for(int i=0;i<arr.length;i++){
    		arr[i] = map.get(arr[i]);
    	}
    	return arr;
    }
    
}
