package T_901_1000;

import java.util.HashMap;

public class T957 {

//	8 间牢房排成一排，每间牢房不是有人住就是空着。
//	每天，无论牢房是被占用或空置，都会根据以下规则进行更改：
//	如果一间牢房的两个相邻的房间都被占用或都是空的，那么该牢房就会被占用。
//	否则，它就会被空置。
//	（请注意，由于监狱中的牢房排成一行，所以行中的第一个和最后一个房间无法有两个相邻的房间。）
//	我们用以下方式描述监狱的当前状态：如果第 i 间牢房被占用，则 cell[i]==1，否则 cell[i]==0。
//	根据监狱的初始状态，在 N 天后返回监狱的状况（和上述 N 种变化）。

//	因为只有8位，可以用异或来作为标签状态
    public int[] prisonAfterNDays(int[] cells, int N) {
    	if(N==0) return cells;
    	HashMap<Integer,Integer> map = new HashMap<>();

        while(N>0){
        	int key = intArrays2int(cells);
        	if(map.containsKey(key)){
        		N%=(map.get(key)-N);//(map.get(key)-N)是循环的大小
        		break;
        	}
        	
        	map.put(key, N);
        	cells = item(cells);
        	N--;
        }
        
        while(N>0){
        	cells = item(cells);
        	N--;
        }
        
        return cells;
        
    }
    
//    int数组转为int
    private int intArrays2int(int[] nums){
    	int ans = 0;
    	for(int i=0;i<nums.length;i++){
    		ans^=nums[i]<<i;
    	}
    	return ans;
    }
    
//    int转为int数组
    private int[] int2intArrays(int num){
    	int[] ans = new int[8];
    	for(int i=7;i>=0;i--){
    		if((num&1)==1)
    			ans[i]=1;
    		else 
    			ans[i]=0;
    	}
    	return ans;
    }
    
//    状态迁移
    private int[] item(int[] cells){
    	int[] ret = new int[cells.length];
    	for(int i=1;i<cells.length-1;i++){
    		if(cells[i-1]==cells[i+1])
    			ret[i]=1;
    		else
    			ret[i]=0;
    	}
    	return ret;
    }
    
}
