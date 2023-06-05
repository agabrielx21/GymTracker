package repositories.membership;

import classes.Membership;
import repositories.TemplateRepository;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class MembershipRepository extends TemplateRepository {
    private final String selectAll = "SELECT * FROM MEMBERSHIP";
    private final String select = "SELECT * FROM MEMBERSHIP WHERE ID = ?";
    private final String selectSpecific = "SELECT * FROM MEMBERSHIP WHERE IDCLIENT = ?";
    private final String insert = "INSERT INTO MEMBERSHIP (id, startingDate, expirationDate, pret, idClient, idSala) VALUES (?,?,?,?,?,?)";
    private final String update = "UPDATE MEMBERSHIP SET expirationDate = ? WHERE id = ? ";
    private final String delete = "DELETE FROM MEMBERSHIP WHERE id = ? ";


    public Set<Membership> SelectAll(){
        Set<Membership> memberships = new HashSet<>();
        try {
            PreparedStatement ps = conn.prepareStatement(selectAll);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Membership m = new Membership(
                        rs.getInt("id"),
                        rs.getDate("startingDate"),
                        rs.getDate("expirationDate"),
                        rs.getInt("pret"),
                        rs.getInt("idClient"),
                        rs.getInt("idSala")
                );
                memberships.add(m);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return memberships;
    }

    public Set<Membership> SelectSpecific(int IDclient){
        Set<Membership> memberships = new HashSet<>();
        try {
            PreparedStatement ps = conn.prepareStatement(selectSpecific);
            ps.setInt(1,IDclient);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Membership m = new Membership(
                        rs.getInt("id"),
                        rs.getDate("startingDate"),
                        rs.getDate("expirationDate"),
                        rs.getInt("pret"),
                        rs.getInt("idClient"),
                        rs.getInt("idSala")
                );
                memberships.add(m);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return memberships;
    }

    public Membership Select(int ID){
        try{
            PreparedStatement ps = conn.prepareStatement(select);
            ps.setInt(1,ID);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Membership m = new Membership(
                        rs.getInt("id"),
                        rs.getDate("startingDate"),
                        rs.getDate("expirationDate"),
                        rs.getInt("pret"),
                        rs.getInt("idClient"),
                        rs.getInt("idSala")
                );
                return m;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public void Insert (Membership m) {
        int newId = 0;
        try{
            String maxIdQuery = "SELECT MAX(id) FROM Membership";
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
            ps.setDate(2, new java.sql.Date( m.getStartingDate().getTime()));
            ps.setDate(3, new java.sql.Date( m.getExpirationDate().getTime()));
            ps.setInt(4,m.getPrice());
            ps.setInt(5,m.getIdClient());
            ps.setInt(6,m.getIdSala());
            ps.execute();
        }
        catch (SQLException e) {
            int errorCode = e.getErrorCode();
            if (errorCode == 2291) {
                System.out.println("Nu s-a gasit niciun client sau nicio sala de fitness cu id-urile introduse");
            }
        }
        catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void Update (Membership m, java.sql.Date data_exp_noua) {
        if (data_exp_noua.after(m.getStartingDate())) {
            try {
                PreparedStatement ps = conn.prepareStatement(update);
                ps.setDate(1, data_exp_noua);
                ps.setInt(2, m.getId());
                ps.execute();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("Nu s-a putut efectua modificarea dorita:");
            System.out.println("Data expirarii abonamentului trebuie sa fie dupa data inceperii abonamentului.");
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
