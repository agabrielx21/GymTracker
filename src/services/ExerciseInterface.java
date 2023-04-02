package services;

import classes.Exercise;
import java.util.List;
public interface ExerciseInterface {

    public void addExercise() throws Exception;
    public List<Exercise> getExercises();

}
