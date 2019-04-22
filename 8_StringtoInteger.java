/*
 Accepted	3 ms	37.2 MB	java
 
        '+' = 43
        '-' = 45
        ' ' = 32
        '0' ~ '9' = 48 ~ 57
 
*/

class Solution {
    public int myAtoi(String str) {
        int a = 1;
        boolean b = false;
        boolean firstNum = false;
        boolean nextmostbeNum = false;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {

            int c = (int) str.charAt(i);

            if (c == 32) {
                if (firstNum || nextmostbeNum)
                    break;
                continue;
            }

            if (c == 45) {
                if (!firstNum && !b && !nextmostbeNum) {
                    b = true;
                    a = -1;
                    nextmostbeNum = true;
                    continue;
                } else {
                    break;
                }
            }

            if (c == 43) {
                if (!firstNum && !b && !nextmostbeNum) {
                    b = true;
                    nextmostbeNum = true;
                    continue;
                } else {
                    break;
                }
            }

            if (c >= 48 && c <= 57) {
                if (!firstNum) firstNum = true;
                sb.append((char) c);
            } else {
                break;
            }
        }

        if (sb.length() == 0) return 0;
        try {
            return Integer.valueOf(sb.toString())*a;
        } catch (Exception e) {
            return a<0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
    }
}
