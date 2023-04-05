import classes.*;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws ParseException {
    Service service = Service.getInit();
    service.doGeneralCommands();
    }
//    Gym    --    has object  --  Person    --    has object --   Membership    --    has object    --   Plan
//       ( not implemented yet )     |                                                                     |
//                                 /   \                                                                 /   \
//                              Client STAFF                                                  WorkoutPlan     EatingPlan
//                                       \                                                         |                |
//                                      /  \                                                       |                |
//                           Receptioner    Personal Trainer                           has object Exercise        has object Meal
}