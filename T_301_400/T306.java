package T_301_400;

public class T306 {
//	累加数是一个字符串，组成它的数字可以形成累加序列。
//	一个有效的累加序列必须至少包含 3 个数。除了最开始的两个数以外，字符串中的其他数都等于它之前两个数相加的和。
//	给定一个只包含数字 '0'-'9' 的字符串，编写一个算法来判断给定输入是否是累加数。
//	说明: 累加序列里的数不会以 0 开头，所以不会出现 1, 2, 03 或者 1, 02, 3 的情况。
	
//	回溯算法
//	先确定初始的两个数，那么后续序列就可以确定，判断是否符合即可
//	用long代替int 防止溢出
	
	boolean isAdditive;
    public boolean isAdditiveNumber(String num) {
    	
    	for(int i=1;!isAdditive && i<num.length()/2+1;i++){//这里剪枝一下，能够击败99%。。。
    		long cur = Long.parseLong(num.substring(0,i));
    		for(int j=i+1;j<num.length();j++){
    			long next = Long.parseLong(num.substring(i,j));
    			if(num.startsWith(cur+next+"", j)){
    				if((cur+next+"").length()+j==num.length()) return true;
    				System.out.println(cur+" + "+next);
    				huisu(next,cur+next,j+(cur+next+"").length(),num);
    			}
    			
    			if(num.charAt(j)=='0') break;//处理01 这样的情况 ，parseLong会处理成1
    		}
    		
    		if(num.charAt(0)=='0') break;//处理01 这样的情况 ，parseLong会处理成1
    	}
        return isAdditive;
    }
    
    private void huisu(long add1,long add2,int end,String num){//判断后续是否满足
    	if(isAdditive) return;
    	
    	long sum = add1+add2;
    	String temp =  sum+"";
    	System.out.println(end);
		if(num.startsWith(temp, end)){//向下递归
			if(temp.length()+end==num.length()){
				isAdditive = true;
				return;
			}
			huisu(add2,sum,end+temp.length(),num);
		}
    }
    
    public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE);
	}
    
}




