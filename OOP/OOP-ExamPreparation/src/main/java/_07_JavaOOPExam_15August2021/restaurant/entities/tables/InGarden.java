package _07_JavaOOPExam_15August2021.restaurant.entities.tables;

public class InGarden extends BaseTable {

    private static final double pricePerPerson = 4.50;

    public InGarden(int number, int size) {
        super(number, size, pricePerPerson);
    }
}
