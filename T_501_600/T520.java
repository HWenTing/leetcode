package T_501_600;

public class T520 {

//	检测大写字母是否正确
//	全部字母都是大写，比如"USA"。
//	单词中所有字母都不是大写，比如"leetcode"。
//	如果单词不只含有一个字母，只有首字母大写， 比如 "Google"。
	
	
//	循规蹈矩的做吧。。
    public boolean detectCapitalUse(String word) {
    	boolean up=false;
    	boolean low=false;
    	int cnt=0;
    	
        for(char c:word.toCharArray()){
        	if(c<='Z'){//大写
        		if(low) return false;
        		up=true;
        		cnt++;
        	}
        	else if(c>='a'){
        		if(cnt>1) return false;
        		low=true;
        	}
        }
        return true;
    }
    
    
}
