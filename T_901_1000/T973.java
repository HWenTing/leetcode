package T_901_1000;

import java.util.Comparator;
import java.util.PriorityQueue;

public class T973 {

//	我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。
//	（这里，平面上两点之间的距离是欧几里德距离。）
//	你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。

//	求k个最小值用大根堆 nlog(k)
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<int[]>(new Comparator<int[]>(){
            @Override
            public int compare(int[] i1,int[] i2){
                return -(i1[0]*i1[0]+i1[1]*i1[1]-i2[0]*i2[0]-i2[1]*i2[1]);
            }	
        });


        for(int i=0;i<points.length;i++){

            maxHeap.add(points[i]);
            if(i>=K){
                maxHeap.poll();
            }
        }

        int[][] ret = new int[K][2];
        for(int i=0;i<K;i++){
            ret[i] = maxHeap.poll();
        }
        return ret;
    }
    
}
