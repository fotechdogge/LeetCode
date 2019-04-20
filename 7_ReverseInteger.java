/*
  Accepted	
  2 ms	
  32.7 MB	
  java
*/

class Solution {
    public int reverse(int x) {
        // if (x == Integer.MIN_VALUE || x == Integer.MAX_VALUE) {
        //     return 0;
        // }

        StringBuilder tmp = new StringBuilder(String.valueOf(x));
        StringBuilder tmp2 = new StringBuilder();
        int length = tmp.length();
        int last = 0;

        if (tmp.charAt(0) == '-') {
            tmp2.append(tmp.charAt(0));
            last = 1;
        }
        for (int i = length - 1; i >= last; i--) {
            tmp2.append(tmp.charAt(i));
        }

        int ans = 0;
        try {
            ans = Integer.valueOf(tmp2.toString());
        } catch (Exception e) {
            return 0;
        }
        return ans;
    }
}
