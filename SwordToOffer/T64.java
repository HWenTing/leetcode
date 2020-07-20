package SwordToOffer;

public class T64 {

//	求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
//	短路与来代替判断  递归来代替循环
    public int sumNums(int n) {
    	int sum = n;
    	boolean _1 = n==1 || (sum+=sumNums(n-1))>0;
    	return sum;
    }
    
}
