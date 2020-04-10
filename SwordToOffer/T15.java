package SwordToOffer;

public class T15 {

//	请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。
//	例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。

//	位运算 先右移 再异或
    public int hammingWeight(int n) {
        int cnt=0;
    	while(n!=0){
    		if((n&1)==1)
    			cnt++;
    		n = n>>>1;
//    		>> 右移运算符，num >> 1,相当于num除以2
//			>>> 无符号右移，忽略符号位，空位都以0补齐
    	}
    	return cnt;
    }
    
}
