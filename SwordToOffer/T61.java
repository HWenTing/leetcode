package SwordToOffer;

public class T61 {

	
//	从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
//	2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
	
//	打表吧
    public boolean isStraight(int[] nums) {
    	
    	int[] cnt = new int[14];
    	for(int i:nums)
    		cnt[i]++;
    	
    	int i=1;
    	for(;i<14;i++){
    		if(cnt[i]>1)return false;
    		else if(cnt[i]==1) break;
    	}
    	
    	int start = i;
    	for(i+=1;i<14 && i<start+5;i++){
    		if(cnt[i]>1)return false;
    		else if(cnt[i]==0){
    			cnt[0]--;
    			if(cnt[0]<0) return false;
    		}
    	}
    	
    	for(i+=1;i<14;i++){
    		if(cnt[i]>=1)return false;
    	}

    	
    	return true;
    	
    }
    
}
