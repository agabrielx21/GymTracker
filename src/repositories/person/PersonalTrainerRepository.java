package repositories.person;

import classes.PersonalTrainer;
import repositories.TemplateRepository;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;
import java.util.HashSet;


public class PersonalTrainerRepository extends TemplateRepository {

    private final String selectAll = "SELECT * FROM PersonalTrainer";
    private final String select = "SELECT * FROM PersonalTrainer WHERE ID = ?";
    private final String insert = "INSERT INTO PersonalTrainer (id, nume, prenume, age, sex, calificare, dataAngajarii, specializare, experienta) VALUES (?,?,?,?,?,?,?,?,?)";
    private final String update = "UPDATE PersonalTrainer SET dataAngajarii = ? WHERE id = ? ";
    private final String delete = "DELETE FROM PersonalTrainer WHERE id = ? ";

    public PersonalTrainerRepository(){
    };

    public Set<PersonalTrainer> SelectAll(){
        Set<PersonalTrainer> PT = new HashSet<>();
        try {
            PreparedStatement ps = conn.prepareStatement(selectAll);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PersonalTrainer p = new PersonalTrainer(
                        rs.getInt("id"),
                        rs.getString("nume"),
                        rs.getString("prenume"),
                        rs.getInt("age"),
                        rs.getBoolean("sex"),
                        rs.getBoolean("calificare"),
                        rs.getDate("dataAngajarii"),
                        rs.getString("specializare"),
                        rs.getInt("experienta")
                );
                PT.add(p);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return PT;
    }

    public PersonalTrainer Select(int ID){
        try{
            PreparedStatement ps = conn.prepareStatement(select);
            ps.setInt(1,ID);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                PersonalTrainer p = new PersonalTrainer(
                        rs.getInt("id"),
                        rs.getString("nume"),
                        rs.getString("prenume"),
                        rs.getInt("age"),
                        rs.getBoolean("sex"),
                        rs.getBoolean("calificare"),
                        rs.getDate("dataAngajarii"),
                        rs.getString("specializare"),
                        rs.getInt("experienta")
                );
                return p;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public void Insert (PersonalTrainer pt) {
        int newId = 0;
        try{
            String maxIdQuery = "SELECT MAX(id) FROM PersonalTrainer";
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
            ps.setString(2,pt.getNume());
            ps.setString(3,pt.getPrenume());
            ps.setInt(4,pt.getAge());
            ps.setBoolean(5,pt.getSex());
            ps.setBoolean(6,pt.getQualified());
            ps.setDate(7,new java.sql.Date(pt.getDataAngajarii().getTime()));
            ps.setString(8,pt.getSpecializare());
            ps.setInt(9,pt.getExperienta());
            ps.execute();

        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    public void Update(PersonalTrainer pt, java.sql.Date data_ang) {
        try{
            PreparedStatement ps = conn.prepareStatement(update);
            ps.setDate(1, data_ang);
            ps.setInt(2, pt.getId());
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
