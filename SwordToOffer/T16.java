package SwordToOffer;

public class T16 {

//	实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。

//	快速幂 和T50一样
    public double myPow(double x, int n) {
    	if(n==0) return 1;
    	else if(n==1) return x;
    	else if(n==-1) return 1/x;
    	
    	double d1 = myPow(x,n/2);
    	double d2 = myPow(x,n%2);
    	return d1*d1*d2;
    }
}
