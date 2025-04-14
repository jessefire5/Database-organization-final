import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

// Class to represent a single task in the to-do list
class Task {
    private String description;  // What the task is about
    private boolean isHighPriority;  // Tells the task has high priority (true = Yes, false = No)

    // Constructor to create a new task
    public Task(String description, boolean isHighPriority) {
        this.description = description;
        this.isHighPriority = isHighPriority;
    }

    // Getter to get the description of the task
    public String getDescription() {
        return description;
    }

    // Getter to check if the task is high priority
    public boolean isHighPriority() {
        return isHighPriority;
    }

    // Setter to update the priority of the task
    public void setHighPriority(boolean isHighPriority) {
        this.isHighPriority = isHighPriority;
    }

    // Method to display the task (with priority as "Yes" or "No")
    @Override
    public String toString() {
        return "[High Priority: " + (isHighPriority ? "Yes" : "No") + "] " + description;
    }
}

// Class to manage the list of tasks (the "brain" of the app)
class TodoList {
    private ArrayList<Task> tasks = new ArrayList<>();  // List of all tasks

    // Method to add a new task
    public void addTask(String description, boolean isHighPriority) {
        tasks.add(new Task(description, isHighPriority));  // Create and add a new Task object
        System.out.println("Task added!");
    }

    // Method to remove a task based on its index in the list
    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);  // Remove the task from the list
            System.out.println("Task removed!");
        } else {
            System.out.println("Invalid.");
        }
    }

    // Method to update the priority of a specific task
    public void updateHighPriority(int index, boolean isHighPriority) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).setHighPriority(isHighPriority);  // Update priority
            System.out.println("Task priority updated!");
        } else {
            System.out.println("Invalid.");
        }
    }

    // Method to display all tasks with their priorities and descriptions
    public void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks yet!");
        } else {
            System.out.println("\nHere’s what’s on your plate:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println(i + ": " + tasks.get(i));  // Displays each task, with index
            }
        }
    }

    // Method to sort tasks by priority (high priority first) and then by description
    public void sortTasks() {
        tasks.sort(Comparator.comparing(Task::isHighPriority).reversed()
                .thenComparing(Task::getDescription));  // Sorting logic
        System.out.println("Tasks sorted!");
    }

    // Method to move a task from one position to another in the list
    public void moveTask(int fromIndex, int toIndex) {
        if (fromIndex >= 0 && fromIndex < tasks.size() && toIndex >= 0 && toIndex < tasks.size()) {
            Task task = tasks.remove(fromIndex);  // Remove the task from its old position
            tasks.add(toIndex, task);  // Add it to the new position
            System.out.println("Task moved!");
        } else {
            System.out.println("Invalid.");
        }
    }
}

// Main class
public class TodoListApp {
    public static void main(String[] args) {
        TodoList todoList = new TodoList();  // Create the task manager
        Scanner scanner = new Scanner(System.in);  // Get input from the user
        boolean running = true;  // To control when the app should stop

        // Main loop to keep the app running
        while (running) {
            System.out.println("\n--- Your To-Do List ---");
            todoList.displayTasks();  // Show all the tasks
            System.out.println("\nWhat would you like to do?");
            System.out.println("1. Add a Task");
            System.out.println("2. Remove a Task");
            System.out.println("3. Update Task Priority");
            System.out.println("4. Sort Tasks");
            System.out.println("5. Move a Task");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int option = scanner.nextInt();  // Read user's choice
            scanner.nextLine();  // Consume newline character

            switch (option) {
                case 1:
                    // Adding a task
                    System.out.print("Enter the task description: ");
                    String description = scanner.nextLine();  // Get task description
                    System.out.print("Is this task high priority? (Yes/No): ");
                    boolean isHighPriority = scanner.nextLine().equalsIgnoreCase("Yes");  // Convert user input to boolean
                    todoList.addTask(description, isHighPriority);  // Add the task
                    break;
                case 2:
                    // Removing a task
                    System.out.print("Enter the task number to remove: ");
                    int removeIndex = scanner.nextInt();  // Get index to remove
                    todoList.removeTask(removeIndex);  // Remove the task
                    break;
                case 3:
                    // Updating task priority
                    System.out.print("Enter the task number to update: ");
                    int updateIndex = scanner.nextInt();  // Get task index
                    scanner.nextLine();  // Consume newline
                    System.out.print("Is this task high priority? (Yes/No): ");
                    boolean newPriority = scanner.nextLine().equalsIgnoreCase("Yes");  // Convert user input to boolean
                    todoList.updateHighPriority(updateIndex, newPriority);  // Update priority
                    break;
                case 4:
                    // Sorting tasks
                    todoList.sortTasks();  // Sort tasks by priority and description
                    break;
                case 5:
                    // Moving a task
                    System.out.print("Enter the task number to move: ");
                    int fromIndex = scanner.nextInt();  // Task to move
                    System.out.print("Enter the new position: ");
                    int toIndex = scanner.nextInt();  // New position
                    todoList.moveTask(fromIndex, toIndex);  // Move the task
                    break;
                case 6:
                    // Exit the application
                    running = false;  // Break out of the loop
                    System.out.println("Go get stuff done.");
                    break;
                default:
                    // Invalid input
                    System.out.println("Invalid. ");
            }
        }

        scanner.close();  // close the scanner
    }
}
