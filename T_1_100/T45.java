package T_1_100;

public class T45 {

/*
 * 贪心算法，每次走能走到的最远距离
 */
    public static int jump(int[] nums) {
    	
    	int len = nums.length;
    	if(len<=1){
    		return 0;
    	}
    	int ans=0;
    	int pos=0;
        while(pos+nums[pos]<len-1){

        	int max=pos+nums[pos];
        	int temp = pos+nums[pos];
        	for(int i=pos+nums[pos];i>pos;i--){
        		if(nums[i]+i>max){
        			max = nums[i]+i;
        			temp = i;
        		}
        	}
        	pos = temp;
        	ans++;
        }
        
        return ++ans;
    }
    
    public static void main(String[] args){
    	int[] candidates = {2,3,1,1,4};
    	
    	System.out.println(jump(candidates));
    }
    
    

    
}
