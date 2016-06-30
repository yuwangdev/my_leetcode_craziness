### Leetcode每日狂刷日志

#### 补遗
- 求最大小值: return Collections.min(myCollection);   也可以用Arrays
- 求最大小值的位置: return Collections.indexOf(Collections.min(myCollection));   也可以用Arrays
- 看一个array是否有重复数值, hashset法保平安: if(!hashset.add(a[i])) return false;





#### 1 Rotate array  
Give an array and k (from the tail) as pivot, rotate. {1,2,3,4,5} and k=2: 45123
- 最简单是直接拷贝移动
- 最有扩展性的是冒泡法
- 冒泡：让目标元素一个个移动到目标位置

```
1234567   k=3
7123456
6712345
5671234
```

#### 27 ZigZag conversion  
Convert a sring to 3-line zigzag style 
- 第一行 0+4n 第二行 1+2n 第三行 2+4n, 当step=3
- StringBuilder
- stringBuilder.toString();
- 可以用简单归纳法
- 涉及到位置的字符题目时，可以完全用数字代替
```
1   7   13
2  68  12
3 5 9 11
4   10
```

从行数为1开始，一直推倒到n=4发现，第一行和最后一行间隔为2n-2
其余行，如果没有中间倾斜数值，仍然是2n-2的间隔
中间倾斜数据，间隔为 2n-2-2*当前行数


#### 218 Reverse integer 
123 convert to 321 
- 小心10000或者数据太大overflow的问题
- 要用long 最后结果(int) longResult
```java
res=res*10+data%10
data/=10
if res>Integer.MAX_VALUE or res<Integer.MIN_VALUE return 0
```

#### Climb stairs 
only 1 or 2 steps per time, how many ways to reach n
- DP method, d(n)=d(n-1)+d(n-2)

#### 60 Count and say
1: 1, 2: 12， 21:1211，以此类推，求nth结果
- 时刻记住string是immutable，要是想操作，必须string.toCharArray() and string.charAt(i)
- 初始化一个最简单的答案，然后while迭代，可以模仿recursion的行为
- res="1", while n<100: res=doSth(res)
- while n-->0： n=1的情况会操作
- while --n>0: n=1的情况不会操作
- 计数重复数值的方法：
```java
while (index < string.length) {
	int counter = 1;
	while (index + 1 < string.length && string[index] == string[index + 1]) {
		counter++;
		index++;
	}
	result.append(counter).append(string[index]);
}
```

- int --- string --- char[]
```java
String.valueOf(int).toCharArray();
Integer.parse(string);
String s = new String(charArray);
Integer.parse(s);
```

#### Factorial trailing zeros
calcuate how many zeros in the tail of n!
- 能被5整除几次，就有几个0

#### 53 Compare version number
Compare two version numbers, return 1, -1 or 0. e.g. 13.11>1.2
- 切记:从头开始比较,前面的数值大者获胜,否则继续迭代下去,但要注意是否长度不会outboundary
- 当在长度范围之内时,就parse成数值,否则就是0
- String[] list = string.split("\\.");

#### 29 Length of last word
return the length of the last word in a sentence String s, if null return 0
- 切记多用counter
- 从后往前推,string.charAt(i)

#### 50 Longest common prefix
find the longest common prefix string in a string[]
- 初始化一个prefixLength结果数值,然后在一遍遍迭代中更新该数值
- string.subString(m,n): [m,n)
- 切记:break只能中断所在loop的循环,不能逃出再往上层次的循环

#### 19 Merge two sorted array
Assume the array A has enough space to hold array B element before merging
- 从后往前推,注意长度限制

#### 46 Majority Element
Find the majority element that appears in an array for more than n/2 times
- 黄金解法:超过半数出现的元素,在序列排序后,肯定在中间
- Arrays.sort(): quick sort, O(nlogn)
- 求数列中最长元素的解法:

```java
int prev = num[0];
int count = 1;
for (int i = 1; i < num.length; i++) {
    if (num[i] == prev) {
        count++;
        if (count > num.length / 2) return num[i];
    } else {
        count = 1;
        prev = num[i];
    }
}
```

#### 36 Longest substring without repeating characters
e.g. abcbb:3, bbbbb:1
- 初始化start和max,进入循环中更新数值,返回max
- 我的方法是用hashset+counter
- HashSet<Character>
- hashSet.add(), .contains()


#### 141 Balanced Binary Tree 
check if a BT is balanced, height difference is not more than 1 
- 记住getHeight(TreeNode)的标准做法
- 改装标准的getHeight(TreeNode)操作,如果不平衡,直接返回-1即可
- 返回-1法:当return值只能是int时,用这个方法代替boolean 

#### 125 Binary tree level order traversal - from top to bottom 
层次遍历一棵树,从上到下,每层元素进一个嵌套的[[1],[1,2],[3,4,4,5]]
- 切记stack是具体class,queue只是interface of LinkedinList
- 用一个queue记录下一层的node,一个普通arraylist记录数值结果.遍历到当前层时,用queue记录下一层所有node,当前层结果进result
- 简化版的BFS:不用visited visiting unvisited做标记,因为标记法只用于图

#### 126 Binary tree level order traversal 2 - from bottom to up 
- 和上面的一样,只是trick在于最后的result插入动作: result.add(0, currentLevelArrayListResult);
- Queue.pop(): 按队列顺序弹出,throw exception if null
- Queue.poll(): 按队列顺序弹出,return null if null


