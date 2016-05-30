这道题就是给你一个2D平面，然后给你的数据结构是由横纵坐标表示的点，然后看哪条直线上的点最多。


/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    /**
     * @param points an array of point
     * @return an integer
     */
    private boolean isSame(Point a, Point b) {
		return a.x == b.x && a.y == b.y;
	}
    public int maxPoints(Point[] points) {
        // Write your code here
        if (points == null || points.length == 0) {
        	return 0;
        }
		//用double integer map建立 斜率 count hashmap
        //查看有几个点坐标一样的isSame dup从1开始计数
        //max为最终结果
		
		
        Map<Double, Integer> map = new HashMap<Double, Integer>();
        int max = 0;//记录在一条线的点数
        for (int i = 0; i < points.length; i++) {
        	map.clear();//The clear() method is used to remove all of the mappings from this map
        	int dup = 1;//ab两点是同一点的数  是不是相同的 若有就是两个  所以初始值为1 !!!!!!!!!!!!!!!!!!!!!!!!!
			//dup在这里 是因为 每次i变化 就从新看dup的值了  所以不能在外面声明！！！
        	for (int j = i + 1; j < points.length; j++) {
        		if (isSame(points[i], points[j])) {
        			dup++;
        		}
        	}
        	for (int j = i + 1; j < points.length; j++) {
        		if (isSame(points[i], points[j])) {
        			continue;
        		}
        		double key = (points[j].x == points[i].x) ? Integer.MAX_VALUE : 0.0 
				//x坐标同 那肯定在一条直线上！！！！  所以把key都设为Integer.MAX_VALUE同一个数
				// 不同的话就看斜率 斜率同也在同一条直线上
							+ (double)(points[j].y - points[i].y) / (double)(points[j].x - points[i].x);//斜率
        		if (!map.containsKey(key)) {
        			map.put(key, dup + 1);
        		} else {
        			map.put(key, map.get(key) + 1);
        		}
        	}
        	if (map.values() == null || map.values().size() == 0) {
        		max = Math.max(max, dup);
        	} else {
        		for (int temp : map.values()) {
        			max = Math.max(max, temp);
        		}
        	}
        }
        return max;
    }
}



不好理解！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
与之一样的点
与之相同斜率的点 包括 x左边一样  y坐标一样 倾斜度一样！

用可能形成多条线 看那个线上点多！！！
所以对于每个点都得看他与其他点是否是上述两种情况 更新 max

