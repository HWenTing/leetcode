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

#### 关于栈和队列的一些想法

* 用栈来实现队列。需要用两个栈，一个元素经过两个栈才能出队列，一个in一个out，out空了将in转到out。

* 用队列模拟栈，每次push一个元素，将之前的元素都出队列再进队列，保证后加入的元素在队列的头部

* 适合解决下一个更大的元素问题（739、496、503）

#### 关于哈希表的一些想法

*  hashmap有时候也是不错的选择 。 HashMap<Integer, Integer> hasMap = new HashMap<Integer, Integer>();空间换时间

#### 关于字符串的一些想法

* 判断字符串关系，比如是否是字母异位词（242）等，对每个字符有统计的，可以声明26位（只有字母）int数组来帮助（或者256位，比较全面）

* 回文字符串个数，双指针向外扩散就好（要记住区分奇数长度和偶数长度），T647

#### 关于数组与矩阵的一些想法

* 

#### 其他想法

























