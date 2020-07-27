import java.util.ArrayList;
import java.util.Arrays;

public class leetcode_275 {

    public static void main(String[] args) {
        new leetcode_275();
    }

    public leetcode_275() {
        ArrayList<int[]> input = new ArrayList<>();
        input.add(new int[]{3, 0, 1, 5, 6});
        input.add(new int[]{0, 1, 2, 5, 6});
//        input.add(new int[]{0, 0, 1});
//        input.add(new int[]{1, 1, 2, 2});
//        input.add(new int[]{2, 5});
//        input.add(new int[]{1, 2});
//        input.add(new int[]{1, 1});
//        input.add(new int[]{9, 100});
//        input.add(new int[]{100});
//        input.add(new int[]{0});

        for (int[] A : input) {
            System.out.printf("ans: %d\n\n", hIndex(A));
        }
    }

    private int hIndex(int[] A) {

        int n = A.length - 1;
        int i = A.length - 1;
        int c = 0;

        if (A.length == 0) return 0;
        if (A[i] == 1) return 1;

        while (i >= 0 && A[i] > c) {
            System.out.printf("A[%d] = %d >= %d, ", i, A[i], n);
            c++;
            System.out.printf("c: %d\n", c);
            n--;
            i--;
        }

        return c;

    }
}
