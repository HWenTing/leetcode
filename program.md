# leetcode

leetcode题解

#### 关于dp的一些想法

* 对于可重复选取元素的01背包问题， 内层for从小到大；反之，不可重复选取的，从大到小

* 对于选取元素顺序有要求的，对物品的迭代应该放在最里层

* 对于股票买卖这种，对买、卖状态各自维护dp数组（甚至可以简化为单个变量）

* 字符串编辑操作次数问题，常规的dp都能解决，找准状态转移方程就好

#### 关于数学的一些想法

* 求小于某数的质数有几个 埃拉托斯特尼筛法 （1）求出q=sqrt(n) （2）去掉小于等于q的质数的倍数

* 最大公约数 辗转相除 （也可以通过位操作和减法求解最大公约数） 递归 return (b==0)?a:gcd(b,a%b);
* 非递归实现：
	private int gcd(int a, int b) {
		while (b != 0) {
			int temp = a % b;
			a = b;
			b = temp;
		}
		return a;
	}


* 最小公倍数为两数的乘积除以最大公约数。

* 进制转换时，可以灵活运用位运算（移位操作可分为 左移操作符（<<）、“有符号”右移操作符（>>）、“无符号”右移操操作符（>>>）三种。）

* 移动距离最小的方式是所有元素都移动到中位数

* 求至少出现n/2次的数，摩尔投票法，同加异减

* 求至少出现n/3次的数，也可以摩尔投票法，T229

* 平方数可以用加法来求 ，相邻平方数间隔为3,5,7,

* 整数范围 三数之积，最大值取max（max1\*max2\*max3，min1\*min2\*max1）

* （453）给定一个长度为 n 的非空整数数组，找到让数组所有元素相等的最小移动次数。每次移动使 n - 1 个元素增加 1。 n-1个少数民族加分相当于1个民族扣分。对（每个元素与最小值的差）求和即可

* 三角形面积公式 海伦公式（知道三边求面积） 二阶行列式绝对值的一半（知道三点求面积）

* （836）给出矩形左下和右上坐标，判断两个矩形是否有重合的部分。对没有交集的情况取反，即可得到答案；或者类似iou的思想，找相交的部分，如果 up>down &&  right>left，说明相交部分存在 

* 组合数C（n，2）可以转换成 前n-1求和

* 蔡勒公式，计算任意一天是星期几 W=[C/4]-2C+Y+[Y/4]+[13×(M+1)/5]+D-1，

* 矩形的充要条件是对角线相等且中点重合

* 蓄水池抽样算法 给定一个数据流，长度N很大，且N在遍历完数据之前不可知，如何在只便利一遍O(n)的情况下，能够随机选取m个不同的元素。思路是先取m个元素放到蓄水池中，当i>=m时，在[0,i]中取随机数d，若d在[0，m-1]中，则用该元素替换蓄水池中的第d个元素

* 打乱一个数组 首先想到的是把数组的所有的数放在一个盒子里，然后不放回的随机抽，按抽到的顺序组成新数组。复杂度O(n^2); 另一种改进算法Fisher-Yates 洗牌算法 ，可以将复杂度降到O(n)，具体做法是：在每次迭代中，生成一个范围在当前下标到数组末尾元素下标之间的随机整数，并将当前元素和随机选出的下标所指的元素互相交换，直到最后一个元素。

* 换底公式 log<sub>a</sub>b = log<sub>c</sub>b/log<sub>c</sub>a

* 快速幂
    public double myPow(double x, int n) {//递归模式
    	if(n==0) return 1;
    	else if(n==1) return x;
    	else if(n==-1) return 1/x;
    	
    	double d1 = myPow(x,n/2);
    	double d2 = myPow(x,n%2);
    	return d1*d1*d2;
    }

    public double myPow(double x, int N) {//循环模式
    	if(N<0){//转化成n>0的情况
    		x = 1/x;
    		N = -N;
    	}

    	double ans = 1;
    	double cur = x;
    	while(N>0){
    		if(N%2 ==1){
    			ans *= cur;
    		}
    		cur *=cur;
    		N/=2;
    	}
    	
    	return ans;
    }
