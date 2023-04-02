package services;
import classes.PersonalTrainer;
import java.util.Set;

public interface PersonalTrainerInterface {

    public void addPT() throws Exception;
    public Set<PersonalTrainer> getPT();
    public PersonalTrainer getPTbyID(int ID) throws Exception;
    public void deletePT(int ID) throws Exception;
}
