package T_701_800;

public class T767 {

//	给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
//	若可行，输出任意可行的结果。若不可行，返回空字符串。
	
	
//	统计字母出现的频率，如果大于[(n+1)/2] 则不可能
    public String reorganizeString(String S) {
        int[] cnt = new int[26];
        for(char c:S.toCharArray())
        	cnt[c-'a']++;
        
        int max=0;
        int maxpos=0;
        for(int i=0;i<26;i++){
        	if(cnt[i]>max){
        		max=cnt[i];
        		maxpos=i;
        	}
        }
        
        if(max>((S.length()+1)/2))
        	return "";
        
        char[] ans = new char[S.length()];
        int pos=0;
        for(int i=0;i<max;i++){
        	ans[pos]=(char) (maxpos+'a');
        	
        	pos+=2;

        }
        for(int k=0;k<26;k++){
        	if(k!=maxpos){
        		while(cnt[k]>0){
        			cnt[k]--;
        			ans[pos>=S.length()?pos=1:pos]=(char)(k+'a');
        			pos+=2;
        		}
        	}
        }
        

        return new String(ans);
    }
    
}
