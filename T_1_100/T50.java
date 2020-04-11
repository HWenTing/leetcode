package T_1_100;

public class T50 {

//	实现 pow(x, n) ，即计算 x 的 n 次幂函数。
	
//	快速幂 A^4 = A^2 x A^2  减少计算
//	递归的写法 递归调用会占用栈空间
//	时间复杂度O(logn) 空间复杂度O(logn)
//    public double myPow(double x, int n) {
//    	if(n==0) return 1;
//    	else if(n==1) return x;
//    	else if(n==-1) return 1/x;
//    	
//    	double d1 = myPow(x,n/2);
//    	double d2 = myPow(x,n%2);
//    	return d1*d1*d2;
//    }
    
//	循环实现快速幂
    public double myPow(double x, int n) {
    	long N = n;//处理极限情况 n=-2147483648 -n溢出
    	if(N<0){//转化成n>0的情况
    		x = 1/x;
    		N = -N;
    	}

    	double ans = 1;
    	double cur = x;
    	while(N>0){
    		if(N%2 ==1){
    			ans *= cur;
    		}
    		cur *=cur;
    		N/=2;
    	}
    	
    	return ans;
    }
    
}
