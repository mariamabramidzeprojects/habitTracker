package org.example;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int choice;
        int completedHabits = 0;
        double progress;
        int habitNumber;
        ArrayList<Habit> habits = new ArrayList<>();

        while(true) {
            System.out.println("1. Add a habit");
            System.out.println("2. View all habits");
            System.out.println("3. Mark a habit as completed");
            System.out.println("0. Exit");
            choice = scanner.nextInt();
            scanner.nextLine();


            switch (choice) {
                case 1:
                    System.out.println("Add a habit selected");
                    habits.add(new Habit(scanner.nextLine()));
                    System.out.println("Habit added successfully");
                    break;
                case 2:
                    for(int i = 0; i < habits.size(); i++){
                        System.out.println((i + 1) + ". " + habits.get(i).name + " --- " + habits.get(i).completed);
                    }
                    break;
                case 3:
                    System.out.println("Mark a habit as completed selected");
                    System.out.print("Choose a habit number: ");
                    habitNumber = scanner.nextInt();
                    if (habitNumber>= 1 && habitNumber <= habits.size()){
                        habits.get(habitNumber - 1).markCompleted();
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







    }
}
