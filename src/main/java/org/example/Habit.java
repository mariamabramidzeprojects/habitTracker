package org.example;
//habits

public class Habit {
    String name;
    boolean completed;

    Habit(String name){
        this.name = name;
    }
    public void markCompleted(){
        completed = true;
    }
}
