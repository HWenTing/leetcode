package T_1_100;

public class T80 {

//	给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
//	不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

//	双指针，一个指向正确的位置，一个指向遍历的位置。
    public int removeDuplicates(int[] nums) {
        int correctPtr = 0;
        int curPtr = 0;
      
        while(curPtr<nums.length){
        	int curval=nums[curPtr];
        	nums[correctPtr]=curval;
        	correctPtr++;
        	int count=1;
        	curPtr++;
        	while(curPtr<nums.length &&nums[curPtr]==curval){
        		curPtr++;
                count++;
        	}
        	
        	if(count>1){
            	nums[correctPtr]=curval;
            	correctPtr++;
        	}
        }

        return correctPtr;
    }
    
    
}
