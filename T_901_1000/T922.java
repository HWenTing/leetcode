package T_901_1000;

public class T922 {

//	给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
//	对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。


//	双指针
	public int[] sortArrayByParityII(int[] A) {
        int pos = 0;//偶数位指针
        int per = 1;//偶数指针
        while(per<A.length){
        	while(pos<A.length && A[pos]%2==0){
        		pos+=2;
        	}
        	while(per<A.length && A[per]%2==1){
        		per+=2;
        	}
        	
        	if(per<A.length){
        		int temp = A[per];
        		A[per] = A[pos];
        		A[pos] = temp;
        	}
        	pos+=2;
        	per+=2;
        }
        return A;
    }
    
}
