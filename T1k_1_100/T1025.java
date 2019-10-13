package T1k_1_100;

import java.util.LinkedList;
import java.util.List;

public class T1025 {

	
	
//	动态规划 只要当前状态 对应的N-x有false，则当前为true，否则为false，因为无论自己怎么操作，到对方时总是对方胜利
//    public boolean divisorGame(int N) {
//        boolean[] ans = new boolean[1001];
//        ans[1] =false;
//        for(int i=2;i<=N;i++){
//        	List<Integer> temp = gcd(i);
//        	for(int pos:temp)
//        		ans[i] |=!ans[N-pos];
//        }
//        return ans[N];
//    }
//    
//    private List<Integer> gcd(int num){//求因子
//    	LinkedList<Integer> ans = new LinkedList<>();
//    	ans.add(1);
//    	for(int i=2;i<=num/2;i++){
//    		if(num%i==0){
//    			ans.add(i);
//    			ans.add(num/i);
//    		}
//    	}
//    	return ans;
//    }
    
	
//	奇淫异术
//	如果N是奇数，因为奇数的所有因数都是奇数，因此 N 进行一次 N-x 的操作结果一定是偶数，
//	所以如果 a 拿到了一个奇数，那么轮到 b 的时候，b拿到的肯定是偶数，这个时候 b 只要进行 -1， 还给 a 一个奇数，那么这样子b就会一直拿到偶数，到最后b一定会拿到最小偶数2，a就输了。
//
//	所以如果游戏开始时Alice拿到N为奇数，那么她必输，也就是false。
//	如果拿到N为偶数，她只用 -1，让bob 拿到奇数，最后bob必输，结果就是true。
    public boolean divisorGame(int N) {
        if(N % 2 == 0){
            return true;
        }
        return false;
    }
    
}
