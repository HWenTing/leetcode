package T_901_1000;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class T914 {

//	给定一副牌，每张牌上都写着一个整数。
//	此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
//	每组都有 X 张牌。
//	组内所有的牌上都写着相同的整数。
//	仅当你可选的 X >= 2 时返回 true。

//	出现次数的最小公因数是否大于1
//    用数组代替hash会快一些
//    public boolean hasGroupsSizeX(int[] deck) {
//        int[] map = new int[10000];
//        for(int i:deck){
//        	map[i]++;
//        }
//        
//        int min=Integer.MAX_VALUE;
//        for(int i:map){
//        	if(i!=0 && i<min)
//        		min=i;
//        }
//        if(min==1)
//        	return false;
//        HashSet<Integer> set = getfactor(min);
//
//        for(int i:map){
//        	if(i==0) continue;
//        	Iterator<Integer> it = set.iterator();
//        	while(it.hasNext()){
//        		int f = it.next();
//        		if(i%f!=0)
//        			it.remove();
//        	}
//        	if(set.isEmpty())
//        		return false;
//        }
//        return true;
//    }
//    
////    寻找除1以外 所有的公因数
//    private HashSet<Integer> getfactor(Integer i){
//    	HashSet<Integer> set = new HashSet<>();
//    	int end = (int) Math.sqrt(i);
//    	for(int temp=2;temp<=end;temp++){
//    		if(i%temp==0){
//    			set.add(temp);
//    			set.add(i/temp);
//    		}
//    	}
//    	if(i>1) set.add(i);
//    	return set;
//    }
	
	
    public boolean hasGroupsSizeX(int[] deck) {
        int[] count = new int[10000];
        for (int c: deck)
            count[c]++;

        int g = -1;
        for (int i = 0; i < 10000; ++i){
        	if (count[i] > 0) {
        		if (g == -1)
        			g = count[i];
        		else
        			g = gcd(g, count[i]);
        		
        		if(g<2) return false;
        	}
        }

        return g >= 2;
    }

    public int gcd(int x, int y) {//求最大公因数
        return x == 0 ? y : gcd(y%x, x);
    }

}











