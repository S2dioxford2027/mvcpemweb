import java.util.Scanner;

public class Depth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();

        int maxDepth = 0, currentDepth = 0;

        for (char ch : input.toCharArray()) {
            if (ch == '(') {
                currentDepth++;
                maxDepth = Math.max(maxDepth, currentDepth);
            } else if (ch == ')') {
                currentDepth--;
                if (currentDepth < 0) {
                    maxDepth = -1;
                    break;
                }
            }
        }

        System.out.println(currentDepth == 0 ? maxDepth : -1);
    }
}
