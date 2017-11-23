import java.util.*;
import java.util.function.BiFunction;

public class AppDrive {

    public static void main(String[] args) {

        BiFunction<String, String, String> biFunction = null;

        biFunction = AppDrive::printNam;
        System.out.println(biFunction.apply("Amir", "Khadiv"));
        Map<String, Integer> map = new HashMap<>();
        int[] nums = new int[3];
        System.out.println(firstUniqChar("abcdab"));
        System.out.println('a');

        int result = solve(2);
        System.out.println(result);
        String ss = "AA";
        System.out.println(ss.charAt(0) == ss.charAt(1));
        int[] inpus = new int[20];
        inpus[10] = 10;
        System.out.println(inpus[0]);

        List<String> list = new ArrayList<>();
        int[] input = {1, 3, 2, 5, 5, 5, 5};
        findDisappearedNumbers(input);
//        System.out.println(Math.abs(-11.4));

        String s = "hello world";
        String newS = s.replaceFirst("l", ">");
        System.out.println(newS.toUpperCase());
//        System.out.println(canConstruct2("aa","ab"));

        System.out.println('b' - 'a');
        int[] arr = new int[3];
        //arr[2]++;
        System.out.println(arr[2]);
        String inputS = "aaa";
        for (int i = 0; i < inputS.length(); i++) {
            arr[inputS.charAt(i) - 'a']++;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]+".....");
        }

        System.out.println(10 - 1/2);
        Stack<Integer> stack = new Stack<>();
        stack.push(null);
        int i = stack.pop();


       // canConstruct2("aa", "aab");
    }

    public static String printNam(String name, String family) {

        return name + family;
    }

    public static int firstUniqChar(String s) {
        int freq[] = new int[26];
        for (int i = 0; i < s.length(); i++)
            freq[s.charAt(i) - 'a']++;
        for (int i = 0; i < s.length(); i++)
            if (freq[s.charAt(i) - 'a'] == 1)
                return i;
        return -1;
    }

    static int solve(int n) {
        if (n <= 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        } else {
            return solve(n - 1) + solve(n - 3) + solve(n - 4);
        }

    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ret = new ArrayList<Integer>();

        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            if (nums[val] > 0) {
                nums[val] = -nums[val];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                ret.add(i + 1);
            }
        }
        return ret;
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        String newMagazine = magazine;
        for (char ch : ransomNote.toCharArray()) {
            if (magazine.contains(ch + "")) {
                newMagazine = newMagazine.replaceFirst(ch + "", ">");
            } else {
                return false;
            }

        }


        return true;
    }

    public static boolean canConstruct2(String ransomNote, String magazine) {

        if (magazine.equals("")) {
            return false;
        }

        Stack<String> stack = new Stack<>();
        for (int i = 0; i < magazine.length(); i++) {
            stack.push(magazine.substring(i, i + 1));
        }
        for (int i = 0; i < ransomNote.length(); i++) {

            char ch = ransomNote.charAt(ransomNote.length() - i - 1);
            String st = stack.pop();
            while (true) {
                if (st.equals(ch + "")) {
                    break;
                } else {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    st = stack.pop();
                }
            }
            if (stack.isEmpty() || i == ransomNote.length() - 1) {
                return st.equals(ch + "");
            }
        }
        return true;
    }

}
