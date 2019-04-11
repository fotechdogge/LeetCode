
/**
* 13. Roman to Integer
* Runtime: 38 ms
* Memory Usage: 39.1 MB
*/
class Solution {
    public int romanToInt(String s) {
        int ans = 0;

        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);


        char[] chars = s.toCharArray();

        int tmp = map.get(chars[0]);
        for (char aChar : chars) {

            int a = map.get(aChar);

            if (a > tmp) ans += (a - tmp * 2);
            else ans += a;
            tmp = a;
        }

        return ans;
    }
}
