package T_301_400;

public class T365 {

//	有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？
//	如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水。
//	你允许：
//	装满任意一个水壶
//	清空任意一个水壶
//	从一个水壶向另外一个水壶倒水，直到装满或者倒空
	
//	一开始没思路，看了看评论说，证明 ax+by =z  看z是否为x、y的做大公约数的倍数
	
//	最大公约数
    public int gcd(int p,int q)
    {
        if(p==0)return q;
        int r=q%p;
        return gcd(r,p);
    }
    
    public boolean canMeasureWater(int x, int y, int z) {
          
         if(x+y<z)return false;
         if(x==z || y==z || x+y==z) return true;
         return z%gcd(x,y)==0;
            
    }
    
}
