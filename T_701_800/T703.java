package T_701_800;

import java.util.Comparator;
import java.util.PriorityQueue;

public class T703 {

//	设计一个找到数据流中第K大元素的类（class）。注意是排序后的第K大元素，不是第K个不同的元素。
//	你的 KthLargest 类需要一个同时接收整数 k 和整数数组nums 的构造器，它包含数据流中的初始元素。
//	每次调用 KthLargest.add，返回当前数据流中第K大的元素。
	
//	左边k最小堆，右边最大堆
//	插入的元素比最小堆顶小，则直接插入右边最大堆；若大，则将最小堆顶弹出，插入最大堆，然后将新元素插入最小堆，保持k个元素
	PriorityQueue<Integer> minpq;
	PriorityQueue<Integer> maxpq;
	int K;
    public T703(int k, int[] nums) {
    	K=k;
    	minpq = new PriorityQueue<>(k);
    	maxpq = new PriorityQueue<>(new Comparator<Integer>(){
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}});
    	
    	
    	for(int i=0;i<k&&i<nums.length;i++){
    		minpq.add(nums[i]);
    	}
    	
    	for(int i=k;i<nums.length;i++){
    		if(nums[i]>minpq.peek()){//插入左侧最小堆
    			int temp = minpq.poll();
    			minpq.add(nums[i]);
    			maxpq.add(temp);
    		}else{//插入右侧最大堆
    			maxpq.add(nums[i]);
    		}
    	}
    }
    
    public int add(int val) {
    	if(minpq.size()<K){
    		minpq.add(val);
    		return minpq.peek();
    	}
        if(val>minpq.peek()){
			int temp = minpq.poll();
			minpq.add(val);
			maxpq.add(temp);
		}else{//插入右侧最大堆
			maxpq.add(val);
		}
        return minpq.peek();
    }
    
}
	