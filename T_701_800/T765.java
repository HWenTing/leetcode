package T_701_800;

public class T765 {

	
//	N 对情侣坐在连续排列的 2N 个座位上，想要牵到对方的手。 计算最少交换座位的次数，以便每对情侣可以并肩坐在一起。 一次交换可选择任意两人，让他们站起来交换座位。
//	人和座位用 0 到 2N-1 的整数表示，情侣们按顺序编号，第一对是 (0, 1)，第二对是 (2, 3)，以此类推，最后一对是 (2N-2, 2N-1)。
//	这些情侣的初始座位  row[i] 是由最初始坐在第 i 个座位上的人决定的。

//	贪心算法，每次两个人中认为左边的位置是正确的，将右边的人安排正确即可
//	mark数组记录每个序号出现的位置
//	时间O(n) 空间O(n)
	
    public int minSwapsCouples(int[] row) {
    	int[] mark = new int[row.length];
    	for(int i=0;i<row.length;i++){
    		mark[row[i]] = i;
    	}
    	
    	int ans = 0;

    	for(int i=0;i<row.length;i+=2){
    		if((row[i]^1)==0){//奇数
    			if(row[i+1]==row[i]-1)//满足
    				continue;
    			else{
    				int pos = mark[row[i]-1];
    				row[pos] = row[i+1];
    				mark[row[i+1]] = pos;
    				ans++;
    			}
    		}else{//偶数
    			if(row[i+1]==row[i]+1)//满足
    				continue;
    			else{
    				int pos = mark[row[i]+1];
    				row[pos] = row[i+1];
    				mark[row[i+1]] = pos;
    				ans++;
    			}
    		}
    	}
    	return ans;
    }
    
}
