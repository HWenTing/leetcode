package T_801_900;

import java.util.ArrayList;
import java.util.List;

public class T842 {

//	没有做。。copy的题解
//	第一个和第二个数确定后，整个备选序列已经确定，不需要使用dfs在剩余序列中试探第三个数是否存在，直接相加找出第三个数是否存在即可；
//	剪枝：第一个数不能大于整个序列长度的一半，第三个数的长度不能小于第一个数和第二个数的长度最大者，数字的开头为0但长度大于1者不留下。

    public List<Integer> splitIntoFibonacci(String S) {
        ArrayList<Integer> ans = new ArrayList<>();
        int len = S.length();
        
        for (int i = 1; i <= len / 2; i++) {
            if (S.charAt(0) == '0' && i > 1) break;
            long tmp1 = Long.parseLong(S.substring(0, i));
            if (tmp1 > Integer.MAX_VALUE) break;
            ans.add((int)tmp1);
            for (int j = 1; Math.max(i, j) <= len - i - j; j++) {
                if (S.charAt(i) == '0' && j > 1) break;
                long tmp2 = Long.parseLong(S.substring(i, i + j));
                if (tmp2 > Integer.MAX_VALUE) break;
                int num1 = (int)tmp1;
                int num2 = (int)tmp2;
                ans.add(num2);
                String sum;
                int start;
                for (start = i + j; start < len; start += sum.length()) {
                    num2 = num1 + num2;
                    num1 = num2 - num1;
                    sum = String.valueOf(num2);
                    if (!S.startsWith(sum, start)) {
                        break;
                    }
                    ans.add(num2);
                }
                if (len == start) return ans;
                ans.clear();
                ans.add((int)tmp1);
            }
            ans.clear();
        }
        
        return ans;
    }

	
}