#### 关于链表的一些想法

* 很适合递归或迭代来解决

* 很多时候也会用到数学素养，两链表求交点的题（160），十分优雅

* 在处理链表时，添加一个虚假的头节点可能会较少麻烦

* 要注意链表的连接与断开问题

* 循环链表，可以使用hashset或双指针来解决。使用双指针（一个走一步，一个走两步）的话，当下重合的时候，快指针多走的距离正好是圈的长度

* 循环链表寻找循环部分的第一个节点，（1）使用快慢指针，如果有相等的地方，则存在圈.（2）将慢指针移回链表头部，慢指针和快指针同时一步一步的往前走，再次相同的地方就是循环部分的第一个节点

* map或者list中对链表节点的存储都是地址，可以很方便对链表直接操作（T1171前缀和）

* 要记得断开链接

#### 关于树的一些想法

* 也十分适合用递归来解决，在递归时，从上往下处理或者从下往上处理要考虑清楚（都是从上往下递归，区别在有没有返回值，是否需要下一次递归的数据）

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

* 前中后序遍历相互转换问题，可以用递归的方法，根据根的位置，找到左右子树的分界点（T105,T106,T889）。前序后序判断是否只有一种中序，只需要判断是否存在只有一个子树的情况（一个子树可能是左也可能是右）

	* 前序遍历  根左右 
	
	* 后序遍历  左右根
	
	* 中序遍历  左根右

* 平衡树 通过对任何一条从根到叶子的路径上各个节点着色的方式的限制，红黑树确保没有一条路径会比其它路径长出两倍，因此，红黑树是一种弱平衡二叉树（由于是弱平衡，可以看到，在相同的节点情况下，AVL树的高度低于红黑树），相对于要求严格的AVL树来说，它的旋转次数少，所以对于搜索，插入，删除操作较多的情况下，我们就用红黑树。

* AVL树，插入操作有四种情况（左左、右右、左右、右左），删除三种情况。插入操作需要O(lg(n))的遍历时间以及至多两次旋转的常数时间；删除操作需要O(lg(n))的遍历时间以及若干次旋转的常数时间；

* LCA 最近公共祖先问题 
	
	* 二叉搜索树的LCA问题，判断两个节点的值是否一个大于根节点一个小于根节点，是的话返回该节点，不是的话递归查找左右子树
	
	* 普通二叉树LCA问题  递归左子树，递归右子树，左子树为空返回右子树的递归值，右子树为空返回左子树的递归值，左子树右子树都不为空返回根节点，

* 在对节点进行编号的时候，左节点就添0，右节点添1，其实相当于左节点等于父节点*2，右节点等于父节点*2+1（因为每次加0或者加1的时候，前边的二进制数组都左移了一位，相当于乘2，再加上0或者1）

* 树的存储结构： 双亲表示法（数组，记录父节点的标号），孩子表示法（单链表，记录孩子节点标号），孩子兄弟表示法（往下记录最左边孩子节点，向右记录兄弟节点）

* 霍夫曼树： 带权路径长度达到最小的扩充二叉树即为霍夫曼树。权值大的节点离根节点最近。霍夫曼编码实现可变长编码

* 左高树 ： 任何一个内部节点的左孩子s值都大于等于右孩子的s值。适合于优先队列的合并。

	* 以x为根的子树的节点数目至少 2^(s(x))-1个

	* 若以x为根节点的子树有m个节点，那么s(x)最多为log_2(m+1)

	* 从x到一外部节点的最右路径的长度为s(x)。

* 若一棵HBLT同时还是大根树，则称为最大HBLT

