
#### 关键字

**join** 
inner join 会取两者都有的部分  等同于join
使用outer join时可以保证指定表的每条记录都出现----即使没有匹配, outer join又可以分为left join, right join, full join。
LEFT JOIN返回左表的全部行和右表满足ON条件的行，如果左表的行在右表中没有匹配，那么这一行右表中对应数据用NULL代替。
RIGHT JOIN返回右表的全部行和左表满足ON条件的行，如果右表的行在左表中没有匹配，那么这一行左表中对应数据用NULL代替。
FULL JOIN 会从左表 和右表 那里返回所有的行。如果其中一个表的数据行在另一个表中没有匹配的行，那么对面的数据用NULL代替

**limit**
语法：  SQL语句  limit [offset,] rows
一般是用于select语句中用以从结果集中拿出特定的一部分数据。offset是偏移量，表示我们现在需要的数据是跳过多少行数据之后的，可以忽略；rows表示我们现在要拿多少行数据。
举例： select * from table limit 10000,100 表示从表table中拿数据，跳过10000行之后，拿100行


**asc、desc**
语法  select * from table order by xxx desc
排序的关键字  默认为asc(升序)


**distinct** 
语法  select distinct 列名称 from 表名称
用于返回唯一不同的值。

**group by**
根据“By”指定的规则对数据进行分组，所谓的分组就是将一个“数据集”划分成若干个“小区域”，然后针对若干个“小区域”进行数据处理。
select的内容只能是by后边的列 或者其他列的聚合操作
https://blog.csdn.net/u014717572/article/details/80687042

**like**
模糊搜索
使用like查询时 尽量不要'%xxx'  而应该写成'jack%'; 因为前者一般不会使用索引  


**explain**
可以用explain命令来查看一些语句的执行计划 比如看有没有使用索引 如何优化


#### 方法
- **IFNULL(expr1,expr2)**
如果expr1不是NULL，IFNULL()返回expr1，否则它返回expr2。IFNULL()返回一个数字或字符串值。例如：
`ifnull(sum(t2.played_num),0)`
如果sum(t2.played_num)为null，则将其置位0


- **聚合函数**
函数| 作用 
-|-|-
sum(列名) | 求和
max(列名) | 最大值
min(列名) | 最小值
avg(列名) | 平均值
count(列名)|统计记录数





#### 注意点


- **where 和having 知识点总结：**
where 是用于在初始表中筛选查询，having用于在where和group by 结果分组中查询
having子句限制的是组，而不是行。where子句中不能使用聚集函数，而having子句中可以。
当一个语句中同时含有where、group by 、having及聚集函数时，执行顺序如下：
    执行where子句查找符合条件的数据；
    使用group by 子句对数据进行分组；对group by 子句形成的组运行聚集函数计算每一组的值；
    最后用having 子句去掉不符合条件的组。
  
- **on 和 where**
	* 在inner join中是相同的  ， 在 outer join中 不同
	*  在多表联接查询时，on比where更早起作用。系统首先根据各个表之间的联接条件，把多个表合成一个临时表后，再由where进行过滤，然后再计算，计算完后再由having进行过滤。
	* 对于JOIN参与的表的关联操作，如果需要不满足连接条件的行也在我们的查询范围内的话，我们就必需把连接条件放在ON后面，而不能放在WHERE后面，如果我们把连接条件放在了WHERE后面，那幺所有的LEFT,RIGHT,等这些操作将不起任何作用，对于这种情况，它的效果就完全等同于INNER连接。对于那些不影响选择行的条件，放在ON或者WHERE后面就可以。记住：所有的连接条件都必需要放在ON后面，不然前面的所有LEFT,和RIGHT关联将作为摆设，而不起任何作用。



- **select having group by  where等语句执行顺序是怎样的？**
S-F-W-G-H-O 
select –>where –> group by–> having–>order by

  
- **集合运算**
集合操作有　并，交，差　３种运算。
union :得到两个查询结果的并集，并且自动去掉重复行。不会排序 
union all:得到两个查询结果的并集，不会去掉重复行。也不会排序 
intersect:得到两个查询结果的交集，并且按照结果集的第一个列进行排序 
minus:得到两个查询结果的减集，以第一列进行排序 


- **DELETE TABLE 和 DROP TABLE**
DELETE TABLE:删除内容不删除定义，不释放空间（效率低，速度慢，因为一行一行的删除）。//能回滚成功
DROP TABLE：删除内容和定义，释放空间。(会放进回收站)

- **如果null参与聚集运算，则除count(*)之外其它聚集函数都忽略null**

- **where的比较方法**
`select s1.Score
from Scores s1 ,Scores s2
where 
s1.score <= s2.score`
会把s1 中的每个元素和s2中的每个元素进行比较  true一次 则select一次
相当于两个表做了个笛卡儿积 然后一行一行的筛选
所以尽量一开始使用较小的表 from的内容可以是已经筛选过的


