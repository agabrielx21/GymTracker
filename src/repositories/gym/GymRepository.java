package repositories.gym;

import classes.Receptioner;
import database.DB_Connection;
import classes.Gym;
import repositories.TemplateRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GymRepository extends TemplateRepository {

    private final String select = "SELECT * FROM GYM WHERE ID = ?";

    public GymRepository(){
    };

    public Gym Select(int ID){
        try{
            PreparedStatement ps = conn.prepareStatement(select);
            ps.setInt(1,ID);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){

            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return new Gym();
    }


}
