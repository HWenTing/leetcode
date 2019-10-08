package T_601_700;

public class T680 {

//	给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
//	注意是删除
	int cnt=0;
    public boolean validPalindrome(String s) {
    	if(s.length()<=2) return true;
    	
        int start=0;
        int end=s.length()-1;
        
        while(start<end){
        	if(s.charAt(start)!=s.charAt(end)){
        		if(s.charAt(start+1)==s.charAt(end) && s.charAt(start)==s.charAt(end-1)){//这个地方要注意两个分支
        			cnt++;
            		if(cnt>1)
            			return false;
        			return validPalindrome(s.substring(start+1,end+1)) || validPalindrome(s.substring(start,end));
        		}else if(s.charAt(start+1)==s.charAt(end)){
        			cnt++;
        			start++;
        		}else if(s.charAt(start)==s.charAt(end-1)){
        			cnt++;
        			end--;
        		}else{
        			return false;
        		}
        		if(cnt>1)
        			return false;
        	}
        	start++;
        	end--;
        }
        return true;
    }
    
}
