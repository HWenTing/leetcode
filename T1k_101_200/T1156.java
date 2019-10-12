package T1k_101_200;

import java.util.LinkedList;
import java.util.List;

public class T1156 {

	
//	如果字符串中的所有字符都相同，那么这个字符串是单字符重复的字符串。
//	给你一个字符串 text，你只能交换其中两个字符一次或者什么都不做，然后得到一些单字符重复的子串。返回其中最长的子串的长度。
	
	
//	就按笨办法按部就班试试
//	。。。速度击败10% 空间击败100%。。
	List<int[]>[] cnt;
    public int maxRepOpt1(String text) {
    	cnt = new List[26];//存放每个字母出现的区间
        for(int i=0;i<26;i++){
        	cnt[i] = new LinkedList<int[]>();
        }
        
        char before = text.charAt(0);
        int start = 0;
        for(int i=1;i<text.length();i++){//统计每个字母出现的区间
        	char c = text.charAt(i);
        	if(c!=before){//和前一个不同
        		cnt[before-'a'].add(new int[]{start,i,i-start});
        		start = i;
        		before = c;//更新前邻字母
        	}
        }
        cnt[before-'a'].add(new int[]{start,text.length(),text.length()-start});
        
        
        int ans=0;
        for(int i=0;i<26;i++){
        	ans = Math.max(ans, getmax(i));
        }
        return ans;
    }
    
    private int getmax(int i){//返回某个字母的最长长度
    	int len = cnt[i].size();

    	if(len==0){//表示该字母没出现过
    		return 0;
    	}else if(len==1){//表示只出现在一段
    		return cnt[i].get(0)[1]-cnt[i].get(0)[0];
    	}else if(len==2){//表示只出现在两段
    		if(cnt[i].get(1)[0]-cnt[i].get(0)[1]==1){//两段只隔1位
    			return cnt[i].get(1)[2]+cnt[i].get(0)[2];
    		}else{
    			return Math.max(cnt[i].get(0)[2],cnt[i].get(1)[2])+1;
    		}
    	}else{//出现多段，
    		int max = 0;
    		for(int pos=0;pos<len;pos++){
    			if(pos<len-1 && cnt[i].get(pos+1)[0]-cnt[i].get(pos)[1]==1){//两段隔一个
    				max = Math.max(max, cnt[i].get(pos+1)[2]+cnt[i].get(pos)[2]+1);
    			}else
    				max = Math.max(cnt[i].get(pos)[2]+1,max);
    		}
    		return max;
    	}
    }
}
