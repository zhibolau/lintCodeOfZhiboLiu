
class Pair {
    String key;
    int value;
    
    Pair(String key, int value) {
        this.key = key;
        this.value = value;
    }
}

public class Solution {
    /**
     * @param words an array of string
     * @param k an integer
     * @return an array of string
     */
     //先按照出现次数比较，若一致就按照字母顺序比较
    private Comparator<Pair> pairComparator = new Comparator<Pair>() {
        public int compare(Pair left, Pair right) {
            if (left.value != right.value) {
                return left.value - right.value;
            }
            return right.key.compareTo(left.key); //字母顺序比较
        }
    };
    
    public String[] topKFrequentWords(String[] words, int k) {
        if (k == 0) {
            return new String[0];
        }
        
        HashMap<String, Integer> counter = new HashMap<>();
        for (String word : words) {
            if (counter.containsKey(word)) {
                counter.put(word, counter.get(word) + 1);
            } else {
                counter.put(word, 1);
            }
        }
//PQ已经排序好 根据 string出现次数排序 从少到多排列 所以最后要reverse一下 让出现次数多的在前面
    PriorityQueue<Pair> Q = new PriorityQueue<Pair>(k, pairComparator);
            for (String word : counter.keySet()) {//对于每个key来说  此时word就是一个变量名字 要声明类型
                Pair peak = Q.peek();// 找到当前Q的第一个节点 
                Pair newPair = new Pair(word, counter.get(word)); //建一个当前key的pair
                if (Q.size() < k) { //若还没找到需要的k个 就把新的pair加入
                    Q.add(newPair);
                } 
                //已经有k个了 但是当前的比头结点出现次数多，就把头结点删除，加入当前节点
                else if (pairComparator.compare(newPair, peak) > 0) {
                    Q.poll();
                    Q.add(new Pair(word, counter.get(word)));
                }
            }

    String[] result = new String[k];//建一个有k个string的string 组
    int index = 0;
    while (!Q.isEmpty()) {
        //只要Q不空 就把q中的key放入result中  其实是次数少的在前面 因为PQ按从大到小排序
        result[index++] = Q.poll().key;
    }
    
    // reverse
    for (int i = 0; i < index / 2; i++) {
        String temp = result[i];
        result[i] = result[index - i - 1];
        result[index - i - 1] = temp;
    }
    
    return result;
 }
}



class Pair{
    String key;
    int value;
    Pair(String key, int value){
        this.key = key;
        this.value = value;
    }
}
public class Solution {
    /**
     * @param words an array of string
     * @param k an integer
     * @return an array of string
     */
    private Comparator<Pair> pairComparator = new Comparator<Pair>(){
        public int compare(Pair left, Pair right){
            if(left.value != right.value){
                return left.value - right.value;
            }
            //大于0 的话 left放在right的右边
            return right.key.compareTo(left.key);//必须这么写
            /*
            The value 0 if the argument is a string lexicographically equal to this string; 
            a value less than 0 if the argument is a string lexicographically greater than 
            this string; and a value greater than 0 if the argument is a string 
            lexicographically less than this string.
            */
            //默认的是 baby yes按字母顺序排列 但是我们result中要reverse
            //所以PQ中要存成相反顺序 也即是要存成yes baby 所以要right与left比
        }
    };
    public String[] topKFrequentWords(String[] words, int k) {
        // Write your code here
        if(k == 0){
            return new String[0];
        }
        HashMap<String, Integer> counter = new HashMap<String, Integer>();
        for (String word : words){ //此时word就是一个变量名字
            if(counter.containsKey(word)){
                counter.put(word, counter.get(word) + 1);
            }
            else{
                counter.put(word, 1);
            }
        }
        PriorityQueue<Pair> Q = new PriorityQueue<Pair>(k, pairComparator);
        for(String word : counter.keySet()){
            Pair peak = Q.peek();
            Pair newPair = new Pair(word, counter.get(word));
            if(Q.size() < k){
                Q.add(newPair);
            }
            else if(pairComparator.compare(newPair, peak) > 0){
                Q.poll();
                Q.add(newPair);//还是要 new Pair》？？？？？？？？？ 不用非得再new一个 已测试
            }
        }
        
        String[] result = new String[k];
        int index = 0;
        while( !Q.isEmpty()){
            result[index++] = Q.poll().key;
        }
        //此时index等于k
        for( int i = 0; i < index/2; i++){
            String temp = result[i];
            result[i] = result[index - i - 1];
            result[index - i - 1] = temp;
        }
        return result;
    }
}