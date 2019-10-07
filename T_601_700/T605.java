package T_601_700;

public class T605 {

//	没有两个相邻的1靠着，问能不能再给定数组的基础上再添加n个1
	
//	对每个位置判断前后是否为0
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
    
    	int len = flowerbed.length;
    	for(int i=0;i<len && n>0;i++){
    		if(flowerbed[i]==0){
    			int before = i-1>=0?flowerbed[i-1]:0;
    			int after = i+1<len?flowerbed[i+1]:0;
    			if(before+after==0){//左右两端都为0
    				flowerbed[i]=1;
    				n--;
    			}
    		}
    	}
    	return n==0;
    }
    
}
