package T_901_1000;

import java.util.LinkedList;
import java.util.Queue;

public class T933 {

	Queue<Integer> queue;
    public T933() {
    	queue = new LinkedList<>();
    }
    
    public int ping(int t) {
    	while(!queue.isEmpty() && t-queue.peek()>3000)
    		queue.poll();
    	queue.add(t);
    	return queue.size();
    }
}
