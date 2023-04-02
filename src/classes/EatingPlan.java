package classes;

import java.util.Vector;

public class EatingPlan extends Plan{
    private Vector<Meal> meals;

    public EatingPlan(Vector<Meal> meals) {
        this.meals = meals;
    }

    public EatingPlan(int price, int duration, Vector<Meal> meals) {
        super(price, duration);
        this.meals = meals;
    }

    public EatingPlan() {

    }

    public Vector<Meal> getMeals() {
        return meals;
    }

    public void setMeals(Vector<Meal> meals) {
        this.meals = meals;
    }

    @Override
    public String toString() {
        return "\nEatingPlan ----> " + '\n' +
                "   Pret: " + getprice() + '\n' +
                "   Durata: " + getDuration() + '\n'+ meals.toString();

    }
}

