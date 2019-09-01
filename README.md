# leetcode
leetcode题解

#### 关于dp的一些想法

* 对于可重复选取元素的01背包问题， 内层for从小到大；反之，不可重复选取的，从大到小

* 对于选取元素顺序有要求的，对物品的迭代应该放在最里层

* 对于股票买卖这种，对买、卖状态各自维护dp数组（甚至可以简化为单个变量）

* 字符串编辑操作次数问题，常规的dp都能解决，找准状态转移方程就好

#### 关于数学的一些想法

* 求小于某数的质数有几个 埃拉托斯特尼筛法

* 最大公约数 辗转相除 （也可以通过位操作和减法求解最大公约数）

* 最小公倍数为两数的乘积除以最大公约数。

* 进制转换时，可以灵活运用位运算（移位操作可分为 左移操作符（<<）、“有符号”右移操作符（>>）、“无符号”右移操操作符（>>>）三种。）

* 移动距离最小的方式是所有元素都移动到中位数

* 求至少出现n/2次的数，摩尔投票法，同加异减

* 求至少出现n/3次的数，也可以摩尔投票法，T229

* 平方数可以用加法来求 ，相邻平方数间隔为3,5,7,

* 整数范围 三数之积，最大值取max（max1\*max2\*max3，min1\*min2\*max1）

#### 关于链表的一些想法

* 很适合递归或迭代来解决

* 很多时候也会用到数学素养，两链表求交点的题（160），十分优雅

* 在处理链表时，添加一个虚假的头节点可能会较少麻烦

* 要注意链表的连接与断开问题

* 循环链表，可以使用hashset或双指针来解决。使用双指针（一个走一步，一个走两步）的话，当下重合的时候，快指针多走的距离正好是圈的长度

* 循环链表寻找循环部分的第一个节点，（1）使用快慢指针，如果有相等的地方，则存在圈.（2）将慢指针移回链表头部，慢指针和快指针同时一步一步的往前走，再次相同的地方就是循环部分的第一个节点

* map或者list中对链表节点的存储都是地址，可以很方便对链表直接操作（T1171前缀和）

#### 关于树的一些想法

* 也十分适合用递归来解决

* 有时候声明一个全局变量会简单很多（T110，543）在递归的时候不断维护

* 很多时候会用到双递归，即连个递归方法交叉调用，如（T437）

* 对叶子节点要理解清楚，是左子树和右子树都为空，只有一者为空不算

* 在层次遍历的时候，在开始遍历每层节点时，当前队列的节点数就是当前层的节点数

* 层次遍历使用 BFS 实现，利用的就是 BFS 一层一层遍历的特性；而前序、中序、后序遍历利用了 DFS 实现。非递归实现：

    * 前序遍历 用栈，先右后左
	
	* 后序遍历为 left -> right -> root,可以修改前序遍历成为 root -> right -> left，那么这个顺序就和后序遍历正好相反。
	
	* 中序遍历 用栈 遍历左子树->加入当前节点->遍历右子树->返回上一层
	
* 求中点不要用 int mid = (l + r)/2，有溢出风险，稳妥的方法是 int mid = l + (r-l)/2;

* 解决关于bst的问题时，可以在边中序遍历（得到有序数列）的同时进行相应的处理，速度会快很多。	

* Trie字典树 空间换时间 每个节点多都有26个子节点，根节点为空

* 二叉搜索树删除节点，若被删除的有两个孩子节点，需要在树中找出所有比被删除节点的值大的所有数，并在这些数中找出一个最小的数来替换到该节点

#### 关于栈和队列的一些想法

* 用栈来实现队列。需要用两个栈，一个元素经过两个栈才能出队列，一个in一个out，out空了将in转到out。

* 用队列模拟栈，每次push一个元素，将之前的元素都出队列再进队列，保证后加入的元素在队列的头部

* 适合解决下一个更大的元素问题（739、496、503）

*  求前 k 大，用小根堆，求前 k 小，用大根堆 能够把复杂度维持在nlogk（T347）

