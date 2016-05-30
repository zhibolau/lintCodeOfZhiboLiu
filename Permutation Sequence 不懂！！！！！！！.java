Permutation Sequence

从所有permutation中 找到第k个


很难

不会！！！！
Given n and k, return the k-th permutation sequence.

For n = 3, all permutations are listed as follows:

"123"
"132"
"213"
"231"
"312"
"321"
If k = 4, the fourth permutation is "231"

Note
n will be between 1 and 9 inclusive.


其实学过数学，知道排列组合，无重复数据的话，n个数，从1到n就有n!种组合。
那么如果我们知道第一位数字是多少，就能算出后面的(n-1)位数的组合，也就是(n-1)!种组合。
这个分析很明显了，n可以分成n组，每组有(n-1)!个数，
比如n = 6，那么以1,2,3,4,5,6开头的组合必然是各有(n-1)! = 5! = 120种组合。
我们认为组数应该从0开始，那么k要-1;


注意此时K = 299，那么我们先要求解这个k在第几组，k/(n-1)! = 299/120 = 2,也就是说k应该在第
3组(注意组号从0开始)，第三组的首个数字应该是3。这样第一个数字就确定了。

确定第2个数字的时候，注意这个时候，k应该等于k % 120 = 59,为什么要这么算呢，因为每个组有120个数字，
而且k在第三组，那么前两组加起来是240，k在第二次循环的时候，应该是从(5-1)!中确定是属于哪个组，其实
就是确定k在第三组中是属于哪个位置。这个时候59/24 = 2,确定应该是属于第三组，
因为在上一步中，3已经用过了，所以这个时候的5个数字是1,2,4,5,6，
所以第三组的首个数字是4，依次类推，一直到n个数字全部算完为止。

不明白1！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
正确的版本！！！下面
public String getPermutation(int n, int k) {  
        k--;//to transfer it as begin from 0 rather than 1
        
        List<Integer> numList = new ArrayList<Integer>();  
        for(int i = 1; i<= n; i++)
            numList.add(i);
       
        int factorial = 1;    
        for(int i = 2; i < n; i++)  
            factorial *= i;    
        
        StringBuilder res = new StringBuilder();
        int times = n-1;
        while(times>=0){
            int indexInList = k/factorial; //找到当前k在indexInList中的第几位 加入进去 并删除它 
            res.append(numList.get(indexInList));  
            numList.remove(indexInList);  
            
            k = k%factorial;//new k for next turn    ？？？？？？？？？？
            if(times!=0)
                factorial = factorial/times;//new (n-1)!
            
            times--;
        }
        
        return res.toString();
    }
	
For n = 3, all permutations are listed as follows:

"123"
"132"
"213"
"231"
"312"
"321"
If k = 4, the fourth permutation is "231"

k-- k = 3
numList:123
factorial = 2 
times = 2 
indexInList = 3/2 = 1 
res.append(2 )
numList:13 
k = 3%2 = 1 
times = 2  !=0
factorial = 2/2 = 1 
times = 1 
1 >= 0
 


	
	
	
	
	
	dfs  超时！！！！！！！！！！！！！！！！！！！！！！！
	
	得到所有  get第k个
	
public class Solution {
    public String getPermutation(int n, int k) {
        ArrayList<String> list = new ArrayList<String>();
        for(int i = 1; i <= n; i++){
            StringBuffer sb = new StringBuffer(i);
            int visit[] = new int[n+1];
            visit[i] = 1;
            sb.append(i);
            int num = 1;
            dfs(list,visit,sb,n,num);
        }
        return list.get(k-1);
    }
    public void dfs(ArrayList<String> list, int visit[], StringBuffer sb, int n, int num){
        if(num == n){
            list.add(sb.toString());
        }
        for(int i = 1; i <= n; i++){
            if(visit[i] == 0){
                StringBuffer tempSb = new StringBuffer(sb);
                tempSb.append(i);
                visit[i] = 1;
                dfs(list,visit,tempSb,n,num+1);
                visit[i] = 0;
            }
        }
    }
}



只count到k也超时
public class Solution {
    public int count ;
    public String result;
    public String getPermutation(int n, int k) {
        count = 0;
        result = "";
        for(int i = 1; i <= n; i++){
            StringBuffer sb = new StringBuffer(i);
            int visit[] = new int[n+1];
            visit[i] = 1;
            sb.append(i);
            int num = 1;
            dfs(visit,sb,n,num,k);
        }
        return result;
    }
    public void dfs(int visit[], StringBuffer sb, int n, int num, int k){
        if(num == n){
            count ++;
            if(count == k){
                result = sb.toString();
                return;
            }
        }
        for(int i = 1; i <= n; i++){
            if(visit[i] == 0){
                StringBuffer tempSb = new StringBuffer(sb);
                tempSb.append(i);
                visit[i] = 1;
                dfs(visit,tempSb,n,num+1,k);
                visit[i] = 0;
            }
        }
    }
}



	
	