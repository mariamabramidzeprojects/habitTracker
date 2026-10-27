
package org.example;

public class Habit {
    private String name;
    private boolean completed;

    public Habit(String name) {
        // FIX: Constructor also validates the name.
        setName(name);
    }

    public String getName() {
        return name;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setName(String newName) {
        // FIX: Prevent null or blank habit names
        if (newName == null || newName.isBlank()) {
            throw new IllegalArgumentException("Habit name cannot be empty");
        }

        this.name = newName.trim();
    }

    public void markCompleted() {
        completed = true;
    }
}