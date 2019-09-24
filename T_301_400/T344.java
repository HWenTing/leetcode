package T_301_400;

public class T344 {

	
//	编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
//	不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
	
//	直接前后交换呗
	
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length-1;
        while(left<right){
        	char temp = s[right];
        	s[right] = s[left];
        	s[left] = temp;
        	left++;
        	right--;
        }
    }
    
}
