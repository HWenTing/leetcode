package T_201_300;

public class T283 {

//	给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序
//	必须在原数组上操作，不能拷贝额外的数组
	
//	两个指针，一个指向第一个0,一个指向第一个0后边的第一个非0
//	唉。。还挺慢的
//    public void moveZeroes(int[] nums) {
//        int pr1=0;//指向第一个0
//        int pr2=pr1;//指向第一个0后边的第一个非0
//        int len = nums.length;
//        
//        while(true){
//        	while(pr1<len && nums[pr1]!=0){//找到第一个0
//        		pr1++;
//        	}
//        	pr2=pr1;
//        	while(pr2<len && nums[pr2]==0){//找到第一个0后边的第一个非0
//        		pr2++;
//        	}
//        	if(pr1>=len || pr2>=len)//结束，返回
//        		return;
//        	nums[pr1]=nums[pr2];//将非0前置
//        	nums[pr2]=0;
//        	pr1++;
//        }
//    }
    
	
//	一个更巧的想法，想象成是两个数组，非0但按顺序放到第二个数组上，后面填0，现在把第二个数组去掉了直接用第一个数组来存
//	击败94%
    public void moveZeroes(int[] nums) {
    	int pr1=0;//新数组指针
    	int pr2=0;//原数组指针
    	int len = nums.length;
      
    	for(;pr2<len;pr2++){
    		if(nums[pr2]!=0){
    			nums[pr1++] = nums[pr2];
    		}
    	}
    	while(pr1<len){
    		nums[pr1++]=0;
    	}
    }
	
	
    
}
