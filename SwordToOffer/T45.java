package SwordToOffer;

import java.util.Arrays;
import java.util.Comparator;

public class T45 {

//	输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
	
	//a+b b+a 排一下序吧
    public String minNumber(int[] nums) {
    	String[] ns = new String[nums.length];
//    	for(int i=0;i<nums.length;i++)
//    		ns[i] = nums[i]+"";
    	for(int i=0;i<nums.length;i++)
    		ns[i] = String.valueOf(nums[i]);//比上边的方法快一些
    	
    	Arrays.sort(ns,new Comparator<String>(){
			@Override
			public int compare(String o1, String o2) {
				return (o1+o2).compareTo(o2+o1);
			}
    	});
    	
    	StringBuilder sb = new StringBuilder();
    	for(String s:ns)
    		sb.append(s);
    	return sb.toString();
    }
    
}
