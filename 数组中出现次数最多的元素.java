

//O（N^2)
public int getPopularElement(int[] a)
{
  int count = 1, tempCount;
  int popular = a[0];
  int temp = 0;
  for (int i = 0; i < (a.length - 1); i++)
  {
    temp = a[i];
    tempCount = 0;
    for (int j = 1; j < a.length; j++)
    {
      if (temp == a[j])
        tempCount++;
    }
    if (tempCount > count)
    {
      popular = temp;
      count = tempCount;
    }
  }
  return popular;
}



//o(N LOGN)

public int findPopular(int[] a) {

    if (a == null || a.length == 0)
        return 0;

    Arrays.sort(a);

    int previous = a[0];
    int popular = a[0];
    int count = 1;
    int maxCount = 1;

    for (int i = 1; i < a.length; i++) {
        if (a[i] == previous)
            count++;
        else {
            if (count > maxCount) {
                popular = a[i-1];
                maxCount = count;
            }
            previous = a[i];
            count = 1;
        }
    }

    return count > maxCount ? a[a.length-1] : popular;

}




import java.util.*;  
public class TestMain {  
    private static HashMap<String, Integer> map;  
    public static HashMap<String, Integer> mostEle(String[] strArray) {  
       map = new HashMap<String, Integer>();  
       String str = "";  
       int count = 0;  
       int result = 0;  
       for (int i = 0; i < strArray.length; i++)  
           str += strArray[i];  
       for (int i = 0; i < strArray.length; i++) {  
           String temp = str.replaceAll(strArray[i], "");  
           count = (str.length() - temp.length()) / strArray[i].length();  
           if (count > result) {  
              map.clear();  
              map.put(strArray[i], count);  
              result = count;  
           } else if (count == result)  
              map.put(strArray[i], count);  
       }  
       return map;  
    }  
    public static void main(String args[]) {  
       String[] strArray = { "11", "11", "2", "2", "4", "5", "4" };  
       HashMap<String, Integer> result = mostEle(strArray);  
       ArrayList<Integer> c = new ArrayList<Integer>(result.values());  
       Set<String> s = result.keySet();  
       System.out.print("一共有" + result.size() + "元素最多。它们分别是");  
       System.out.print(s);  
       System.out.println("，分别出现了" + c.get(0) + "次。");  
    }  
}



public class TestMain {  
public static void main(String[] args) {  
    Object array[]={1,2,3,4,5,6,23,12,12};//建立数组存放取出状态的时间  
    Set<Object> s = new HashSet<Object>();// HashSet用来去掉重复  
    for (Object o : array) {  
       s.add(o);  
    } // 现在的集合s中无重复的包含array中的所有元素  
    Object[] obj = s.toArray();// 把集合s中的元素存入数组obj2中  
    int[] n = new int[obj.length];// 这个数组用来存放每一个元素出现的次数  
    int max = 0;  
    for (int i = 0; i < obj.length; i++) {  
       int cout = 0;  
       for (int j = 0; j < array.length; j++) {  
           if (obj[i].equals(array[j]))  
              cout++;  
           // 用obj中的元素跟array中的每一个比较，如果相同cout自增  
       }  
       n[i] = cout;// 每一个元素出现的次数存入数组n  
                  // 数组n的下标i跟数组obj的下标是一一对应的。  
       if (max < cout) {// 得到元素出现次数最多是多少次  
           max = cout;  
       }  
    }  
    for (int i = 0; i < n.length; i++) {  
       if (max == n[i]) {  
           // 如果出现的次数等于最大次数，就输出对应数组obj中的元素  
           System.out.println("最多的数是"+obj[i]);  
       }  
    }  
}  
}

