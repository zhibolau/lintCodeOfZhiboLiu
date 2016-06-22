
这道题就把原来N个字符串连成一个字符串，然后还能把一整个字符串变回原来的N个字符串就OK了

复杂度
时间 O(N) 空间 O(1)

思路
本题难点在于如何在合并后的字符串中，区分出原来的每一个子串。这里我采取的编码方式，
是将每个子串的长度先赋在前面，然后用一个#隔开长度和子串本身。这样我们先读出长度，
就知道该读取多少个字符作为子串了。

注意
为了简化代码，这里使用了indexOf和substring这两个属于String的API，实际上复杂度和遍历是一样的。
public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder output = new StringBuilder();
        for(String str : strs){
            // 对于每个子串，先把其长度放在前面，用#隔开
            output.append(String.valueOf(str.length())+"#");
            // 再把子串本身放在后面
            output.append(str);
        }
        return output.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new LinkedList<String>();
        int start = 0;
        while(start < s.length()){
            // 找到从start开始的第一个#，这个#前面是长度
            int idx = s.indexOf('#', start);
            int size = Integer.parseInt(s.substring(start, idx));
            // 根据这个长度截取子串
            res.add(s.substring(idx + 1, idx + size + 1));
            // 更新start为子串后面一个位置
            start = idx + size + 1;
        }
        return res;
    }
}


