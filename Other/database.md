
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


























