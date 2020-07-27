import java.util.ArrayList;

public class leetcode_1147 {

    public static void main(String[] args) {

        String[] strs = {
                "rsvigugligxpzvneqrwluvejblyhohsouywwspknybqdantfnllfnantnybqdywwspkuyhohsouvejblqrwlzvneigxpglrsvigu",
                "wuamlwxskgjzegshjhcwchkgjzegshjwuamlwxs",
                "ghiabcdefhelloadamhelloabcdefghi",
                "antaprezatepzapreanta",
                "merchant",
                "antaprezatepzapreanta",
                "aaaaaaaa",
                "aaaaaaa",
                "aaaaaa",
                "aaaaa",
                "aaaa",
                "aaa",
                "aa",
                "a",
        };

        ArrayList<Integer> arr = new ArrayList<>();
        leetcode_1147 o = new leetcode_1147();

        for (String s : strs) {
            arr.add(o.leetcode_1147_fun(s));
        }

        System.out.println();
        for (int i : arr) System.out.printf("%d, ", i);
        System.out.println("\n26, 9, 7, 11, 1, 11, 8, 7, 6, 5, 4, 3, 2, 1");

        System.out.println(
        "rsvigu gl igxp zvne qrwl uvejbl yhohso u ywwspk nybqd ant fn l" +
        "l fn ant nybqd ywwspk u yhohso uvejbl qrwl zvne igxp gl rsvigu"
        );
    }

    public int leetcode_1147_fun(String s) {

        int count = 0;
        int length = s.length();
        int arg1 = length % 2;
        int center = length / 2 + arg1;
        int r = 0;
        int r_max = 0;
        int l = 0;
        int right = 0;
        int left = 0;
        char[] chars = s.toCharArray();

        if (length == 1) {
            System.out.printf("count : %d", length);
            return length;
        }

        if (arg1 == 0) {
            r_max = center;
            l = r + 1;
        } else {
            r_max = center - 1;
            l = center + 1;
        }

//        System.out.printf("input : %s | len : %d ", s, length);
//        System.out.printf("center : %d , arg1 : %d\n", center, arg1);
//        System.out.printf("center : %d , %d\n", r, l);

        l = length - 1;

        int tmp_r = r, tmp_l = l;
        while (r < center) {

            right += chars[r];
            left += chars[l];

//            System.out.printf(" %d %s (%d) : %s %d (%d)\n", r, chars[r], right, chars[l], l, left);

            if (right == left) {
                // check
//                System.out.println("check");
                boolean result = true;
                for (int i = r, j = tmp_l; i >= tmp_r; i--, j--) {
                    result = chars[i] == chars[j];
//                    System.out.printf("check -> r %d (%s) :  (%s) %d %b\n", i, chars[i], chars[j], j, result);
                    if (!result) break;
                }
                if (result) {

                    right = 0;
                    left = 0;

                    if (r == l) {
                        count+=1;
                        break;
                    }

                    count += 2;
//                    System.out.printf("check ok : r=%d l=%d | count=%d \n\n", r, l, count);
                    tmp_r = r + 1;
                    tmp_l = l - 1;
                }
                else {
                }

            }

            r++;
            l--;
        }

//        System.out.printf("end r: %d , l: %d | center: %d | length: %d\n", r, l, center, length);

        if (right != 0) count += 1;

        if (count == 0) count += 1;

//        System.out.printf("count : %d , \n\n", count);
        return  count;
    }

    /**
     * "ghiabcdefhelloadamhelloabcdefghi"
     * "antaprezatepzapreanta"
     * "merchant"
     * "agbtycbtag"
     * "aaaaa"
     * "aaaa"
     * "aaa"
     * "aa"
     * "a"
     *  7 , 11 , 1 , 2 , 5 , 5 , 5 , 3 , 3 , 1 ,
     *  7 , 11 , 1 , 5 , 5 , 4 , 3 , 2 , 1 ,
     */
}
