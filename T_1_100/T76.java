package T_1_100;

import java.util.HashMap;

public class T76 {
	
//	给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
	
//	没啥好想法
//	还是模仿滑动窗口
//	击败%50
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> cnt = new HashMap<>();
        
        int left=0;
        int right=0;
        int[] pos = new int[3];
        pos[2]=Integer.MAX_VALUE;
        
        int len = t.length();
        for(char c:t.toCharArray())
        	cnt.put(c,cnt.getOrDefault(c, 0)+1);
        
        while(right<s.length()){//右指针扩展
        	char c = s.charAt(right);
        	if(cnt.containsKey(c)){
        		cnt.put(c,cnt.get(c)-1);
        		if(cnt.get(c)>=0)
        			len--;
        	}
        	right++;
        	
        	
        	while(len==0){//左指针回缩
        		if(cnt.containsKey(s.charAt(left))){//left指在关键字母
        			cnt.put(s.charAt(left), cnt.get(s.charAt(left))+1);
        			if(cnt.get(s.charAt(left))>0)
        				len++;
        		}
        		if(right-left<pos[2]){
        			pos[0]=left;
        			pos[1]=right;
        			pos[2] = right-left;
        		}
        		left++;
        	}
        }
        return s.substring(pos[0],pos[1]);
    }
    
    public static void main(String[] args){
    	for(int i=0;i<"ADOBECODEBANC".length();i++){
    		System.out.print(i+"\t");
    	}
    	System.out.println();
    	for(int i=0;i<"ADOBECODEBANC".length();i++){
    		System.out.print("ADOBECODEBANC".charAt(i)+"\t");
    	}
    	System.out.println();
    	T76 t =new T76();
    	System.out.println(t.minWindow("a", "aa"));
    }
}
