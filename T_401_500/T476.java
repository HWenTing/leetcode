package T_401_500;

public class T476 {

//	给定一个正整数，输出它的补数。补数是对该数的二进制表示取反。
//	给定的整数保证在32位带符号整数的范围内。
//	你可以假定二进制数不包含前导零位。
	
//	可以观察到，101+010+1=1000
//	击败99%
    public int findComplement(int num) {
        int ans = (Integer.highestOneBit(num))<<1;
        return ans-num-1;
    }
    

    
}
