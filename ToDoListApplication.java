import java.util.*;

class Task {
    String description;
    boolean isComplete;

    Task(String description) {
        this.description = description;
        this.isComplete = false;
    }

    void markComplete() {
        this.isComplete = true;
    }

    public String toString() {
        return (isComplete ? "[Completed] " : "[Pending] ") + description;
    }
}

public class ToDoListApplication {

    private static List<Task> tasks = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n To Do List Application@datasoftixsInternship\n1. Add 2. View 3. Edit 4. Delete 5. Complete 6. Exit");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Task: ");
                    tasks.add(new Task(sc.nextLine()));
                }
                case 2 -> tasks.forEach(t -> System.out.println((tasks.indexOf(t) + 1) + ". " + t));
                case 3 -> {
                    System.out.print("Task #: ");
                    int idx = sc.nextInt() - 1;
                    sc.nextLine();
                    if (idx >= 0 && idx < tasks.size()) {
                        System.out.print("New Task: ");
                        tasks.get(idx).description = sc.nextLine();
                    }
                }
                case 4 -> {
                    System.out.print("Task #: ");
                    int idx = sc.nextInt() - 1;
                    if (idx >= 0 && idx < tasks.size()) tasks.remove(idx);
                }
                case 5 -> {
                    System.out.print("Task #: ");
                    int idx = sc.nextInt() - 1;
                    if (idx >= 0 && idx < tasks.size()) tasks.get(idx).markComplete();
                }
                case 6 -> System.out.println("Thankyou, Application closed");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 6);
    }
}
