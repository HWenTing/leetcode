package T_301_400;

public class T371 {

	
//	不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
	
    public int getSum(int a, int b) {
    	return b==0?a:getSum(a^b,(a&b)<<1);//(a&b)<<1表示进位
    }
    
    
}
