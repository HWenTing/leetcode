package T_1_100;

public class T9 {
	
	
//	转换成字符串
//    public static boolean isPalindrome(int x) {
//        String number = x+"";
//        String rev = new StringBuilder(number).reverse().toString();
//        return number.equals(rev);
//    }
    
	
	
//	不转换成字符串，将数字的后半部分反转一下看与前边是否相等即可
//	判断是否到达中间，只需要判断x>right即可
//	速度快了很多，击败99.4%
    public boolean isPalindrome(int x) {
        if(x<0 || x%10==0 && x!=0)
        	return false;
        int right=0;
        while(x>right){
        	right = right*10+x%10;
        	x/=10;
        }
        return x==right|| x==right/10;
    }

}
