import java.util.ArrayList;

public class leetcode_274 {
    public static void main(String[] args) {
        new leetcode_274();
    }

    public leetcode_274() {
        ArrayList<int[]> inputs = new ArrayList<>();
        inputs.add(new int[]{3, 0, 1, 5, 6});
        inputs.add(new int[]{30, 0, 12, 56, 6});
        inputs.add(new int[]{30, 99, 12, 56, 4});
        inputs.add(new int[]{2, 2, 2, 2, 2});
        inputs.add(new int[]{6, 2, 6, 2, 1});

        for (int[] a : inputs) {
            System.out.printf("input: [");
            for (int i : a)
                System.out.printf("%d, ", i);
            System.out.println("]");
        }

        for (int[] a : inputs) {
            System.out.printf("ans: %d\n", fun(a));
        }
    }

    /*

        [3,0,1,5,6]
        []

     */

    private int fun(int[] A) {
        int len = A.length;
        int c = 0;
        int max = 0;

        int[] tmp = new int[len + 1];
        for (int i = 0; i < len; i++) {
            if (A[i] >= len) tmp[len] += 1;
            else tmp[A[i]] += 1;
        }

        for (int i : tmp) System.out.printf("%d, ", i);
        int i = len;
        while (i >= 0) {
            c += tmp[i];
            if (c >= i) return i;
            i--;
        }

        return i;
    }
}
