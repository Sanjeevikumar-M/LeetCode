import java.util.*;

public class Solution {
    public static List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>(n);
        int fizz = 3;
        int buzz = 5;

        for(int i=1;i<=n;i++){
            fizz--;
            buzz--;

            if(fizz==0 && buzz==0){
                res.add("FizzBuzz");
                fizz=3;
                buzz=5;
            }else if(buzz==0){
                res.add("Buzz");
                buzz=5;
            }else if(fizz==0){
                res.add("Fizz");
                fizz=3;
            }else{
                res.add(String.valueOf(i));
            }
        }

        return res;

    }
}