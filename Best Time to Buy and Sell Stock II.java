class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
        int len = prices.length;
        if(prices == null || len < 2){
            return 0;
        }
        int profit = 0;
        int start = 0;
        int end = 0;
        int i =0;
        while(i<len-1){//下边有i+1所以要<len-1
            //找递增最小值
            while(i<len-1 && prices[i] > prices[i+1]){
                i++;
            }
            start = i;
            i = i+1;//在此之后找最大值
            while(i<len && prices[i] >= prices[i-1]){
                i++;
            }
            end = i-1;
            profit = prices[end] - prices[start] + profit;//别忘了+profit最后 可以多买多卖！！！
        }
        return profit;
        
    }
};
http://www.cnblogs.com/springfor/p/3877065.html

public static int maxProfit(int[] prices) {
        int len = prices.length;
        if(len <= 1)
            return 0;
        
        int i = 0;
        int total = 0;
        while(i < len - 1){
            int buy,sell;
            //寻找递减区间的最后一个值（局部最小点）
            while(i+1 < len && prices[i+1] < prices[i])
                i++;
            //局部最小点作为买入点
            buy = i;
            
            //找下一个点(卖出点至少为下一个点）
            i++;
            //不满足。。继续往下找递增区间的最后一个值（局部最高点）
            while(i<len && prices[i] >= prices[i-1])
                i++;
            //设置卖出点
            sell = i-1;
            //计算总和
            total += prices[sell] - prices[buy];
        }
        return total;
    }
	
	
	
