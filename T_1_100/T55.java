package T_1_100;

public class T55 {

	
//	给定一个非负整数数组，你最初位于数组的第一个位置。	数组中的每个元素代表你在该位置可以跳跃的最大长度。
//	判断你是否能够到达最后一个位置。
	
//	速度击败41% 遍历，看每次能到达的最远距离
//    public boolean canJump(int[] nums) {
//    	int len = nums.length;
//        boolean[] reach = new boolean[len];
//        reach[0]=true;
//        for(int i=0;i<len-1;i++){
//        	if(reach[i]){
//        		int pos=Math.min(i+nums[i], len-1);
//        		while(!reach[pos]){
//        			reach[pos]=true;
//        			pos--;
//        		}
//        	}
//        }
//        return reach[len-1];
//    }
   
	
//	击败60% 稍微快一点
    public boolean canJump(int[] nums) {
    	int max = 0;
    	for (int i = 0; i < nums.length-1; i++) {
    		max = Math.max(i + nums[i], max);
    		if (max <= i )
    			return false;
    	}
    	return true;
    }
    
}
