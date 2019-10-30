package T_1_100;

public class T75 {

//	给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
//	荷兰国旗问题
	

    public void sortColors(int[] nums) {
        int left01 = -1;//指向最后一个0
        int right12 = nums.length;//指向第一个2
        
        for(int i=0;i<right12;i++){
        	if(nums[i]==0){
        		left01++;
        		nums[i]=nums[left01];
        		nums[left01]=0;
        	}
        	else if(nums[i]==2){
        		right12--;
        		nums[i]=nums[right12];
        		nums[right12] = 2;
        		i--;
        	}
        }
        return ;
    }
    
}
