package T_401_500;

import java.util.HashMap;
import java.util.Map;

public class T464 {

//	在 "100 game" 这个游戏中，两名玩家轮流选择从 1 到 10 的任意整数，累计整数和，先使得累计整数和达到 100 的玩家，即为胜者。
//	如果我们将游戏规则改为 “玩家不能重复使用整数” 呢？
//	例如，两个玩家可以轮流从公共整数池中抽取从 1 到 15 的整数（不放回），直到累计整数和 >= 100。
//	给定一个整数 maxChoosableInteger （整数池中可选择的最大数）和另一个整数 desiredTotal（累计和），判断先出手的玩家是否能稳赢（假设两位玩家游戏时都表现最佳）？
//	你可以假设 maxChoosableInteger 不会大于 20， desiredTotal 不会大于 300。

//	maxChoosableInteger小于等于20，而int32位，因此可以用int的每一位来标记对应的元素是否被选择
//	打表，防止重复运算
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {

    	if(maxChoosableInteger>=desiredTotal)//最大值即可满足
    		return true;
    	if((maxChoosableInteger*(maxChoosableInteger+1))/2<desiredTotal)//总和还小于
    		return false;
    	Map<Integer,Boolean> map = new HashMap<>();
    	return canIWin(maxChoosableInteger,desiredTotal,0,map);
    	
    }

    private boolean canIWin(int maxChoosableInteger, int desiredTotal,int used,Map<Integer,Boolean> map){
    	if(map.containsKey(used))
    		return map.get(used);
    	
    	for(int i=0;i<maxChoosableInteger;i++){
    		int cur = 1<<i;//标记当前选择第几位
    		if((used&cur)==0){//查看该位是否被占用
//    			i+1>=desiredTotal 满足条件
//    			used|cur 是选择该位置的数字后，used所表示的值
//    			desiredTotal 是还需要的大小
    			if(i+1>=desiredTotal || !canIWin(maxChoosableInteger,desiredTotal-(i+1),used|cur,map)){
    				map.put(used, true);
    				return true;
    			}
    		}
    	}
		map.put(used, false);
		return false;
    }
    
    
    
    
    
    
    
}
