package repositories.person;

import classes.Client;
import repositories.TemplateRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;
import java.util.HashSet;


public class ClientRepository extends TemplateRepository {

    private final String selectAll = "SELECT * FROM CLIENT";
    private final String select = "SELECT * FROM CLIENT WHERE ID = ?";
    private final String insert = "INSERT INTO CLIENT (id, nume,prenume,age,sex,cnp,fidelity) VALUES (?,?,?,?,?,?,?)";
    private final String update = "UPDATE CLIENT SET id = ?, nume = ?, prenume = ?, age = ?, sex = ?, cnp = ?, fidelity = ? WHERE id = ? ";
    private final String delete = "DELETE FROM CLIENT WHERE id = ? ";

    public ClientRepository(){
    };

    public Set<Client> SelectAll(){
        Set<Client> clients = new HashSet<>();
        try {
            PreparedStatement ps = conn.prepareStatement(selectAll);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Client client = new Client(
                        rs.getInt("id"),
                        rs.getString("nume"),
                        rs.getString("prenume"),
                        rs.getInt("age"),
                        rs.getBoolean("sex"),
                        rs.getString("cnp"),
                        rs.getBoolean("fidelity")
                );
                clients.add(client);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return clients;
    }

    public Client Select(int ID){
        try{
            PreparedStatement ps = conn.prepareStatement(select);
            ps.setInt(1,ID);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Client client = new Client(
                        rs.getInt("id"),
                        rs.getString("nume"),
                        rs.getString("prenume"),
                        rs.getInt("age"),
                        rs.getBoolean("sex"),
                        rs.getString("cnp"),
                        rs.getBoolean("fidelity")
                );
                return client;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public void Insert (Client client) {
        int newId = 0;
        try{
            String maxIdQuery = "SELECT MAX(id) FROM Client";
            PreparedStatement maxIdPs = conn.prepareStatement(maxIdQuery);
            ResultSet maxIdRs = maxIdPs.executeQuery();
            int maxId = 0;
            if (maxIdRs.next()) {
                maxId = maxIdRs.getInt(1);
            }
            newId = maxId + 1;
        }
        catch (Exception e){
            e.printStackTrace();
        }

        try{
            PreparedStatement ps = conn.prepareStatement(insert);
            ps.setInt(1, newId);
            ps.setString(2,client.getNume());
            ps.setString(3,client.getPrenume());
            ps.setInt(4,client.getAge());
            ps.setBoolean(5,client.getSex());
            ps.setString(6,client.getCnp());
            ps.setBoolean(7,client.getFidelity());
            ps.execute();
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    public void Update (Client client, int ID) {
        try{
            PreparedStatement ps = conn.prepareStatement(update);
            ps.setInt(1, client.getId());
            ps.setString(2,client.getNume());
            ps.setString(3,client.getPrenume());
            ps.setInt(4,client.getAge());
            ps.setBoolean(5,client.getSex());
            ps.setString(6,client.getCnp());
            ps.setBoolean(7,false);
            ps.setInt(8,client.getId());
            ps.execute();
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public void Delete(int ID) {
        try {
            PreparedStatement ps = conn.prepareStatement(delete);
            ps.setInt(1, ID);
            ps.execute();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
