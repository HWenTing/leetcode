package T_1_100;

import java.util.*;

class TwoTuple{
    char first;
    int second;
    public TwoTuple(char a, int b){
        first = a;
        second = b;
    }
}
public class T32 {
//	给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
//	用栈模拟
//    public int longestValidParentheses(String s) {
//    	Stack<TwoTuple> st = new Stack<>();
//        int len = s.length();
//        int ans = 0;
//        for(int i =0;i<len;i++){
//        	if(s.charAt(i)=='('){
//        		st.add(new TwoTuple('(',i));
//        	}else{
//        		if(!st.isEmpty() && st.peek().first=='('){
//        			st.pop();
//        		}else{
//        			st.add(new TwoTuple(')',i));
//        		}
//        	}
//        }
//        if(st.empty()) return s.length();
//        
//        int cur = s.length();
//        while(!st.isEmpty()){
//        	int temp = st.pop().second;
//        	ans = Math.max(ans, cur-temp-1);
//        	cur = temp;
//        }
//        ans = Math.max(ans, cur-0);
//        return ans;
//    }
  
//    动态规划的方法 dp[i]表示以下标 i字符结尾的最长有效括号的长度
    public int longestValidParentheses(String s) {
        int maxans = 0;
        int dp[] = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }


}
