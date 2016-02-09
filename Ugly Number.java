class Solution {
    public long kthPrimeNumber(int n) {        
        Queue<Long> Q = new PriorityQueue<Long>();//用来保证按顺序排列好的数
        HashMap<Long, Boolean> inQ = new HashMap<Long, Boolean>();//是不是有 3 5 7
        Long[] primes = new Long[3];// 循环检查是不是这仨数的倍数
        primes[0] = Long.valueOf(3);
        primes[1] = Long.valueOf(5);
        primes[2] = Long.valueOf(7);
        for (int i = 0; i < 3; i++) {
            Q.add(primes[i]);
            inQ.put(primes[i], true);
        }
        Long number = Long.valueOf(0);
        for (int i = 0; i < n; i++) {//找第n个有3 5 7 factor的数 所以看n次 每次要检查是否有 3 5 7 因数
            number = Q.poll();
            for (int j = 0; j < 3; j++) {
                if (!inQ.containsKey(primes[j] * number)) {
                    Q.add(number * primes[j]);
                    inQ.put(number * primes[j], true);
                }
            }
        }
        return number;
    }
}




class Solution {
    /**
     * @param k: The number k.
     * @return: The kth prime number as description.
     */
    public long kthPrimeNumber(int k) {
        // write your code here
        Queue<Long> pq = new PriorityQueue<Long> ();
        HashMap<Long, Boolean> hs = new HashMap<Long, Boolean>();
        Long[] primes = new Long[3];
        primes[0] = Long.valueOf(3);
        primes[1] = Long.valueOf(5);
        primes[2] = Long.valueOf(7);
        
        for(int i = 0; i<3; i++){
            pq.add(primes[i]);
            hs.put(primes[i], true);
        }
        Long num = Long.valueOf(0);
        for(int i = 0; i<k; i++){
            num = pq.poll();//得remove 因为下次还是用第一个点
            for(int j = 0; j<3; j++){
                if (!hs.containsKey(primes[j] * num)){
                    pq.add(primes[j] * num);
                    hs.put(primes[j] * num, true);
                }
            }
            
        }
        return num;
    }
};
