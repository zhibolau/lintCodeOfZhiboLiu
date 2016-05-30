Two Strings Are Anagrams
看看两个 str是不是Anagrams： 有变换字母顺序得到的新词
就看两个str的hash code一样不

Write a method anagram(s,t) to decide if two strings are anagrams or not.


Given s="abcd", t="dcab", return true.

public class Solution {
    /**
     * @param s: The first string
     * @param b: The second string
     * @return true or false
     */
    private int getHash(String str) {
        int[] count= new int[256];
        for (char c : str.toCharArray()) {//别忘记转换成charArray
            count[c]++;//每个对应的char count数字+1
        }
        int hash = 0;
        for (int i : count) {//每个元素有自己对应的hash code
            hash = hash * 33 + i;
        }
        return hash;
    }
    public boolean anagram(String s, String t) {
        // write your code here
        return getHash(s) == getHash(t);
    }
};