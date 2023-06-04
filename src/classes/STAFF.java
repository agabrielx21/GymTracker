package classes;

import java.util.Date;

public abstract class STAFF extends Person {
    private Boolean isQualified;
    private Date dataAngajarii;

    public Boolean getQualified() {
        return isQualified != null ? isQualified : Boolean.FALSE;
    }

    public void setQualified(Boolean qualified) {
        isQualified = qualified;
    }

    public Date getDataAngajarii() {
        return dataAngajarii;
    }

    public void setDataAngajarii(Date dataAngajarii) {
        this.dataAngajarii = dataAngajarii;
    }

    public STAFF(){

    }
    public STAFF(Boolean isQualified, Date dataAngajarii) {
        this.isQualified = isQualified;
        this.dataAngajarii = dataAngajarii;
    }

    public STAFF(String nume, String prenume, int age, Boolean sex, Boolean isQualified, Date dataAngajarii) {
        super(nume,prenume,age,sex);
        this.isQualified = isQualified;
        this.dataAngajarii = dataAngajarii;
    }
    public STAFF(int ID,String nume, String prenume, int age, Boolean sex, Boolean isQualified, Date dataAngajarii) {
        super(ID,nume,prenume,age,sex);
        this.isQualified = isQualified;
        this.dataAngajarii = dataAngajarii;
    }

    @Override
    public String toString() {
        String sexString = "Unknown";
        if (getSex() != null) {
            sexString = getSex() ? "M" : "F";
        }

        String isQualifiedString = "Unknown";
        if(isQualified != null) {
            isQualifiedString = isQualified ? "   Client fidel" : "   Nu e client fidel";
        }
        return "Staff Member ----> " + '\n' +
                "   ID: " + getId() + '\n' +
                "   Nume: " + getNume() + '\n' +
                "   Prenume: " + getPrenume() + '\n' +
                "   Varsta: " + getAge() + '\n' +
                "   Sex: " + sexString + '\n' +
                "   Data angajarii: " + dataAngajarii + '\n' +
                "   Calificare: " + isQualifiedString;
    }
}
