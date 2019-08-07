package T_101_200;

import java.util.HashMap;
import java.util.Map;

public class T128 {

//	set 先把所有元素都加到set中，然后一个一个寻找看是否有num+1的元素，速度很慢，应该可以剪枝
	
//    public int longestConsecutive(int[] nums) {
//    	int max = 0;
//        Set<Integer> set = new HashSet<>();
//        for(int num:nums)
//        	set.add(num);
//        
//        int cnt=0;
//        for(int num:nums){
//        	cnt=1;
//        	while(set.contains(++num))
//                cnt++;
//        	max = Math.max(cnt, max);
//        }
//        return max;
//    }
	
	
//	简化了很多重复的计算，提升了很多。。但是还是挺慢的
	private Map<Integer,Integer> map;
    public int longestConsecutive(int[] nums) {
    	int max = 0;
        map = new HashMap<>();
        for(int num:nums)
        	map.put(num, 0);
        
        for(int num:nums){
        	max = Math.max(max,dfs(num));
        }
        return max;
    }
    
    private int dfs(int num){
    	if(!map.containsKey(num)) return 0;//不存在下一个就返回0;
    	
    	if(map.get(num)!=0)//如果当前值已经被计算过了，直接返回
    		return map.get(num);
    	
    	int ans = dfs(num+1)+1;//否则递归进行计算
    	map.put(num, ans);
    	return ans;
    }
    
}
