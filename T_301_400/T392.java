package T_301_400;

public class T392 {
	 
//	给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
	
	
//	终于过了尼玛的。。
    public boolean isSubsequence(String s, String t) {
    	if(s.length()>t.length()) return false;
    	int pos=-1;
        for(char i:s.toCharArray()){
            pos++;
            if(pos>=t.length()) return false;
        	while(i!=t.charAt(pos)){
                pos++;
        		if(pos>=t.length()) return false;
        	}

        }
        return true;
    }
    
//    public boolean isSubsequence(String s, String t) {
//        int index = -1;
//        for (char c : s.toCharArray()){
//            index = t.indexOf(c, index+1);
//            if (index == -1) return false;
//        }
//        return true;
//    }
    
}
