package classes;

public class Exercise {
    private String name;
    private int numberOfSets;
    private String target;

    public Exercise(String name, int numberOfSets, String target) {
        this.name = name;
        this.numberOfSets = numberOfSets;
        this.target = target;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfSets() {
        return numberOfSets;
    }

    public void setNumberOfSets(int numberOfSets) {
        this.numberOfSets = numberOfSets;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }
    @Override
    public String toString() {
        return "\nExercise ----> " + '\n' +
                "   Nume: " + name + '\n' +
                "   Grupa musculara : " + target + '\n' +
                "   Numar de seturi recomandat: " + numberOfSets;

    }

}
