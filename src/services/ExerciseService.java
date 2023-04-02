package services;

import classes.Client;
import classes.Exercise;

import java.util.*;

public class ExerciseService implements ExerciseInterface{

    Scanner scanner = new Scanner(System.in);
    private static ExerciseService init;
    private List<Exercise> exercises = new ArrayList<>();

    public ExerciseService() {
    }
    public ExerciseService(List<Exercise> exercises) {
        this.exercises = exercises;
    }
    public static ExerciseService getInit() {
        if (init == null)
            init = new ExerciseService();
        return init;
    }

    @Override
    public void addExercise() throws Exception {
        Exercise exercise = new Exercise();

        System.out.println("---> Introducere exercitiu nou");
        System.out.println("Nume exercitiu: ");
        exercise.setName(scanner.nextLine());

        System.out.println("Target exercitiu: ");
        exercise.setTarget(scanner.nextLine());

        System.out.println("Numar seturi exercitiu: ");
        exercise.setNumberOfSets(scanner.nextInt());
        scanner.nextLine();
        exercises.add(exercise);
    }

    @Override
    public List<Exercise> getExercises() {
        return this.exercises;
    }
}
