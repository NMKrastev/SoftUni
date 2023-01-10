import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class A7_MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<String> namesQueue = new ArrayDeque<>();
        Arrays.stream(input.split("\\s+")).forEach(name -> namesQueue.offer(name));
        int turns = Integer.parseInt(scanner.nextLine());
        int cycle = 1;

        while (namesQueue.size() > 1) {
            for (int i = 1; i < turns; i++) {
                namesQueue.offer(namesQueue.poll());
            }

            cycle++;

            if (isPrime(cycle)) {
                System.out.println("Prime " + namesQueue.peek());
            } else {
                System.out.println("Removed " + namesQueue.poll());
            }
        }

        System.out.println("Last is " + namesQueue.poll());
    }

    private static boolean isPrime(int cycle){

        if (cycle == 1) {
            return false;
        }

        for (int i = 2; i <= cycle / 2; i++) {
            if (cycle % i == 0) {
                return false;
            }
        }

        return true;
    }
}
/*Rework the previous problem so that a child is removed only on a composite (not prime) cycle (cycles start from 1).
If a cycle is prime, print the child's name.
As before, print the name of the child that is left last.
*/
