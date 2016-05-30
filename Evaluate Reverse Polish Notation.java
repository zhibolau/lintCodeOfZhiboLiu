public static int evalRPN(String[] tokens) {
        if(tokens==null||tokens.length==0)// string[]  用的是length  不是 length（）
            return 0;
        int ans = 0;//用来更新答案的 
        Stack<Integer> res = new Stack<Integer>();
        for(int i = 0; i<tokens.length;i++){
            ans = 0;//必须  因为每次都用 b来获取当前值 a为上次ans值 所以得把当前ans reset为0 来记录这次的ans
            if(tokens[i].equals("/")||tokens[i].equals("*")||tokens[i].equals("+")||tokens[i].equals("-")){
                int b = res.pop();
                int a = res.pop();
                if(tokens[i].equals("/"))
                    ans += a/b;
                else if(tokens[i].equals("+"))
                    ans += a+b;
                else if(tokens[i].equals("-"))
                    ans += a-b;
                else if(tokens[i].equals("*"))
                    ans += a*b;
                res.push(ans);
            }else{
                res.push(Integer.parseInt(tokens[i]));// 要注意 tokens中为string  stack中要加入int 所以要parse
            }
        }
        return res.pop();
    }
	
	
	若 不是运算符 就把数字加入stack 遇到运算符 就判断其种类 
	对其进行对应计算 更新 answer 加入到res 最后stack最上边就是答案