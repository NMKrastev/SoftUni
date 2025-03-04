import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class A2_BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int s = Integer.parseInt(input.split("\\s+")[1]);
        int x = Integer.parseInt(input.split("\\s+")[2]);
        String nums = scanner.nextLine();
        ArrayDeque<Integer> elementsStack = new ArrayDeque<>();
        Arrays.stream(nums.split("\\s+")).forEach(num -> elementsStack.push(Integer.parseInt(num)));

        for (int i = 0; i < s; i++) {
            elementsStack.pop();
        }

        if (elementsStack.isEmpty()) {
            System.out.println(0);
        } else {
            if (elementsStack.contains(x)) {
                System.out.println("true");
            } else {
                int min = Integer.MAX_VALUE;
                for (int i = 0; i < elementsStack.size(); i++) {
                    int currentNum = elementsStack.pop();
                    if (currentNum < min) {
                        min = currentNum;
                    }
                }
                System.out.println(min);
            }
        }
    }
}
/*You will be given an integer N representing the number of elements to push into the stack, an integer S representing
the number of elements to pop from the stack, and an integer X, an element that you should check whether is present in
the stack. If it is, print "true" on the console. If it's not, print the smallest element currently present in the stack.
Input
•	On the first line, you will be given N, S, and X separated by a single space.
•	On the next line, you will be given a line of numbers separated by one or more white spaces.
Output
•	On a single line print, either "true" if X is present in the stack, otherwise, print the smallest element in the stack.
•	If the stack is empty – print 0.
*/