* B树  可以认为是m叉的多路平衡查找树。因为我们要考虑磁盘IO的影响，它相对于内存来说是很慢的。数据库索引是存储在磁盘上的，当数据量大时，就不能把整个索引全部加载到内存了，只能逐一加载每一个磁盘页（对应索引树的节点）。所以我们要减少IO次数，对于树来说，IO次数就是树的高度，而“矮胖”就是b树的特征之一，它的每个节点最多包含m个孩子，m称为b树的阶，m的大小取决于磁盘页的大小。

	* 树的根或者是一片树叶，或者其儿子数为[2, M]。

	* 除根外，所有的非树叶结点的儿子数为[M/2, M]，向上取整。
	
	* 节点内各关键字互不相等且从小到大排列
	
	* 所有叶子节点都在树的同一层
	
	* 关键字集合分布在整颗树中,任何一个关键字出现且只出现在一个结点中,搜索有可能在非叶子结点结束,其搜索性能等价于在关键字全集内做一次二分查找
	
	
* B+树

	* 所有数据都保存在叶子节点
	
	* 所有的叶子结点中包含了全部关键字的信息，及指向含这些关键字记录的指针，且叶子结点本身依关键字的大小自小而大顺序链接
	
	* 通常在b+树上有两个头指针，一个指向根结点，一个指向关键字最小的叶子结点。
	
	* 同一个数字会在不同节点中重复出现，根节点的最大元素就是b+树的最大元素
	

* B树B+树的区别  https://www.cnblogs.com/xueqiuqiu/articles/8779029.html

	* b+树的中间节点不保存数据，所以磁盘页能容纳更多节点元素，更“矮胖”；
	
	* b+树查询必须查找到叶子节点，b树只要匹配到即可不用管元素位置，因此b+树查找更稳定（并不慢）；
	
	* 对于范围查找来说，b+树只需遍历叶子节点链表即可，b树却需要重复地中序遍历
	
* Morris遍历法，能以O(1)的空间复杂度实现二叉树的中序遍历。Morris遍历算法的步骤如下：

	* 根据当前节点，找到其前序节点，如果前序节点的右孩子是空，那么把前序节点的右孩子指向当前节点，然后进入当前节点的左孩子。

	* 如果当前节点的左孩子为空，打印当前节点，然后进入右孩子。

	* 如果当前节点的前序节点其右孩子指向了它本身，那么把前序节点的右孩子设置为空，打印当前节点，然后进入右孩子。


#### 关于堆的一些想法

* 大根树 每个节点的值都大于或等于其子节点（不一定是二叉树）

* 大根堆 既是大根树又是完全二叉树

* 大根堆插入： 把新元素插入新节点，然后沿着新节点到根节点的路径进行起泡操作

* 大根堆删除，删除顶节点，将最后一个元素删除放在头节点，然后下沉

* 堆排序：以最大堆为例，

	* 每趟将堆顶元素与最后一个元素互换，可以得到非递减序列

	* 每趟将堆顶元素依次输出到新的数组，得到非递增序列

 	
#### 关于栈和队列的一些想法

* 用栈来实现队列。需要用两个栈，一个元素经过两个栈才能出队列，一个in一个out，out空了将in转到out。

* 用队列模拟栈，每次push一个元素，将之前的元素都出队列再进队列，保证后加入的元素在队列的头部

* 适合解决下一个更大的元素问题（739、496、503）

*  求前 k 大，用小根堆，求前 k 小，用大根堆 能够把复杂度维持在nlogk（T347）

* 求第k大（或小）的数，用快排的思想，依次划分，平均复杂度O(n)

*  n个元素入站顺序一定时，判断一个序列是否是弹出序列可以使用一个栈来模拟压入弹出操作。所有出栈顺序的可能性数量是卡特兰数C(2n,n)/(n+1) 即  C(2n,n)— C(2n,n+1)
出栈个数问题等价于：n个1和n个0组成一2n位的2进制数，要求从左到右扫描，1的累计数不小于0的累计数，试求满足这条件的数有多少？
先在2n个位置找n个放1，其他的放0，然后减去不合要求的。
问题也等价于 直角三角形网格，从左上角开始，只能向右走和向下走，问总共有多少种走法？

