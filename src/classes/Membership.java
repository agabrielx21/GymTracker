package classes;

import java.util.Date;

public class Membership {
    private int id;
    private static int nextId = 1;
    private WorkoutPlan workoutPlan;
    private EatingPlan eatingPlan;
    private Date startingDate;
    private Date expirationDate;
    private int price;
    public Membership() {
        this.id = nextId;
        nextId++;
    }
    public Membership(WorkoutPlan workoutPlan, EatingPlan eatingPlan, Date startingDate, Date expirationDate, int price) {
        this.workoutPlan = workoutPlan;
        this.eatingPlan = eatingPlan;
        this.startingDate = startingDate;
        this.expirationDate = expirationDate;
        this.price = price;
        this.id = nextId;
        nextId++;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        String workoutPlanString;
        String eatingPlanString;
        try {
            workoutPlanString = workoutPlan.toString();
        } catch (NullPointerException e) {
            workoutPlanString = "N/A";
        }

        try {
            eatingPlanString = eatingPlan.toString();
        } catch (NullPointerException e) {
            eatingPlanString = "N/A";
        }
        return "Membership ----> " + '\n' +
                "   ID : " + id + '\n' +
                "   Data inceput : " + startingDate + '\n' +
                "   Data expirare : " + expirationDate + '\n' +
                "   Pret : " + price + '\n' +
                "   Plan alimentar: " + workoutPlanString + '\n' +
                "   Plan antrenament: " + eatingPlanString;

    }
}
