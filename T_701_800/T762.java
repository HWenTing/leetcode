package T_701_800;

public class T762 {

//	计算L到R间有多少二进制1的个数为质数的数
	
	
    public int countPrimeSetBits(int L, int R) {
        
    	int ans=0;
    	while(L<=R){
    		if(valid(Integer.bitCount(L)))//计算二进制1的位数
    			ans++;
    		L++;
    	}
    	return ans;
    }

//    判断是否为质数
	private boolean valid(int bitCount) {
		if(bitCount<=1) return false;
		else{
			int mid = (int) Math.sqrt(bitCount);
			while(mid>1){
				if(bitCount%mid==0)
					return false;
				mid--;
			}
		}
		return true;
	}
    
}
