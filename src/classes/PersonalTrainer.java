package classes;

import java.util.Date;

public class PersonalTrainer extends STAFF {

    private String specializare;
    private int experienta;

    public PersonalTrainer(){

    }

    public PersonalTrainer(String specializare, int experienta) {
        this.specializare = specializare;
        this.experienta = experienta;
    }

    public PersonalTrainer(Boolean isQualified, Date dataAngajarii, String specializare, int experienta) {
        super(isQualified, dataAngajarii);
        this.specializare = specializare;
        this.experienta = experienta;
    }

    public PersonalTrainer(int ID,String nume, String prenume, int age, Boolean sex, Boolean isQualified, Date dataAngajarii, String specializare, int experienta) {
        super(ID, nume, prenume, age, sex, isQualified, dataAngajarii);
        this.specializare = specializare;
        this.experienta = experienta;
    }

    public String getSpecializare() {
        return specializare;
    }

    public void setSpecializare(String specializare) {
        this.specializare = specializare;
    }

    public int getExperienta() {
        return experienta;
    }

    public void setExperienta(int experienta) {
        this.experienta = experienta;
    }

    public PersonalTrainer(String nume, String prenume, int age, Boolean sex, Boolean isQualified, Date dataAngajarii, String specializare, int experienta) {
        super(nume, prenume, age, sex, isQualified, dataAngajarii);
        this.specializare = specializare;
        this.experienta = experienta;
    }

    @Override
    public String toString() {
        String sexString = "Unknown";
        if (getSex() != null) {
            sexString = getSex() ? "M" : "F";
        }
        String isQualifiedString = "Unknown";
        if(getQualified() != null) {
            isQualifiedString = getQualified() ? "   Calificat" : "   Necalificat";
        }
        return "Personal Trainer ----> " + '\n' +
                "   ID: " + getId() + '\n' +
                "   Nume: " + getNume() + '\n' +
                "   Prenume: " + getPrenume() + '\n' +
                "   Varsta: " + getAge() + '\n' +
                "   Sex: " + sexString + '\n' +
                "   Specializare : " + specializare + '\n' +
                "   Experienta : " + experienta + " an/ani" + '\n' +
                "   Data angajarii: " + getDataAngajarii() + '\n' + isQualifiedString;
    }
}
