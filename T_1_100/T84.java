package T_1_100;

import java.util.Stack;

public class T84 {

//	给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
//	求在该柱状图中，能够勾勒出来的矩形的最大面积。
	
	
//	乍一看和存雨滴的题很像（虽然那个题我也忘了。。）
//	不会啊。。。
//	看的题解。。看了好久才大体明白。。。
//	用栈的方法 单调栈
	
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int ans=0;
        st.push(-1);
        
        for(int i=0;i<heights.length;i++){
        	while(st.peek()!=-1 && heights[st.peek()]>=heights[i]){
        		ans = Math.max(ans, heights[st.pop()]*(i-1-st.peek()));//这个地方要注意
        	}
        	st.push(i);
        }
        
        while(st.peek()!=-1){
        	ans = Math.max(ans, heights[st.pop()]*(heights.length-1-st.peek()));
        }
        return ans;
    }
    
    public static void main(String[] args){
    	int[] heights= new int[]{5,4,1,2};
    	T84 t =new T84();
    	t.largestRectangleArea(heights);
    	
    }
    
}