- **窗口函数**
窗口函数，也叫OLAP函数（Online Anallytical Processing，联机分析处理），可以对数据库数据进行实时分析处理。https://mp.weixin.qq.com/s?__biz=MzAxMTMwNTMxMQ==&mid=2649247566&idx=1&sn=f9c7018c299498673b38221db2ecd5cd&chksm=835fc77eb4284e68b7528fd7f75eedb8868a6740704af8559f8a5cbdd2867a49ffa21bf4e531&token=426730634&lang=zh_CN#rd
窗口函数的基本语法如下：
`<窗口函数> over (partition by <用于分组的列名> order by <用于排序的列名>)`
<窗口函数>的位置，可以放以下两种函数：
	* 专用窗口函数，包括后面要讲到的rank, dense_rank, row_number等专用窗口函数。
	* 聚合函数，如sum. avg, count, max, min等

- **topN问题**
https://mp.weixin.qq.com/s?__biz=MzAxMTMwNTMxMQ==&mid=501763959&idx=1&sn=5a8a3c3400e1933c3b6eb3b9cbc5eaf8&chksm=035fc74734284e512f1f569bb569f12d4d79c99ad176005917ca48854afb5163904533837d38#rd
`# topN问题 sql模板
select * from (   select *,  row_number() over (partition by 要分组的列名   order by 要排序的列名 desc) as ranking    from 表名) as a
where ranking <= N`


- **sql where 1=1 0=1 的妙用**
	* SELECT * FROM strName WHERE 1 = 0
该select语句主要用于读取表的结构而不考虑表中的数据，这样节省了内存，因为可以不用保存结果集。另外，这个用在什么地方呢？主要用于创建一个新表，而新表的结构与查询的表的结构是一样的。如下SQL语句：`create table newtableas select * from oldtablewhere 1=0;`
	* select * from table1 where 1=1
除了在sql注入时会用到，在不定数量查询条件情况下，1=1还可以很方便的规范语句。例如一个查询可能有name,age,height,weight约束，也可能没有，那么在拼接sql字符串的时候还要判断是否有where关键字 ，如果写上了where 1=1 那么直接在后边添加其他判断即可


- **索引**

- **索引覆盖**
如果要查询的字段都建立过索引，那么引擎会直接在索引表中查询而不会访问原始数据（否则只要有一个字段没有建立索引就会做全表扫描），这叫索引覆盖。
因此我们需要尽可能的在select后只写必要的查询字段，以增加索引覆盖的几率。

- **数据库为什么使用B+树而不是B树**
	* B树只适合随机检索，而B+树同时支持随机检索和顺序检索；
	* B+树空间利用率更高，可减少I/O次数，磁盘读写代价更低。一般来说，索引本身也很大，不可能全部存储在内存中，因此索引往往以索引文件的形式存储的磁盘上。这样的话，索引查找过程中就要产生磁盘I/O消耗。B+树的内部结点并没有指向关键字具体信息的指针，只是作为索引使用，其内部结点比B树小，盘块能容纳的结点中关键字数量更多，一次性读入内存中可以查找的关键字也就越多，相对的，IO读写次数也就降低了。而IO读写次数是影响索引检索效率的最大因素；
	* B+树的查询效率更加稳定。B树搜索有可能会在非叶子结点结束，越靠近根节点的记录查找时间越短，只要找到关键字即可确定记录的存在，其性能等价于在关键字全集内做一次二分查找。而在B+树中，顺序检索比较明显，随机检索时，任何关键字的查找都必须走一条从根节点到叶节点的路，所有关键字的查找路径长度相同，导致每一个关键字的查询效率相当。
	* B树在提高了磁盘IO性能的同时并没有解决元素遍历的效率低下的问题。B+树的叶子节点使用指针顺序连接在一起，只要遍历叶子节点就可以实现整棵树的遍历。而且在数据库中基于范围的查询是非常频繁的，而B树不支持这样的操作。
	* 增删文件（节点）时，效率更高。因为B+树的叶子节点包含所有关键字，并以有序的链表结构存储，这样可很好提高增删效率。

- **数据库的乐观锁和悲观锁是什么？怎么实现的？**
数据库管理系统（DBMS）中的并发控制的任务是确保在多个事务同时存取数据库中同一数据时不破坏事务的隔离性和统一性以及数据库的统一性。乐观并发控制（乐观锁）和悲观并发控制（悲观锁）是并发控制主要采用的技术手段。
	* 悲观锁：假定会发生并发冲突，屏蔽一切可能违反数据完整性的操作。在查询完数据的时候就把事务锁起来，直到提交事务。实现方式：使用数据库中的锁机制
	* 乐观锁：假设不会发生并发冲突，只在提交操作时检查是否违反数据完整性。在修改数据的时候把事务锁起来，通过version的方式来进行锁定。实现方式：乐一般会使用版本号机制或CAS算法实现。

两种锁的使用场景：
		从上面对两种锁的介绍，我们知道两种锁各有优缺点，不可认为一种好于另一种，像乐观锁适用于写比较少的情况下（多读场景），即冲突真的很少发生的时候，这样可以省去了锁的开销，加大了系统的整个吞吐量。
		但如果是多写的情况，一般会经常产生冲突，这就会导致上层应用会不断的进行retry，这样反倒是降低了性能，所以一般多写的场景下用悲观锁就比较合适。
		
