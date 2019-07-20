package T_601_700;

import java.util.Arrays;
import java.util.Comparator;

//要注意题目中说的 可以以任何顺序选择其中的一些数对来构造！！

public class T646 {
    public int findLongestChain(int[][] pairs) {
        int row = pairs.length;
        if(row==0)
        	return 0;
        
        Arrays.sort(pairs, new Comparator<int[]>(){

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[0]-o2[0];
			}
        	
        });        

        int[] dp = new int[row];
        
        for(int i=0;i<row;i++){
        	dp[i]=1;
        	for(int j=i-1;j>=0;j--){
        		if(pairs[i][0]>pairs[j][1])
        			dp[i] = Math.max(dp[i], dp[j]+1);
        	}
        }
        int max = 0;
        for(int i:dp){
        	max = Math.max(max, i);
        }
        return max;
    }
    public static void main(String[] args){
    	int [][] a =new int[][]{{3,4},
    		{2,3},
    		{1,2}};
    	T646 t = new T646();
    	System.out.println(t.findLongestChain(a));
    }
}