#### 关于哈希表的一些想法

*  hashmap有时候也是不错的选择 。 HashMap<Integer, Integer> hasMap = new HashMap<Integer, Integer>();空间换时间

* 分为哈希集合（705）和哈希映射（706）

* 关于字符有关的，哈希表也可以用数组替换，速度会快一些

#### TreeSet

* 不能有重复的元素；

* 具有排序功能；

* TreeSet中的元素必须实现Comparable接口并重写compareTo()方法，TreeSet判断元素是否重复 、以及确定元素的顺序 靠的都是这个方法；

	* 对于Java类库中定义的类，TreeSet可以直接对其进行存储，如String，Integer等,因为这些类已经实现了Comparable接口);
	
	* 对于自定义类，如果不做适当的处理，TreeSet中只能存储一个该类型的对象实例，否则无法判断是否重复。
	
* 依赖TreeMap。

*  相对HashSet,TreeSet的优势是有序，劣势是相对读取慢。根据不同的场景选择不同的集合。

#### 关于字符串的一些想法

* 判断字符串关系，比如是否是字母异位词（242）等，对每个字符有统计的，可以声明26位（只有字母）int数组来帮助（或者256位，比较全面），hash的思想

* 回文字符串个数，双指针向外扩散就好（要记住区分奇数长度和偶数长度），T647

* 判断是否为子串 s1.contains(s2) 

* 大量数字转String  String.valueOf(nums) 比 nums+"" 好一些

* 字符串的题目很多时候都是考察动态规划

* 判断最大回文字符串 manacher方法 能够将复杂度降为O(n)

#### 关于数组与矩阵的一些想法

* 处理有序矩阵，从左下方向右上方（或反过来）经常能够简化很多计算（T240、378）

* 把数组模拟成链表（T287），数组的值看作下一个元素的下标位置，思想很妙

* 前缀和的应用。求数组某一区间的和，可以先用On的空间 记录下前n项的和S(n), 那么[m,n]范围内的和为S(n)-S(m);

#### 关于图的一些想法

* 二分图 如果可以用两种颜色对图中的节点进行着色，并且保证相邻的节点颜色不同，那么这个图就是二分图

* 拓扑排序，用一个队列存储入度为0的节点较为方便

* dfs退栈的顺序是一种逆拓扑排序

* 并查集

* 最小生成树 prim和 kruskal算法

	* prim 加点法 适合稠密图 每次加入与已生成树各节点相连的最小权值的节点
	
	* kruskal 加边法 适合稀疏图 在不生成环路的情况下每次将最小的边加入
	
* AOE网（顶点活动网络），只有一个入度为0的点（源点），一个出度为0的点（汇点），从源点到汇点的具有最大路径长度的路径称为关键路径。找最早开始时间和最晚开始时间相同的点


* dijkstra算法时间复杂度O(mlogn) （看似对每个点nlogn，实际上也对每个边mlogn，一般m>n）

单源最短路径

算法 | 时间复杂度 | 备注
-|-|-
dijkstra | O(mlogn) | 非负权重
Bellman-Ford （动态规划） | O(mn) | 任意权重 OPT(i,v) = min{OPT(i-1,v),min{OPT(i-1,u)+l_(uv)}} //最多i条边到达v点的最小距离

* 检测负圈，Bellman-Ford方法如果OPT(n,v)<OPT(n-1,v) 说明存在负圈

任意点对最短路径