#### 18 String to integer, ATOI
string convert to integer,类似于integer.parse(String),注意加减号/空白/超出范围
- Integer.MAX_VALUE: 32位的1
- 遇到大数值的题目,可以用long,最后return (int) longResult;
- string去除空白: string.trim()
- 数值题目重要技巧:
```java
int result =0;
while 从头开始多加一位数:
    result=10*result+加的这位数
```

#### Maximum depth of binary tree
along the longest path 
- 二叉树题目常用方法:Math.max(node.left, node.right)+1

#### 139 Minimum depth of binary tree
along the shortest path of BT 
- 和最高树高类似,但要注意如果左或者右树为空,返回的是对面的树的结果

#### 133 Path sum 
根据给定的数值,判断一棵树是否有一条从头到尾的链,相加之和是这个数值
- 递归:实时更新sum-root.value
- BFS:层次遍历,一个queue记录下一层所有node,一个ArrayList<>记录每一层每一个node上实时更新sum数值
- 注意:每一个node只有一个实时更新sum数值,因为只有唯一的一条向上路径,别想多了

#### 48 Remove element 
remove all the item from an array as per the given value, return the new length, space=O(1) 
- 双指针i=0 j=n-1,跑i,如果a[i]==target,把a[j]放到a[i]上,j--; 否则,i++
- 当题目不要求新的序列顺序时,把最后的元素往前面的位置提,可以是一个不错的方法

#### 34 Remove duplicates from sorted array 
remove all duplicated elements from a sorted array, and return the new length, in place 
- O(n) time and O(n) space: HashSet 
- 时刻谨记木洞排序法!!!!贼好用!, 但是需要O(n)的空间
- 遇到要求空间O(1)的array相关题目时,经典做法就是双指针,可能会出现a[j]==a[j+1] return j或者i的做法
- 具体做法:i=0 j=1,j是runner,如果j有重复就一直跑,如果没有重复了,让a[i]=a[j],i是整理后array的最后元素的位置
- 更好用的方法:只算出来所有重复元素的次数,然后用总长度相减即可
- 记住了,counter法是奇兵!

#### same tree 
check if two trees are exactly identical 
- base case 就是null node 

#### 142 Symmetric tree 
check if two trees are symmetricz
- recursion:比较数值,以及n1.left VS n2.right, n1.right VS n2.left


#### 55 Pascals triangles
Given a number n, generated n-layer PT, as [[],[],[]]
- 创建个结果[[]],初始化第一层as[1],然后for loop一层层叠加
- PS:arraylist和linkedlist都是list interface的具体实现,而stack和queue是linkedlist的子类

#### 56 Pascals triangles 2
Given an index k, return the kth row of the Pascal's triangle.
- 一种更易理解的方法:效仿PT1迭代法,只不过result.set(0, tempResult);

#### 219 Palindrome number
Check if a number is palindrome, with O(1) space. Palindrome: backwards and forwards are the same.
- 变成char array的方法会让space大于1,所以不能用
- 当只能操作数值时,黄金方法:通过一直相除找出位数相同的100000值,相除找到第一位数值,%10得出最后一位数值;通过number%1000/10去除首尾两位,10000/100维持循环

```java
int div = 1;
while (num / div >= 10) div *= 10; // two digits

while (num != 0) { // stop till num is 0, all digits compared
    int l = num / div; // left digit
    int r = num % 10; // right digit
    if (l != r) return false; // compare
    num = (num % div) / 10; // remove first and last digit
    div /= 100; // div should be smaller
}
```

#### 22 Implement strStr()
Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
- 时刻想着substring的方法,尤其是比较成块成块的string时

#### 103 Merge two sorted linked list 
Merge two sorted linked list to become a new one as whole 
- 因为当pointer到了最尾部后回不来最前面,这样就不能最终return了,所以在最开始设一个beforehead=pointer,开始比较后,让pointer.next=xxx,这样最后返回时只需要return beforehead.next即可
- 步骤:1)做出beforehead=pointer两个指针;2)让pointer跑,哪个小,成为pointer.next;3)当L1和L2有一个null时,把还有的list最后的加在pointer最后即可
- 一个经典模板:
```java
 while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                pointer.next = l1;
                l1 = l1.next;
            } else {
                pointer.next = l2;
                l2 = l2.next;
            }
            pointer = pointer.next;
        }
```


#### 109 Intersection of two linked list 
Find out the node of the intersection of two linked list, or return null 
- 需要齐头并进:先求长度差,让两个head都一致了

#### 114 Remove the Nth node from the end of the linked list 
1-2-3-4-5 and n=2, return 1-2-3-5
- 注意去除第一个node的特殊情况
- 遇到linkedlist in-place并需要return head时,一定是要使用beforeHead方法的
- 两种方法, 一种是faster/slower法,让faster先跳n步,然后slower faster一起跑知道faster到底,然后slow.next=slow.next.next 
- 另一种是直接length-n,从头调到目标node之前的那个


#### 26 Valid Panlindrome, ignore blank space and case: 镜像对称,注意当string为null的特殊例子
- Character.isLetterOrDigit(char)
- string.toLowerCase()

#### 20 Valid parentheses
check if the string contains complete () or []
- stack法:时刻记住,如果遇到类似和之前的char比较的题目,stack法是个好办法

#### 105 Remove duplicates from sorted linked list: so that every element is unique 




















