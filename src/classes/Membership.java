package classes;

import java.util.Date;

public class Membership {
    private WorkoutPlan workoutPlan;
    private EatingPlan eatingPlan;
    private Date startingDate;
    private Date expirationDate;
    private int price;

    public Membership(WorkoutPlan workoutPlan, EatingPlan eatingPlan, Date startingDate, Date expirationDate, int price) {
        this.workoutPlan = workoutPlan;
        this.eatingPlan = eatingPlan;
        this.startingDate = startingDate;
        this.expirationDate = expirationDate;
        this.price = price;
    }

    public WorkoutPlan getWorkoutPlan() {
        return workoutPlan;
    }

    public void setWorkoutPlan(WorkoutPlan workoutPlan) {
        this.workoutPlan = workoutPlan;
    }

    public EatingPlan getEatingPlan() {
        return eatingPlan;
    }

    public void setEatingPlan(EatingPlan eatingPlan) {
        this.eatingPlan = eatingPlan;
    }

    public Date getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(Date startingDate) {
        this.startingDate = startingDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Membership ----> " + '\n' +
                "   Data inceput : " + startingDate + '\n' +
                "   Data expirare : " + expirationDate + '\n' +
                "   Pret : " + price + '\n' +
                "   Plan alimentar: " + workoutPlan.toString() + '\n' +
                "   Plan antrenament: " + eatingPlan.toString();

    }
}
