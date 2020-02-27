package T_301_400;

import java.util.HashSet;

public class T391 {

//	我们有 N 个与坐标轴对齐的矩形, 其中 N > 0, 判断它们是否能精确地覆盖一个矩形区域。
//	每个矩形用左下角的点和右上角的点的坐标来表示。
//	例如， 一个单位正方形可以表示为 [1,1,2,2]。 ( 左下角的点的坐标为 (1, 1) 以及右上角的点的坐标为 (2, 2) )。

	
//	如果是完美矩形 那么一定满足两点： 
//	（1）最左下 最左上 最右下 最右上 的四个点只出现一次 其他点成对出现 （2）四个点围城的矩形面积 = 小矩形的面积之和
    public boolean isRectangleCover(int[][] rectangles) {
    	
    	int sum=0;
    	int left = Integer.MAX_VALUE;
    	int bottom = Integer.MAX_VALUE;
    	int right = Integer.MIN_VALUE;
    	int up = Integer.MIN_VALUE;
    	HashSet<String> set = new HashSet<>();
    	
    	for(int[] rectangle:rectangles){
    		sum+=(rectangle[2]-rectangle[0])*(rectangle[3]-rectangle[1]);
    		left = Math.min(left, rectangle[0]);
    		bottom = Math.min(bottom, rectangle[1]);
    		right = Math.max(right, rectangle[2]);
    		up = Math.max(up, rectangle[3]);
    		
    		String lb = rectangle[0]+"#"+rectangle[1];
    		String rb = rectangle[2]+"#"+rectangle[1];
    		String lu = rectangle[0]+"#"+rectangle[3];
    		String ru = rectangle[2]+"#"+rectangle[3];
    		
    		if(set.contains(lb))set.remove(lb);else set.add(lb);
    		if(set.contains(rb))set.remove(rb);else set.add(rb);
    		if(set.contains(lu))set.remove(lu);else set.add(lu);
    		if(set.contains(ru))set.remove(ru);else set.add(ru);
    	
    	}
    	
    	if(set.size()==4 && sum==(up-bottom)*(right-left) &&
    			set.contains(left+"#"+bottom) && set.contains(left+"#"+up) &&set.contains(right+"#"+bottom) && set.contains(right+"#"+up))
    		return true;
    	return false;
    	
    }
	
	
    

}


