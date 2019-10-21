package T_701_800;

public class T738 {
	
//	给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
//	（当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）

//	找到单增序列的分界点，前边不变，后边变9
//	先从尾到头遍历一遍，如果出现逆序，大的值减1，并记录最后一个逆序的位置i，然后把从i开始到末尾的数全部变9
    public int monotoneIncreasingDigits(int N) {
    	if(N<10) return N;
        String num = N+"";
        char[] chars = num.toCharArray();
        int len = num.length();
        int i;
        for(i=0;i<len-1;i++){
        	if(chars[i]>chars[i+1])
        		break;
        }
        if(i==len-1) return N;
        chars[i]-=1;
        for(i+=1;i<len;i++){
        	chars[i]='9';
        }
     
        i=0;
        while(chars[i]==0)
        	i++;
        return monotoneIncreasingDigits(Integer.parseInt(new String(chars,i,len-i)));//递归解决332的问题
    }
}
