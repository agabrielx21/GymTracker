package services;
import classes.Meal;
import classes.Membership;

import java.util.List;

public interface MembershipInterface {
    public void addMembership() throws Exception;
    public void updateMembership(int ID) throws Exception;
    public void deleteMembership(int ID) throws Exception;
    public Membership getMembershipByID(int ID) throws Exception;
    public List<Membership> getMemberships();

}
