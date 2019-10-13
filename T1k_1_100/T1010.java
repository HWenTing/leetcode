package T1k_1_100;

public class T1010 {

//	在歌曲列表中，第 i 首歌曲的持续时间为 time[i] 秒。
//	返回其总持续时间（以秒为单位）可被 60 整除的歌曲对的数量。形式上，我们希望索引的数字  i < j 且有 (time[i] + time[j]) % 60 == 0。


//	set存放 因为这里长度限定了，所以数组也可
	public int numPairsDivisibleBy60(int[] time) {
        int[] cnt = new int[60];
        for(int i: time)
        	cnt[i%60]++;
        int ans = 0;
        if(cnt[0]!=0)
        	ans+=(cnt[0]*(cnt[0]-1))/2;
        for(int i=1;i<30;i++)
        	ans+=cnt[i]*(cnt[60-i]);
        if(cnt[30]!=0)
        	ans+=(cnt[30]*(cnt[30]-1))/2;
        return ans;
    }
    
}
