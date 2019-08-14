package T_101_200;

import java.util.HashMap;
import java.util.Map;

public class T190 {

	
//	将给定的int代表 32 位无符号整数的二进制位颠倒，输出新的int
//	击败98%
//    public int reverseBits(int n) {
//        int ans=0;
//    	for(int i=0;i<31;i++){
//    		ans+=(n&1);//ans加上n的最后一位
//    		ans = ans<<1;//ans左移一位
//    		n = n>>>1;//n无符号右移一位
//    	}
//		ans+=(n&1);//要注意的是，ans一共需要左移31次，n一共需要右移31次，ans需要加32次
//    	return ans;
//    }
	
	
//	哦豁速度还慢了一些，击败80%
//	public int reverseBits(int n) { 
//		int ret = 0; 
//		for (int i = 0; i < 32; i++) { //依然是 ans一共需要左移31次，n一共需要右移31次，ans需要或32次
//			ret <<= 1; //实际上第一次没有效果
//			ret |= (n & 1);//这里的或操作 相当于加，因为或0不变，或1加1
//			n >>>= 1; //实际上最后一次没有效果
//		}
//		return ret;
//	}
	
    
    
//    如果该函数需要被调用很多次，可以将 int 拆成 4 个 byte，然后缓存 byte 对应的比特位翻转，最后再拼接起来。
    private static Map<Byte, Integer> cache = new HashMap<>();
    public int reverseBits(int n) { 
    	int ret = 0; 
    	for (int i = 0; i < 4; i++) { 
    		ret <<= 8; 
    		ret |= reverseByte((byte) (n & 0b11111111)); //取后八位
    		n >>= 8; 
    	}
    	return ret; 
    }
    
    private int reverseByte(byte b) { 
    	if (cache.containsKey(b)) //查看缓存
    		return cache.get(b); 
    	int ret = 0; 
    	byte t = b;
    	for (int i = 0; i < 8; i++) { 
    		ret <<= 1; 
    		ret |= t & 1; 
    		t >>= 1; 
    	}
    	cache.put(b, ret); 
    	return ret; }
    
    
    
    public static void main(String[] args){
    	T190 t =new T190();
    	System.out.println(t.reverseBits(-3));
    }
}
