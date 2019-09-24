package T_301_400;

public class T400 {

//	在无限的整数序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...中找到第 n 个数字。
//	确切说是第n位数字
	
//	先确定是几位数，然后确定是哪一个数，然后确定是这个数字的哪个位置
//	9
//	2x90
//	3x900
//	4x9000
	
    public int findNthDigit(int n) {
//        先判断几位数
    	int base= 9 ;
    	int bit = 1;//位数
    	while(n>=base){
    		n-=base;
    		bit++;
    		base=(int) (9*bit*Math.pow(10, bit-1));
    	}
    	if(n==0) 
    		return 9;
    		
    		
    	int pos = n%bit;
    	int number = n/bit - (pos==0?1:0);
    	pos = (pos==0?bit:pos);
    	
    	int which = (int) (Math.pow(10, bit-1)+number);//具体是哪个数字
    	
    	pos=bit-pos;//在这个数字里的哪一位
    	while(pos>0){
    		which/=10;
    		pos--;
    	}
    	return which%10;
    }
    
}
