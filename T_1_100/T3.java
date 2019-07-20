package T_1_100;

public class T3 {
	static public int lengthOfLongestSubstring(String s) {
        int len = 0;
        int pos = 0; 
        int count=0;
        for(int i =0;i<s.length();i++){
        	if(check(s.substring(pos, i),s.charAt(i))>=0){//有重复的
        		int temp  = check(s.substring(pos, i),s.charAt(i));
        		len = ((i-pos)>len)?(i-pos):len;
        		pos = pos+temp;
        		count=i-pos+1;
        	}else{
        		count++;
        	}
        }
        if(count>len) len = count;

        return len;
    }
	static int check(String s,char c){
		for(int i =0;i<s.length();i++){
			if(s.charAt(i)==c)
				return i+1;//有相同的字母返回位置
		}
		return -1;//没有相同的字母
		
	}
	public static void main(String []args){
		String s = "pwwkew";
		System.out.println(lengthOfLongestSubstring(s));
	}
}
