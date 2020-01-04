package T_101_200;

public class T135 {
	
//	老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
//	你需要按照以下要求，帮助老师给这些孩子分发糖果：
//	每个孩子至少分配到 1 个糖果。
//	相邻的孩子中，评分高的孩子必须获得更多的糖果。
//	那么这样下来，老师至少需要准备多少颗糖果呢？

//	每个位置只需要考虑两边比它低的
//	left = ratings[i]>ratings[i-1]? item(i-1)+1:1
//	right = ratings[i]>ratings[i+1]? item(i+1)+1:1
//	item(i) = max(left,right)
//	记忆化 贪心
	
//	一遍ac 速度击败96%
//	或者正着遍历一遍 ，前小于后的 后=前+1，否则后=1 
//	然后反着遍历一遍 ，前大于后的 前=后+1 ，否则不变
    public int candy(int[] ratings) {
        if(ratings.length<2)
        	return ratings.length;
    	
        int ans=0;
        int[] cnt = new int[ratings.length];
        for(int i=0;i<ratings.length;i++)
        	ans+=item(ratings,i,cnt);
        return ans;
    }
    
//    简化之后的item
    private int item(int[] ratings,int pos,int[] cnt){
    	if(cnt[pos]>0)
    		return cnt[pos];
    	int ans=0;
    	int left = ratings[pos]>ratings[pos-1>=0?pos-1:pos]? item(ratings,pos-1,cnt)+1:1;
    	int right = ratings[pos]>ratings[pos+1<=ratings.length-1?pos+1:pos]? item(ratings,pos+1,cnt)+1:1;
    	ans = Math.max(left,right);
    	cnt[pos]=ans;
    	return ans;
    	
    }
    
//    第一版
//    private int item(int[] ratings,int pos,int[] cnt){
//    	
//    	if(cnt[pos]>0)
//    		return cnt[pos];
//    	int ans=0;
//    	
//    	if(pos == 0){
//    		if(ratings[pos]<=ratings[pos+1])
//    			ans = 1;
//    		else
//    			ans = item(ratings,pos+1,cnt)+1;
//    	}else if(pos == ratings.length-1){
//    		if(ratings[pos]<=ratings[pos-1])
//    			ans = 1;
//    		else
//    			ans = item(ratings,pos-1,cnt)+1;
//    	}else{
//    		if(ratings[pos]<=ratings[pos-1] && ratings[pos]<=ratings[pos+1])
//    			ans = 1;
//    		else if(ratings[pos]<=ratings[pos-1])
//    			ans = item(ratings,pos+1,cnt)+1;
//    		else if(ratings[pos]<=ratings[pos+1])
//    			ans = item(ratings,pos-1,cnt)+1;
//    		else
//    			ans = Math.max(item(ratings,pos+1,cnt), item(ratings,pos-1,cnt))+1;
//    	}
//    	
//    	cnt[pos]=ans;
//    	return ans;
//    }
    
}
