package Other;

public class Manacher {

//	manacher(马拉车)算法  O(n)复杂度寻找最长回文子串
	
	private int R ;//最右边界
	private int C ;//最右边界对应的中心点
	private int[] radios;//每个点对应的回文半径 最小是1 也就是本身
	
	public String longestPalindrome(String s) {
		if(s.length()<2) return s;
		StringBuilder sb = new StringBuilder();
		sb.append('#');
		for(char c:s.toCharArray()){//先预处理字符串 对奇数长度和偶数长度统一处理
			sb.append(c);
			sb.append('#');
		}
		R = -1;
		C = -1;
		radios = new int[sb.length()];
		
		for(int i=0;i<sb.length();i++){
			if(i>=R){//正常向外扩
				expand(i-1,i+1,i,sb);
			}else{
				int L = 2*C-R;//最右边界对应的最左边界
				int symmetric_points = 2*C-i;//i点关于中心的对称点
				if(symmetric_points - radios[symmetric_points]+1>L){//如果对称点的最左边界在[L,R]内，则i的半径与对称点相同（因为[L,R]都是回文的）
					radios[i] = radios[symmetric_points];
				}else if(symmetric_points - radios[symmetric_points]+1 == L){//如果对称点的最左边界刚好等于L，那么i点只需要从R继续向外扩就好，因为R以内的和i的对称点相同
					expand(i- radios[symmetric_points],R+1,i,sb);
				}else{////如果对称点的最左边界在小于L，那么i的半径向右最多到R（如果大于R，矛盾了）
					radios[i] = R-i+1;
				}
			}
		}
		int anspos = 0;
		for(int i=0;i<radios.length;i++){//找到最长半径
			if(radios[i]>radios[anspos]){
				anspos = i;
			}
		}
		return s.substring((anspos-radios[anspos]+1)/2,(anspos+radios[anspos]-1)/2);//对应到原始字符串s 的截取范围
	}
	
	private void expand(int left,int right,int i,StringBuilder sb){
		while(left>=0 && right<sb.length() && sb.charAt(left)==sb.charAt(right)){
			left--;
			right++;
		}
		if(right-1>R){//更新R值和C值
			C = i;
			R = right-1;
		}
		radios[i] = i-left;
	}
	
	public static void main(String[] args){
		Manacher m = new Manacher();
		System.out.println(m.longestPalindrome("babad"));
	}
	
//	1 2 1 2 3 2 1 2 1
	
//	0 1 2 3 4 5 6 7 8
//	# c # b # b # d #
	
	
//	1 2 1 4 1 4 1 2 1 2 0
	
//	0 1 2 3 4 5 6 7 8 9 10
//	# b # a # b # a # d #
	
	
}
