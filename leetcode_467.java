import java.util.ArrayList;

public class leetcode_467 {

    public static void main(String[] args) {
        new leetcode_467();
    }

    public leetcode_467() {
        ArrayList<String> arr = new ArrayList<>();
//        arr.add("abcdefghijklmnopqrsxyz");
        arr.add("abcd");
        arr.add("abde");
        arr.add("abccd");
        arr.add("cac");
        arr.add("zab");

        for (String s : arr) {
            System.out.printf("ans: %d \n", fun(s));
        }
    }

    /*
        a-z  = 97-122;

     */

    private int fun(String s) {

        char[] a = s.toCharArray();


//        for (int i = 0; i<a.length; i++) {
//            System.out.printf("%c, ", a[i]);
//            count++;
//        }

        /*
        k = 0; k < S.length;
        a b c d
        ab bc cd
        abc bcd
        abcd

         */


        int tmp = 0;
        int lim = 'a' - 'z';
        for (int k = 0; k < a.length; k++) {
            for (int i = 0; i < a.length - k; i++) {
                tmp = 0;
                for (int j = i; j < k + i + 1; j++) {
                    System.out.printf("%c", a[j]);
                    char c = a[j];
                    if (tmp > 0) {
                        int arg = c - tmp;
                        if (arg == lim) ;
                        else if (arg != 1) {
                            System.out.printf("X");
                        }
                    }
                    tmp = c;
                }
                System.out.print(", ");
            }
        }

        System.out.println();

        int[] base = new int[26];
        int za = 'z' - 'a';
        int count = 0;

        for (int i = 0; i < a.length; i++) {
            if (i > 0) {
                int arg = a[i] - a[i - 1];
//                System.out.println(arg);
                if (arg == 1 || arg == -za) {
                    count++;
                }
                else count = 1;
            } else count = 1;


            int p = a[i] - 'a';
            base[p] = Math.max(base[p], count);
        }

        int sum = 0;
        for (int i : base) sum += i;

        return sum;
    }
}
