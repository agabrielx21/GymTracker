# GymTracker                          
                                                
Aplicatia propusa de mine se poate folosi pentru administrarea unei sali de fitness.
Din meniul principal se pot accesa alte meniuri in care se pot efectua operatii de tip CRUD pe clasele Client, Personal Trainer, Exercise, Meal, Membership.
Accesarea unei optiuni se va face prin citirea de la tastatura a optiunii pe care doriti sa o selectati.
Din meniul Clientului, se pot adauga clienti noi in aplicatie, sterge, actualiza sau afisa toti clientii. 
Tot din acest meniu putem sa adaugam un membership nou unui client sau sa afisam membershipurile acestuia. ( aceasta cautare se va face dupa ID-ul unui client specific )
Din celalalte meniuri, se pot face cautari pe ID pentru a afisa obiectul dorit, sau operatii de tip CRUD pe cele mai importante clase din aceasta aplicatie.

Pentru a afisa meniul principal si a efectua diferite actiuni, este necesar sa rulam fisierul Main.java care face apeluri catre o clasa serviciu ce colecteaza serviciile tuturor claselor din aplicatie si ne permite sa efectuam operatii de tip CRUD. De asemenea, in fisierul Main.java se regaseste ierarhia claselor utilizate in aplicatie.
