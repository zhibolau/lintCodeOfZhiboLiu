/**
 * Definition of Interval:
 * public class Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */

class Solution {
    /**
     * @param intervals: Sorted interval list.
     * @return: A new sorted interval list.
     */
     private class IntervalComparator implements Comparator<Interval> {
		public int compare(Interval a, Interval b) {
			return a.start - b.start;
		}
	}
    public List<Interval> merge(List<Interval> intervals) {
        // write your code here
        List<Interval> rst = new ArrayList<Interval>();//Interval要大写！！！
    	if (intervals == null || intervals.size() == 0) {
    		return rst;
    	}
		//排序过后 若第一个区间的末尾比第二个区间的开始大的话 说明有重叠 更新end
    	Collections.sort(intervals, new IntervalComparator());// 得有new这里
    	Interval last = intervals.get(0);
    	for (int i = 1; i < intervals.size(); i++) {
    		Interval cur = intervals.get(i);
    		if (last.end >= cur.start) {
    			last.end = Math.max(last.end, cur.end);//此时没加入到rst是因为可能与后面的还有重叠 所以要在走完for之后再加入rst
    		} else {
    			rst.add(last);//加入的是last 下边last会变成cur 所以不用考虑cur
    			last = cur;
    		}
    	}
    	rst.add(last);
    	return rst;
    }

}