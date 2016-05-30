/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */

class Solution {
    /**
     * @param intervals: An interval array
     * @return: Count of airplanes are in the sky.
     */
    public int countOfAirplanes(List<Interval> airplanes) { 
        // write your code here
        if(airplanes == null || airplanes.size() == 0){
            return 0;
        }
        int max = 0;
        Map<Integer, Integer> hs = new HashMap<Integer, Integer>();
        for(Interval a : airplanes){
            for(int i = a.start; i < a.end; i++){
                if(hs.containsKey(i)){
                    hs.put(i, hs.get(i)+1);
                }
                else{
                    hs.put(i,1);
                }
                max = Math.max(max, hs.get(i));
            }
        }
        return max;
    }
}


看同时天空有多少个飞机

就是在一个时间点来没落地的飞机
把所有数字排序 连上没个interval  看交集