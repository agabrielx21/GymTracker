package classes;

public class Person {
    private int id;
    private static int nextId = 1;
    private String nume;
    private String prenume;
    private int age;
    private Boolean sex;

    public Person() {
        this.id = nextId;
        nextId++;
    }

    public Person(String nume, String prenume, int age, Boolean sex) {
        this.nume = nume;
        this.prenume = prenume;
        this.id = nextId;
        nextId++;
        this.age = age;
        this.sex = sex;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Persoana ----> " + '\n' +
                "   ID: " + id + '\n' +
                "   Nume: " + nume + '\n' +
                "   Prenume: " + prenume + '\n' +
                "   Varsta: " + age + '\n' +
                "   Sex: " + ( sex ? "M" : "F") ;
    }
}
