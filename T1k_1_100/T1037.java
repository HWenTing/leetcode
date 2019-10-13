package T1k_1_100;

public class T1037 {

//	回旋镖定义为一组三个点，这些点各不相同且不在一条直线上。
//	给出平面上三个点组成的列表，判断这些点是否可以构成回旋镖。
	
//	判断向量是否平行
//	x1y2==x2y1  可以看作斜率的变形
    public boolean isBoomerang(int[][] points) {
        return (points[0][0]-points[1][0])*(points[0][1]-points[2][1]) != (points[0][0]-points[2][0])*(points[0][1]-points[1][1]); 
    }
    
}
