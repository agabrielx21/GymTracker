package classes;

public class Meal {
    private String name;
    private String meatType;
    private String garnish;
    private int kcal;

    public Meal(String name, String meatType, String garnish, int kcal) {
        this.name = name;
        this.meatType = meatType;
        this.garnish = garnish;
        this.kcal = kcal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMeatType() {
        return meatType;
    }

    public void setMeatType(String meatType) {
        this.meatType = meatType;
    }

    public String getGarnish() {
        return garnish;
    }

    public void setGarnish(String garnish) {
        this.garnish = garnish;
    }

    public int getKcal() {
        return kcal;
    }

    public void setKcal(int kcal) {
        this.kcal = kcal;
    }

    @Override
    public String toString() {
        return "\nMeal ----> " + '\n' +
                "   Nume: " + name + '\n' +
                "   Tip de carne utilizat: " + meatType + '\n' +
                "   Garnitura : " + garnish + '\n' +
                "   Numar de kcal: " + kcal;

    }
}