#### 关于哈希表的一些想法

*  hashmap有时候也是不错的选择 。 HashMap<Integer, Integer> hasMap = new HashMap<Integer, Integer>();空间换时间

* 分为哈希集合（705）和哈希映射（706）

* 关于字符有关的，哈希表也可以用数组替换，速度会快一些


#### 关于字符串的一些想法

* 判断字符串关系，比如是否是字母异位词（242）等，对每个字符有统计的，可以声明26位（只有字母）int数组来帮助（或者256位，比较全面），hash的思想

* 回文字符串个数，双指针向外扩散就好（要记住区分奇数长度和偶数长度），T647

#### 关于数组与矩阵的一些想法

* 处理有序矩阵，从左下方向右上方（或反过来）经常能够简化很多计算（T240、378）

* 把数组模拟成链表（T287），数组的值看作下一个元素的下标位置，思想很妙

#### 关于图的一些想法

* 二分图 如果可以用两种颜色对图中的节点进行着色，并且保证相邻的节点颜色不同，那么这个图就是二分图

* 拓扑排序，用一个队列存储入度为0的节点较为方便

* 并查集

#### 关于位运算的一些想法

* 异或，与，或 , 取反（~）

	* 异或（^） 可以去除重复两次的数

	* 与（&）  可以实现掩码操作（x与一串01进行与操作，只保留1对应的位）

	*  或（|） 可以进行设值操作（x与一串01进行或操作，1对应的位始终是1）

* 位与运算技巧

	* n&(n-1) 去除 n 的位级表示中最低的那一位。例如对于二进制表示 10110100，减去 1 得到 10110011，这两个数相与得到 10110000。

	* n&(-n) 得到 n 的位级表示中最低的那一位。-n 得到 n 的反码加 1，对于二进制表示 10110100，-n 得到01001100，相与得到 00000100。

* 移位运算：

	* \>\> n 为算术右移，相当于除以 2^n；
	
	* \>\>\> n 为无符号右移，左边会补上 0。
	
	* << n 为算术左移，相当于乘以 2^n。
	
* mask 计算

	* 要获取 111111111，将 0 取反即可，~0。
	
	* 要得到只有第 i 位为 1 的 mask，将 1 向左移动 i-1 位即可，1<<(i-1) 。例如 1<<4 得到只有第 5 位为 1 的 mask ：00010000。
	
	* 要得到 1 到 i 位为 1 的 mask，1<<(i+1)-1 即可，例如将 1<<(4+1)-1 = 00010000-1 = 00001111。
	
	* 要得到 1 到 i 位为 0 的 mask，只需将 1 到 i 位为 1 的 mask 取反，即 ~(1<<(i+1)-1)。

* Java 中的位操作

	* static int Integer.bitCount(); // 统计 1 的数量 
	
	* static int Integer.highestOneBit(); // 获得最高位 
	
	* static String toBinaryString(int i); // 转换为二进制表示的字符串	
	
* 不用额外变量交换两个整数  a = a ^ b; b = a ^ b; a = a ^ b;

* 边界数的补码（负数取反加一）

	* -2147483648	10000000000000000000000000000000
	
	* -2147483647 	10000000000000000000000000000001
	
	* 2147483647 	01111111111111111111111111111111
	
	* -0 			0000000000000000000000000000000
	
	* 0 			0000000000000000000000000000000
	
	* 1 			0000000000000000000000000000001
	
	* -1 			11111111111111111111111111111111

*   不使用运算符 + 和 - ​​​​​​​，计算两整数​​​​​​​之和  ：	return b==0?a:getSum(a^b,(a&b)<<1); //(a&b)<<1表示进位



	
#### 其他想法

* Comparable 这个interface 很好用，如 class Tuple implements Comparable<Tuple> {}（T378）

* 蒙特卡罗看运气法我也是服了。。。

* KMP算法

* 滑动窗口 （76、438、3）， 可以分成固定窗口大小和可改变窗口大小（更像双指针）

* 前缀和 思想




















