package T_301_400;

public class T383 {

//	判断ransomNote是否包含在magazine
	
//	感觉用map
	
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] cnt = new int[26];
        for(char c:magazine.toCharArray()){
        	cnt[c-'a']++;
        }
        
        for(char c:ransomNote.toCharArray()){
        	cnt[c-'a']--;
        }
        
        for(int i:cnt){
        	if(i<0)
        		return false;
        }
        return true;
    }
    
}
