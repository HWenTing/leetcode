package T1k_101_200;

public class T1103 {

//	给数组循环赋值 每次加1
    public int[] distributeCandies(int candies, int num_people) {
        int[] ans = new int[num_people];
        int num=0;
        while(candies>0){
        	ans[num%num_people]+=++num;
        	candies-=num;
        }
        ans[(num-1)%num_people]+=candies;
        return ans;
    }
    
}
