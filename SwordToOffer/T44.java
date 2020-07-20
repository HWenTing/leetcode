package SwordToOffer;

public class T44 {

	
//	数字以0123456789101112131415…的格式序列化到一个字符序列中。
//	在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。

//	请写一个函数，求任意第n位对应的数字。
//	同T400
	
    public int findNthDigit(int n) {
    	if(n<10) return n;
    	n-=10;
    	
    	int bit = 2;
    	long base = 10;
    	while(true){//先判断是几位数
    		if(n<bit*9*base)
    			break;
    		n-=bit*9*base;
    		bit++;
    		base*=10;
    	}
    	
    	int offset = n%bit;//在bit位数的哪一位
    	int index = n/bit;//第几个bit位数

    	long which = index+base;
    	offset=bit-offset-1;//在这个数字里的哪一位
    	while(offset>0){
    		which/=10;
    		offset--;
    	}
    	return (int) (which%10);
//    	String temp = index+base+"";
//    	return temp.charAt(offset)-'0';
    	
    }
	
}
