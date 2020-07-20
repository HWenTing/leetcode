package SwordToOffer;

public class T56_2 {

//	在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
//	同T137
//	目的是构造变化规则
	
//	  one	 two
//    00	 00 	+t--->
//    t		 00 	+t--->
//    00	 t 		+t--->
//    00	 00 
    
    public int singleNumber(int[] nums) {

        int one = 0;
        int two = 0;
        for(int i:nums){
        	one = one^i & (~two);
        	two = two^i & (~one);
        }
        return one;
    }
    

    
}