- **SQL语句主要分为哪几类**
	* 数据定义语言DDL（Data Ddefinition Language）CREATE，DROP，ALTER
	* 数据查询语言DQL（Data Query Language）SELECT
这个较为好理解 即查询操作，以select关键字。各种简单查询，连接查询等 都属于DQL。
	* 数据操纵语言DML（Data Manipulation Language）INSERT，UPDATE，DELETE
主要为以上操作 即对数据进行操作的，对应上面所说的查询操作 DQL与DML共同构建了多数初级程序员常用的增删改查操作。而查询是较为特殊的一种 被划分到DQL中。
	* 数据控制功能DCL（Data Control Language）GRANT，REVOKE，COMMIT，ROLLBACK
主要为以上操作 即对数据库安全性完整性等有操作的，可以简单的理解为权限控制等。

- **超键、候选键、主键、外键分别是什么**
	* 超键：在关系中能唯一标识元组的属性集称为关系模式的超键。一个属性可以为作为一个超键，多个属性组合在一起也可以作为一个超键。超键包含候选键和主键。
	* 候选键：是最小超键，即没有冗余元素的超键。
	* 主键：数据库表中对储存数据对象予以唯一和完整标识的数据列或属性的组合。一个数据列只能有一个主键，且主键的取值不能缺失，即不能为空值（Null）。
	* 外键：在一个表中存在的另一个表的主键称此表的外键。

- **mysql中 in 和 exists 区别**
mysql中的in语句是把外表和内表作hash 连接(先算出子查询的结果)，而exists语句是对外表作loop循环，每次loop循环再对内表进行查询。一直大家都认为exists比in语句的效率要高，这种说法其实是不准确的。这个是要区分环境的。
	* exist： 先执行外部查询语句，然后在执行子查询，子查询中它每次都会去执行数据库的查询，执行次数等于外查询的数据数量。查询数据库比较频繁(记住这点),如果b表再id上加了索引也会走索引
	* in:    先查询 in()子查询的数据(1次)，并且将数据放进内存里(不需要多次查询),然后外部查询的表再根据查询的结果进行查询过滤,最后返回结果。 这个的操作主要是在内存进行，不会进行数据库的多次查询。
	* 如果查询的两个表大小相当，那么用in和exists差别不大。
	* 如果两个表中一个较小，一个是大表，则子查询表大的用exists，子查询表小的用in。
	* not in 和not exists：如果查询语句使用了not in，那么内外表都进行全表扫描，没有用到索引；而not extsts的子查询依然能用到表上的索引。所以无论那个表大，用not exists都比not in要快。

- **超大分页怎么处理**
超大的分页一般从两个方向上来解决.解决超大分页,其实主要是靠缓存,可预测性的提前查到内容,缓存至redis等k-V数据库中,直接返回即可.
	* 数据库层面,这也是我们主要集中关注的(虽然收效没那么大),类似于select * from table where age > 20 limit 1000000,10这种查询其实也是有可以优化的余地的. 这条语句需要load1000000数据然后基本上全部丢弃,只取10条当然比较慢. 当时我们可以修改为select * from table where id in (select id from table where age > 20 limit 1000000,10).这样虽然也load了一百万的数据,但是由于索引覆盖,要查询的所有字段都在索引中,所以速度会很快. 同时如果ID连续的好,我们还可以select * from table where id > 1000000 limit 10,效率也是不错的,优化的可能性有许多种,但是核心思想都一样,就是减少load的数据.
	* 从需求的角度减少这种请求…主要是不做类似的需求(直接跳转到几百万页之后的具体某一页.只允许逐页查看或者按照给定的路线走,这样可预测,可缓存)以及防止ID泄漏且连续被人恶意攻击.
	
- **MySQL的复制原理以及流程**
主从复制：将主数据库中的DDL和DML操作通过二进制日志（BINLOG）传输到从数据库上，然后将这些日志重新执行（重做）；从而使得从数据库的数据与主数据库保持一致。

- ****

- **** 

- ****

- ****

- ****

- ****

- ****

#### leetcode解题记录

 T_175
关于多表查询 考察了对Join的基本使用
select FirstName, LastName, City, State
from Person left join Address
on Person.PersonId = Address.PersonId
;

T_176
select (select distinct salary from Employee order by salary desc limit 1,1) as SecondHighestSalary

T_177
编写一个 SQL 查询，获取 Employee 表中第 n 高的薪水（Salary）。
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
    set N = N-1;
    RETURN (
      # Write your MySQL query statement below.
        select distinct salary from employee order by salary desc limit N,1
    );
END


T_178
按照分数输出排名
select s1.Score,count(s2.score) Rank
from Scores s1 ,(select Score from Scores group by Score) as s2
where 
s1.score <= s2.score
group by s1.Id
order by Rank


























