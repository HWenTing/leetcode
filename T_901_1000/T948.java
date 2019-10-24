package T_901_1000;

import java.util.Arrays;

public class T948 {

	
//	你的初始能量为 P，初始分数为 0，只有一包令牌。
//
//	令牌的值为 token[i]，每个令牌最多只能使用一次，可能的两种使用方法如下：
//
//	如果你至少有 token[i] 点能量，可以将令牌置为正面朝上，失去 token[i] 点能量，并得到 1 分。
//	如果我们至少有 1 分，可以将令牌置为反面朝上，获得 token[i] 点能量，并失去 1 分。
//	在使用任意数量的令牌后，返回我们可以得到的最大分数。

	
//	贪心，先排序，卖高分，买低分
    public int bagOfTokensScore(int[] tokens, int P) {
        Arrays.sort(tokens);
        int left=0;
        int right=tokens.length-1;
        int ans=0;//最高得分
        int point=0;//目前的得分
        while(left<=right){
        	if(tokens[left]>P){//不够买低分，就卖高分
        		if(point<=0)
        			return ans;
        		else{
        			point--;
        			P+=tokens[right];
        			right--;
        		}
        	}else{//够买低分就买低分
        		P-=tokens[left];
        		point++;
        		ans = Math.max(ans, point);
        		left++;
        	}
        }
        
        return ans;
    }
    
}
