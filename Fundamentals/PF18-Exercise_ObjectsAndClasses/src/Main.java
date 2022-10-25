import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<A6_PersonsInfo> personsInfoList = new ArrayList<>();
        String input = "";

        while (!(input = scanner.nextLine()).equals("End")) {

            String name = input.split("\\s+")[0];
            String id = input.split("\\s+")[1];
            int age = Integer.parseInt(input.split("\\s+")[2]);

            A6_PersonsInfo person = new A6_PersonsInfo(name, id, age);

            personsInfoList.add(person);
        }

        personsInfoList = personsInfoList.stream().sorted(Comparator.comparing(A6_PersonsInfo::getAge)).collect(Collectors.toList());

        for (A6_PersonsInfo person : personsInfoList) {
            System.out.println(person);
        }
    }
}