package T_501_600;

public class T565 {

//	找最大循环长度
//	击败98%
	
    public int arrayNesting(int[] nums) {
    	int len = nums.length;
        boolean[] visit = new boolean[len];
        
        int temp,count;
        int ansmax=0;
        for(int i=0;i<len;i++){
        	temp=i;
        	count=0;
        	while(!visit[temp]){//没被循环到
        		visit[temp]=true;
        		count++;
        		temp = nums[temp];//寻找下一个位置
        		
        	}
        	ansmax = Math.max(ansmax, count);
        }
        return ansmax;
    }
    
    
}
