题解： 

根据题目要求，最多进行两次买卖股票，而且手中不能有2只股票，就是不能连续两次买入操作。

所以，两次交易必须是分布在2各区间内，也就是动作为：买入卖出，买入卖出。

进而，我们可以划分为2个区间[0,i]和[i,len-1]，i可以取0~len-1。

那么两次买卖的最大利润为：在两个区间的最大利益和的最大利润。

一次划分的最大利益为：Profit[i] = MaxProfit(区间[0,i]) + MaxProfit(区间[i,len-1]);

最终的最大利润为：MaxProfit(Profit[0], Profit[1], Profit[2], ... , Profit[len-1])。


public int maxProfit(int[] prices) {  
        if(prices == null || prices.length <= 1){  
            return 0;  
        }  
        int len = prices.length;  
        int maxProfit = 0;  
        int min = prices[0];  
        int arrayA[] = new int[len];  
        
        for(int i=1;i<prices.length;i++){
            min=Math.min(min,prices[i]);//买入价格
            arrayA[i]=Math.max(arrayA[i-1],prices[i]-min);//利润
        }
        
        int max = prices[len-1];  
        int arrayB[] = new int[len];  
        for(int i = len-2; i >= 0; i--){
            max = Math.max(prices[i],max);//卖出价格
            arrayB[i] = Math.max(max-prices[i],arrayB[i+1]);//利润
        }  
        
        for(int i = 0; i < len; i++){  
            maxProfit = Math.max(maxProfit,arrayA[i] + arrayB[i]);
        }  
        
        return maxProfit;  
    }
	
	
	mine：
	
	
	class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
        int len = prices.length;
        if(prices==null || len <= 1){
            return 0;
        }
        
        int min = prices[0];
        int[] a = new int[len];
        for(int i=1; i<len; i++){
            min=Math.min(prices[i], min);//买入价格让他尽量小
            a[i]= Math.max(a[i-1], prices[i]-min);//利润让他尽量大
        }
        
        int max = prices[len - 1];
        int[] b = new int[len];
		for(int j = len-2; j >=0; j--){
            max = Math.max(max, prices[j]); //卖出价尽量大
            b[j] = Math.max(b[j+1], max-prices[j]);
        }
		
        int maxProfit = 0;
        for(int k=0; k<len; k++){
            maxProfit = Math.max(maxProfit, a[k]+b[k]);
        }
        return maxProfit;
    }
};


