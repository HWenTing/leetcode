package T_201_300;

import java.util.HashSet;
import java.util.Set;

public class T202 {

//	编写一个算法来判断一个数是不是“快乐数”。

// 	一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，
//	然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。

//	用一个set存储出现过的数字，如果重复则返回false
//	击败61%
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        
        while(!set.contains(n)){
        	if(n==1)
        		return true;
        	set.add(n);
        	n=getn(n);
        	
        }
        return false;
    }
    
    private int getn(int n){
    	int ans=0;
    	
    	while(n>0){
    		ans+=Math.pow((n%10), 2);
    		n/=10;
    	}
    	return ans;
    }
	
}
