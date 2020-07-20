package T_101_200;

public class T137 {

//	给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
	
//	位运算
//	构造出来 满足  num op 0 =0; num op num op num=0 即可   即构造三进制
	
//	目的是构造变化规则
	
//	  one	 two
//  00	 00 	+t--->
//  t		 00 	+t--->
//  00	 t 		+t--->
//  00	 00 
  
    public int singleNumber(int[] nums) {
        int one = 0;
        int two = 0;
        for(int i:nums){
        	one = one^(i & (~two));
        	two = two^(i & (~one));
        }
        return one;
//        如果返回two 表示返回只出现两次的唯一数
    }
    
}
