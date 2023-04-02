package classes;

import java.util.Vector;

public class WorkoutPlan extends Plan{
    private Vector<Exercise> exercises;

    public WorkoutPlan(Vector<Exercise> exercises) {
        this.exercises = exercises;
    }

    public WorkoutPlan(int price, int duration, Vector<Exercise> exercises) {
        super(price, duration);
        this.exercises = exercises;
    }

    public WorkoutPlan() {

    }

    public Vector<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(Vector<Exercise> exercises) {
        this.exercises = exercises;
    }

    @Override
    public String toString() {
        return "\nWorkoutPlan ----> " + '\n' +
                "   Pret: " + getprice() + '\n' +
                "   Durata: " + getDuration() + '\n'+ exercises.toString();

    }

}
