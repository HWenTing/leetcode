package T_901_1000;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class T970 {
//	给定两个正整数 x 和 y，如果某一整数等于 x^i + y^j，其中整数 i >= 0 且 j >= 0，那么我们认为该整数是一个强整数。
//			返回值小于或等于 bound 的所有强整数组成的列表。
//			你可以按任何顺序返回答案。在你的回答中，每个值最多出现一次。

//	。。。要注意这里不是异或。。是次方
//	暴力遍历吧 
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
    	int tempx=1;
    	HashSet<Integer> set = new HashSet<>();
    	
    	while(true){
    		if(tempx>=bound)
    			break;
    		int tempy=1;
    		while(true){
    			if(tempy+tempx<=bound){
    				set.add(tempy+tempx);
    			}else{
    				break;
    			}
    			
        		if(tempy*y<=tempy)//处理y为1的情况
        			break;
        		
    			tempy*=y;
    		}
    		
    		if(tempx*x<=tempx)//处理x为1的情况
    			break;
    		tempx*=x;
    		
    	}
    	ArrayList<Integer> ans = new ArrayList<>(set);
    	return ans;
    }
    
}
