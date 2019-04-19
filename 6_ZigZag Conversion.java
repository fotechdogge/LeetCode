/*
  Accepted	3 ms	38.3 MB	java
*/

/*
        0  1  2  3  4  5  6  7  8  9  10 11 12 13 14 15
        L  e  e  t  C  o  d  e  F  u  c  k  Y  o  u  g

        s.length = 16; numRows = 5;

       y
     x * 0 1 2 3 4 5 6 7 8
       0 l       f
       1 e     e u     g
       2 e   d   c   u
       3 t o     k o
       4 c       y

       l += 2; link = 3;

       0 l   c   f   y
       1 e t o e u k o g
       2 e   d   c   u

       l == 2; link = 1;


        0  1  2  3  4  5  6  7  8  9  10 11 12 13 14 15
        P  A  Y  P  A  L  I  S  H  I  R  I  N  G

       y
     x * 0 1 2 3 4 5 6 7 8
       0 p       h
       1 a     s i
       2 y   i   r
       3 p l     i g
       4 a       n

         p     i     n
      -> a   l s   i g
      -> y a   h r
         p     i

        1. a -> l
        2. y -> a

     */

class Solution {
    public String convert(String s, int numRows) {
        
        if (numRows >= s.length()) return s;
        if (numRows <= 0) return s;
        if (numRows == 1) return s;
        
        StringBuilder ans = new StringBuilder();

        int length = s.length();
        int offset = numRows - 2;
        int xAxis = numRows + offset;

        for (int y = 0, xoffset = xAxis; y < numRows; y++, xoffset -= 2) {
            
            for (int x = 0; x < length; x += xAxis) {

                int xPos = x + y;
                if (xPos < length)
                    ans.append(s.charAt(xPos));

                if (y > 0 && y < numRows - 1) {
                    int xx = xPos + xoffset;
                    if (xx < length)
                        ans.append(s.charAt(xx));
                }

            }
        }

        return ans.toString();
    }
}

