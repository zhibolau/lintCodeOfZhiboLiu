Anagrams
看看这个array中那个str不是anagram来的

Given an array of strings, return all groups of strings that are anagrams.

All inputs will be in lower-case

Given ["lint", "intl", "inlt", "code"], return ["lint", "inlt", "intl"].

Given ["ab", "ba", "cd", "dc", "e"], return ["ab", "ba", "cd", "dc"].

public ArrayList<String> anagrams(String[] strs) {
     ArrayList<String> result=new ArrayList<String>();
     
     if (strs==null||strs.length==0)
         return result;
     
     HashMap<String,ArrayList<String>> hm = new HashMap<String, ArrayList<String>>();
     
     for (String s:strs){
         char[] temp=s.toCharArray();
         Arrays.sort(temp);// 每个string都换成 char[] 再sort 若是变形词就会变成一样的 like 从abc bac 都会变成 abc
         String tempStr=new String(temp);//又从char[]换成string了
         
         if (hm.containsKey(tempStr)){// containsKey!!!!!!!!!!!!!!!!!!!!
             if(hm.get(tempStr).size() == 1){
				 //若已经有一个数了 就把它放入res 因为第一次只是把它放入了tempList！！！！！！！！！！
				result.add(hm.get(tempStr).get(0));
			 }
             hm.get(tempStr).add(s);
             result.add(s);
         }else{
             ArrayList<String> tempList=new ArrayList<String>();
             tempList.add(s);//s还是原来顺序那个词 
             hm.put(tempStr, tempList);// HASHMAP用来记录排序过后的那个string跟 加入s后的那个tempList 之后再把string从tempList中加入到res中
             }
        }
        return result;
 }
 
 
 这道题看所给的字符串数组里面有多少个是同一个变形词变的。这道题同样使用HashMap来帮助存老值和新值，以及帮忙判断是否是变形词。

首先对每个string转换成char array然后排下序，HashMap里面的key存sort后的词，value存原始的词。然后如果这个排好序的词没在HashMap中出现过，
那么就把这个sorted word和unsortedword put进HashMap里面。如果一个sorted word是在HashMap里面存在过的，说明这个词肯定是个变形词，
除了把这个词加入到返回结果中，还需要把之前第一个存进HashMap里面的value存入result中。


public class Solution {
    /*
     * @param strs: A list of strings
     * @return: A list of strings
     */
    private int getHash(int[] count) {//计算一个int数组的hashcode
        int hash = 0;
        for (int i : count) {
            hash = hash * 33 + i;
        }
        return hash;
    }
    public List<String> anagrams(String[] strs) {
        // write your code here
        List<String> rst = new ArrayList<String>();
        if (strs == null || strs.length == 0) {
            return rst;
        }
        Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();//里面放的是当前数组的hash值 与对应的数组
        for (String s : strs) {//str由26个字母组成的
            int[] count = new int[26];
            for (int i = 0; i < s.length(); i++) {
                count[s.charAt(i) - 'a']++;//把此str的各个字符放入count数组中 准备计算hash
            }
            int hash = getHash(count);
            if (!map.containsKey(hash)) {
                map.put(hash, new ArrayList<String>());
            }
            map.get(hash).add(s);
        }
        for (List<String> temp : map.values()) {
            if (temp.size() > 1) {//只有一个不是anagram的str
                rst.addAll(temp);
            }
        }
        return rst;
    }
}

