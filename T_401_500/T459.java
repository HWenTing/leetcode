package T_401_500;

public class T459 {

	
//	给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
	
//	遍历从1到n/2,能被整除的都算一遍
    public boolean repeatedSubstringPattern(String s) {
        
    	int len = s.length();
    	for(int i=1;i<=len/2;i++){
    		if(len%i==0){

    			int cnt=i;
    			int start=0;
    			
    			while(cnt+i<=len && s.substring(start, cnt).equals(s.substring(cnt,cnt+i))){
                    start+=i;
    				cnt+=i;
    			}
    			if(cnt+i>len)
    				return true;
    		}
    	}
    	return false;
    }
    
}
