package T_401_500;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class T406 {
	
//	假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。

//	没思路啊，哭死
//	题解的思路 ：先排序再插入
//	按a[0]从高到低，a[1]从小到大排序
//	然后按顺序插入，位置为a[1]
	
//	先排高个子，矮个子的随后插入不会影响到高个子
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,new Comparator<int[]>(){
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0]==o2[0]? o1[1]-o2[1]:o2[0]-o1[0];
			}
        });
        LinkedList<int[]> ans = new LinkedList<>();
        for(int[] p:people)
        	ans.add(p[1], p);
        return ans.toArray(people);
    }
    
}










