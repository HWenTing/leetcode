package SwordToOffer;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class T41 {

//	如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
//	如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
// 同T295
	
	//左边大根堆，右边小根堆
	class MedianFinder {

	    /** initialize your data structure here. */
		private Queue<Integer> left;
		private Queue<Integer> right;
	    public MedianFinder() {
	    	right = new PriorityQueue<Integer>();
	    	left =  new PriorityQueue<Integer>(new Comparator<Integer>(){
				@Override
				public int compare(Integer o1, Integer o2) {
					return o2-o1;
				}
	    	});
	    }
	    
	    public void addNum(int num) {
	    	if(left.isEmpty()){
	    		left.add(num);
	    		return;
	    	}
	    	
	    	if(num<=left.peek()){
	    		right.add(left.peek());
	    		left.remove();
	    		left.add(num);
	    	}else{
	    		right.add(num);
	    	}
	    	balance();
	    }
	    
	    private void balance() {
			if(right.size()-left.size()>=2)
				left.add(right.poll());
		}

		public double findMedian() {
			if(left.size()>right.size())
				return left.peek();
			else if(left.size()<right.size())
				return right.peek();
			else{
				if(left.size()==0) return 0;
				else return (0.0+left.peek()+right.peek())/2;
			}
	    }
	}
	
}
