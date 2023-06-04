package services;

import classes.Client;
import classes.Gym;
import repositories.gym.GymRepository;

import java.util.*;
import java.util.stream.Collectors;

public class GymService implements GymInterface{

    Scanner scanner = new Scanner(System.in);
    private static GymService init;
    private GymRepository GymRepository = new GymRepository();
    private Set<Gym> gyms = new HashSet<>();

    public GymService(){
    }
    public static GymService getInit() {
        if (init == null)
            init = new GymService();
        return init;
    }
    @Override
    public void addGym() throws Exception {
        Gym gym = new Gym();
        System.out.println("---> Introducere sala noua in sistem");

        System.out.println("Nume:");
        gym.setNume(scanner.nextLine());

        System.out.println("Adresa:");
        gym.setAdresa(scanner.nextLine());

        System.out.println("Numar clienti:");
        gym.setNumarClienti(scanner.nextInt());
        GymRepository.Insert(gym);
    }

    @Override
    public Set<Gym> getGyms() {
        Set<Gym> gyms = GymRepository.SelectAll();
        return gyms.stream().sorted(Comparator.comparingInt(Gym::getNumarClienti)).collect(Collectors.toCollection(LinkedHashSet::new));
    }

    @Override
    public void updateGym(int ID) throws Exception {
        System.out.println("Introduceti noua adresa a salii selectate");
        String new_adress = scanner.nextLine();
        GymRepository.Update(ID, new_adress);
    }

    @Override
    public void deleteGym(int ID) throws Exception {
        GymRepository.Delete(ID);
    }
}
