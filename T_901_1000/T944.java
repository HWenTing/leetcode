package T_901_1000;

public class T944 {

//	把A当作二维数组，求有多少列是非降序的，用n减去这个数
    public int minDeletionSize(String[] A) {
        int n=A[0].length();
        int ans=0;
        for(int i=0;i<n;i++){
        	boolean add=false;
        	for(int row=0;row<A.length-1;row++){
        		if(A[row].charAt(i)>A[row+1].charAt(i)){
        			add=true;
        			break;
        		}
        	}
        	if(add) ans++;
        }
        return ans;
    }
    
}
