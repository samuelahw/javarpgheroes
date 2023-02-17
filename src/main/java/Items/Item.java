package Items;

public abstract class Item {

    protected String itemName;
    protected int requiredLevel;

    protected ItemSlot itemSlot;


    public String getName(){return itemName;}
    public int getLevel(){return requiredLevel;}
    public ItemSlot getSlot() {
        return itemSlot;
    }

}
