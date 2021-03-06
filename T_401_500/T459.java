package T_401_500;

public class T459 {

	
//	给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
	
//	遍历从1到n/2,能被整除的都算一遍 暴力破解
//    public boolean repeatedSubstringPattern(String s) {
//    	int len = s.length();
//    	for(int i=1;i<=len/2;i++){
//    		if(len%i==0){
//    			int cur = i;
//    			while(cur<len && s.charAt(cur)==s.charAt(cur-i))
//    				cur++;
//    			if(cur==len)
//    				return true;
//    		}
//    	}
//    	return false;
//    }
	
	
//	S由s重复多次 即S=s...s构成  那么2S[1:2n-1] 中一定含有S  可以使用KMP方法
    public boolean repeatedSubstringPattern(String s) {
    	return KMP((s+s).substring(1,2*s.length()-1),s)>=0;
    }
    
//	字符串匹配，返回shorter在longer中的下标，若没有则返回-1
	int KMP(String longer,String shorter){
		int i=0; //一直自增
		int j=0; //不断回跳
		
		int[] next = getNext(shorter);
		while(i<longer.length() && j<shorter.length()){
			if(j==-1 || longer.charAt(i)==shorter.charAt(j)){
				i++;
				j++;
			}else
				j = next[j];
			
			if(j==shorter.length()) return i-j;
		}
		return -1;
	}
	
//	获得next数组
	private int[] getNext(String s){//下标从1开始算
		int[] next = new int[s.length()+1];
		next[0] = -1;
		int i=0; //一直自增
		int j=-1; //不断回跳
		while(i<s.length()){
			if(j==-1 || s.charAt(i)==s.charAt(j)){//相等 则两个指针都前进一步
				i++;
				j++;
				next[i] = j;
			}else 
				j = next[j];//还是不大明白 好像是指向上一次最长前缀的末尾
		}
		return next;
	}
	
}
