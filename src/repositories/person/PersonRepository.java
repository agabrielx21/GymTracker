package repositories.person;

import classes.Client;
import database.DB_Connection;
import classes.Client;
import oracle.jdbc.proxy.annotation.Pre;
import repositories.TemplateRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonRepository extends TemplateRepository {

    private final String select = "SELECT * FROM CLIENT WHERE ID = ?";
    private final String insert = "INSERT INTO CLIENT (id, nume,prenume,age,sex,cnp,fidelity) VALUES (?,?,?,?,?,?,?)";
    private final String update = "UPDATE CLIENT SET id = ?, nume = ?, prenume = ?, age = ?, sex = ?, cnp = ?, fidelity = ? WHERE id = ? ";

    public PersonRepository(){
    };

    public Client Select(int ID){
        try{
            PreparedStatement ps = conn.prepareStatement(select);
            ps.setInt(1,ID);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Client client = new Client(
//                        rs.getInt("id"),
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
        try{
            PreparedStatement ps = conn.prepareStatement(insert);
            ps.setInt(1, client.getId() + 1);
            ps.setString(2,client.getNume());
            ps.setString(3,client.getPrenume());
            ps.setInt(4,client.getAge());
            ps.setBoolean(5,client.getSex());
            ps.setString(6,client.getCnp());
            ps.setBoolean(7,false);
            ps.execute();
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    public void Update (Client client, int ID) {
        try{
            PreparedStatement ps = conn.prepareStatement(update);
            ps.setInt(1, client.getId() + 1);
            ps.setString(2,client.getNume());
            ps.setString(3,client.getPrenume());
            ps.setInt(4,client.getAge());
            ps.setBoolean(5,client.getSex());
            ps.setString(6,client.getCnp());
            ps.setBoolean(7,false);
            ps.execute();
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }

}
