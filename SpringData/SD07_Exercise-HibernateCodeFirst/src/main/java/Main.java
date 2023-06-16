import A1_GringottsDatabase.WizardDeposit;
import A2_SalesDatabase.Customer;
import A2_SalesDatabase.Product;
import A2_SalesDatabase.Sale;
import A2_SalesDatabase.StoreLocation;
import A3_UniversitySystem.Course;
import A3_UniversitySystem.Student;
import A3_UniversitySystem.Teacher;
import A4_HospitalDatabase.*;
import jakarta.persistence.EntityManager;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

import static enums.PersistenceUnitName.*;
import static enums.Variable.*;

public class Main {

    /**
     * Tasks are completed by using switch case that depending on your choice
     * executes a specific task related to its number thus creating a DB and populating it.
     * <p>
     * Choose a number that correspond to the task from the homework paper,
     * the application will do the rest. After that you can refresh your DB client
     * to check the DB, tables, etc.
     */

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Please enter task number from 1 to 6: ");
        int taskNumber = Integer.parseInt(scanner.nextLine());

        if (isTaskNumberNonExistent(taskNumber)) return;

        System.out.println(executeTask(taskNumber));
    }

    private static String executeTask(int taskNumber) {

        final EntityManager manager;

        switch (taskNumber) {
            case 1 -> {
                manager = Utils.getSQLConnection(GRINGOTTS.getPersistenceUnitName());
                taskOne(manager);
                manager.close();
                return executedTaskNumber(taskNumber);
            }
            case 2 -> {
                manager = Utils.getSQLConnection(SALES.getPersistenceUnitName());
                taskTwo(manager);
                manager.close();
                return executedTaskNumber(taskNumber);
            }
            case 3 -> {
                manager = Utils.getSQLConnection(UNIVERSITY.getPersistenceUnitName());
                taskThree(manager);
                manager.close();
                return executedTaskNumber(taskNumber);
            }
            case 4 -> {
                manager = Utils.getSQLConnection(HOSPITAL.getPersistenceUnitName());
                taskFour(manager);
                manager.close();
                return executedTaskNumber(taskNumber);
            }
        }

        return "Something went wrong with execution!";
    }

    /**
     * Part one: Populating the DB
     * <p>
     * Populates the DB with patients, diagnoses and medicaments.
     * <p>
     * <p>
     * Part two: Create a visitation
     * <p>
     * Creates a visitation from a patient with the given ID. You can diagnose the patient by entering the diagnosis
     * name that is in the database. Furthermore, you can make a prescription for that patient. All of this is
     * inserted into the `visitations` table in database "hospital".
     */
    private static void taskFour(EntityManager manager) {

        /*Part one*/
        System.out.println(DO_YOU_WANT_TO_POPULATE_DB);
        String input = scanner.nextLine().toLowerCase();

        if (input.equalsIgnoreCase("yes")) {

            while (!input.equalsIgnoreCase("No")) {

                manager.getTransaction().begin();

                final String firstName = PatientInfoGatherer.getFirstName();
                final String lastName = PatientInfoGatherer.getLastName();
                final String address = PatientInfoGatherer.getAddress();
                final String email = PatientInfoGatherer.getEmail();
                final LocalDate date = PatientInfoGatherer.getDateOfBirth();
                final Boolean isInsured = PatientInfoGatherer.isInsured();
                final Patient patient = new Patient(firstName, lastName, address, email, date, PICTURE_IN_BLOB, isInsured);
                manager.persist(patient);

                final String diagnoseName = DiagnoseInfoGatherer.getName();
                final String diagnoseComment = DiagnoseInfoGatherer.getComment();
                final Diagnose diagnoseOne = new Diagnose(diagnoseName, diagnoseComment);
                manager.persist(diagnoseOne);

                final String medicamentName = MedicamentInfoGatherer.getName();
                final Medicament medicament = new Medicament(medicamentName);
                manager.persist(medicament);

                System.out.println(DO_YOU_WANT_TO_POPULATE_DB);
                input = scanner.nextLine();

                manager.getTransaction().commit();
            }
        }

        /*Part two*/
        manager.getTransaction().begin();

        //Could be with patient's name instead of ID
        System.out.print(VISITATION_FROM_PATIENT_WITH_ID);
        int id = Integer.parseInt(scanner.nextLine());

        System.out.println(COMMENT_FOR_VISITATION);
        final String comment = scanner.nextLine();

        System.out.print(PATIENT_IS_DIAGNOSED_WITH);
        final String diagnoseName = scanner.nextLine();

        System.out.print(PATIENT_WITH_PRESCRIPTION_FOR_MEDICAMENT_NAME);
        final String medicamentName = scanner.nextLine();

        final Patient patient = manager.createQuery(FIND_PATIENT, Patient.class).setParameter(1, id).getSingleResult();

        final Diagnose diagnose = manager.createQuery(FIND_DIAGNOSE, Diagnose.class).setParameter(1, diagnoseName).getSingleResult();

        final Medicament medicament = manager.createQuery(FIND_MEDICAMENT, Medicament.class).setParameter(1, medicamentName).getSingleResult();

        final Visitation visitation = new Visitation(LocalDate.now(), comment, patient, diagnose, medicament);

        manager.persist(visitation);

        manager.getTransaction().commit();
    }

    private static void taskThree(EntityManager manager) {

        manager.getTransaction().begin();

        //Bonus code to populate the DB
        final Teacher teacherOne = new Teacher(FIRST_NAME, LAST_NAME);
        final Student studentOne = new Student(FIRST_NAME, LAST_NAME);
        final Student studentTwo = new Student(FIRST_NAME, LAST_NAME);
        final Course courseOne = new Course(COURSE_NAME, LocalDate.now());

        teacherOne.getCourses().add(courseOne);
        courseOne.setTeacher(teacherOne);

        studentOne.getCourses().add(courseOne);
        courseOne.getStudents().add(studentOne);
        courseOne.getStudents().add(studentTwo);

        manager.persist(teacherOne);
        manager.persist(courseOne);
        manager.persist(studentOne);
        manager.persist(studentTwo);

        manager.getTransaction().commit();
    }

    private static void taskTwo(EntityManager manager) {

        manager.getTransaction().begin();

        //Bonus code to populate the DB
        final Product product = new Product(PRODUCT_ONE, QUANTITY, PRICE);
        final Customer customer = new Customer(CUSTOMER_ONE, EMAIL, CARD_NUMBER);
        final StoreLocation storeLocation = new StoreLocation(LOCATION_NAME);
        final Sale saleOne = getSale(product, customer, storeLocation);

        product.getSales().add(saleOne);
        saleOne.setProduct(product);

        customer.getSales().add(saleOne);
        saleOne.setCustomer(customer);

        storeLocation.getSales().add(saleOne);
        saleOne.setStoreLocation(storeLocation);

        manager.persist(product);
        manager.persist(customer);
        manager.persist(storeLocation);
        manager.persist(saleOne);

        final Sale saleTwo = getSale(product, customer, storeLocation);

        product.getSales().add(saleTwo);
        saleTwo.setProduct(product);

        customer.getSales().add(saleTwo);
        saleTwo.setCustomer(customer);

        storeLocation.getSales().add(saleTwo);
        saleTwo.setStoreLocation(storeLocation);

        manager.persist(saleTwo);

        manager.getTransaction().commit();
    }

    private static Sale getSale(Product product, Customer customer, StoreLocation storeLocation) {
        return new Sale(product, customer, storeLocation, Date.from(Instant.now()));
    }

    private static void taskOne(EntityManager manager) {

        manager.getTransaction().begin();

        final WizardDeposit wizardDeposit = new WizardDeposit(LAST_NAME, AGE);
        manager.persist(wizardDeposit);

        manager.getTransaction().commit();
    }

    private static boolean isTaskNumberNonExistent(int taskNumber) {

        if (taskNumber < 1 || taskNumber > 6) {
            System.out.printf(String.format(TASK_DOES_NOT_EXIST, taskNumber));
            return true;
        }

        return false;
    }

    private static String executedTaskNumber(int taskNumber) {
        return String.format(TASK_WAS_EXECUTED, taskNumber);
    }
}
