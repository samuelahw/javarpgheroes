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

    @Override
    public int getLevel() {
        return requiredLevel;
    }

    public WeaponType getWeaponType(){
        return wType;
    }

    public int getWeaponDamage(){
        return weaponDamage;
    }
}
