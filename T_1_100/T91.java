package T_1_100;

public class T91 {

//题目整体思路就是dp，就是找当前位编码数和前一位编码数的关系以及前两位编码数的关系。 要分好几种情况来分析：
//如果当前位为0：
//如果前一位不是1或2，则这个0无法和任何数组成字母，代表整个串无法构成编码
//如果前一位是1或者2，则说明前一位和当前位能组成字母，这时候能构成的编码数目是和前前位相同的，即：dp[i] = dp[i-2]
//如果当前位不为0：
//如果前一位和当前位能组成字母，则当前位的构成编码数目应该为前一位和前前位之和，即：dp[i] = dp[i-1] + dp[i-2]，当然要考虑当前位是否符合i>=2?
//如果前一位和当前位不能组成字母，则当前位单独组成字母，即dp[i] = dp[i-1]
	
	//0的问题要多注意
    public int numDecodings(String s) {
        int n =s.length();
        if(n==0)
        	return 0;
        if(s.charAt(0)=='0')
			return 0;
        int []dp = new int[n+1];
        dp[0] = dp[1]=1;
        for(int i=2;i<=n;i++){
        	
        	if(s.charAt(i-1)!='0'){//当前位不为0
        		if(Integer.parseInt(s.substring(i-2, i))<=26 && Integer.parseInt(s.substring(i-2, i))>10){
        			dp[i] = dp[i-1]+dp[i-2];
        		}else{
        			dp[i] = dp[i-1];
        		}
        		
        	}else{//当前位为0
        		if(s.charAt(i-2)=='0' ||s.charAt(i-2)-'0'>2)//不能组成
        			return 0;
        		dp[i] = dp[i-2];
        	}
        	
        }
        
        return dp[n];
    }
    
    
	public static void main(String[] args) {
		T91 t =new T91();
		System.out.println(t.numDecodings("7"));

	}

}
