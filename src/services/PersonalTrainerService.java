package services;
import classes.PersonalTrainer;
import repositories.person.PersonalTrainerRepository;
import java.util.*;
import java.util.stream.Collectors;

public class PersonalTrainerService implements PersonalTrainerInterface {

    Scanner scanner = new Scanner(System.in);
    private static PersonalTrainerService init;

    private final PersonalTrainerRepository ptRepository = new PersonalTrainerRepository();
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
        ptRepository.Insert(personalTrainer);
    }

    @Override
    public Set<PersonalTrainer> getPT() {
        Set<PersonalTrainer> personalTrainers = ptRepository.SelectAll();
        return personalTrainers.stream().sorted(Comparator.comparingInt(PersonalTrainer::getId)).collect(Collectors.toCollection(LinkedHashSet::new));
    }

    @Override
    public PersonalTrainer getPTbyID(int ID) throws Exception {
        return ptRepository.Select(ID);
    }

    @Override
    public void deletePT(int ID) throws Exception {
        ptRepository.Delete(ID);
    }

    @Override
    public void updatePT(int ID) throws Exception {
        PersonalTrainer ptToUpdate = getPTbyID(ID);
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduceti data angajarii care va inlocui data actuala a personal trainerului ");

        int an;
        do {
            System.out.print("Anul: ");
            an = scanner.nextInt();
        } while (an < 0);

        int luna;
        do {
            System.out.print("Luna: (1-12) ");
            luna = scanner.nextInt();
        } while (luna < 1 || luna > 12);

        int ziua;
        do {
            System.out.print("Ziua: (1-31) ");
            ziua = scanner.nextInt();
        } while (ziua < 1 || ziua > 31);

        Calendar calendar = Calendar.getInstance();
        calendar.set(an, luna - 1, ziua);
        java.util.Date utilDate = calendar.getTime();

        java.sql.Date data_angajarii_noua = new java.sql.Date(utilDate.getTime());

        ptRepository.Update(ptToUpdate, data_angajarii_noua);
    }
}
