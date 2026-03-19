import java.util.*;

public class Solution {
    public static List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();

        int fizz = 3, buzz = 5;

        for (int i = 1; i <= n; i++) {
            fizz--;
            buzz--;

            if (fizz == 0 && buzz == 0) {
                result.add("FizzBuzz");
                fizz = 3;
                buzz = 5;
            } else if (fizz == 0) {
                result.add("Fizz");
                fizz = 3;
            } else if (buzz == 0) {
                result.add("Buzz");
                buzz = 5;
            } else {
                result.add(String.valueOf(i));
            }
        }

        return result;
    }
}