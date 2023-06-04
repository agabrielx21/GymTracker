package services;

import classes.Gym;

import java.util.Set;

public interface GymInterface {

    public void addGym() throws Exception;
    public Set<Gym> getGyms();
    public void deleteGym(int ID) throws Exception;
    public void updateGym(int ID) throws Exception;
}
