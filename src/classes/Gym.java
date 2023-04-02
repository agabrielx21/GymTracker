package classes;

import java.util.Vector;

public class Gym {
    private Vector<PersonalTrainer> trainers;
    private Vector<Receptioner> receptioners;
    private String adresa;
    private int numarClienti;

    public Gym(){
    }
    public Gym(Vector<PersonalTrainer> trainers, Vector<Receptioner> receptioners, String adresa, int numarClienti) {
        this.trainers = trainers;
        this.receptioners = receptioners;
        this.adresa = adresa;
        this.numarClienti = numarClienti;
    }

    public Vector<PersonalTrainer> getTrainers() {
        return trainers;
    }

    public Vector<Receptioner> getReceptioners() {
        return receptioners;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public int getNumarClienti() {
        return numarClienti;
    }

    public void setNumarClienti(int numarClienti) {
        this.numarClienti = numarClienti;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
