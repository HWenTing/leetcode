package T_1_100;

public class T43 {

//	给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
	
    /**
    num1的第i位(高位从0开始)和num2的第j位相乘的结果在乘积中的位置是[i+j, i+j+1]
    例: 123 * 45,  123的第1位 2 和45的第0位 4 乘积 08 存放在结果的第[1, 2]位中
      index:    0 1 2 3 4  
          
                    1 2 3
                *     4 5
                ---------
                      1 5
                    1 0
                  0 5
                ---------
                  0 6 1 5
                    1 2
                  0 8
                0 4
                ---------
                0 5 5 3 5
    这样我们就可以单独都对每一位进行相乘计算把结果存入相应的index中        
    **/
	
    public String multiply(String num1, String num2) {
        int len = num1.length()+num2.length();
        int[] ans = new int[len];
        
        
        for(int i=num1.length()-1;i>=0;i--){
        	for(int j=num2.length()-1;j>=0;j--){
        		int cur = (num1.charAt(i)-'0')*(num2.charAt(j)-'0');
        		cur+=ans[i+j+1];//考虑进位
        		ans[i+j+1] = cur%10;
        		ans[i+j] += cur/10;
        	}
        }
        
        StringBuffer sb = new StringBuffer();
        int i=0;
        while(i<len-1 && ans[i]==0)//len-1 处理答案为0的情况
        	i++;
        while(i<len)
        	sb.append(ans[i++]);
        return sb.toString();
    }
    
}
