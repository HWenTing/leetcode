package T_401_500;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class T402 {

//	给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
//
//	num 的长度小于 10002 且 ≥ k。
//	num 不会包含任何前导零。

	
//	思路，从左到右，找第一个比后面大的字符，删除，清零，k次扫描。
//    public String removeKdigits(String num, int k) {
//        if (num.length() == k) return "0";
//        StringBuilder s = new StringBuilder(num);
//        for (int i = 0; i < k; i++) {
//        	
//            int idx = 0;
//            while(idx+1< s.length() &&s.charAt(idx+1) >= s.charAt(idx))//找第一个比后面大的字符
//            	idx++;
//            
//            s.delete(idx, idx + 1);
//            while (s.length() > 1 && s.charAt(0) == '0') s.delete(0, 1);
//        }
//        return s.toString();
//    }
    
//	可以使用压栈的方式，// 移除s[i]>s[i+1]的s[i]
    public String removeKdigits(String num, int k) {
    	Deque<Integer> deque = new LinkedList<>(); 
        
        int len = num.length();
        if(k>=len) return "0";
        
        deque.addLast(-1);
        
        int i;
        for(i=0;k>0&&i<len;i++){//移除s[i]>s[i+1]的s[i]
        	if(num.charAt(i)<deque.peekLast()){
        		deque.pollLast();
        		k--;
        		i--;
        	}else
        		deque.addLast((int) num.charAt(i));
        }
        
        StringBuilder sb = new StringBuilder();
    	deque.pollFirst();
    	while(!deque.isEmpty()){
    		int cur = deque.pollFirst();
    		sb.append((char)cur);
    	}
    	sb.append(num.substring(i));

    	int firstIndex = 0;
    	while(firstIndex<sb.length()-k &&sb.charAt(firstIndex)=='0'){//去除前缀0
    		firstIndex++;
    	}
    	return firstIndex==sb.length()?"0":sb.substring(firstIndex,sb.length()-k);
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
