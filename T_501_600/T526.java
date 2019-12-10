package T_501_600;

public class T526 {
//	假设有从 1 到 N 的 N 个整数，如果从这 N 个数字中成功构造出一个数组，使得数组的第 i 位 (1 <= i <= N) 满足如下两个条件中的一个，我们就称这个数组为一个优美的排列。条件：
//	第 i 位的数字能被 i 整除
//	i 能被第 i 位上的数字整除
//	现在给定一个整数 N，请问可以构造多少个优美的排列？

//	回溯算法
	
	int ans;
    public int countArrangement(int N) {
    	ans = 0;
    	item(N,1,new boolean[N+1]);
    	return ans;
    }
    
    private void item(int N,int cnt,boolean[] marked){
    	if(cnt==N){
    		for(int i=1;i<=N;i++){
    			if(!marked[i] && (i%cnt==0 || cnt%i==0))
    				ans++;
    		}
    		return ;
    	}
    	
    	for(int i=1;i<=N;i++){
    		if(!marked[i] && (i%cnt==0 || cnt%i==0)){//别忘记清除状态
    			marked[i]=true;
    			item(N,cnt+1,marked);
    			marked[i]=false;
    		}
    	}
    }
    
}
