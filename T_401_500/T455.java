package T_401_500;

import java.util.Arrays;

public class T455 {

	
//	假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
//	对每个孩子 i ，都有一个胃口值 gi ，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j ，都有一个尺寸 sj 。
//	如果 sj >= gi ，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
		
//	贪心，最小的饼干满足最小的需求
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        
        int cnt=0;
        for(int i=0;i<s.length;i++){
        	if(s[i]>=g[cnt]){
        		cnt++;
        	}
        	if(cnt>=g.length)
        		return cnt;
        }
        return cnt;
    }
    
}
