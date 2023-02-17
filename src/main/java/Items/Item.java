package Items;

//Abstract class for items
public abstract class Item {

    protected String itemName;
    protected int requiredLevel;

    protected ItemSlot itemSlot;

    //Getter for item name
    public String getName(){return itemName;}

    //Getter for item required level
    public int getLevel(){return requiredLevel;}

    //Getter for item slot
    public ItemSlot getSlot() {
        return itemSlot;
    }

}
