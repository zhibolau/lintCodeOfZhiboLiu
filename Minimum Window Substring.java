Minimum Window Substring

从字符串中找到包含target最短的那个字符串 只要有就行 不用顺序一样

public String minWindow(String S, String T) {
    String res = "";
    if(S == null || T == null || S.length()==0 || T.length()==0)
        return res;
    /*
		在实现中就是维护一个HashMap，一开始key包含字典中所有字符，value就是该字符的数量，
		然后遇到字典中字符时就将对应字符的数量减一。
	*/
    HashMap<Character, Integer> dict = new HashMap<Character, Integer>();//integer  是出现次数
    for(int i =0;i < T.length(); i++){
        if(!dict.containsKey(T.charAt(i)))
            dict.put(T.charAt(i), 1);
        else
            dict.put(T.charAt(i), dict.get(T.charAt(i))+1);
    }
    
    int count = 0;//是用来看当前走了几个字符了 若与target长度一样就检查 记录是不是当前已经达到目标长度
    int pre = 0;
    int minLen = S.length()+1;
    for(int i=0;i<S.length();i++){
        if(dict.containsKey(S.charAt(i))){
            dict.put(S.charAt(i),dict.get(S.charAt(i))-1);//更新hm 看此字符还剩几个没visit了
            if(dict.get(S.charAt(i)) >= 0)
                count++;
                
            while(count == T.length()){
                if(dict.containsKey(S.charAt(pre))){
                    dict.put(S.charAt(pre),dict.get(S.charAt(pre))+1);
                    
                    if(dict.get(S.charAt(pre))>0){//target中charAt(pre)出现次数大于0 进入for是target中的字符出现了，
											//	若count== T.length() 说明 当前字符的pre字符也出现在target中了 也就是target出现了！！！
                        if(minLen>i-pre+1){//若minLen比当前找到的还长 所以更新minLen
                            res = S.substring(pre,i+1);//pre其实是在当前i前边那个字符
							//substring都是小写！！！！
                            minLen = i-pre+1;
                        }
                        count--;//用完S.charAt(pre) 就把count降1 
                    }
                }
                pre++;//hm无pre pre就向右移动
            }
        }//end for if(dict.containsKey(S.charAt(i)))
    }
    return res;
}


