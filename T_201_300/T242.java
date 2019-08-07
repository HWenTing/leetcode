package T_201_300;

public class T242 {

//	给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
//	可以用hashmap来统计出现的次数
//	也可以直接用26位的数组来统计
	
    public boolean isAnagram(String s, String t) {
        int[] count = new int[26];
        for(char c :s.toCharArray())
        	count[c-'a']++;
        
        for(char c :t.toCharArray())
        	count[c-'a']--;
        
        for(int i :count)
        	if(i!=0)
        		return false;
        return true;
    }
    
}
