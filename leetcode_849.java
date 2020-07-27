import java.util.ArrayList;

public class leetcode_849 {

    public static void main(String[] args) {
        new leetcode_849();
    }

    public leetcode_849() {
        ArrayList<int[]> inp = new ArrayList<>();
        inp.add(new int[]{1, 0, 0, 0, 1, 0, 1});
        inp.add(new int[]{1, 0, 0, 0});
        inp.add(new int[]{1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1});
        inp.add(new int[]{1, 0});
        inp.add(new int[]{0, 0, 1});
        inp.add(new int[]{1, 1, 0, 1, 1});
        inp.add(new int[]{0, 0, 1, 0, 1, 1});
        inp.add(new int[]{0, 1, 0, 1, 0});
        inp.add(new int[]{0, 1, 0, 0, 0});
        inp.add(new int[]{1, 1, 1, 0, 0});
        inp.add(new int[]{0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0});

        for (int[] a : inp) {
            for (int i : a) {
                System.out.printf("%d, ", i);
            }
            System.out.printf("len: %d\n", a.length);
            System.out.printf("ans: %d\n\n", fun(a));
        }
    }

    private int fun(int[] a) {

        int len = 0;
        for (int i : a) if (i == 1) len++;

//        int[] tmp = new int[len];
//        for (int i = 0; i < a.length; i++) if (a[i] == 1) tmp[p++] = i;

//        for (int i : tmp) System.out.printf("%d, ", i);
//        System.out.println();
        int max = 0;


        int left = 1;
        if (a[0] == 0) {
            int i = 0;
            while (a[++i] != 1) ;
            max = i;
            left = max;
        }
        System.out.println(max);

        int right = a.length;
        if (a[a.length - 1] == 0) {
            int i = a.length;
            while (a[--i] != 1) ;
            max = Math.max(max, a.length - 1 - i);
            right = i+1;
        }

        System.out.printf("left: %d , right: %d \n", left, right);


        int p = 0;
        for (int i = left; i < right; i++) {
//            System.out.printf("p: %d\n", p);
            if (a[i] == 1) {
                System.out.printf("%d - %d\n", i, p);
                int i1 = (i - (i - p-1)) / 2;
                if (max < i1)
                    max = i1;
                p = 0;
            } else
                p++;
        }

//        if (right != )
        if (max == 0) return a.length - 1;
//        if (tmp.length > 1 && tmp[0] == 0) return max/2;
        return max;
    }
}
