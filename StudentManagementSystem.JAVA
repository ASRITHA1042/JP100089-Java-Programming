import java.util.*;

class Student {
    int id;
    String name;
    int marks;

    Student(int id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Marks: " + marks;
    }
}

public class StudentManagementSystem {

    private static Map<Integer, Student> students = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n     Student Management System@datasoftixsInternship\n1. Add 2. View 3. Update 4. Delete 5. Exit");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Marks: ");
                    int marks = sc.nextInt();
                    students.put(id, new Student(id, name, marks));
                }
                case 2 -> students.values().forEach(System.out::println);
                case 3 -> {
                    System.out.print("ID to update: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    if (students.containsKey(id)) {
                        System.out.print("New Name: ");
                        String name = sc.nextLine();
                        System.out.print("New Marks: ");
                        int marks = sc.nextInt();
                        students.put(id, new Student(id, name, marks));
                    } else {
                        System.out.println("Not found.");
                    }
                }
                case 4 -> {
                    System.out.print("ID to delete: ");
                    int id = sc.nextInt();
                    students.remove(id);
                }
                case 5 -> System.out.println("Thankyou, Application closed");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 5);
    }
}
