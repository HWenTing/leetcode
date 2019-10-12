package T_901_1000;

public class T917 {

//	给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
	
//	双指针
    public String reverseOnlyLetters(String S) {
        int left = 0;
        int right = S.length()-1;
        char[] ans = S.toCharArray();
        while(left<right){
        	while(left<right && (ans[left]<'A' ||ans[left]>'z'||ans[left]>'Z' && ans[left]<'a')){//寻找单词
        		left++;
        	}
        	
        	while(left<right && (ans[right]<'A' || ans[right]>'z'||ans[right]>'Z' && ans[right]<'a')){//寻找单词
        		right--;
        	}
        	
        	if(left<right){
        		char temp = ans[right];
        		ans[right] = ans[left];
        		ans[left] = temp;
        	}
        	right--;
        	left++;
        }
        return new String(ans);
    }
    
	
}
