package T1k_1_100;

import java.util.Arrays;

public class T1051 {

//	排序后看有几位变化了
//	排序可以替换成桶排序
    public int heightChecker(int[] heights) {
    	int count = 0;
        int[] temp = heights.clone();
        Arrays.sort(temp);
        for(int i=0;i<heights.length;i++){
            if(heights[i]!=temp[i])
                count++;
        }
        return count;
    }
    
}
