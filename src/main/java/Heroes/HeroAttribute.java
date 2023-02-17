package Heroes;

//Class for hero attributes
public class HeroAttribute {
    int stat;
    public HeroAttribute(int i) {
        stat = i;
    }

    //Getter for stat
    public int returnStat() {
        return stat;
    }

    //Function for increasing stats
    public void addStat(int amount) {
        stat += amount;
    }

}
