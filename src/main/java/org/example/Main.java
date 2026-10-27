
package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        HabitManager manager = new HabitManager();

        // FIX: Removed the unused variables and duplicate habits list.
        // HabitManager is now responsible for storing habits.

        while (true) {

            System.out.println("\n===== HABIT TRACKER =====");
            System.out.println("1. Add a habit");
            System.out.println("2. View all habits");
            System.out.println("3. Mark a habit as completed");
            System.out.println("4. View progress");
            System.out.println("5. Delete a habit");
            System.out.println("6. Edit a habit");
            System.out.println("0. Exit");

            System.out.print("Choose an option: ");

            // FIX: Read input as text to avoid Scanner
            // problems when the user enters letters.
            String input = scanner.nextLine();
            int choice;

            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                continue;
            }

            switch (choice) {

                case 1: {
                    System.out.print("Enter habit name: ");
                    String name = scanner.nextLine();

                    // FIX: Check the result before showing success.
                    if (manager.addHabit(name)) {
                        System.out.println("Habit added successfully");
                    } else {
                        System.out.println("Invalid habit name");
                    }
                    break;
                }

                case 2: {
                    ArrayList<Habit> allHabits = manager.getAllHabits();

                    if (allHabits.isEmpty()) {
                        System.out.println("No habits found");
                    } else {
                        for (int i = 0; i < allHabits.size(); i++) {
                            Habit habit = allHabits.get(i);

                            System.out.println(
                                    (i + 1) + ". " +
                                            habit.getName() + " --- " +
                                            (habit.isCompleted() ? "Completed" : "Pending")
                            );
                        }
                    }
                    break;
                }

                case 3: {
                    System.out.print("Choose a habit number: ");
                    int habitNumber = readNumber(scanner);

                    // FIX: Main displays messages based on the result.
                    if (manager.markHabitCompleted(habitNumber)) {
                        System.out.println("Habit completed successfully");
                    } else {
                        System.out.println(
                                "Invalid habit number or already completed"
                        );
                    }
                    break;
                }

                case 4: {
                    // FIX: Main displays the progress returned by manager.
                    double progress = manager.getProgress();

                    System.out.printf("Progress: %.2f%%%n", progress);
                    break;
                }

                case 5: {
                    System.out.print("Enter the habit number to delete: ");
                    int habitNumber = readNumber(scanner);

                    if (manager.deleteHabit(habitNumber)) {
                        System.out.println("Habit deleted successfully");
                    } else {
                        System.out.println("Invalid habit number");
                    }
                    break;
                }

                case 6: {
                    System.out.print("Enter the habit number to edit: ");
                    int habitNumber = readNumber(scanner);

                    System.out.print("Enter a new habit name: ");
                    String newName = scanner.nextLine();

                    if (manager.editHabit(habitNumber, newName)) {
                        System.out.println("Habit updated successfully");
                    } else {
                        System.out.println("Invalid habit number or name");
                    }
                    break;
                }

                case 0:
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option");
            }
        }
    }

    // FIX: Reusable input method to handle invalid numbers
    // without crashing the application.
    private static int readNumber(Scanner scanner) {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
