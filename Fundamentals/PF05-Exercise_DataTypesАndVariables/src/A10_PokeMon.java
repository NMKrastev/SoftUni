import java.util.Scanner;

public class A10_PokeMon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int pokePower = Integer.parseInt(scanner.nextLine());
        int distance = Integer.parseInt(scanner.nextLine());
        int exhaustionFactor = Integer.parseInt(scanner.nextLine());

        int currentPokePower = pokePower;
        int targetsCount = 0;

        while (currentPokePower >= distance) {

            currentPokePower -= distance;
            targetsCount++;

            if (currentPokePower == pokePower * 0.5 && exhaustionFactor != 0) {

                currentPokePower /= exhaustionFactor;

            }
        }

        System.out.printf("%d\n%d\n", currentPokePower, targetsCount);
    }
}
/*The Poke Mon pokes his target and then proceeds to poke another target. The distance between his targets reduces
his poke power.
You will be given the poke power the Poke Mon has, N – an integer.
Then you will be given the distance between the poke targets, M – an integer.
Then you will be given the exhaustionFactor Y – an integer.
Your task is to start subtracting M from N until N becomes less than M, i.e. the Poke Mon does not have enough power
to reach the next target.
Every time you subtract M from N that means you’ve reached a target and poked it successfully. COUNT how many
targets you’ve poked – you’ll need that count.
The Poke Mon becomes gradually more exhausted. IF N becomes equal to EXACTLY 50 % of its original value, you must
divide N by Y, if it is POSSIBLE. This DIVISION is between integers.
If a division is not possible, you should NOT do it. Instead, you should continue subtracting.
After dividing, you should continue subtracting from N, until it becomes less than M.
When N becomes less than M, you must take what has remained of N and the count of targets you’ve poked, and print
them as output.

NOTE: When you are calculating percentages, you should be PRECISE at maximum.
Example: 505 is NOT EXACTLY 50 % from 1000, its 50.5 %.
Input
•	The input consists of 3 lines.
•	On the first line, you will receive N – an integer.
•	On the second line, you will receive M – an integer.
•	On the third line, you will receive Y – an integer.
Output
•	The output consists of 2 lines.
•	On the first line, print what has remained of N, after subtracting from it.
•	On the second line, print the count of targets, you’ve managed to poke.
Constrains
•	The integer N will be in the range [1, 2.000.000.000].
•	The integer M will be in the range [1, 1.000.000].
•	The integer Y will be in the range [0, 9].
•	Allowed time / memory: 16 MB / 100ms.
*/
