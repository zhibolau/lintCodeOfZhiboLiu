class TrieNode {     // Initialize your data structure here.  
     public TrieNode[] next;   
     public char value;    
     public boolean isWordEnd; //该字符是一个结尾字符
 
	public TrieNode() { //默认根结点       
	 value = ' ';     //此地必须有空格 代表空字符  
	 next = new TrieNode[26];       
	 isWordEnd = false;     
	}  
	
	 public TrieNode(char c){       
		 value = c;         
		 next = new TrieNode[26];        
		 isWordEnd = false;  
	 } 
	 
	/*  public TrieNode(char c, boolean endFlg){     
		 value = c;        
		 next = new TrieNode[26];       
		 isWordEnd = endFlg;   
	}    */     //下边干脆没用上
 
 } 

public class WordDictionary {     
	private TrieNode root; 
	
	public WordDictionary() {        //有（）
		root = new TrieNode();     
	}     // Adds a word into the data structure.    
		
		
	public void addWord(String word) {        
		TrieNode tmpRoot = root;        
		for(int i = 0; i < word.length(); i++){             
			char c = word.charAt(i);
            
			if(tmpRoot.next[c - 'a'] == null){   //若那位置是空 就new一个以c为内容的trieNode              
				tmpRoot.next[c - 'a'] = new TrieNode(c);               
			} 
			//那个地方有东西 就把root挪位置  root要挪动到当前字母位置 因为将来要从这个位置开始加入新字母
			tmpRoot = tmpRoot.next[c - 'a'];         
		}
		
		tmpRoot.isWordEnd = true;             
	}      // Returns if the word is in the data structure. A word could    
        // contain the dot character '.' to represent any one letter.     
	

	public boolean search(String word) {      
		 int idx = 0;       
		 TrieNode tmpRoot = root;        
		 return search(word, idx, tmpRoot);            
	}         
	 
	 public boolean search(String word, int idx, TrieNode tmpRoot){       
	 if(tmpRoot == null) return false;        
	 if(idx == word.length() && tmpRoot.isWordEnd) 
		return true;    
	
	 if(idx >= word.length()) 
		 return false;     
	 
	 char c = word.charAt(idx);                
		 if(c == '.'){           
			 boolean result = false;        
			 for(int i = 0; i < 26; i++){         
				if(null != tmpRoot.next[i]){      
//c已经与word第一个字符一样了 所以从idx+1开始找！！！！！！！！！！！！！！				
					result = search(word, idx + 1, tmpRoot.next[i]); // . 可以表示任何一个字符       
					//tmpRoot.next[i]表示root的26个孩子  从下一个idx中找与26个孩子是否一致  
					if(result) 
						return result;             
				}            
			 }           
			return result;      
		 }
		 else{          
		 //c已经与word第一个字符一样了 所以从idx+1开始找！！！！！！！！！！！！！！
			return search(word, idx + 1, tmpRoot.next[c - 'a']);   //从距离a那么远的字符找起 
		 }     
	 }
} 
 
 
 // Your WordDictionary object will be instantiated and called as such: 
 // WordDictionary wordDictionary = new WordDictionary(); 
 // wordDictionary.addWord("word"); // wordDictionary.search("pattern");
 