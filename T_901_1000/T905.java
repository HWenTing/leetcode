package T_901_1000;

public class T905 {

//	给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。
//	你可以返回满足此条件的任何数组作为答案。
	
//	双指针
    public int[] sortArrayByParity(int[] A) {
        int even = 0;//偶数
        int odd = A.length-1;//奇数
        
        while(even<odd){
        	while(even<odd && A[even]%2==0)
        		even++;
        	while(even<odd && A[odd]%2==1)
        		odd--;
        	if(even<odd){
        		int temp = A[even];
        		A[even] = A[odd];
        		A[odd] = temp;
        	}
        }
        return A;
    }
    
}
