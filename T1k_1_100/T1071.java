package T1k_1_100;

import java.util.LinkedList;
import java.util.List;

public class T1071 {

//	对于字符串 S 和 T，只有在 S = T + ... + T（T 与自身连接 1 次或多次）时，我们才认定 “T 能除尽 S”。
//			返回字符串 X，要求满足 X 能除尽 str1 且 X 能除尽 str2。

//	先找到较短字符串的因子，然后判断是否为长字符串的因子
//	击败50%
//    public String gcdOfStrings(String str1, String str2) {
//    	if(str1.length()<str2.length()){//保证str2短
//    		String s = str1;
//    		str1 = str2;
//    		str2 = s;
//    	}
//    	
//    	LinkedList<String> str2gcd =  gcd(str2);
//    	for(int i=str2gcd.size()-1;i>=0;i--){
//    		String temp = str2gcd.get(i);
//			int len = temp.length();
//			if(str1.length()%len==0){
//				boolean add = true;
//				for(int start =0;start<=str1.length()-len;start+=len){
//					if(!str1.substring(start, start+len).equals(temp)){
//						add=false;
//						break;
//					}
//				}
//				if(add)
//					return temp;
//			}
//    	}
//    	return "";
//    }
//    
//    private LinkedList<String> gcd(String str){
//    	LinkedList<String> ans = new LinkedList<>(); 
//    	for(int i=1;i<=str.length()/2;i++){
//    		if(str.length()%i==0){
//    			String temp = str.substring(0, i);
//    			boolean add = true;
//    			for(int start =i;start<=str.length()-i;start+=i){
//    				if(!str.substring(start, start+i).equals(temp)){
//    					add=false;
//    					break;
//    				}
//    			}
//    			if(add)
//    				ans.add(temp);
//    		}
//    	}
//    	ans.add(str);
//    	return ans;
//    }
    
//	妙啊
    private int gcd(int a, int b) {
    	return b == 0? a : gcd(b , a % b);
    }
    public String gcdOfStrings(String str1, String str2) {
        if (!(str1+str2).equals(str2 + str1)) return "";
        return str1.substring(0, gcd(str1.length(), str2.length()));
    }
    
    
}
