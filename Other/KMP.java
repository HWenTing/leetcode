package Other;

public class KMP {

//	字符串匹配，返回shorter在longer中的下标，若没有则返回-1
	int KMP(String longer,String shorter){
		int i=0; //一直自增
		int j=0; //不断回跳
		
		int[] next = getNext(shorter);
		while(i<longer.length() && j<shorter.length()){
			if(j==-1 || longer.charAt(i)==shorter.charAt(j)){
				i++;
				j++;
			}else
				j = next[j];
			
			if(j==shorter.length()) return i-j;
		}
		return -1;
	}
	
//	获得next数组
	private int[] getNext(String s){//下标从1开始算
		int[] next = new int[s.length()+1];
		next[0] = -1;
		int i=0; //一直自增
		int j=-1; //不断回跳
		while(i<s.length()){
			if(j==-1 || s.charAt(i)==s.charAt(j)){//相等 则两个指针都前进一步
				i++;
				j++;
				next[i] = j;
			}else 
				j = next[j];//还是不大明白 好像是指向上一次最长前缀的末尾
		}
		return next;
	}
	
//	如何更好地理解和掌握 KMP 算法? - 海纳的回答 - 知乎
//	https://www.zhihu.com/question/21923021/answer/281346746这个解释还可以

	public static void main(String[] args) {
		KMP k = new KMP();
		System.out.println(k.KMP("aba", "baab"));
	}
	
}