算法 | 时间复杂度 | 备注
-|-|-
Dijkastra | O (mn logn) | 边权重非负
Bellman-Ford | O (mn^2) | 
Basic “matrix multiplication” | O (n^4) | 非负圈  L_(ij)^(m) = min{L_(ik)^(m-1)+w_(kj)} //i到j最多经过m条边的最短路径
Improve “matrix multiplication” | O (n^3 logn) | 非负圈  类比矩阵乘法
Floyd-Warshall | O (n^3) | 非负圈  d_(ij)^(k) = min{d_(ij)^(k-1),d_(ik)^(k-1)+d_(jk)^(k-1)} //i到j经过{1,2,..n}的最短路径


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


#### 排序

算法 | 稳定性 |  时间复杂度 | 空间复杂度 | 备注  
-|-|-|-|-
选择排序 | x  | N^2 | 1 | 
冒泡排序 | √  | N^2 | 1 | 
插入排序 | √  | N^2 | 1 | 时间复杂度和初始顺序有关
快速排序 | x  | NlogN | logN | 递归深度logN
归并排序 | √  | NlogN | N | 
堆排序   | x  | NlogN | 1 | 无法离哟个局部性原理 ，不稳定，因为每次删除堆顶节点，会把最后一个元素放在堆顶，然后下沉
希尔排序 | x  |与增量序列有关| |
* 堆排序不稳定

* 归并排序空间复杂度N，快速排序空间复杂度logN

* 基准的选择堆快速排序影响很大，常用的方法有打乱数组、取两端点和中点的mid值等

* 希尔排序是把序列按一定间隔分组，对每组使用直接插入排序；随着间隔减小，一直到1，使得整个序列有序
时间复杂度未完全解决 和增量序列有关 大概在O(n^(1.3—2))


	
#### 贪心算法

* 本质上是确定一个策略，每步都执行，得到的最后结果即为最优解

* 找区间的 很多情况对起点终点用贪心算法


#### java使用

* Comparable 这个interface 很好用，如 class Tuple implements Comparable<Tuple> {}（T378）

* sc.nextInt 用完后，还需要sc.nextline来吞掉一个回车

* 保留n位小数 String.format("%.nf", d);
 
* 反转list Collections.reverse(lists)

* 由char数组得到字符串 用new String(chars); 

* 判断一个double变量是否为整数  number%1==0

* 
	* 将long转换为16进制字符串Long.toHexString(ans)，字母是小写
	
	* 将十六进制字符串转换成long，Long.parseLong(s1, 16)
	
* 空字符串和null是不一样的

* 要把字符串按“.”分割成数组，不可以直接String.split(“.”);，因为.是一种通配符，需要先转义 String.split("\\.")

* 		Comparator<Pair> comparator = new Comparator<Pair>(){
			@Override
			public int compare(Pair o1, Pair o2) {
				return 0;
			}
			
		};
		
	在使用Arrays.sort时即可将作为参数传入。 //注意，要想改变默认的排列顺序，不能使用基本类型（int,double,char）而要使用它们对应的类
		
* 判断是否为子串 s1.contains(s2)  如果能直接用StringBuffer的lastIndexOf速度会提升很多

*   最小堆 PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(); 

*   最大堆 

	PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>(){
		@Override
		public int compare(Integer i1,Integer i2){
			return i2-i1;
		}	
	};
	只能是泛型可替代的，int不行，Integer行
	
* 哈希表或list初始化的时候 最好确定长度，能够省时	

* 在使用字符串查找或者匹配时时，要注意正则匹配问题。比如replaceAll方法，对string时正则的。但是replace不是正则的，并且也替换全部的

* 判断是否为数字 Character.isDigit();

* list转为数组 ans.toArray(new String[ans.size()]);

* 数组 clone 1维数组是深度克隆，二维数组是浅拷贝。clone方法是从Object类继承过来的，基本数据类型（int ，boolean，char，byte，short，float ，double，long）都可以直接使用clone方法进行克隆，注意String类型是因为其值不可变所以才可以使用。

* LinkedHashMap LinkedHashMap继承了HashMap，有序hash

