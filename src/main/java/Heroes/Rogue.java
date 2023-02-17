package Heroes;

import Items.*;

public class Rogue extends Hero{

    public Rogue(String name) {
        super(name);
        strength = new HeroAttribute(2);
        dexterity = new HeroAttribute(6);
        intelligence = new HeroAttribute(1);

        validArmor.add(ArmorType.LEATHER);
        validArmor.add(ArmorType.MAIL);
        validWeapons.add(WeaponType.DAGGER);
        validWeapons.add(WeaponType.SWORD);
    }

    //Function for leveling up hero
    @Override
    public void levelUp() {
        level++;
        strength.addStat(1);
        dexterity.addStat(4);
        intelligence.addStat(1);
    }

    //Function for hero damage calculation returns damage as int
    @Override
    public int getHeroDamage() {
        if(equipment.get(ItemSlot.WEAPON) != null){
            double x = ((Weapon)equipment.get(ItemSlot.WEAPON)).getWeaponDamage() * (1 + (double)totalAttributes(HeroAttributeNames.DEXTERITY) / 100);
            return (int) Math.round(x) ;
        } else {
            return 1 + (1 + dexterity.returnStat() / 100);
        }
    }
}
