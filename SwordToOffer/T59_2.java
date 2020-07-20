package SwordToOffer;

import java.util.LinkedList;

public class T59_2 {

	class Node{
		int a,b;
		Node(int a,int b){
			this.a = a;
			this.b = b;
		}
	}
	
//	class MaxQueue {
//
//		private LinkedList<Node> queue ;
//		private LinkedList<Node> help ;
//		private int cnt;
//	    public MaxQueue() {
//	    	 queue = new LinkedList<>();
//	    	 help = new LinkedList<>();
//	    	 cnt = 0;
//	    }
//	    
//	    public int max_value() {
//	    	if(queue.isEmpty()) return -1;
//	    	return help.peekFirst().b;
//	    }
//	    
//	    public void push_back(int value) {
//	    	if(!queue.isEmpty()){
//	    		while(!help.isEmpty() && value>help.getLast().b)
//	    			help.pollLast();
//	    	}
//    		queue.add(new Node(cnt,value));
//    		help.add(new Node(cnt,value));
//	    	cnt++;
//	    }
//	    
//	    public int pop_front() {
//	    	System.out.println(queue.size());
//	    	if(queue.isEmpty()) return -1;
//	    	if(help.peekFirst().a==queue.peekFirst().a)
//	    		help.pollFirst();
//	    	return queue.pollFirst().b;
//	    }
//	}
	
//	上边想复杂了，直接比较就可
	class MaxQueue {

		private LinkedList<Integer> queue ;
		private LinkedList<Integer> help ;
	    public MaxQueue() {
	    	 queue = new LinkedList<>();
	    	 help = new LinkedList<>();
	    }
	    
	    public int max_value() {
	    	if(queue.isEmpty()) return -1;
	    	return help.peekFirst();
	    }
	    
	    public void push_back(int value) {
	    	if(!queue.isEmpty()){
	    		while(!help.isEmpty() && value>help.getLast())
	    			help.pollLast();
	    	}
    		queue.add(value);
    		help.add(value);
	    }
	    
	    public int pop_front() {
	    	if(queue.isEmpty()) return -1;
//	    	if(help.peekFirst()==queue.peekFirst())//!!!!!!!!!要注意装箱拆箱问题！！！！在这里被坑了
	    	if(help.peekFirst().intValue() == queue.peekFirst().intValue())
	    		help.pollFirst();
	    	return queue.pollFirst();
	    }
	}
	
}
