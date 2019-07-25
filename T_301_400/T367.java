package T_301_400;

public class T367 {

//	判断是否为平方数
//	我的想法是 从1到n/2，相乘若等于num则满足 但是乘法复杂度比较高
//    public boolean isPerfectSquare(int num) {
//        for(int i=1;i<=num/2;i++){
//        	if(i*i==num)
//        		return true;
//        }
//        return false;	
//    }
    
//	可以直接使用加法来做
//	平方序列：1,4,9,16,..
//	间隔：3,5,7,...
//	好吧竟然也没快多少。。。
//	public boolean isPerfectSquare(int num) {
//		int diff = 1;
//		long now = 0;//这个地方是long 防止溢出为负的情况
//		while(now<=num){
//			if(now==num)
//				return true;
//			now+=diff;
//			diff+=2;
//		}
//		return false;
//	}
  
//	和上边的相同，只不过顺序反过来了，并且不存在溢出的问题
//	？？？？？速度竟然击败了95%
	public boolean isPerfectSquare(int num) { 
		int subNum = 1; 
		while (num > 0) {
			num -= subNum; 
			subNum += 2; 
		}
		return num == 0; 
	}
	
	public static void main(String[] args){
		T367 t =new T367();
		System.out.println(t.isPerfectSquare(2147483647));
	}
}
