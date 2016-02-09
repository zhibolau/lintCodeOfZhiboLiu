Trie树，又称为字典树、单词查找树或者前缀树，是一种用于快速检索的多叉数结构。例如，英文字母的字典树是26叉数，数字的字典树是10叉树。 
Trie树的基本性质有三点，归纳为：

根节点不包含字符，根节点外每一个节点都只包含一个字符。
从根节点到某一节点，路径上经过的字符连接起来，为该节点对应的字符串。
每个节点的所有子节点包含的字符串不相同。

class TrieNode {
    private TrieNode[] children;
    public boolean hasWord;
    
    // Initialize your data structure here.
    public TrieNode() {
        children = new TrieNode[26];//每个trieNode会有一个可以放26个trieNode的数组的孩子  好像英语字典一样
        hasWord = false;
    }
    
    public void insert(String word, int index) { //下边传进来的都是从0开始的
		//？？？？？？？？？？？？不理解 这句话
        if (index == word.length()) {//若在当前word后边插入 那么当前word就被包含了 没被拆开
            this.hasWord = true;
            return;
        }
        
        int pos = word.charAt(index) - 'a';
		//每个孩子都可以是从a到z的字符 所以看距离a多远 那个位置没东西就new  有就加在下一个地方
		
        if (children[pos] == null) {
            children[pos] = new TrieNode();
        }
        children[pos].insert(word, index + 1);
    }
    
    public TrieNode find(String word, int index) {
        if (index == word.length()) {
            return this;
        }
        //同理
        int pos = word.charAt(index) - 'a';
        if (children[pos] == null) {
            return null;
        }
        return children[pos].find(word, index + 1);
    }
}

public class Solution {
    private TrieNode root;

    public Solution() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        root.insert(word, 0);
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = root.find(word, 0);
        return (node != null && node.hasWord);
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode node = root.find(prefix, 0);
        return node != null; //prefix不一定是一样的单词  不是 找word 不必一样 包含就行
    }
}