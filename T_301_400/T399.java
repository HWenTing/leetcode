package T_301_400;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Edge{
	double weight;
	String point;
	Edge(String point,double weight){
		this.weight = weight;
		this.point = point;
	}
}
//给出方程式 A / B = k, 其中 A 和 B 均为代表字符串的变量， k 是一个浮点型数字。
//根据已知方程式求解问题，并返回计算结果。如果结果不存在，则返回 -1.0。

//构造图来做
public class T399 {

	Map<String,LinkedList<Edge>> points = new HashMap<>();//邻接链表
	Set<String> marked ;//防止重复访问
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] ans = new double[queries.size()];
        
        int pos=0;
        for(List<String> equation : equations){
        	addEdge(equation.get(0),equation.get(1),values[pos]);
        	addEdge(equation.get(1),equation.get(0),1/values[pos]);
        	pos++;
        }
        
        pos=0;
        for(List<String> query : queries){
        	marked = new HashSet<>();
        	ans[pos] = find(query.get(0),query.get(1));
        	pos++;
        }
    	return ans;
    }
    
//    bfs查找
	private double find(String a, String b) {
		if(marked.contains(a) || !points.containsKey(a) || !points.containsKey(b))
			return -1.0;
		else if(a.equals(b))
			return 1.0;
		else{

			for(Edge edge:points.get(a)){
				double temp = find(edge.point,b);
				if(temp>0){
					return edge.weight*temp;
				}
			}
			return -1.0;
		}
	}
	
//	添加有向边
	private void addEdge(String a, String b, double weight) {
		if(!points.containsKey(a)){
			LinkedList<Edge> temp = new LinkedList<>();
			temp.add(new Edge(b,weight));
			points.put(a, temp);
		}else{
			points.get(a).add(new Edge(b,weight));
		}
	}
    
}
