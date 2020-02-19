package T_701_800;

import java.util.LinkedList;
import java.util.Queue;

public class T752 {

//	你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为  '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
//	锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
//	列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
//	字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。

//	bfs 来标记重复访问
	
    public static int openLock(String[] deadends, String target) {
    	
    	boolean[] marked = new boolean[10000];
    	for(String s:deadends)
    		marked[Integer.parseInt(s)] = true;
    	
    	
    	Queue<String> queue = new LinkedList<>();
    	queue.add("0000");
    	int layer=0;
    	while(!queue.isEmpty()){
    		int len = queue.size();
    		
    		for(int i=0;i<len;i++){
    			String cur = queue.poll();
    			System.out.println(cur);
    			if(cur.equals(target))
    				return layer;
    			else if(marked[Integer.parseInt(cur)])
    				continue;
    			
    			marked[Integer.parseInt(cur)] = true;
    			char[] cc = cur.toCharArray();
    			for(int j=0;j<4;j++){//对每位数字进行加一或者减一操作 0 和9 也包含在内
    				char temp = cc[j];
    				String tempstring;
    				
    				cc[j] = (char) ('0'+(temp-'0'+11)%10);//加一
    				tempstring = new String(cc);
    				if(!marked[Integer.parseInt(tempstring)]) queue.add(tempstring);
    				
    				cc[j] = (char) ('0'+(temp-'0'+9)%10);//减一
    				tempstring = new String(cc);
    				if(!marked[Integer.parseInt(tempstring)]) queue.add(tempstring);
    				
    				cc[j] = temp;
    			}
    		}
    		layer++;
    	}
    	return -1;
    }
    
    
}
