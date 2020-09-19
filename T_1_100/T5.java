package T_1_100;


public class T5 {
//	寻找最长回文子串
	//暴力破解
//	public static String longestPalindrome(String s) {
//		int len = s.length();
//		if(len ==0){
//			return "";
//		}
//		String ans = s.charAt(0)+"";
//		int left,right;
//		int maxlen = 1;
//		
//		if (len == 1){
//			ans = s;
//		}else{
//			for (int i =0;i<len-1;i++){
//				for (int j = i+1;j<len;j++){
//					left = i;
//					right = j;
//					boolean ishuiwen = true;
//					while(left<=right){
//						if(s.charAt(left) == s.charAt(right)){
//							left++;
//							right--;
//						}else{
//							ishuiwen = false;
//							break;
//						}
//					}
//					if(ishuiwen && maxlen <=j-i){
//						maxlen = j-i;
//						ans = s.substring(i, j+1);
//					}
//				}
//			}
//		}
//		return ans;
//	}
	
//	中心扩展法
	private int start,end,len;
    public String longestPalindrome(String s) {
    	len = s.length();
    	if(len<2) return s;
    	start=0;
    	end=1;
    	
    	for(int i=0;i<len;i++){//两种情况
    		i = item(i,s);
    	}
    	return s.substring(start, end);

    }
    
    private int item(int left,String s){
    	int right = left;
    	while(right<len && s.charAt(right)==s.charAt(left)){//将与i相邻的相同的字母看作一个字母
    		right++;
    	}
    	right--;
    	int ret = right;
    	
		while(left>=0 && right<len && s.charAt(left)==s.charAt(right)){
			left--;
			right++;
		}
		if(end-start<right-left-1){
			start=left+1;
			end = right;
		}
		return ret;
    }
	
}
