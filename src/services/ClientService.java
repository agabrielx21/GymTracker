package services;

import classes.Client;
import classes.Membership;

import java.util.*;
import java.util.stream.Collectors;

import repositories.person.ClientRepository;
public class ClientService implements ClientInterface {

    Scanner scanner = new Scanner(System.in);
    private static ClientService init;

    private ClientRepository ClientRepository = new ClientRepository();
    private Set<Client> clients = new HashSet<Client>();

    public ClientService() {
    }
    public static ClientService getInit() {
        if (init == null)
            init = new ClientService();
        return init;
    }

    public ClientService(Set<Client> clients) {
        this.clients = clients;
    }

    @Override
    public void addClient() throws Exception {
        Client client = new Client();
        System.out.println("---> Introducere client nou");

        System.out.println("Nume client: ");
        client.setNume(scanner.nextLine());

        System.out.println("Prenume client: ");
        client.setPrenume(scanner.nextLine());

        System.out.println("Varsta client: ");
        client.setAge(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Sex client:\n--->1.M\n--->2.F");
        int gender = 0;
        do {
            gender = scanner.nextInt();
            scanner.nextLine();
            if(gender == 1)
                client.setSex(true);
            else if(gender == 2)
                client.setSex(false);
            else System.out.println("Optiunile invalida, va rugam sa reintroduceti optiunea dorita.");
        } while (gender != 1 && gender != 2);

        String cnp = "";
        System.out.println("CNP client: ");
        while (cnp.length() != 13) {
            if(!cnp.isEmpty())
                System.out.println("CNP client: ");
            cnp = scanner.nextLine();
            if (cnp.length() != 13 && !cnp.isEmpty())
                System.out.println("CNP invalid, va rugam sa introduceti un cnp format din 13 cifre !");
        }

        client.setCnp(cnp);
        ClientRepository.Insert(client);

    }

    @Override
    public Set<Client> getClients() {
        Set<Client> clients = ClientRepository.SelectAll();
        return clients.stream().sorted(Comparator.comparingInt(Client::getId)).collect(Collectors.toCollection(LinkedHashSet::new));
    }

    @Override
    public Client getClientbyID(int ID) throws Exception {
        return ClientRepository.Select(ID);
    }

    @Override
    public void updateClient(int ID) throws Exception {
        Boolean updated = false;
        Client clientToUpdate = getClientbyID(ID);
        int option = 0;
        do {
            System.out.println("Introduceti nr.optiunii pe care doriti sa o efectuati:\n1.Modificare nume\n2.Modificare prenume");
            option = scanner.nextInt();
            scanner.nextLine();
            if(option == 1){
                System.out.println("Introduceti numele modificat al clientului: ");
                String nume = scanner.nextLine();
                clientToUpdate.setNume(nume);
            }
            else if(option == 2){
                System.out.println("Introduceti prenumele modificat al clientului: ");
                String prenume = scanner.nextLine();
                clientToUpdate.setPrenume(prenume);
            }
            else System.out.println("Optiunile invalida, va rugam sa reintroduceti optiunea dorita.");
        } while (option != 1 && option != 2);
        ClientRepository.Update(clientToUpdate,ID);
    }

    @Override
    public void deleteClient(int ID) throws Exception {
        ClientRepository.Delete(ID);
    }

    @Override
    public List<Membership> getMembershipToList(int ID) throws Exception {
        for (Client client : clients) {
            if (client.getId() == ID)
                return client.getMembershipList();
        }
        throw new Exception("Ne pare rau, dar nu exista niciun client cu ID-ul furnizat !");
    }


}
