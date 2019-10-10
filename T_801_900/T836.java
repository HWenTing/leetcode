package T_801_900;

public class T836 {

	
//	矩形以列表 [x1, y1, x2, y2] 的形式表示，其中 (x1, y1) 为左下角的坐标，(x2, y2) 是右上角的坐标。
//	如果相交的面积为正，则称两矩形重叠。需要明确的是，只在角或边接触的两个矩形不构成重叠。
//	给出两个矩形，判断它们是否重叠并返回结果。
	
//	很典型
//	对没有交集的情况取反，即可得到答案 return !(rec1[0]>=rec2[2]||rec1[2]<=rec2[0]||rec1[1]>=rec2[3]||rec1[3]<=rec2[1]);
//    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
//    	 return !(rec1[0]>=rec2[2]||rec1[2]<=rec2[0]||rec1[1]>=rec2[3]||rec1[3]<=rec2[1]);
//    }
    
//	或者类似iou的思想，找相交的部分，如果 up>down &&  right>left，说明相交部分存在
//    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
//    	int up = Math.min(rec1[3],rec2[3]);
//    	int down = Math.max(rec1[1],rec2[1]);
//    	int left = Math.max(rec1[0],rec2[0]);
//    	int right = Math.min(rec1[2],rec2[2]);
//    	if (up>down &&  right>left)
//    		return true;
//    	return false;
//    }
    
//	或者判断 长和宽的坐标都分别相交  这种解法要注意乘法溢出问题，并且乘法也慢
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
    	return (rec2[0]-rec1[2])*(rec2[2]-rec1[0])<0&&(rec2[1]-rec1[3])*(rec2[3]-rec1[1])<0;//直接这样写会溢出
	}

}
