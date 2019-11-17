package T_101_200;

import java.util.Arrays;
import java.util.Comparator;

public class T179 {

//	给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
	
//	特殊考虑 全0
//	自定义一种排序方式 比较 s1 + s2 和 s2 + s1
    public String largestNumber(int[] nums) {
    	String[] temp = new String[nums.length];
        for(int i=0;i<nums.length;i++)
        	temp[i] = nums[i]+"";
        
        Arrays.sort(temp,new Comparator<String>(){
			@Override
			public int compare(String o1, String o2) {
				String s1 = o1+o2;
				String s2 = o2+o1;
				for(int i=0;i<s1.length();i++){
					if(s1.charAt(i)>s2.charAt(i))
						return -1;
					else if(s1.charAt(i)<s2.charAt(i))
						return 1;
				}
				return 0;
			}
        });
        
        StringBuilder sb = new StringBuilder();
        for(String i:temp)
        	sb.append(i);
        if(sb.charAt(0)=='0')
        	return "0";
        return sb.toString();
    }
    
}
