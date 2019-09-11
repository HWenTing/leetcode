package T_301_400;

public class T374 {
	
//	猜数字，二分法
	int pick=6;
	int guess(int num){
		return 0;
	}
    public int guessNumber(int n) {
        int up = n;
        int low = 1;
        int mid;
        
        while(up>low){
        	mid = low+(up-low)/2;//以后求中点都这样求吧，防止溢出
        	int ans = guess(mid);
        	if(ans==0)
        		return mid;
        	else if(ans>0){//猜小了
                low = mid+1;
        	}else{
        		up = mid;
        	}
        }
        return up;
    }
    
}
