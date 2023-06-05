package services;

import classes.Membership;
import java.util.Set;

public interface MembershipInterface {
    public void addMembership() throws Exception;
    public void updateMembership(int ID) throws Exception;
    public void deleteMembership(int ID) throws Exception;
    public Membership getMembershipByID(int ID) throws Exception;
    public Set<Membership> getMemberships();
    public Set<Membership> getMembershipsForSpecificClient(int IDclient);

}
