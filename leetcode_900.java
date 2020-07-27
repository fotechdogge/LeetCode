public class leetcode_900 {

    public static void main(String[] args) {
        new leetcode_900();
    }

    public leetcode_900() {
        RLEIterator(new int[]{6, 8, 3, 9, 5, 5});
        RLEIterator(new int[]{825, 668, 1, 494, 868, 244, 325, 871, 191, 568, 238, 968, 803, 448, 80, 320, 508, 933, 109, 551});
        show();
        for (int index : _next) {
            System.out.printf("%d.", no++);
            System.out.println(next(index) + ", ");
        }
        System.out.println();
    }


    int c_index;
    int pos;
    int no = 1;
    //    int[] _next = {2, 3, 7, 9};
    int[] _next = {210, 157, 228, 145, 251, 149, 142, 104, 136, 86, 125, 61, 40, 39, 125, 130, 92, 17, 141, 157};
    //    int[] _next = {2, 2, 1, 1};
    int[] _a;

    public void RLEIterator(int[] A) {
        _a = A;
        c_index = 0;
        pos = 0;
    }

    public int next(int n) {

        if (n == 0) return -1;

        if (c_index >= _a.length) {
            return -1;
        }


        int count = _a[c_index];

        System.out.printf("count = %d pos = %d n = %d -> ", count, pos, n);

        if (count - pos >= n) {
            pos += n;
            return _a[c_index + 1];
        } else {
            c_index += 2;
            pos = pos - count;
            return next(n);
        }
    }

    public void show() {
        System.out.print("[");
        for (int i : _a) System.out.printf("%d, ", i);
        System.out.print("]");
        System.out.println();
        System.out.print("[");
        int tal = 0;
        for (int i = 0; i < _a.length; i += 2) {
            tal += _a[i];
            for (int j = 0; j < _a[i]; j++) {
                System.out.printf("%d, ", _a[i + 1]);
            }
        }
        System.out.print("]");
        System.out.printf(" length = %d \n", tal);
        System.out.print("[");
        for (int i : _next) System.out.printf("%d, ", i);
        System.out.print("]");
        System.out.println();
    }

    /**
     * # input:
     * [6, 8, 3, 9, 5, 5]
     * [2, 3, 7, 9]
     *
     * # output:
     * [null,8,8,5,-1]
     *
     *
     * ["RLEIterator","next","next","next","next","next","next","next","next","next","next","next","next","next","next","next","next","next","next","next","next"]
     * [825,668,1,494,868,244,325,871,191,568,238,968,803,448,80,320,508,933,109,551],
     * [210],[157],[228],[145],[251],[149],[142],[104],[136],[86],[125],[61],[40],[39],[125],[130],[92],[17],[141],[157]
     *                          5                             10                        15
     * [null,668,668,668,668,244,244,244,244,244,244,871,871,871,871,871,568,968,968,968,448]
     */
}
