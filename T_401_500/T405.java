package T_401_500;

import java.util.HashMap;
import java.util.Map;

public class T405 {

//	16进制与十进制地转换，要注意负数取得补码问题，涉及了int long转换以及相应地取值范围
//    public String toHex(int num) {
//    	if(num==0)
//    		return 0+"";
//    	
//    	char []tochar = new char[]{'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
//    	StringBuffer sb = new StringBuffer();
//    	long numl = num;
//    	if(numl<0){
//    		numl+=(long)Math.pow(2, 32);
//    	}
//       	long shang = numl;
//    	int  yu = (int) (numl%16);
//    	while(shang!=0){
//    		sb.append(tochar[yu]);
//    		shang = shang/16;
//    		yu = (int)(shang%16);
//    	}
//    	return sb.reverse().toString();
//    }
   
	
//	一种比较高端地写法，使用位运算
	
    public String toHex(int num) {
    	if(num==0)
		return 0+"";
	
		char []tochar = new char[]{'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
		StringBuffer sb = new StringBuffer();
		while(num!=0){
			sb.append(tochar[num&0b1111]);//使用0xf(00...01111b)获取num的低4位。
			num>>>=4;//>>算数位移，其中正数右移左边补0，负数右移左边补1。	
//			移位操作可分为 左移操作符（<<）、“有符号”右移操作符（>>）、“无符号”右移操操作符（>>>）三种。
		}
		return sb.reverse().toString();
		
    }
    
    
    
    public static void main(String[] args){
    	T405 t = new T405();
    	System.out.println(t.toHex(-1));
    }
}
