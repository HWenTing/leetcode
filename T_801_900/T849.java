package T_801_900;

public class T849 {

//	在一排座位（ seats）中，1 代表有人坐在座位上，0 代表座位上是空的。
//	至少有一个空座位，且至少有一人坐在座位上。
//	亚历克斯希望坐在一个能够使他与离他最近的人之间的距离达到最大化的座位上。
//	返回他到离他最近的人的最大距离。
	
//	也就是  Math.max(连续0的个数 +1)/2,最左边连续0，最右边连续0)
    public int maxDistToClosest(int[] seats) {
    	int cnt=0;
    	int ans=0;
    	boolean first=true;
        for(int i:seats){
        	if(i==0){
        		if(cnt>0)
        			cnt++;
        		else
        			cnt=1;
        	}else{
        		if(first){
        			ans=cnt;
        			first=false;
        		}
        		ans=Math.max(ans, (cnt+1)/2);
        		cnt=0;
        	}
        }
        return Math.max(ans,cnt);
    }
    
}
