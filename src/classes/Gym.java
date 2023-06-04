package classes;

import java.util.Vector;

public class Gym {
    private Vector<PersonalTrainer> trainers;
    private Vector<Receptioner> receptioners;

    private String nume;
    private String adresa;
    private int numarClienti;

    public Gym(){
    }
    public Gym(String nume, Vector<PersonalTrainer> trainers, Vector<Receptioner> receptioners, String adresa, int numarClienti) {
        this.nume = nume;
        this.trainers = trainers;
        this.receptioners = receptioners;
        this.adresa = adresa;
        this.numarClienti = numarClienti;
    }

    public Gym(String nume, String adresa, int numarClienti){
        this.nume = nume;
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

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    @Override
    public String toString() {
        return "Gym ----> " + '\n' +
                "   Nume: " + getNume() + '\n' +
                "   Adresa: " + getAdresa() + '\n' +
                "   Numar Clienti: " + getNumarClienti() + '\n';
    }
}
