class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> answers = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            boolean divisibleBy3 = i % 3 == 0;
            boolean divisibleBy5 = i % 5 == 0;
            StringBuilder word = new StringBuilder();

            if (divisibleBy3) {
                word = word.append("Fizz");
            }

            if (divisibleBy5) {
                word = word.append("Buzz");
            }

            if (word.isEmpty()) {
                word = word.append(i);
            }

            answers.add(word.toString());
        }
        return answers;
    }

    
}