package T_801_900;

import java.util.HashSet;

public class T804 {

//	摩斯密码
    public int uniqueMorseRepresentations(String[] words) {
        HashSet<String> set = new HashSet<>();
        String[] psw = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        
        StringBuffer sb;
        for(String s:words){
        	sb = new StringBuffer();
        	for(char c : s.toCharArray()){
        		sb.append(psw[c-'a']);
        	}
        	set.add(sb.toString());
        }
        return set.size();
    }
    
}
