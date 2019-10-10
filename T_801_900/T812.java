package T_801_900;

public class T812 {
	
	
//	给定包含多个点的集合，从其中取三个点组成三角形，返回能组成的最大三角形的面积。
	
//	三角形面积 海伦公式 行列式
//	遍历每个三角形，根据行列式求出面积
    public double largestTriangleArea(int[][] points) {
        double ans=0;
        int len = points.length;
        int vec1x,vec2x,vec1y,vec2y;
        for(int i=0;i<len-2;i++){
        	for(int j=i+1;j<len-1;j++){
        		vec1x = points[i][0]-points[j][0];
        		vec1y = points[i][1]-points[j][1];
        		for(int k=j+1;k<len;k++){
            		vec2x = points[i][0]-points[k][0];
            		vec2y = points[i][1]-points[k][1];
            		
        			double cur = 0.5*Math.abs(vec1x*vec2y-vec1y*vec2x);
        			ans = Math.max(ans, cur);
        		}
        	}
        }
        return ans;
    }
    
}
