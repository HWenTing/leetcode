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

* 平方数可以用加法来求 ，相邻平方数间隔为3,5,7,

* 整数范围 三数之积，最大值取max（max1*max2*max3，min1*min2*max1）

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



























