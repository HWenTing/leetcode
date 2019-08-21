package T_301_400;

import java.util.HashMap;

public class T387 {

//	hashmap解决
//	算法的思路就是遍历一遍字符串，然后把字符串中每个字符出现的次数保存在一个散列表中。这个过程的时间复杂度为 O(N)O(N)，其中 NN 为字符串的长度。

//  接下来需要再遍历一次字符串，这一次利用散列表来检查遍历的每个字符是不是唯一的。如果当前字符唯一，直接返回当前下标就可以了。第二次遍历的时间复杂度也是 O(N)O(N)。

//	有点慢，击败时间29%,空间37%
//    public int firstUniqChar(String s) {
//        HashMap<Character, Integer> count = new HashMap<Character, Integer>();
//        int n = s.length();
//        // build hash map : character and how often it appears
//        for (int i = 0; i < n; i++) {
//            char c = s.charAt(i);
//            count.put(c, count.getOrDefault(c, 0) + 1);
//        }
//        
//        // find the index
//        for (int i = 0; i < n; i++) {
//            if (count.get(s.charAt(i)) == 1) 
//                return i;
//        }
//        return -1;
//    }

	
//	关于字符的，换成数组试一下
//	果然快了很多，时间击败73%，空间35%
    public int firstUniqChar(String s) {
        int[] cnt = new int[256];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            cnt[c]++;
        }
        
        for (int i = 0; i < n; i++) {
            if (cnt[s.charAt(i)] == 1) 
                return i;
        }
        return -1;
    }

}
