public class Solution {
    /**
      * @param start, a string
      * @param end, a string
      * @param dict, a set of string
      * @return an integer
      */
    public int ladderLength(String start, String end, Set<String> dict) {
        
        if(start==null || end==null || start.length()==0 || end.length()==0 || start.length()!=end.length())  
        return 0; 
        
        LinkedList<String> wordQueue = new LinkedList<String>();
        int level = 1; //the start string already count for 1
        int curnum = 1;//the candidate num on current level 当前有一个num要被替换字母 //有可能当前字母替换会有两个或多个与dict中单词一样
        int nextnum = 0;//counter for next level 下一层中有几个单词要替换
        
        wordQueue.add(start);
		
		if(start.equals(end)){
            return level;
        }
		
		
        
        while(!wordQueue.isEmpty()){
            String word = wordQueue.poll();
            curnum--;// 拿出去一个word 所以当前层单词数减一
            
            for(int i = 0; i < word.length(); i++){
                char[] wordunit = word.toCharArray();//对于word字符串中每个字符进行处理
                for(char j = 'a'; j <= 'z'; j++){
                    wordunit[i] = j;//换字母 挨个换
                    String temp = new String(wordunit);  //替换字符后的新字符串 看看 字典中有否
                    
                    if(temp.equals(end))
                        return level+1;
                    if(dict.contains(temp)){
                        wordQueue.add(temp);
                        nextnum++;//找到一个一眼的 所以下层要处理的也要多一个 因为也要把这个替换 还未到end
                        dict.remove(temp);
                    }
                }
            }
            //next level时 只是level增加了 其余俩数未变
            if(curnum == 0){//当前层处理完了 就要处理下一层了 所以替换值 更新各值
                curnum = nextnum;
                nextnum = 0;
                level++;
            }
        }
        
        return 0;
    }
    
}

题解：

 这道题是套用BFS同时也利用BFS能寻找最短路径的特性来解决问题。

 把每个单词作为一个node进行BFS。当取得当前字符串时，对他的每一位字符进行从a~z的替换，如果在字典里面，就入队，并将下层count++，并且为了避免环路，
 需把在字典里检测到的单词从字典里删除。这样对于当前字符串的每一位字符安装a~z替换后，在queue中的单词就作为下一层需要遍历的单词了。

 正因为BFS能够把一层所有可能性都遍历了，所以就保证了一旦找到一个单词equals（end），那么return的路径肯定是最短的。

 

 像给的例子 start = hit，end = cog，dict = [hot, dot, dog, lot, log]

 按照上述解题思路的走法就是：

  level = 1    hit   dict = [hot, dot, dog, lot, log]

         ait bit cit ... xit yit zit ，  hat hbt hct ... hot ... hxt hyt hzt ，  hia hib hic ... hix hiy hiz

 

  level = 2    hot  dict = [dot, dog, lot, log]

         aot bot cot dot ...  lot ... xot yot zot，hat hbt hct ... hxt hyt hzt，hoa hob hoc ... hox hoy hoz

 

  level = 3    dot lot  dict = [dog log]

         aot bot ... yot zot，dat dbt ...dyt dzt，doa dob ... dog .. doy doz，

         aot bot ... yot zot，lat lbt ... lyt lzt，loa lob ... log... loy loz

 

  level = 4   dog log dict = [] 

         aog bog cog

 

  level = 5   cog  dict = []
  
  
  
  http://www.cnblogs.com/springfor/p/3893499.html
  
  
  
  
  
  public class Solution {
    /**
      * @param start, a string
      * @param end, a string
      * @param dict, a set of string
      * @return an integer
      */
    public int ladderLength(String start, String end, Set<String> dict) {
        if(start.length() <= 0 || end.length() <= 0 || start == null || end == null || dict.size() < 0 || start.length() != end.length()){
            return 0;
        }
        int level = 1;
        int curNum = 1;
        int nextNum = 0;
        
        LinkedList<String> wordQueue = new LinkedList<String>();
        wordQueue.add(start);
        
		if(start.equals(end)){
            return level;
        }
		
		
        while(!wordQueue.isEmpty()){
            String word = wordQueue.poll();
            curNum--;
            
            for(int i = 0; i < word.length(); i++){
                char[] wordUnit = word.toCharArray();
                for(char j = 'a'; j < 'z'; j++){
                    wordUnit[i] = j;
                    String temp =new String(wordUnit);
                    
                    if(temp.equals(end)){// string 相等 不能用 ==
                        return level + 1;
                    }
                    else{
                        if(dict.contains(temp)){
                            wordQueue.add(temp);
                            nextNum++;
                            dict.remove(temp);
                        }
                    }
                }
            }//当前层单词处理结束 这是看 下边数值是否更新
                
            if(curNum == 0){
                curNum = nextNum;
                nextNum = 0;
                level++;
            }
        }
        
        return 0;
    }
}




  
  