package classes;

public abstract class Plan {
    private int price;
    private int duration;

    public Plan(){
        
    }
    public Plan(int price, int duration) {
        this.price = price;
        this.duration = duration;
    }

    public int getprice() {
        return price;
    }

    public void setprice(int price) {
        this.price = price;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Plan ----> " + '\n' +
                "  Pret : " + price + '\n' +
                "   Durata: " + duration  ;

    }
}