* 根据HashMap的值来排序 ：先将map的Entry们转化为list 然后用collections自定义排序规则排序
        List<Map.Entry<Character,Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list,new Comparator<Map.Entry<Character,Integer>>() {
        	@Override
        	public int compare(Entry<Character,Integer> o1,
                    Entry<Character,Integer> o2) {
                return o2.getValue()-o1.getValue();
            }
        });

* 一般重写equals方法时也也要重写hashcode方法，为了保证行为一致性。通过源码可以看出hashset等应用判断时既要判断hashcode也会判断equals。

* 不定长list转二维array  (int[][])temp.toArray(new int[0][]);

* 要注意Integer等的拆箱装箱问题，判断Integer是否相等用.intValue() 要不然大于127时会使用对象来比较
#### 其他想法

* 蒙特卡罗看运气法我也是服了。。。

* KMP算法

* 滑动窗口 （76、438、3）， 可以分成固定窗口大小和可改变窗口大小（更像双指针）

* 前缀和 思想

*  mid = low+(up-low)/2;//以后求中点都这样求吧，防止溢出	
 
* 矩阵链乘法问题 可描述如下：给定n个矩阵的链<A1,A2,...,An>，矩阵Ai的规模为p(i-1)×p(i) (1<=i<=n)，求完全括号化方案，使得计算乘积A1A2...An所需标量乘法次数最少。。T375  887鸡蛋掉落 312戳气球 132分割回文串.关键点还是找准父状态由子状态的转移方程

* O(1)时间内删除链表某个节点：

	* 如果该节点不是尾节点，那么可以直接将下一个节点的值赋给该节点，然后令该节点指向下下个节点，再删除下一个节点，时间复杂度为 O(1)。

	*  否则，就需要先遍历链表，找到节点的前一个节点，然后让前一个节点指向 null，时间复杂度为 O(N)。

* 求数据流中的中位数，维护两个堆（左边最大堆，右边最小堆），保持两个堆的大小一样，最后的结果就是两个堆顶元素平均值（或一个堆的堆顶元素） 

* 约瑟夫环 (dfs(n-1,m)+m)%n  https://blog.csdn.net/u011500062/article/details/72855826
	//递归
    public int lastRemaining(int n, int m) {
    	if(n==1) return 0;
    	return (lastRemaining(n-1,m)+m)%n ;
    }
	//非递归
	public int lastRemaining(int n, int m) {
        int ans = 0;
        // 最后一轮剩下2个人，所以从2开始反推
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i;
        }
        return ans;
    }

* 现代操作系统很少使用堆排序，因为无法利用局部性原理进行缓存，也就是数组元素很少和相邻的元素进行比较和交换

* 两个链表的第一个公共节点 L1遍历完指向L2头，L2遍历完指向L1头，继续遍历，直到相等（L1长度a+c,L2长度b+c,  a+c+b=b+c+a 为第一个相同节点的位置）

* 荷兰国旗问题，三个指针，将数组分为三个部分 推广一下，可以将数组分为三部分，中间部分为某个值的数（可能有多个），左边小于这个数，右边大于这个数

* 柱状图中最大矩形，用单调栈，a[i]>a[i+1] 压入栈，否则出栈，并计算最大值

* 前缀树，字典树

* 为什么mod 10^9 + 7，因为int32位的最大值为2147483647，所以对于int32位来说1000000007足够大；int64位的最大值为2^63-1，对于1000000007来说它的平方不会在int64中溢出

* 两个x，y容量水壶装水问题，问能否能弄出z容量的水 ： 找到x,y的最大公约数能否z被整除即可

* 要求原地算法的题目，要擅长使用所给的空间，比如T73，用首行和首列来记录0是否存在

* 尽量将常量写在左边 比如判断a是否为null时写成 null == a 这样防止少写= 出现问题   算是一个好习惯吧

* 64匹马,8个赛道,最少比几次找出跑得最快的4匹马？ 答：11次

* 不管是stack还是其他地方  用到Integer时都要特别注意Integer的拆箱装箱问题