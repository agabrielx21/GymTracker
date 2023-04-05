# GymTracker
Class hierarchy                            
                            
Gym    --    has object  --  Person    --    has object --   Membership    --    has object    --    Plan
    ( not implemented yet )     |                                                                     |
                              /   \                                                                /   \
                           Client STAFF                                                  WorkoutPlan   EatingPlan
                                     \                                                         |            |
                                    /  \                                                       |            |
                        Receptioner    Personal Trainer                         has object Exercise     has object Meal
                        
Aplicatia propusa de mine se poate folosi pentru administrarea unei sali de fitness. 
Din meniul principal se pot efectua operatii de tip CRUD pe clasele Client, Personal Trainer, Exercise, Meal, Membership
Din meniul Clientului, se pot adauga clienti noi in aplicatie, sterge, actualiza sau afisa toti clientii. 
Tot din acest meniu putem sa adaugam un membership nou unui client sau sa afisam membershipurile acestuia. ( aceasta cautare se va face dupa ID-ul unui client specific )
