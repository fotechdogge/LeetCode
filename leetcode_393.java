public class leetcode_393 {

    public static void main(String[] args) {
        new leetcode_393();
    }

    public leetcode_393() {
        /**
         * 1 | 0xxxxxxx
         * 2 | 110xxxxx 10xxxxxx
         * 3 | 1110xxxx 10xxxxxx 10xxxxxx
         * 4 | 11110xxx 10xxxxxx 10xxxxxx
         *
         * 0x7f | 01111111 | 1 = { 00000000 - 01111111 } -> { 0x00 - 0x7f } -> { 0 - 127 }
         * 0xDf | 11011111 | 2 = { 11000000 - 11011111 } -> { 0xC0 - 0xDf } -> { 192 - 223 }
         * 0xEf | 11101111 | 3 = { 11100000 - 11101111 } -> { 0xE0 - 0xEf } -> { 224 - 239 }
         * 0xF7 | 11110111 | 4 = { 11110000 - 11110111 } -> { 0xF0 - 0xF7 } -> { 240 - 247 }
         * 0xBF | 10111111 |     { 10000000 - 10111111 } -> { 0x80 - 0xBf } -> { 128 - 191 }
         */
//        System.out.println(validUtf8(new int[]{115,100,102,231,154,132,13,10}));
//        System.out.println(validUtf8(new int[]{197, 130, 1}));
//        System.out.println(validUtf8(new int[]{248,130,130,130}));
//        System.out.println(validUtf8(new int[]{255}));
//        System.out.println(validUtf8(new int[]{235, 140, 4}));
        System.out.println(validUtf8(new int[]{197,130,1}));

        System.out.println(validUtf8(new int[]{32, 196, 147, 225, 184, 165, 246, 149,
                170, 129, 204, 153, 243, 188, 141, 147, 0, 217, 149, 234, 176, 176, 243, 178,
                133, 144, 213, 181, 193, 187, 238, 137, 134, 218, 155, 33, 231, 134, 162, 243,
                184, 144, 131, 71, 201, 131, 244, 133, 189, 140, 242, 178, 128, 156, 207, 154,
                230, 165, 181, 240, 181, 134, 180, 227, 129, 199, 172, 226, 158, 164, 214, 183,
                224, 137, 141, 20, 194, 188, 232, 177, 151, 242, 157, 180, 153, 200, 189, 239,
                153, 186, 240, 153, 181, 154}));
    }

    public boolean validUtf8(int[] data) {

        int i = 0;
        int count = 0;
        System.out.printf("size = %d \n", data.length);
        for (int num : data) {
            System.out.printf("%s. ", String.format("%02d", ++i));
            System.out.printf(" %s ", String.format("%8s", Integer.toBinaryString(num)).replace(' ', '0'));

            if (num >= 0x80 && num <= 0xbf) {
                count--;
                System.out.println("ele");
                continue;
            }

            if (count != 0) return false;

            if (num <= 0x7f) {
                count = 0;
                System.out.printf("count = %d\n", count);
            }
            else if (num <= 0xdf) {
                count = 1;
                System.out.println("1");
            } else if (num <= 0xef) {
                count = 2;
                System.out.println("2");
            } else if (num <= 0xf7) {
                count = 3;
                System.out.println("3");
            }  else {
                System.out.println("wrong");
                return false;
            }
        }
        return count == 0;

//        int plen = 0;
//        for (int pos = 0; pos < data.length; pos++) {
//
//            System.out.printf("%d. %s plen=%d ",
//                    1 + pos, String.format("%08d", Integer.parseInt(Integer.toBinaryString(data[pos]))), plen);
//
//            char[] chars = convTobinary(data[pos]);
//            boolean isChild = isChild(chars);
//
//            int len = getLength(chars);
//
//            if (len == -1) return false;
//            if (len!=0 && isWrong(len, chars)) return false;
//            if (plen == 0 && isChild) return false;
//
//
//            if (plen > 0) {
//                if (isChild) {
//                    plen--;
//                    System.out.printf("isChild plen-- plen=%d \n", plen);
//                    continue;
//                } else {
//                    System.out.println(plen);
//                    return false;
//                }
//            }
//
//            plen = len;
//            System.out.printf(" -> plen=%d \n", plen);
//        }
//
//        return plen == 0;
    }

    private char[] get8bit(int num) {
        char[] bytes = new char[8];
        for (int i = 0, p = 7; i < 8; i++) {
            bytes[p] = (char) (num % 2);
            num /= 2;
            p--;
        }
        return bytes;
    }

    private char[] convTobinary(int res) {
        return String.format("%08d", Integer.parseInt(Integer.toBinaryString(res))).toCharArray();
    }

    private boolean isChild(char[] chars) {
        return (chars[0] == '1' && chars[1] == '0');
    }

    private boolean isWrong(int len, char[] chars) {
        return chars[len + 1] != '0';
    }

    private int getLength(char[] chars) {
        if (chars[0] == '0') return 0;
        int num = 0, pos = 0;
        while (pos < 4) {
            if (pos >= chars.length) return -1;
            if (chars[pos] == '0') break;
            num++;
            pos++;
        }
        return num - 1;
    }
}
