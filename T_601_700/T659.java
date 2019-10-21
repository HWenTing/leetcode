package T_601_700;

import java.util.HashMap;

public class T659 {

//	输入一个按升序排序的整数数组（可能包含重复数字），你需要将它们分割成几个子序列，其中每个子序列至少包含三个连续整数。返回你是否能做出这样的分割？
	
//	贪心策略，就是使序列尽可能的长。
    public boolean isPossible(int[] nums) {
        HashMap<Integer,Integer> count = new HashMap<>();//计算剩余数字个数
        HashMap<Integer,Integer> tail = new HashMap<>();//计算以该数字结尾的链的个数
        for(int i:nums)
        	count.put(i, count.getOrDefault(i, 0)+1);
        
        for(int num:nums){
        	if(count.get(num)==0)
        		continue;
        	else if(tail.getOrDefault(num-1, 0)>0){//可以接上上一个串
        		tail.put(num-1,tail.get(num-1)-1);
        		tail.put(num,tail.getOrDefault(num,0)+1);
        	}else if(count.getOrDefault(num+1, 0)>0 && count.getOrDefault(num+2, 0)>0){//不可以的话就另起一串
        		count.put(num+1, count.get(num+1)-1);
        		count.put(num+2, count.get(num+2)-1);
        		tail.put(num+2,tail.getOrDefault(num+2,0)+1);
        	}else
        		return false;
        	
        	
        	count.put(num, count.get(num)-1);
        }
        return true;
    }
}





