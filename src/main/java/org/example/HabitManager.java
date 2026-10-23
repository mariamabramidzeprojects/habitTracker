package org.example;

import java.util.ArrayList;

public class HabitManager {
    private ArrayList<Habit> habits = new ArrayList<>();

    public void getHabits(){
        for(int i = 0; i < habits.size(); i++){
            System.out.println((i + 1) + ". " + habits.get(i).getName() + " --- " + habits.get(i).isCompleted());
        }
    }

    public void addHabit(String name){
        Habit habit = new Habit(name);
        habits.add(habit);
    }
}
