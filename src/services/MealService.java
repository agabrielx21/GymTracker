package services;

import classes.Meal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MealService implements MealInterface{

    Scanner scanner = new Scanner(System.in);
    private static MealService init;
    private List<Meal> meals = new ArrayList<>();

    public MealService(){

    }
    public MealService(List<Meal> meals) {
        this.meals = meals;
    }
    public static MealService getInit() {
        if (init == null)
            init = new MealService();
        return init;
    }
    @Override
    public void addMeal() throws Exception {
        Meal meal = new Meal();

        System.out.println("---> Introducere meniu de mancare nou");
        System.out.println("Nume meniu de mancare: ");
        meal.setName(scanner.nextLine());

        System.out.println("Garnitura meniului: ");
        meal.setGarnish(scanner.nextLine());

        System.out.println("Tipul de carne al meniului: ");
        meal.setMeatType(scanner.nextLine());

        System.out.println("Numarul de kcal al meniului: ");
        meal.setKcal(scanner.nextInt());
        scanner.nextLine();
        meals.add(meal);
    }

    @Override
    public List<Meal> getMeals() {
        return this.meals;
    }
}
