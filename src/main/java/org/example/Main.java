package org.example;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HabitManager manager = new HabitManager();

        int choice;
        double completedHabits;
        double progress;
        int habitNumber;
        ArrayList<Habit> habits = new ArrayList<>();

        while(true) {
            //menu
            System.out.println("1. Add a habit");
            System.out.println("2. View all habits");
            System.out.println("3. Mark a habit as completed");
            System.out.println("4. View progress");
            System.out.println("5. Delete a habit");
            System.out.println("6. Edit a habit");
            System.out.println("0. Exit");
            choice = scanner.nextInt();
            scanner.nextLine();


            switch (choice) {
                case 1:
                    System.out.println("Add a habit selected");
                    manager.addHabit(scanner.nextLine());
                    System.out.println("Habit added successfully");
                    break;
                case 2:
                    for(int i = 0; i < habits.size(); i++){
                        System.out.println((i + 1) + ". " + habits.get(i).getName() + " --- " + habits.get(i).isCompleted());
                    }
                    break;
                case 3:
                    System.out.println("Mark a habit as completed selected");
                    System.out.print("Choose a habit number: ");
                    habitNumber = scanner.nextInt();
                    if(habitNumber>= 1 && habitNumber <= habits.size() && habits.get(habitNumber-1).isCompleted()){
                        System.out.println("This habit is already completed!");
                    }
                    else if (habitNumber>= 1 && habitNumber <= habits.size()){
                        habits.get(habitNumber - 1).markCompleted();
                        System.out.println("Habit completed successfully");
                    }else{
                        System.out.println("Invalid habit number");
                    }
                    break;
                case 4:
                    completedHabits = 0;
                    for(int i = 0; i < habits.size(); i++){
                        if(habits.get(i).isCompleted()){
                            completedHabits++;
                        }
                    }
                    if (habits.size() > 0){
                        progress = completedHabits / habits.size()*100;
                        System.out.printf("progress: %.2f%%%n",progress);
                    }else{
                        System.out.println("progress: 0.00%");
                    }
                    break;
                case 5:
                    System.out.print("Enter the habit number to be deleted: ");
                    habitNumber = scanner.nextInt();
                    if(habitNumber>= 1 && habitNumber <= habits.size()) {
                        System.out.println("Your habit: " + habits.get(habitNumber - 1).getName() + " is deleted");
                        habits.remove(habitNumber - 1);
                    }else{
                        System.out.println("Invalid habit number");
                    }
                    break;
                case 6:
                    System.out.print("Enter the habit number to be edited:");
                    habitNumber = scanner.nextInt();
                    scanner.nextLine();
                    if(habitNumber > 0 && habitNumber <= habits.size() ){
                        System.out.print("Enter a new habit name: ");
                        String newName = scanner.nextLine();
                        System.out.println(
                                "Habit: " + habits.get(habitNumber-1).getName() + "'s name has been changed to: " + newName);
                        habits.get(habitNumber-1).setName(newName);
                    }else{
                        System.out.println("Invalid habit number");
                    }
                    break;
                case 0:
                    System.out.println("goodbye");
                    return;
                default:
                    System.out.println("Invalid option");

            }
        }






//
    }
}
