package T1k_201_300;

public class T1217 {

	
//	求奇数和偶数哪个最少
    public int minCostToMoveChips(int[] chips) {
    	int odd=0;
    	int even=0;
        for(int i:chips){
        	if(i%2==0)
        		even++;
        	else
        		odd++;
        }
        return Math.min(odd,even);
    }
    
}
