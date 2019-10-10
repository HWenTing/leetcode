package T_701_800;

import java.util.HashSet;

public class T788 {

	
//	我们称一个数 X 为好数, 如果它的每位数字逐个地被旋转 180 度后，我们仍可以得到一个有效的，且和 X 不同的数。要求每位数字都要被旋转。
//	如果一个数的每位数字被旋转以后仍然还是一个数字， 则这个数是有效的。0, 1, 和 8 被旋转后仍然是它们自己；
//	2 和 5 可以互相旋转成对方；6 和 9 同理，除了这些以外其他的数字旋转以后都不再是有效的数字。
//	现在我们有一个正整数 N, 计算从 1 到 N 中有多少个数 X 是好数？

	
//	每位都在(2, 5, 6, 9, 0, 1, 8)内，至少一位在(2, 5, 6, 9)内
	
	HashSet<Integer> set2;
	HashSet<Integer> set;
    public int rotatedDigits(int N) {
    	set2 = new HashSet<>();
    	set2.add(2);set2.add(5);set2.add(6);set2.add(9);
    	set = new HashSet<>(set2);
        set.add(0);set.add(1);set.add(8);
        int ans=0;
       	while(N>0){
       		if(valid(N))
       			ans++;
       		N--;
        }
       	return ans;
    }

    private boolean valid(int n) {//判断是否为好数
    	boolean hasset2=false;
    	int temp;
    	while(n>0){
    		temp = n%10; 
    		if(!set.contains(temp))
    			return false;
    		else{
    			if(set2.contains(temp))
    				hasset2=true;
    		}
    		n=n/10;
    	}
    	return hasset2;
	}
    
}
