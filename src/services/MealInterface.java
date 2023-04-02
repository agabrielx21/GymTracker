package services;

import classes.Meal;
import java.util.List;
public interface MealInterface {

    public void addMeal() throws Exception;
    public List<Meal> getMeals();
}
