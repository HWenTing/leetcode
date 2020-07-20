package SwordToOffer;

import java.util.LinkedList;
import java.util.List;

public class T57_2 {

//	输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
//	序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。

//	偏数学性

    public int[][] findContinuousSequence(int target) {
    	if(target<3) return new int[0][0];
    	
    	List<int[]> temp = new LinkedList<>();
    	int diff = 1;
    	int num = 2;
    	while(target-diff>0){
    		if((target-diff)%num==0){
    			int start = (target-diff)/num;
    			int[] cur = new int[num];
    			for(int i=0;i<num;i++)
    				cur[i] = start+i;
    			temp.add(0, cur);
    		}
    		diff+=num;
    		num++;
    	}
    	
    	return (int[][])temp.toArray(new int[0][]);
    	
    }
}
