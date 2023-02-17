package Heroes;

public class HeroAttribute {
    int stat;
    public HeroAttribute(int i) {
        stat = i;
    }

    public int returnStat() {
        return stat;
    }

    public void addStat(int amount) {
        stat += amount;
    }

}
