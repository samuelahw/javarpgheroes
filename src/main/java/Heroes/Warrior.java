package Heroes;

import Items.ArmorType;
import Items.ItemSlot;
import Items.Weapon;
import Items.WeaponType;

public class Warrior extends Hero{

    public Warrior(String name) {
        super(name);
        strength = new HeroAttribute(5);
        dexterity = new HeroAttribute(2);
        intelligence = new HeroAttribute(1);

        validArmor.add(ArmorType.MAIL);
        validArmor.add(ArmorType.PLATE);
        validWeapons.add(WeaponType.AXE);
        validWeapons.add(WeaponType.HAMMER);
        validWeapons.add(WeaponType.SWORD);
    }

    //Function for leveling up hero
    @Override
    public void levelUp() {
        level++;
        strength.addStat(3);
        dexterity.addStat(2);
        intelligence.addStat(1);
    }

    //Function for hero damage calculation returns damage as int
    @Override
    public int getHeroDamage() {
        if(equipment.get(ItemSlot.WEAPON) != null){
            double x = ((Weapon)equipment.get(ItemSlot.WEAPON)).getWeaponDamage() * (1 + (double)totalAttributes(HeroAttributeNames.STRENGTH) / 100);
            return (int) Math.round(x) ;
        } else {
            return 1 + (1 + strength.returnStat() / 100);
        }
    }
}
