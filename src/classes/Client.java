package classes;
import java.util.List;
public class Client extends Person{
    private String cnp;
    private Boolean fidelity;
    private List<Membership> membershipList;

    public List<Membership> getMembershipList() {
        return membershipList;
    }

    public void setMembershipList(List<Membership> membershipList) {
        this.membershipList = membershipList;
    }

    public Client(){

    }
    public Client(String cnp, Boolean fidelity){
        this.cnp = cnp;
        this.fidelity = fidelity;
    }
    public Client (String nume, String prenume, int age, Boolean sex, String cnp, Boolean fidelity) {
        super(nume,prenume,age,sex);
        this.cnp = cnp;
        this.fidelity = fidelity;
    }

    public Client (int ID, String nume, String prenume, int age, Boolean sex, String cnp, Boolean fidelity){
        super(ID,nume,prenume,age,sex);
        this.cnp = cnp;
        this.fidelity = fidelity;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public Boolean getFidelity() {
        return fidelity != null ? fidelity : Boolean.FALSE;
    }

    public void setFidelity(Boolean fidelity) {
        this.fidelity = fidelity;
    }

    @Override
    public String toString() {
        String sexString = "Unknown";
        if (getSex() != null) {
            sexString = getSex() ? "M" : "F";
        }
        String fidelityString = "   Unknown fidelity";
        if(fidelity != null) {
            fidelityString = fidelity ? "   Client fidel" : "   Nu e client fidel";
        }
        return "Client ----> " + '\n' +
                "   ID: " + getId() + '\n' +
                "   Nume: " + getNume() + '\n' +
                "   Prenume: " + getPrenume() + '\n' +
                "   Varsta: " + getAge() + '\n' +
                "   Sex: " + sexString + '\n' +
                "   CNP: " + cnp + '\n' + fidelityString;

    }
}
