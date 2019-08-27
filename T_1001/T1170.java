package T_1001;

public class T1170 {

	
//	按要求来即可
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] ans = new int[queries.length];
        int cnt;
        int pos=0;
        int[] wordscnt=new int[words.length];
        for(int i=0;i<words.length;i++){//先计算一遍，节省时间
        	wordscnt[i] = f(words[i]);
        }
        
        for(String s:queries){
        	cnt=0;
        	int fs = f(s);
        	for(int word:wordscnt){//一个个对比
        		if(fs<word)
        			cnt++;
        	}
        	ans[pos++]=cnt;
        }
        return ans;
    }
    
    private int f(String s){
    	int[] cnt = new int[26];
    	for(char c:s.toCharArray()){
    		cnt[c-'a']++;
    	}
    	for(int i:cnt){
    		if(i!=0)
    			return i;
    	}
    	return 0;
    }
    
}
