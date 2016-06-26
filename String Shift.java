input: String, key(int value), e.g. input: "aAa！"， key = 3, return "dDd!"



public String shift(String s, int key) {
                String res = "";
                for (int i = 0; i < s.length(); i++) {
                        char c = s.charAt(i);
                        if (c >= 'a' && c <= 'z') {
                                res = res + (char) ((c - 'a' + key) % 26 + 'a');
                        } else if (c >= 'A' && c <= 'Z') {
                                res = res + (char) ((c - 'A' + key) % 26 + 'A');
                        } else {
                                res = res + c;
                        }
                }
                return res;
        } 















public static String shift(String s) { 
                // 把所有字符串都转成以a开头的,+26是为了防止c - s.charAt(0)为负数
                for (int i = 0; i < s.length(); i++) { 
                        char c = s.charAt(i);
                        char cc = (char) ((c - s.charAt(0) + 26) % 26 + 'a');
                        res = res + cc; 
                }
                return res; 
        }
如果都是小写字母的话








		
		




public String shift(String s, int key)
{
                StringBuilder sb = new StringBuilder(adc);  
                
                for(int i =0; i < sb.length();i++)
                {
                        sb.setCharAt(i,(char)(adc.charAt(i) + 3%26));
					 // sb.setCharAt(i,(char)(adc.charAt(i) + (（26+key)%26)));
                } 

return sb.toString(); 
}