package T_201_300;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class T295 {
//	 数据流的中位数
//	左边大根堆，右边小根堆，大小差1以内
	
	private Queue<Integer> left,right;
	private int leftsize,rightsize;
    public T295() {
    	right = new PriorityQueue<>();//小根堆
    	left = new PriorityQueue<>(new Comparator<Integer>(){
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
    	});//大根堆
    	leftsize = 0;
    	rightsize = 0;
    }
    
    public void addNum(int num) {
		if(leftsize+rightsize==0){
			left.add(num);
			leftsize++;
    		return;	
    	}
        if(leftsize==rightsize){
        	if(num<=left.peek()){
        		left.add(num);
        		leftsize++;
        	}else{
        		right.add(num);
        		rightsize++;
        	}
        }else if(leftsize<rightsize){
        	if(num<=right.peek()){
        		left.add(num);
        	}else{
        		int temp = right.poll();
        		right.add(num);
        		left.add(temp);
        	}
        	leftsize++;
        }else{
        	if(num>=left.peek()){
        		right.add(num);
        	}else{
        		int temp = left.poll();
        		left.add(num);
        		right.add(temp);
        	}
        	rightsize++;
        }
    }
    
    public double findMedian() {
        if(leftsize==rightsize)
        	return (left.peek()+right.peek())/2.0;
        return leftsize>rightsize?left.peek():right.peek();
    }
    
    
}
