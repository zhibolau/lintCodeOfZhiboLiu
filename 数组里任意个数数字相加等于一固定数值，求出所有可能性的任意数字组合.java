/**
* 
* @param arr
* 数组
* @param num
* 固定值
* @return 组合
*/
public static List a(int[] arr, int num) {
	List strList = new ArrayList();
	for (int i = 0; i < arr.length; i++) {
		int all = i;
		String str = i + ",";
		for (int j = 0; j < arr.length; j++) {
			all += j;
			str += j + ",";
			if (all == num) {
			strList.add(str);
			}
		}
	}
return strList;
}