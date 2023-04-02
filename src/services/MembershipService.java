package services;

import classes.*;

import java.util.*;

public class MembershipService implements MembershipInterface{
    Scanner scanner = new Scanner(System.in);
    private static MembershipService init;
    private List<Membership> memberships = new ArrayList<>();

    public MembershipService() {
    }

    public MembershipService(List<Membership> memberships) {
        this.memberships = memberships;
    }

    public static MembershipService getInit() {
        if (init == null)
            init = new MembershipService();
        return init;
    }
    @Override
    public void addMembership() throws Exception {
        WorkoutPlan wp = new WorkoutPlan();
        EatingPlan mp = new EatingPlan();
        System.out.println("Introduceti pretul membershipului: ");
        int price = scanner.nextInt();
        Membership m = new Membership(wp,mp,new Date(),new Date(),price);
        memberships.add(m);
    }

    @Override
    public void updateMembership(int ID) throws Exception {
        //TODO
    }

    @Override
    public void deleteMembership(int ID) throws Exception {
        Boolean deleted = false;
        for (Membership membership : memberships) {
            if (membership.getId() == ID) {
                this.memberships.remove(membership);
                deleted = true;
                break;
            }
        }
        if (deleted == false)
            throw new Exception("Ne pare rau, dar nu exista niciun membership cu ID-ul furnizat !");
    }

    @Override
    public Membership getMembershipByID(int ID) throws Exception {
        for (Membership membership : memberships) {
            if (membership.getId() == ID)
                return membership;
        }
        throw new Exception("Ne pare rau, dar nu exista niciun membership cu ID-ul furnizat !");
    }

    @Override
    public List<Membership> getMemberships() {
        return this.memberships;
    }
}
