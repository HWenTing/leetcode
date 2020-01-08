package T_401_500;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class T403 {

	

//	想法是 dp是set数组，dp[i]代表到达第i个石头时的步长，然后根据每个步长更新到达的石子的数据
//	过是过了。。。但是极其慢。。击败5%
//    public boolean canCross(int[] stones) {
//    	
//    	if(stones[1]>1) return false; 
//    	int len = stones.length;
//    	
//    	LinkedList<Set<Integer>> dp = new LinkedList<>();
//    	for(int i=0;i<len;i++){
//    		dp.add(new HashSet<Integer>());
//    	}
//    	
//    	HashMap<Integer,Integer> map = new HashMap<>();
//    	for(int i=0;i<len;i++)
//    		map.put(stones[i], i);
//    	
//    	int max = stones[len-1];
//    	dp.get(1).add(1);
//    	for(int i=1;i<len;i++){
//
//    		Set<Integer> set = new HashSet<>(dp.get(i));
//    		int cur = stones[i];
//    		for(int d:set){
//    			
//    			if(d-1>0 && map.containsKey(cur+d-1)){
//    				if(cur+d-1==max) return true;
//    				dp.get(map.get(cur+d-1)).add(d-1);
//    			}
//    			if(map.containsKey(cur+d)){
//    				if(cur+d==max) return true;    				
//    				dp.get(map.get(cur+d)).add(d);
//    			}
//    			if(map.containsKey(cur+d+1)){
//    				if(cur+d+1==max) return true;  
//    				dp.get(map.get(cur+d+1)).add(d+1);
//    			}
//    		}
//    	}
//    	return dp.get(len-1).size()>0;
//    }
    
//  。。。我傻了。。我上边为啥实现的这么麻烦。。一样的思路。。下边的就很快
    public boolean canCross(int[] stones) {
    	
    	int max = stones[stones.length-1];
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            map.put(stones[i], new HashSet<Integer>());
        }
        map.get(0).add(0);
        for (int i = 0; i < stones.length; i++) {
            for (int k : map.get(stones[i])) {
                for (int step = k - 1; step <= k + 1; step++) {
                    if (step > 0 && map.containsKey(stones[i] + step)) {
                    	if(stones[i] + step==max) return true;
                        map.get(stones[i] + step).add(step);
                    }
                }
            }
        }
        return map.get(stones[stones.length - 1]).size() > 0;
    }
    
    
}
