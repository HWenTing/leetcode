package T_901_1000;

import java.util.HashMap;
import java.util.List;

class Edge{
	int x1,x2;
	int y1,y2;
	Edge(int x1,int y1,int x2,int y2){
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}
}


public class T963 {

//	给定在 xy 平面上的一组点，确定由这些点组成的任何矩形的最小面积，其中矩形的边不一定平行于 x 轴和 y 轴。
//	如果没有任何矩形，就返回 0。
	
//	遍历，三个角垂直，复杂度C(4,n) O(n^4)
//	中点方法，因为对角线相等且中点相同是矩形的充要条件，所以复杂度可以降到O(n^2)
//	用map存下<中点及长度,点1> 每次遇到相同的中点及长度就算一下
	
	
    public double minAreaFreeRect(int[][] points) {

    	HashMap<String,List<Edge>> map = new HashMap<>();
        int len = points.length; 
    	
    	
    	
    	
    }
    
}
















