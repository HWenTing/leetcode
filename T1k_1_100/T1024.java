package T1k_1_100;

import java.util.Arrays;
import java.util.Comparator;

public class T1024 {

//	dp[i] 表示[0,i]范围内片段所需要的片段个数
//	先按照clip[1]排序  
//	dp[i] = Math.min(dp[i], dp[clip[0]]+1);
	
    public int videoStitching(int[][] clips, int T) {
    	Arrays.sort(clips,new Comparator<int[]>(){
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1]==o2[1])
					return o1[0]-o2[0];
				return o1[1]-o2[1];
			}
    	});
    	
    	
    	int[] dp = new int[101];
    	Arrays.fill(dp, Integer.MAX_VALUE);
    	dp[0]=0;
    	
    	int max=0;
    	for(int[] clip:clips){
    		if(clip[1]>max){//终点相同的clip只需要看第一个就行 比如[1,9]和[2,9] 只需要看[1,9]，因为后者包含在前者中
    			if(dp[clip[0]]==Integer.MAX_VALUE) continue;//如果clip[0]还没有赋值
    			int curmin = dp[clip[0]]+1;
    			for(int i=clip[0]+1;i<=clip[1];i++){
    				dp[i] = Math.min(dp[i], curmin);
    			}
    			
    			max = clip[1];
    		}
    	}
    	return dp[T]==Integer.MAX_VALUE?-1:dp[T];

    }
    
    
    
}
