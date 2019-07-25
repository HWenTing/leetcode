package T_301_400;

public class T326 {

//	判断是否是3的幂次 ， 第一反应是循环或递归
//	然后发现下边这种很。。的操作。击败99.56%
    public boolean isPowerOfThree(int n) {
    	return n > 0 && (1162261467 % n == 0);//1162261467是int范围内最大的3的幂次
    }
    
	
//    也可以转为三进制，看是否第一位为1，其他是0
    
    public static void main(String[] args){
    	T326 t =new T326();
    	System.out.println(t.isPowerOfThree(3));
    }
    
}
