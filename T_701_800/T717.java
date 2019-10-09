package T_701_800;

public class T717 {
//	有两种特殊字符。第一种字符可以用一比特0来表示。第二种字符可以用两比特(10 或 11)来表示。
//	现给一个由若干比特组成的字符串。问最后一个字符是否必定为一个一比特字符。给定的字符串总是由0结束。

//	为0不用管，为1跳一位
    public boolean isOneBitCharacter(int[] bits) {
        for(int i=0;i<bits.length-1;i++){
        	if(bits[i]==1){
        		if(i+1>=bits.length-1)
        			return false;
        		i++;
        	}
        }
        return bits[bits.length-1]==0;
    }
    
}
