package T_301_400;

public class T389 {

//	给定两个字符串 s 和 t，它们只包含小写字母。
//	字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
//	请找出在 t 中被添加的字母。
	
//	map
//	因为只有一个是多的，ASCII码相加作差即可
    public char findTheDifference(String s, String t) {
        int[] cnt = new int[26];
        for(char c:s.toCharArray()){
        	cnt[c-'a']++;
        }
        
        for(char c:t.toCharArray()){
        	cnt[c-'a']--;
        }
        
        for(int i=0;i<26;i++){
        	if(cnt[i]<0)
        		return (char) (i+'a');
        }
        return 0;
    }
    
}
