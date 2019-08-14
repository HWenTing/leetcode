package T_601_700;

public class T693 {

//	给定一个正整数，检查他是否为交替位二进制数：换句话说，就是他的二进制数相邻的两个位数永不相等。
	
//	转成二进制字符串，一个一个检查
//	击败47%
//    public boolean hasAlternatingBits(int n) {
//        String binary = Integer.toBinaryString(n);
//        char before='2';
//        for(char c:binary.toCharArray()){
//        	if(c==before)
//        		return false;
//        	before=c;
//        }
//        return true;
//    }
    
	
//	位运算解决
//	对于 1010 这种位级表示的数，把它向右移动 1 位得到 101，这两个数每个位都不同，因此异或得到的结果为	1111。
//	击败99.85%
    public boolean hasAlternatingBits(int n) {
        int a = n^(n>>1);
        return (a & (a+1))==0;
    }
    
    
    
}
