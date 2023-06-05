package repositories.gym;
import classes.Gym;
import repositories.TemplateRepository;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class GymRepository extends TemplateRepository {

    private final String insert = "INSERT INTO GYM (id, nume, adresa, numarClienti) VALUES (?, ?, ?, ?)";
    private final String selectAll = "SELECT * FROM GYM";
    private final String update = "UPDATE GYM SET adresa = ? WHERE id = ?";
    private final String delete = "DELETE FROM GYM WHERE id = ? ";


    public GymRepository(){
    };

    public void Insert(Gym gym){
        int newId = 0;
        try{
            String maxIdQuery = "SELECT MAX(id) FROM GYM";
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
            ps.setString(2,gym.getNume());
            ps.setString(3,gym.getAdresa());
            ps.setInt(4,gym.getNumarClienti());
            ps.execute();
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public Set<Gym> SelectAll(){
        Set<Gym> gyms = new HashSet<>();
        try {
            PreparedStatement ps = conn.prepareStatement(selectAll);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Gym gym = new Gym(
                        rs.getString("nume"),
                        rs.getString("adresa"),
                        rs.getInt("numarClienti")
                );
                gyms.add(gym);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return gyms;
    }

    public void Update (int ID, String new_address) {
        try{
            PreparedStatement ps = conn.prepareStatement(update);
            ps.setString(1, new_address);
            ps.setInt(2, ID);
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
