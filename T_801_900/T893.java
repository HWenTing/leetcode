package T_801_900;

import java.util.Arrays;
import java.util.HashSet;

public class T893 {

//	数组中的任意偶数调换或者奇数调换能够相同的归为一组，问有几组
	
//	对每个字符串排序，set中不存在则增加一组
    public int numSpecialEquivGroups(String[] A) {
        HashSet<String> set = new HashSet<>();
        int ans=0;
        for(String s:A){
        	String temp = sort(s);
        	if(!set.contains(temp)){
        		ans++;
        		set.add(temp);
        	}
        }
        return ans;
    }
    
//    返回奇数位和偶数位分别排好序以后的字符串
    private String sort(String s){
    	char[] a = s.toCharArray();
    	char[] odd = new char[(a.length+1)/2];//奇数位
    	char[] even = new char[a.length/2];//偶数位
    	for(int i=0;i<a.length;i+=2){
    		odd[i/2] = a[i];
    		if(i+1<a.length)
    			even[(i+1)/2] = a[i+1];
    	}
    	Arrays.sort(odd);
    	Arrays.sort(even);
    	for(int i=0;i<odd.length;i++){
    		a[2*i]=odd[i];
    		if(i<even.length)
    			a[2*i+1]=even[i];
    	}
    	return new String(a);
    }
    
}
