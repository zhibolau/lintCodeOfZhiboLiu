public class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
        int len = prices.length;
        if(prices == null || len ==0){
            return 0;
        }
        int min = Integer.MAX_VALUE;//最小值作为买入价
        int max = 0;// 最大值作为利润 买在卖之前！！！
        for(int i=0; i<len; i++){
            min = Math.min(min, prices[i]);//在最便宜时候买入
            max = Math.max(max, prices[i] - min);//prices[i]-min 就是最大利润
        }
        return max;
    }
}
http://www.cnblogs.com/springfor/p/3877059.html

这道题只让做一次transaction，那么就需要找到价格最低的时候买，价格最高的时候卖（买价的日期早于卖价的日期）。
从而转化为在最便宜的时候买入，卖价与买价最高的卖出价最大时，就是我们要得到的结果。

因为我们需要买价日期早于卖价日期，所以不用担心后面有一天价格特别低，而之前有一天价格特别高而错过了（这样操作是错误的）。

所以，只许一次遍历数组，维护一个最小买价，和一个最大利润(保证了买在卖前面）即可。


