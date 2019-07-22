package T_401_500;

public class T474 {
	
//	dp的思想，好像对strs里的元素处理的顺序没有关系

    public int findMaxForm(String[] strs, int m, int n) {
    	if (strs == null || strs.length == 0) {
    		return 0; 
    	}
    	
    	int [][]dp = new int[m+1][n+1];
    	
    	for(String str:strs){
    		int one = 0 ;
    		int zero = 0;
    		for(char c:str.toCharArray()){
    			if(c=='0')
    				zero++;
    			else if(c=='1')
    				one++;
    		}

    		for(int i=m;i>=zero;i--){//注意顺序，一定要从m--，保证一个元素只影响一次
    			for(int j=n;j>=one;j--){
    				dp[i][j]=Math.max(dp[i][j], dp[i-zero][j-one]+1);
    			}
    		}
    		
//    		for(int i=zero;i<=m;i++){//如果从0到m，相当于同一个str能被利用多次，即前边的结果影响到了后边
//				for(int j=one;j<=n;j++){
//					dp[i][j]=Math.max(dp[i][j], dp[i-zero][j-one]+1);
//				}
//			}
    		
//    		for(int i=0;i<=m;i++){//输出dp矩阵
//    			for(int j=0;j<=n;j++){
//    				System.out.print(dp[i][j]+" ");
//    			}
//    			System.out.println();
//    		}
//    		System.out.println();
    		
    		

    		
    		
    	}
    	return dp[m][n];
    }
	
	
	public static void main(String[] args){
		T474 t =new T474();
		String [] strs=new String[]{"10","0001","111001","1","0"};
		System.out.println(t.findMaxForm(strs, 5, 3));
	}
}
