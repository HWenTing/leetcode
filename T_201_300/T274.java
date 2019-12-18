package T_201_300;

import java.util.Arrays;

public class T274 {

//	给定一位研究者论文被引用次数的数组（被引用次数是非负整数）。编写一个方法，计算出研究者的 h 指数。
//	h 指数的定义: “h 代表“高引用次数”（high citations），一名科研人员的 h 指数是指他（她）的 （N 篇论文中）至多有 h 篇论文分别被引用了至少 h 次。（其余的 N - h 篇论文每篇被引用次数不多于 h 次。）”

//	倒序排序  满足citations[i]>=i的最大index 
//	击败16%。。。。
//    public int hIndex(int[] citations) {
//        Arrays.sort(citations);
//        int len = citations.length;
//        for(int i=0;i<len;i++){
//        	if(citations[i]>=len-i)
//        		return len-i;
//        }
//        return 0;
//    }

	//	桶排序 可以降到O(n)， 引用次数大于文章总数的改成n即可
//	击败100%
	public int hIndex(int[] citations) {
		int len = citations.length;
		int[] cnt=new int[len+1];
		for(int i:citations)
			cnt[Math.min(i, len)]++;
		
		for(int i=0;i<=len;i++){
			System.out.println(cnt[i]);
		}
        int k = len;
        for (int s = cnt[len]; k > s; s += cnt[k])
            k--;
        return k;

	}
	
	public static void main(String[] args) {
		T274 t = new T274();
		int[] citations = new int[]{1,1};
		System.out.println(t.hIndex(citations));
	}
}
