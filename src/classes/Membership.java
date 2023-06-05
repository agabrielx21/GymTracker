package classes;

import java.util.Date;

public class Membership {
    private int id;
    private static int nextId = 1;
    private WorkoutPlan workoutPlan;
    private EatingPlan eatingPlan;
    private Date startingDate;
    private Date expirationDate;
    private int idClient;
    private int idSala;
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

    public Membership(int ID, Date startingDate, Date expirationDate, int pret, int idClient, int idSala){
        this.id = ID;
        this.startingDate = startingDate;
        this.expirationDate = expirationDate;
        this.price = pret;
        this.idClient = idClient;
        this.idSala = idSala;
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

    public int getIdSala() {
        return idSala;
    }

    public void setIdSala(int idSala) {
        this.idSala = idSala;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    @Override
    public String toString() {

        try {
            return "Membership ----> " + '\n' +
                    "   ID : " + id + '\n' +
                    "   Data inceput : " + startingDate + '\n' +
                    "   Data expirare : " + expirationDate + '\n' +
                    "   Pret : " + price + '\n' +
                    "   IDclient : " + idClient + '\n' +
                    "   IDsala : " + idSala;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
