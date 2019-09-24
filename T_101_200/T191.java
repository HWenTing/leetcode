package T_101_200;

public class T191 {

//	编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
	
//	位运算，每次判断最后一位是否为1
    public int hammingWeight(int n) {
//        return Integer.bitCount(n);//调库一行代码。。击败99.89%
    	int cnt =0;
    	while(n!=0){
    		if((n&(-n))==1) cnt++;
    		n>>>=1;
    	}
    	return cnt;	
    }
    
}
