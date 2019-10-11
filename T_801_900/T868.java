package T_801_900;

public class T868 {

//	给定一个正整数 N，找到并返回 N 的二进制表示中两个连续的 1 之间的最长距离。 
	
//	位运算
    public int binaryGap(int N) {
    	int ans=0;
    	int pos=-1;
    	int cnt=0;
    	while(N>0){
    		cnt++;
    		if((N&1)==1){
    			if(pos<0){//第一个
    				pos=cnt;
    			}else{//不是第一个
    				ans = Math.max(ans, cnt-pos);
    				pos = cnt;
    			}
    		}
    		N>>>=1;
    	}
        return ans;
    }
    
}
