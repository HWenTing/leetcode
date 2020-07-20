package SwordToOffer;

public class T46 {

//	给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
//	一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。

	//第一想法dp
    public int translateNum(int num) {
    	if(num<10) return 1;
    	char[] numstring = String.valueOf(num).toCharArray();
    	int len = numstring.length;
    	
    	int[] dp = new int[len];
    	dp[0] = 1;
    	if(numstring[1]-'0'+(numstring[0]-'0')*10<26)
    		dp[1] = 2;
    	else
    		dp[1] = 1;
    	
    		
    	for(int i=2;i<len;i++){
    		if(numstring[i-1]!='0' && numstring[i]-'0'+(numstring[i-1]-'0')*10<26){//要注意506这种情况
    			dp[i]+=dp[i-2];
    		}
    		dp[i]+=dp[i-1];
    	}
    	return dp[len-1];
    	
    }
}
