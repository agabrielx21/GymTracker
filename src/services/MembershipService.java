package services;

import classes.*;
import java.util.*;
import java.util.stream.Collectors;
import repositories.membership.MembershipRepository;

public class MembershipService implements MembershipInterface{
    Scanner scanner = new Scanner(System.in);
    private static MembershipService init;

    private MembershipRepository MembershipRepository = new MembershipRepository();
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

        System.out.println("Introduceti ID-ul clientului: ");
        int idClient = scanner.nextInt();


        System.out.println("Introduceti ID-ul salii de fitness: ");
        int idSala = scanner.nextInt();

        Membership m = new Membership(1, new Date(),new Date(), price, idClient, idSala);
        MembershipRepository.Insert(m);
    }

    @Override
    public void updateMembership(int ID) throws Exception {
        Membership membershipToUpdate = getMembershipByID(ID);
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduceti data expirarii noua a abonamentului : ");

        int an;
        do {
            System.out.print("Anul: ");
            an = scanner.nextInt();
        } while (an < 0);

        int luna;
        do {
            System.out.print("Luna: (1-12) ");
            luna = scanner.nextInt();
        } while (luna < 1 || luna > 12);

        int ziua;
        do {
            System.out.print("Ziua: (1-31) ");
            ziua = scanner.nextInt();
        } while (ziua < 1 || ziua > 31);

        Calendar calendar = Calendar.getInstance();
        calendar.set(an, luna - 1, ziua);
        java.util.Date utilDate = calendar.getTime();

        java.sql.Date data_exp_noua = new java.sql.Date(utilDate.getTime());

        MembershipRepository.Update(membershipToUpdate, data_exp_noua);
    }

    @Override
    public void deleteMembership(int ID) throws Exception {
        MembershipRepository.Delete(ID);
    }

    @Override
    public Membership getMembershipByID(int ID) throws Exception {
        return MembershipRepository.Select(ID);
    }

    @Override
    public Set<Membership> getMemberships() {
        Set<Membership> memberships = MembershipRepository.SelectAll();
        return memberships.stream().sorted(Comparator.comparingInt(Membership::getPrice)).collect(Collectors.toCollection(LinkedHashSet::new));
    }

    @Override
    public Set<Membership> getMembershipsForSpecificClient(int IDclient) {
        Set<Membership> memberships = MembershipRepository.SelectSpecific(IDclient);
        return memberships.stream().sorted(Comparator.comparingInt(Membership::getPrice)).collect(Collectors.toCollection(LinkedHashSet::new));
    }


}
