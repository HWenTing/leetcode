package SwordToOffer;

public class T14_2 {

//	同14.1 范围变大了2 <= n <= 1000  答案需要取模 1e9+7（1000000007）
	
    public int cuttingRope(int n) {
        if (n==1 || n==2)
           return 1;
       if (n==3)
           return 2;
       long sum=1;//防止溢出
       while (n>4){
           sum*=3;
           sum%=1000000007;
           n-=3;
       }

       return (int) (sum*n%1000000007);
   }
    
}
