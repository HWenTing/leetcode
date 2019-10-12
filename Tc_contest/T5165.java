package Tc_contest;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;

public class T5165 {

	
//	超时了。。。。
	LinkedList<Stack<Integer>> dinnerPlates = new LinkedList<>();
	PriorityQueue<Integer> canaddplates = new PriorityQueue<>();
	final int capacity;
    public T5165(int capacity) {
    	this.capacity = capacity;
    	dinnerPlates.add(new Stack<>());
    }
    
    
    public void push(int val) {
    	if(canaddplates.isEmpty()){
            if(dinnerPlates.isEmpty() || dinnerPlates.getLast().size()==capacity){
            	dinnerPlates.add(new Stack<>());
            }
            dinnerPlates.getLast().add(val);
    	}else{//前面有空位置
    		dinnerPlates.get(canaddplates.peek()).add(val);
    		if(dinnerPlates.get(canaddplates.peek()).size()==capacity){//一个盘子满了
    			canaddplates.poll();
    		}
    	}
    }
    
    public int pop() {
    	while(!dinnerPlates.isEmpty() && dinnerPlates.getLast().isEmpty())
    		dinnerPlates.remove(dinnerPlates.size()-1);
    	if(dinnerPlates.isEmpty())
    		return -1;
    	return dinnerPlates.getLast().pop();
    	
    }
    
    public int popAtStack(int index) {
        if(index>=dinnerPlates.size() || dinnerPlates.get(index).isEmpty())
        	return -1;
        
        if(dinnerPlates.get(index).size()==capacity)//第一次加入
        	canaddplates.add(index);
        
        return dinnerPlates.get(index).pop();
    }
    
	

    
    
}
