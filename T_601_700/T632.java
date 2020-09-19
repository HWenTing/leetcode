package T_601_700;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class triplet{
	int val,index,nums_index;
	public triplet(int val, int index, int nums_index) {
		super();
		this.val = val;
		this.index = index;
		this.nums_index = nums_index;
	}
	@Override
	public String toString() {
		return "triplet [val=" + val + ", index=" + index + ", nums_index=" + nums_index + "]";
	}
}

public class T632 {

//	你有 k 个升序排列的整数数组。找到一个最小区间，使得 k 个列表中的每个列表至少有一个数包含在其中。
//	我们定义如果 b-a < d-c 或者在 b-a == d-c 时 a < c，则区间 [a,b] 比 [c,d] 小。

//	暴力法好像复杂度有点高 k*n*k
//	使用优先级队列 维护一个k大小的集合，k*n*logk  多指针
    
//	题解好像说的可以用滑动窗口  复杂度优化到k*n
    public int[] smallestRange(List<List<Integer>> nums) {
    	
    	int start = Integer.MAX_VALUE;
    	int end = Integer.MIN_VALUE;
    	int cur_start = Integer.MAX_VALUE;
    	int cur_end = Integer.MIN_VALUE;
    	
    	PriorityQueue<triplet> pq = new PriorityQueue<triplet>(new Comparator<triplet>(){
			@Override
			public int compare(triplet o1, triplet o2) {
				return o1.val-o2.val==0?o1.index-o2.index:o1.val-o2.val;
			}
    	});
    	
    	for(int i=0;i<nums.size();i++){//初始化
    		int temp = nums.get(i).get(0);
    		pq.add(new triplet(temp, 0, i));
    		cur_start = Math.min(cur_start, temp);
    		cur_end = Math.max(cur_end, temp);
    	}
    	start = cur_start;
    	end = cur_end;
    	
    	while(true){
    		triplet cur = pq.poll();
    		cur_start =cur.val;//优先级队列取出当前集合中最小值

    		if(cur_end-cur_start<end-start || (cur_end-cur_start==end-start && cur_start<start)){//更新最小值
    	    	start = cur_start;
    	    	end = cur_end;
    	    	if(end==start) return new int[]{start,end};//剪枝
    		}
    		List<Integer> temp = nums.get(cur.nums_index);
    		if(cur.index==temp.size()-1)//有一个指针到头了 那么直接跳出循环
    			break;
    		cur_end = Math.max(cur_end, temp.get(cur.index+1));//最大值取 当前最大和将要add进去的值的最大值
    		pq.add(new triplet(temp.get(cur.index+1),cur.index+1,cur.nums_index));
    	}
    	return new int[]{start,end};
    }
    
    
}
