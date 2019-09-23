package T_1_100;

public class T66 {

//	给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
//	最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
	
//	需要考虑进位问题
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int[] ans = new int[len+1];
        int carry=1;
        for(int pos=len-1;pos>=0;pos--){
        	if(carry==1){
            	if(carry+digits[pos]>=10){
            		ans[pos+1]=0;
            		digits[pos]=0;
            	}else{
            		carry=0;
            		digits[pos]++;
            		ans[pos+1]=digits[pos];
            	}
        	}else{
        		ans[pos+1]=digits[pos];
        	}
        }
        if(carry==1){
        	ans[0]=1;
        	return ans;
        }else{
        	return digits;
        }
    }
    
}
