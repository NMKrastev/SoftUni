package EP17_JavaAdvancedRetakeExam14December2022.A3_SoftUni;

public class Student {

    private String firstName;
    private String lastName;
    private String bestCourse;

    public Student(String firstName, String lastName, String bestCourse) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.bestCourse = bestCourse;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBestCourse() {
        return bestCourse;
    }

    @Override
    public String toString() {
        return String.format("Student: %s %s, Best Course = %s", firstName, lastName, bestCourse);
    }
}
