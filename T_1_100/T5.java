package T_1_100;

import java.util.Deque;
import java.util.LinkedList;

public class T5 {

	
	public static String longestPalindrome(String s) {
		int len = s.length();
		if(len ==0){
			return "";
		}
		String ans = s.charAt(0)+"";
		int left,right;
		int maxlen = 1;
		
		if (len == 1){
			ans = s;
		}else{
			for (int i =0;i<len-1;i++){
				for (int j = i+1;j<len;j++){
					left = i;
					right = j;
					boolean ishuiwen = true;
					while(left<=right){
						if(s.charAt(left) == s.charAt(right)){
							left++;
							right--;
						}else{
							ishuiwen = false;
							break;
						}
					}
					if(ishuiwen && maxlen <=j-i){
						maxlen = j-i;
						ans = s.substring(i, j+1);
					}
				}
			}
		}
		return ans;
	}
	
	
	public static void main(String []args){
		String s = "ababad";
		System.out.println(longestPalindrome(s));
	}
}
