package T_701_800;

public class T796 {

//	给定两个字符串, A 和 B。
//	A 的旋转操作就是将 A 最左边的字符移动到最右边。 例如, 若 A = 'abcde'，在移动一次之后结果就是'bcdea' 。
//	如果在若干次旋转操作之后，A 能变成B，那么返回True。

//	只需比较一下两个字符串的长度，然后判断A + A中是否存在B就ok，因为A + A中已经包含了所有可能的移动情况
    public boolean rotateString(String A, String B) {
        if(A.length()!=B.length()) return false;
        return (A+A).indexOf(B)!=-1;
    }
    
}
