import classes.Client;
import classes.PersonalTrainer;
import services.ClientService;
import services.PersonalTrainerService;

import java.util.Scanner;
import java.util.Set;

public class Service {
    private static Service init;
    private ClientService clientServ = ClientService.getInit();
    private PersonalTrainerService ptServ = PersonalTrainerService.getInit();
    private Scanner scanner = new Scanner(System.in);
    private Service(){

    }
    public static Service getInit(){
        if(init == null){
            init = new Service();
        }
        return init;
    }

    public void showGeneralCommands(){
        System.out.println("--->1.Meniu manipulare clienti");
        System.out.println("--->2.Meniu manipulare personal traineri");
    }

    public void doGeneralCommands(){
        while(true){
            showGeneralCommands();
            int option = 0;
            while(true){
                try{
                    option = scanner.nextInt();
                    if(option >= 1 && option <= 2)
                        break;
                    else System.out.println("Introduceti un numar de la 1 la 2 pentru a utiliza o instructiune valida!");
                }
                catch (Exception exception){
                    System.out.println("Introduceti un numar de la 1 la 2 pentru a utiliza o instructiune valida!");
                }

            }
            if(option == 1)
                doClientCommands();
            else if(option == 2)
                doPTCommands();
            else {
                System.out.println("Optiunea " + option + ", nu a fost inca implementata!");
            }
        }
    }

    public void showPTCommands(){
        System.out.println("--->0.Exit");
        System.out.println("--->1.Afisare personal traineri");
        System.out.println("--->2.Cautare personal trainer dupa ID");
        System.out.println("--->3.Adauga personal trainer");
        System.out.println("--->4.Sterge personal trainer");
    }

    public void doPTCommands(){
        while(true){
            showPTCommands();
            int option = -1;
            while(true){
                try{
                    option = scanner.nextInt();
                    if(option >= 0 && option <= 4)
                        break;
                    else System.out.println("Introduceti un numar de la 0 la 4 pentru a utiliza o instructiune valida!");
                }
                catch (Exception exception){
                    System.out.println("Introduceti un numar de la 0 la 4 pentru a utiliza o instructiune valida!");
                }

            }
            if(option == 0){
                doGeneralCommands();
            }
            else if(option == 1){
                if(ptServ.getPT().size() == 0)
                    System.out.println("Nu exista personal traineri inregistrati in sistem");
                else{
                    Set<PersonalTrainer> personalTrainers = ptServ.getPT();
                    for(PersonalTrainer pt : personalTrainers)
                        System.out.println(pt.toString());
                }
            }
            else if(option == 2){
                System.out.println("Introduceti ID-ul personal trainerului pe care doriti sa il identificati: ");
                int id = scanner.nextInt();
                try {
                    PersonalTrainer pt = ptServ.getPTbyID(id);
                    if (pt != null) {
                        System.out.println(pt.toString());
                    } else {
                        System.out.println("Ne pare rau, dar nu exista niciun personal trainer cu ID-ul furnizat !");
                    }
                } catch (Exception e) {
                    System.out.println("A aparut o eroare la identificarea personal trainerului: ");
                }
            }
            else if(option == 3){
                try {
                    ptServ.addPT();
                }
                catch (Exception e){
                    System.out.println("A aparut o eroare la introducerea personal trainerului in sistem.");
                }
            }

            else if(option == 4){
                System.out.println("Introduceti ID-ul personal trainerului pe care doriti sa il stergeti din sistem: ");
                int id = scanner.nextInt();
                try {
                    PersonalTrainer pt = ptServ.getPTbyID(id);
                    if (pt != null) {
                        ptServ.deletePT(id);
                    } else {
                        System.out.println("Ne pare rau, dar nu exista personal trainer client cu ID-ul furnizat !");
                    }
                } catch (Exception e) {
                    System.out.println("A aparut o eroare la identificarea personal trainerului: ");
                }
            }
            else {
                System.out.println("Optiunea " + option + ", nu a fost inca implementata!");
            }
        }
    }

    public void showClientCommands(){
        System.out.println("--->0.Exit");
        System.out.println("--->1.Afisare clienti");
        System.out.println("--->2.Cautare client dupa ID");
        System.out.println("--->3.Adauga client");
        System.out.println("--->4.Modificare client");
        System.out.println("--->5.Sterge client");
    }
    public void doClientCommands(){
        while(true){
            showClientCommands();
            int option = -1;
            while(true){
                try{
                    option = scanner.nextInt();
                    if(option >= 0 && option <= 5)
                        break;
                    else System.out.println("Introduceti un numar de la 0 la 5 pentru a utiliza o instructiune valida!");
                }
                catch (Exception exception){
                    System.out.println("Introduceti un numar de la 0 la 5 pentru a utiliza o instructiune valida!");
                }

            }
            if(option == 0){
                doGeneralCommands();
            }
            else if(option == 1){
                if(clientServ.getClients().size() == 0)
                    System.out.println("Nu exista clienti inregistrati in sistem");
                else{
                    Set<Client> clients = clientServ.getClients();
                    for(Client c : clients)
                        System.out.println(c.toString());
                }
            }
            else if(option == 2){
                System.out.println("Introduceti ID-ul clientului pe care doriti sa il identificati: ");
                int id = scanner.nextInt();
                try {
                    Client client = clientServ.getClientbyID(id);
                    if (client != null) {
                        System.out.println(client.toString());
                    } else {
                        System.out.println("Ne pare rau, dar nu exista niciun client cu ID-ul furnizat !");
                    }
                } catch (Exception e) {
                    System.out.println("A aparut o eroare la identificarea clientului: ");
                }
            }
            else if(option == 3){
                try {
                    clientServ.addClient();
                }
                catch (Exception e){
                    System.out.println("A aparut o eroare la introducerea clientului in sistem.");
                }
            }
            else if(option == 4){
                System.out.println("Introduceti ID-ul clientului caruia doriti sa ii modificati profilul din sistem: ");
                int id = scanner.nextInt();
                try {
                    Client client = clientServ.getClientbyID(id);
                    if (client != null) {
                        clientServ.updateClient(id);
                    } else {
                        System.out.println("Ne pare rau, dar nu exista niciun client cu ID-ul furnizat !");
                    }
                } catch (Exception e) {
                    System.out.println("A aparut o eroare la identificarea clientului: ");
                }
            }
            else if(option == 5){
                System.out.println("Introduceti ID-ul clientului pe care doriti sa il stergeti din sistem: ");
                int id = scanner.nextInt();
                try {
                    Client client = clientServ.getClientbyID(id);
                    if (client != null) {
                        clientServ.deleteClient(id);
                    } else {
                        System.out.println("Ne pare rau, dar nu exista niciun client cu ID-ul furnizat !");
                    }
                } catch (Exception e) {
                    System.out.println("A aparut o eroare la identificarea clientului: ");
                }
            }
            else {
                System.out.println("Optiunea " + option + ", nu a fost inca implementata!");
            }
        }
    }
}
