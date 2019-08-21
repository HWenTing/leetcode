package T_501_600;

import java.util.Arrays;
import java.util.HashMap;

public class T599 {
//	两个列表的最小索引总和
//	hashmap处理
//	速度66%，内存78%
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0;i<list1.length;i++)
        	map.put(list1[i], i);

        String[] ans = new String[list1.length];
        int min=Integer.MAX_VALUE;
        int pos=0;
        for(int i=0;i<list2.length;i++){
        	String temp = list2[i];
        	if(map.containsKey(temp)){
        		if(map.get(temp)+i==min){
        			ans[pos++]=temp;
        		}else if(map.get(temp)+i<min){
        			pos=0;
        			ans[pos++]=temp;
        			min = map.get(temp)+i;
        		}
        	}
        }
        return Arrays.copyOf(ans, pos);
    }
    
}
