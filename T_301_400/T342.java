package T_301_400;

public class T342 {

//	给定一个整数 (32 位有符号整数)，请编写一个函数来判断它是否是 4 的幂次方。
	
//	看是否唯一的1在奇数位
    public boolean isPowerOfFour(int num) {
        if( num<=0 || Integer.bitCount(num)!=1)
        	return false;
        return Integer.bitCount(num-1)%2==0;//减一之后偶数个1，说明唯一的1在奇数位
    }
    
}
