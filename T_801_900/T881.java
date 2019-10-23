package T_801_900;

import java.util.Arrays;

public class T881 {

//	第 i 个人的体重为 people[i]，每艘船可以承载的最大重量为 limit。
//	每艘船最多可同时载两人，但条件是这些人的重量之和最多为 limit。
//	返回载到每一个人所需的最小船数。(保证每个人都能被船载)。

	
//	双指针，每次贪心匹配最沉和最轻，先排序
//	如果最重的人可以与最轻的人共用一艘船，那么就这样安排。否则，最重的人无法与任何人配对，那么他们将自己独自乘一艘船。
//	因为体重有范围，可以桶排序
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left=0;
        int right=people.length-1;
        int ans=0;
        while(left<=right){
        	if(people[left]+people[right]>limit){//超重右指针前移
        		ans++;
        		right--;
        	}else{//不超重就组合在一起，左右指针中间移
        		ans++;
        		left++;
        		right--;
        	}
        }
        return ans;
    }
    
}
