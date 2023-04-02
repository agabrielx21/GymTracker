package classes;

import java.util.Date;

public class Receptioner extends STAFF{
    private int numarAbonamente;
    private String shift;

    public Receptioner(int numarAbonamente, String shift) {
        this.numarAbonamente = numarAbonamente;
        this.shift = shift;
    }

    public Receptioner(Boolean isQualified, Date dataAngajarii, int numarAbonamente, String shift) {
        super(isQualified, dataAngajarii);
        this.numarAbonamente = numarAbonamente;
        this.shift = shift;
    }

    public Receptioner(String nume, String prenume, int age, Boolean sex, Boolean isQualified, Date dataAngajarii, int numarAbonamente, String shift) {
        super(nume, prenume, age, sex, isQualified, dataAngajarii);
        this.numarAbonamente = numarAbonamente;
        this.shift = shift;
    }

    public int getnumarAbonamente() {
        return numarAbonamente;
    }

    public void setnumarAbonamente(int numarAbonamente) {
        this.numarAbonamente = numarAbonamente;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
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

        return "Receptioner ----> " + '\n' +
                "   ID: " + getId() + '\n' +
                "   Nume: " + getNume() + '\n' +
                "   Prenume: " + getPrenume() + '\n' +
                "   Varsta: " + getAge() + '\n' +
                "   Sex: " + sexString + '\n' +
                "   Tura : " + shift + '\n' +
                "   Numar abonamente : " + numarAbonamente + '\n' + isQualifiedString;
    }
}
