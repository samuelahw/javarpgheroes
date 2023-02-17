package Items;

public class Weapon extends Item{

    WeaponType wType;

    int weaponDamage;
    public Weapon(String name, WeaponType type, int levelReq, int dmg){
        itemSlot = ItemSlot.WEAPON;
        itemName = name;
        wType = type;
        requiredLevel = levelReq;
        weaponDamage = dmg;
    }

    //Getter for weapon type
    public WeaponType getWeaponType(){
        return wType;
    }

    //getter for weapon damage
    public int getWeaponDamage(){
        return weaponDamage;
    }
}
