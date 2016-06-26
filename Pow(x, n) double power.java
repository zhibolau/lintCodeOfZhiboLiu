
Pow(2.1, 3) = 9.261
Pow(0, 1) = 0
Pow(1, 0) = 1

double power

Implement pow(x, n).

http://www.programcreek.com/2012/12/leetcode-powx-n/





public class Solution {
    /**
     * @param x the base number
     * @param n the power number
     * @return the result
     */
    public double myPow(double x, int n) {
        if (n < 0) {
		return 1 / power(x, -n);
	} else {
		return power(x, n);
	}
}
    
    
    public double power(double x, int n) {
	if (n == 0)
		return 1;
 
	double v = power(x, n / 2);
 
	if (n % 2 == 0) {
		return v * v;
	} else {
		return v * v * x;
	}
}
}



