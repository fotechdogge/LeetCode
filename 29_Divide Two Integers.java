
/**
*
* 29. Divide Two Integers
*
* 9 minutes ago	Accepted	1 ms	32.7 MB	java
* 被除数和除数均为 32 位有符号整数。
* 除数不为 0。
* 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
*
* divd = 100, divs = 2 , result = 0
*
* 1. {i = 6, 2^6 = 64, 100-64 = 36, result += 2<<i-1} => divd = 36, result = 32
* 2. {i = 5, 2^5 = 32, 36-32=4, result += 2<<i-1} => divd = 4, result=48(32+16)
* 3. {i = 2, 2^2 = 4, 4-4=0, result += 2<<i-1} => divd = 0, result = 50 (48+2) 
*/
     
public int divide(int dividend, int divisor) {
        if (divisor == 0 || dividend == 0) return 0;
        if ((dividend == Integer.MIN_VALUE) &&
                (divisor == -1)) return Integer.MAX_VALUE;
        boolean b = (dividend ^ divisor) < 0;
        int result = 0;

        long divd = Math.abs((long) dividend);
        long divs = Math.abs((long) divisor);

        int t = 0;
        for (int i = 31; i >= 0; i--) {

            if ((divs << i) <= divd) {
                divd -= divs << i;
                result += (1 << i) + divide((int)divd, (int)divs);
                break;
            }
        }
        return b ? -result : result;
}
