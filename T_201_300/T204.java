package T_201_300;

public class T204 {
	
//	求小于某数的质数有几个
//	首先的想法就是暴力，从n到1，一次看是否为质数，但是很low
//	有个 埃拉托斯特尼筛法 
//	比如说求20以内质数的个数,首先0,1不是质数.2是第一个质数,然后把20以内所有2的倍数划去.
//	2后面紧跟的数即为下一个质数3,然后把3所有的倍数划去.
//	3后面紧跟的数即为下一个质数5,再把5所有的倍数划去.
//	以此类推.
	
    public int countPrimes(int n) {
    	int ans=0;
        boolean []notPrimes = new boolean[n+1];
        for(int i=2;i<n;i++){
        	if(!notPrimes[i]){
        		ans++;
        		int temp=i;
        		while(temp+i<=n){
        			temp+=i;
        			notPrimes[temp]=true;
        		}
        	}
        }
        return ans;
    }
    

	public static void main(String[] args) {
		T204 t = new T204();
		System.out.println(t.countPrimes(2));
	}

}
