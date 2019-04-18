/*
  Accepted	100 ms	37.2 MB
*/

private static String longestPalindrome(String s)
    {
        if (s.length() == 0 || s == null) return "";
        int m = 0;
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {

                char ca = s.charAt(i);
                char cb = s.charAt(j);

                if (ca == cb) {
                    if (j - i > m && check(s, i + 1, j - 1)) {
                        m = j - i;
                        start = i;
                        end = j;
                    }
                }
            }
        }
        return s.substring(start, end + 1);
    }

    private static boolean check(String s, int start, int end)
    {
        if (end - start == 0) return true;
        if (end - start == 1) {
            return s.charAt(start) == s.charAt(end);
        }
        boolean b = true;
        for (int i = start, j = end; j - i >= 1; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                b = false;
                break;
            }
        }
        return b;
    }
