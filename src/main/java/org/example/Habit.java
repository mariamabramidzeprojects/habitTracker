package org.example;
//habits

public class Habit {
    private String name;
    private boolean completed;

    Habit(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setName(String newName){
        this.name = newName;
    }

    public void markCompleted(){
        completed = true;
    }
}
