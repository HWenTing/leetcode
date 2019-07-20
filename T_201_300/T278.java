package T_201_300;

public class T278 {
	public boolean isBadVersion(int a ){
		return true;
	}
    public int firstBadVersion(int n) {
        int l =1 ;
        int h =n;
        while(l<=h){
        	int mid = l+(h-l)/2;
        	if(isBadVersion(mid)){
        		h=mid-1;
        	}else{
        		l = mid+1;
        	}
        	
        }
        return l;
    }
}
