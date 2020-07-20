package SwordToOffer;

public class T65 {

//	写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。

//	 位运算实现加法
	
    public int add(int a, int b) {
    	
    	int carry=b;
    	while(b!=0){
    		carry = (a&carry)<<1;//&运算确定进位的位置
    		a = a^b;
    		b = carry;
    	}
    	return a;
    }
    
}
