
package org.example;

import java.util.ArrayList;

public class HabitManager {

    private final ArrayList<Habit> habits = new ArrayList<>();

    public ArrayList<Habit> getAllHabits() {
        // FIX: Return a new list so callers cannot
        // clear or remove items from the original list.
        return new ArrayList<>(habits);
    }

    public boolean addHabit(String name) {
        // FIX: Return false for invalid names instead
        // of silently ignoring them.
        if (name == null || name.isBlank()) {
            return false;
        }

        Habit habit = new Habit(name);
        habits.add(habit);
        return true;
    }

    public boolean markHabitCompleted(int habitNumber) {
        // FIX: Validate the number before accessing the list.
        if (habitNumber < 1 || habitNumber > habits.size()) {
            return false;
        }

        Habit habit = habits.get(habitNumber - 1);

        // FIX: Do not mark an already completed habit again.
        if (habit.isCompleted()) {
            return false;
        }

        habit.markCompleted();
        return true;
    }

    public boolean deleteHabit(int habitNumber) {
        if (habitNumber < 1 || habitNumber > habits.size()) {
            return false;
        }

        habits.remove(habitNumber - 1);

        // FIX: Return true when deletion succeeds.
        return true;
    }

    public boolean editHabit(int habitNumber, String newName) {
        // FIX: Validate both the habit number and the new name.
        if (habitNumber < 1 || habitNumber > habits.size()) {
            return false;
        }

        if (newName == null || newName.isBlank()) {
            return false;
        }

        habits.get(habitNumber - 1).setName(newName);

        // FIX: Return true after successful editing.
        return true;
    }

    public double getProgress() {
        // FIX: Avoid division by zero when no habits exist.
        if (habits.isEmpty()) {
            return 0.0;
        }

        int completedHabits = 0;

        for (Habit habit : habits) {
            if (habit.isCompleted()) {
                completedHabits++;
            }
        }

        // FIX: Return the result instead of printing it.
        return (double) completedHabits / habits.size() * 100;
    }
}
