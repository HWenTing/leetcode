package SwordToOffer;

public class T10_1 {

//	写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。答案需要取模 1e9+7（1000000007）
    public int fib(int n) {

    	if(n<2) return n;
    	int a = 0;
    	int b = 1;
    	
    	int temp;
    	while(n>1){
    		temp = a+b;
    		a = b;
    		b = temp%1000000007;
    		n--;
    	}
    	return b;
    }
    
}
