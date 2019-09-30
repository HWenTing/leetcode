package T_401_500;

public class T492 {

//	构造矩形
//	1. 你设计的矩形页面必须等于给定的目标面积。
//	2. 宽度 W 不应大于长度 L，换言之，要求 L >= W 。
//	3. 长度 L 和宽度 W 之间的差距应当尽可能小。
	
//	找到中心点，往两边找
    public int[] constructRectangle(int area) {
//        int log = (int) (Math.log(area)/Math.log(2));
        int sqrt = (int) Math.sqrt(area);
        while(sqrt>0){
        	if(area%sqrt==0)
        		return new int[]{area/sqrt,sqrt};
        	sqrt--;
        }
        return new int[]{area,1};
    }
}
