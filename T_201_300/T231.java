package T_201_300;

public class T231 {

//	给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
	
//	判断是否二进制表示只有一个 1 存在
    public boolean isPowerOfTwo(int n) {
        return n>0 && Integer.bitCount(n)==1;//要注意n>0这个条件，-2147483648的二进制也只有一个1
        
//        return n > 0 && (n & (n - 1)) == 0;/利用 1000 & 0111 == 0 这种性质，得到此解法
    }
    
}
