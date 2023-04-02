package services;
import classes.Client;
import classes.PersonalTrainer;

import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PersonalTrainerService implements PersonalTrainerInterface {

    Scanner scanner = new Scanner(System.in);
    private static PersonalTrainerService init;
    private Set<PersonalTrainer> personalTrainers = new HashSet<PersonalTrainer>();

    public PersonalTrainerService() {
    }

    public static PersonalTrainerService getInit() {
        if (init == null)
            init = new PersonalTrainerService();
        return init;
    }

    public PersonalTrainerService(Set<PersonalTrainer> personalTrainers) {
        this.personalTrainers = personalTrainers;
    }
    @Override
    public void addPT() throws Exception {
        PersonalTrainer personalTrainer = new PersonalTrainer();
        System.out.println("---> Introducere personal trainer nou");

        System.out.println("Nume personal trainer: ");
        personalTrainer.setNume(scanner.nextLine());

        System.out.println("Prenume personal trainer: ");
        personalTrainer.setPrenume(scanner.nextLine());

        System.out.println("Varsta personal trainer: ");
        personalTrainer.setAge(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Sex personal trainer:\n--->1.M\n--->2.F");
        int gender = 0;
        do {
            gender = scanner.nextInt();
            scanner.nextLine();
            if(gender == 1)
                personalTrainer.setSex(true);
            else if(gender == 2)
                personalTrainer.setSex(false);
            else System.out.println("Optiunile invalida, va rugam sa reintroduceti optiunea dorita.");
        } while (gender != 1 && gender != 2);

        personalTrainer.setDataAngajarii(new Date());
        System.out.println("Specializarea personal trainerului:");
        String specializare = "";
        specializare = scanner.nextLine();
        personalTrainer.setSpecializare(specializare);

        System.out.println("Experienta (in ani) a personal trainerului:");
        int experienta = scanner.nextInt();
        personalTrainer.setExperienta(experienta);

        this.personalTrainers.add(personalTrainer);
    }

    @Override
    public Set<PersonalTrainer> getPT() {
        return this.personalTrainers;
    }

    @Override
    public PersonalTrainer getPTbyID(int ID) throws Exception {
        for (PersonalTrainer pt : personalTrainers) {
            if (pt.getId() == ID)
                return pt;
        }
        throw new Exception("Ne pare rau, dar nu exista niciun personal trainer cu ID-ul furnizat !");
    }

    @Override
    public void deletePT(int ID) throws Exception {
        Boolean deleted = false;
        for (PersonalTrainer pt : personalTrainers) {
            if (pt.getId() == ID) {
                this.personalTrainers.remove(pt);
                deleted = true;
                break;
            }
        }
        if (deleted == false)
            throw new Exception("Ne pare rau, dar nu exista niciun client cu ID-ul furnizat !");
    }
}
