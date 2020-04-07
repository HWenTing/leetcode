package Other;

/*
 * 希尔排序
 * 时间复杂度和增量序列有关
 */
public class ShellSort {
	public static void shellSort(int[] array) {
	    int number = array.length / 2;
	    int i;
	    int j;
	    int temp;
	    while (number >= 1) {
	        for (i = number; i < array.length; i++) {
	            temp = array[i];
	            j = i - number;
	            while (j >= 0 && array[j] > temp) { 
	                array[j + number] = array[j];
	                j = j - number;
	            }
	            array[j + number] = temp;
	        }
	        number = number / 2;
	    }
	}
	
	public static void main(String[] args) {
		int[] nums = new int[]{1,4,2,7,3,5,8,1,4,9,34,6,8,2};
		shellSort(nums);
		for(int i:nums)
			System.out.print(i+" ");
		System.out.println();
	}
}
