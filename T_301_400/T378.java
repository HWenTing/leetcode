package T_301_400;

import java.util.PriorityQueue;

public class T378 {

//	给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第k小的元素。
//	没思路。。。。。。看了一下题解，二分查找、n路归并、堆
	
	
//	二分查找
//	击败50%速度一般
//    public int kthSmallest(int[][] matrix, int k) {
//    	int n = matrix.length;
//    	int min = matrix[0][0];
//    	int max = matrix[n-1][n-1];
//    	int mid;
//    	int cnt;
//    	while(min<=max){//两个指针向中间逼近
//    		cnt=0;
//    		mid = min+(max-min)/2;//防溢出
//    		for(int i=0;i<n;i++){
//    			for(int j=0;j<n &&matrix[i][j]<=mid;j++)
//    				cnt++;
//    		}
//    		if(cnt<k)min = mid+1;
//    		else max = mid-1;
//    	}
//    	return min;
//    }
	
//	还是二分查找，对查询计数部分进行优化,从左下角开始向右上方逼近
//	击败96%。。妈耶
    public int kthSmallest(int[][] matrix, int k) {
    	int n = matrix.length;
    	int min = matrix[0][0];
    	int max = matrix[n-1][n-1];
    	int mid;
    	int cnt;
    	while(min<=max){//两个指针向中间逼近
    		cnt=0;
    		mid = min+(max-min)/2;//防溢出
    		
    		int i=n-1;
    		int j=0;
    		while(i>=0 && j<n){
    			if(matrix[i][j]<=mid){//说明ij位置上方的元素都小于mid
    				cnt+=i+1;//加到cnt中
    				j++;
    			}else{
    				i--;
    			}
    		}
    		
    		if(cnt<k)min = mid+1;
    		else max = mid-1;
    	}
    	return min;
    }
	
	
	
//	k路归并
//	更慢。。。击败14%
//    public int kthSmallest(int[][] matrix, int k) {
//    	int n = matrix.length;
//        int[] temp = new int[n];
//        while(k-->1){
//        	get(matrix,temp);
//        }
//        return get(matrix,temp);
//    }
////    返回k路中下一个最小值
//    private int get(int[][] matrix,int[] temp){
//    	int len = temp.length;
//    	int pos =-1;//哪一行
//    	int min =Integer.MAX_VALUE;
//    	
//    	
//    	for(int i=0;i<len;i++){
//    		int pr = temp[i];//第i行的列指针
//    		if(pr<len){//指针有效
//    			if(matrix[i][pr]<min){//当前值较小
//    				pos = i;
//    				min = matrix[i][pr];
//    			}
//    		}
//    	}
//    	temp[pos]++;
//    	return min;
//    }
    
	
	
//	最小堆排序，和k路归并思路相似
//	也不快。。没想到第一种最快
//    public int kthSmallest(int[][] matrix, int k) {
//        int n = matrix.length;
//        PriorityQueue<Tuple> pq = new PriorityQueue<>();
//        for(int i=0;i<n;i++)
//        	pq.add(new Tuple(0,i,matrix[0][i]));
//        while(k-->1){
//        	Tuple temp = pq.poll();
//        	if(temp.x<n-1){
//        		pq.add(new Tuple(temp.x+1,temp.y,matrix[temp.x+1][temp.y]));
//        	}
//        }
//        return pq.poll().val;
//    }
//    
////    实现comparaTo方法
//    class Tuple implements Comparable<Tuple> {
//    	int x,y,val;
//    	public Tuple(int x,int y,int val){
//    		this.x = x;
//    		this.y = y;
//    		this.val = val;
//    	}
//		@Override
//		public int compareTo(Tuple o) {
//			return this.val-o.val;
//		}
//    }
    
    
}
