package T_contest;

public class T5168 {

	
//	较为容易
	
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] ans = new int[queries.length];
        int cnt;
        int pos=0;
        for(String s:queries){
        	cnt=0;
        	int fs = f(s);
        	for(String word:words){
        		if(fs<f(word))
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
