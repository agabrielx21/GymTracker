package services;

import classes.Client;
import classes.Membership;

import java.util.List;
import java.util.Set;

public interface ClientInterface {

    public void addClient() throws Exception;
    public Set<Client> getClients();
    public Client getClientbyID(int ID) throws Exception;
    public void updateClient(int ID) throws Exception;
    public void deleteClient(int ID) throws Exception;
    public List<Membership> getMembershipToList(int ID) throws Exception;
}
