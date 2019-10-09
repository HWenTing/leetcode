package T_701_800;

public class T754 {

//	在一根无限长的数轴上，你站在0的位置。终点在target的位置。
//	每次你可以选择向左或向右移动。第 n 次移动（从 1 开始），可以走 n 步。
//	返回到达终点需要的最小移动次数。
	
//	放弃了，，
	
//	从1到N一直累加, 直到SUM==TARGET, 或SUM减TARGET为正偶数. 因为在第n步往回走一次,SUM就会减少2n, 所以他们的差必须是偶数才能到.
    public int reachNumber(int target) {
    	target=Math.abs(target);//正负是对称的
        int ans=1;
        int sum=0;
        while(true){
        	sum+=ans;
        	if(sum-target>=0 && (sum-target)%2==0)
        		return ans;
        	ans++;
        }
    }
    
}
