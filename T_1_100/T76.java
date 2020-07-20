package T_1_100;

import java.util.HashMap;

public class T76 {
	
//	给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
	
//	没啥好想法
//	还是模仿滑动窗口
//	击败%50
//    public String minWindow(String s, String t) {
//        HashMap<Character,Integer> cnt = new HashMap<>();
//        
//        int left=0;
//        int right=0;
//        int[] pos = new int[3];
//        pos[2]=Integer.MAX_VALUE;
//        
//        int len = t.length();
//        for(char c:t.toCharArray())
//        	cnt.put(c,cnt.getOrDefault(c, 0)+1);
//        
//        while(right<s.length()){//右指针扩展
//        	char c = s.charAt(right);
//        	if(cnt.containsKey(c)){
//        		cnt.put(c,cnt.get(c)-1);
//        		if(cnt.get(c)>=0)
//        			len--;
//        	}
//        	right++;
//        	
//        	
//        	while(len==0){//左指针回缩
//        		if(cnt.containsKey(s.charAt(left))){//left指在关键字母
//        			cnt.put(s.charAt(left), cnt.get(s.charAt(left))+1);
//        			if(cnt.get(s.charAt(left))>0)
//        				len++;
//        		}
//        		if(right-left<pos[2]){
//        			pos[0]=left;
//        			pos[1]=right;
//        			pos[2] = right-left;
//        		}
//        		left++;
//        	}
//        }
//        return s.substring(pos[0],pos[1]);
//    }
    
//	哦吼，一遍ac，击败95%
//	滑动窗口
    public String minWindow(String s, String t) {
    	
    	int[] cnt = new int[128];
    	for(char c:t.toCharArray())
    		cnt[c]++;
    	
    	int nums = t.length();//记录当前窗口内包含字母与t中字母差几个
    	int[] window = new int[128];
    	
    	int left = 0;//双指针
    	int right = 0;
    	int[] ans = new int[2]; ans[0] = -1; ans[1] = s.length();//字串边界
    	
    	while(right<s.length()){
    		char temp = s.charAt(right);
    		if(cnt[temp]>0){//说明找到一个在t中的字母
    			window[temp]++;
    			if(window[temp]<=cnt[temp]){//如果是必须的，那么nums减少一个
    				nums--;
    			}
    		}
    		
    		if(nums==0){//不缺少字母时，表示当前窗口中齐了，那么尽量右移左边界
    			char lc = s.charAt(left);
    			while(cnt[lc]==0 || cnt[lc]<window[lc]){//如果left指向的字母是t中没有的，或者t中多余的，那么直接跳过
    				if(cnt[lc]<window[lc]) window[lc]--;//如果是t中多余的字母，标记一下
    				left++;//右移指针
    				lc = s.charAt(left);
    			}
    			if(right-left<ans[1]-ans[0]){//判断是否是最短的
    				ans[1] = right;
    				ans[0] = left;
    			}
    		}
    		right++;
    	}
    	
    	return ans[1]-ans[0]<=s.length()?s.substring(ans[0],ans[1]+1):"";//判断是否存在子串
    	
    }
    

}
