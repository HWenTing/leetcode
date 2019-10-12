package T_901_1000;

public class T985 {

	
//	挺无聊的这题。。
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
    	int[] ans = new int[queries.length];
    	int sum=0;
    	for(int i:A){
    		if(i%2==0)
    			sum+=i;
    	}
    	
    	for(int i=0;i<queries.length;i++){
    		int[] query = queries[i];
    		if(A[query[1]]%2==0)
    			sum-=A[query[1]];
    		A[query[1]]+=query[0];
    		if(A[query[1]]%2==0)
    			sum+=A[query[1]];
    		
    		ans[i] = sum;
    	}
    	
    	return ans;
    }

}
