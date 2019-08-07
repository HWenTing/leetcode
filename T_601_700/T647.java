package T_601_700;

import java.util.Stack;

public class T647 {

//	计算这个字符串中有多少个回文子串。
//	具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
	
//	想法是以结尾为基准，计算以每个位置作为结尾时回文个数的加和
//	可以ac，但是很慢很慢，空间也很大
//    public int countSubstrings(String s) {
//        int sum = 0;
//        int len=s.length();
//        
//        for(int i=1;i<=len;i++){
//        	sum+=getnum(s,i);
//        }
//        return sum;
//    }
//    
//    private int getnum(String s,int end){
//    	int sum = 0;
//    	for(int i=0;i<end;i++){
//    		sum+=ishuiwen(s.substring(i, end))?1:0;
//    	}
//    	return sum;
//    }
//    
//    private boolean ishuiwen(String s){//判断是否为回文
//    	if(s.length()<=1)
//    		return true;
//    	int start =0;
//    	int end = s.length()-1;
//    	while(start<end){
//    		if(s.charAt(start)!=s.charAt(end))
//    			return false;
//    		start++;
//    		end--;
//    	}
//    	return true;
//    }
	
	
	
//	从字符串某一位开始，尝试扩展字符串
//	速度很快，也很省内存
    private int cnt=0;
	public int countSubstrings(String s) {
        for(int i=0;i<s.length();i++){
        	extendstring(s,i,i);//奇数长度
        	extendstring(s,i,i+1);//偶数长度
        }
        return cnt;
    }
    
    private void extendstring(String s, int start,int end){//向外扩展字符串
    	while(start>=0 && end<s.length() && s.charAt(start)==s.charAt(end)){
    		cnt++;
    		start--;
    		end++;
    	}
    }
}
