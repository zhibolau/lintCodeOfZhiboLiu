public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
     class Pair implements Comparable<Pair>{
         int value;
         int index;
         public Pair(int v, int i){//用来存储 value 跟 index的结构
             value = v;
             index = i;
         }
         public int compareTo(Pair other){ //用来sort用的
             return this.value - other.value;
         }
     }
    public int[] subarraySumClosest(int[] nums) {
        // write your code here
        int[] res = new int[2];//用来存储结果
        int len = nums.length;
        if(nums == null || len == 0){
            return res;
        }
        
        Pair[] pair = new Pair[len + 1];
        pair[0] = new Pair(0, -1);//建这个是因为 pair[1]有可能本身就是最接近0，没这个就会把pair[1]忘记了
        int sum = 0;
        for(int i = 0; i < len; i++){
            sum = sum + nums[i];
            pair[i+1] = new Pair(sum, i);//把所有元素都放入pair数组中 每个元素有对应的 sum跟index
        }
        Arrays.sort(pair);//按照value大小排好，
        int min = Math.abs(pair[0].value - pair[1].value);//用abs 是因为 -1 跟1 都同样滴接近0
        int start = Math.min(pair[0].index, pair[1].index) + 1;/*最开始自己建立了一个pair[0] = new Pair(0, -1);  若第一个是最近接0，index不能是-1，所以得+1 ？？？？？？？？？？？？？？？？？？？？？？？？？？？
        */
        int end = Math.max(pair[0].index, pair[1].index);
        
        for(int i = 1; i < len; i++){//上面从i=0开始的 所以此时从1开始
            int diff = Math.abs(pair[i].value - pair[i+1].value);
            if(diff < min){//只要diff比当前min小 min就更新
                min = diff;
                start = Math.min(pair[i].index, pair[1+i].index) + 1;
                end = Math.max(pair[i].index, pair[1+i].index);
            }
        }
        
        res[0] = start;
        res[1] = end;
        return res;
        
    }
}





s[i] = nums[0]+....nums[i], also record the index i into s[i]. Sort array s, and the minimum difference between two consecutive element, is the the subarray.


首先建立一个pair类，便于记录前n项和与对应的index。因为后面要对sum数组排序，结果又要返回index
loop一遍有序的sum数组，维护一个Closest变量，有更小的就更新


要是 ArrayList<Integer>  就这么写！！！！！！！！！！！！

class Element implements Comparable<Element>{
    int val;
    int index;
    public Element(int v, int i){
        val = v;
        index = i;
    }

    public int compareTo(Element other){
        return this.val - other.val;
    }

    public int getIndex(){
        return index;
    }

    public int getValue(){
        return val;
    }
}

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySumClosest(int[] nums) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (nums.length==0) return res;

        Element[] sums = new Element[nums.length+1];
        sums[0] = new Element(0,-1);
        int sum = 0;
        for (int i=0;i<nums.length;i++){
            sum += nums[i];
            sums[i+1] = new Element(sum,i);
        }

        Arrays.sort(sums);
        int min = Math.abs(sums[0].getValue() - sums[1].getValue());
        int start =  Math.min(sums[0].getIndex(), sums[1].getIndex())+1;
        int end = Math.max(sums[0].getIndex(), sums[1].getIndex());
        for (int i=1;i<nums.length;i++){
            int diff = Math.abs(sums[i].getValue() - sums[i+1].getValue());
            if (diff<min){
                min = diff;
                start = Math.min(sums[i].getIndex(), sums[i+1].getIndex())+1;
                end  = Math.max(sums[i].getIndex(), sums[i+1].getIndex());
            }
        }

        res.add(start);
        res.add(end);
        return res;
    }
}

